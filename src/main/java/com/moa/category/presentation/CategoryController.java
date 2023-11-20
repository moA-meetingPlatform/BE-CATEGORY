package com.moa.category.presentation;
import com.moa.category.application.CategoryService;
import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import com.moa.category.dto.CategoryMeetingGetDto;
import com.moa.category.dto.MeetingDetailGetDto;
import com.moa.category.dto.UserInterestGetDto;
import com.moa.category.infrastructure.CategoryMeetingListRepository;
import com.moa.category.vo.request.*;
import com.moa.category.vo.response.CategoriesListOut;
import com.moa.category.vo.response.MeetingDetailOut;
import com.moa.category.vo.response.MeetingListOut;
import com.moa.global.vo.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final CategoryMeetingListRepository categoryMeetingListRepository;

    // 카테고리 선택 화면을 위해서 상위카테고리들아래에 하위카데고리들을 리스트로 묶어서 보냄
    @GetMapping("")
    public ResponseEntity<?>getCategoriesList(){
        List<CategoriesListOut> categoriesList = categoryService.categoriesList();
        return ResponseEntity.ok(ApiResult.ofSuccess(categoriesList));
    }
    // 관리자가 카테고리 생성
    @PostMapping("")
    public ResponseEntity<?> createThemeCategory(@RequestBody CreateThemeCategoryIn createThemeCategoryIn){
        categoryService.createThemeCategory(createThemeCategoryIn);
        return ResponseEntity.ok(ApiResult.ofSuccess(null));
    }

    // 유저가 선택한 카테고리를 DB에 저장
    @PostMapping("/user")
    public ResponseEntity<?>createUserInterests(@RequestBody UserInterestsIn userInterestsIn){
        categoryService.createUserInterests(modelMapper.map(userInterestsIn, UserInterestGetDto.class));
        return ResponseEntity.ok(ApiResult.ofSuccess(null));
    }
    // 유저 관심사 변경
    @PutMapping("/user")
    public ResponseEntity<?>updateUserInterests(@RequestBody UserInterestsIn userInterestsIn){
        categoryService.updateUserInterests(modelMapper.map(userInterestsIn, UserInterestGetDto.class));
        return ResponseEntity.ok(ApiResult.ofSuccess(null));
    }
    // 모임생성시 선택한 카테고리를 DB에 저장
    @PostMapping("/meeting")
    public ResponseEntity<?>createMeetingCategory(@RequestBody MeetingCategoryIn meetingCategoryIn){
        categoryService.createMeetingCategory(modelMapper.map(meetingCategoryIn, CategoryMeetingGetDto.class));
        return ResponseEntity.ok(ApiResult.ofSuccess(null));
    }
    // 모임 종료, 모임 취소, 모임 삭제시 : 0으로 바꾸기
    @PutMapping("/meeting")
    public ResponseEntity<?>disableMeetingCategory(@RequestBody DisableMeetingCategoryIn disableMeetingCategoryIn){
        categoryService.disableMeetingCategory(disableMeetingCategoryIn.getMeetingId());
        return ResponseEntity.ok(ApiResult.ofSuccess(null));
    }
    // 유저가 선택한 카테고리 조회
    @GetMapping("/user")
    public ResponseEntity<?> getUserInterests(@RequestParam(value = "userUuid") UUID uuid) {
        List<Integer> userInterests = categoryService.getUserInterests(uuid);
        return ResponseEntity.ok(ApiResult.ofSuccess(userInterests));
    }

    // 카테고리 선택시 그에 맞는 모임 리스트로 보여주기
    // 로그인 X
    @GetMapping("/meeting")
    public ResponseEntity<?> getMeetingListByCategory(
            @RequestParam(value = "categoryId", defaultValue = "0") int categoryId,
            @RequestParam(value = "userUuid", required = false) UUID userUuid,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "gender", required = false) String genderString,
            @RequestParam(value = "companies", required = false) String companiesString) {

        // 유저 선호도 설정
        UserCategoriesIn userPreferences = UserCategoriesIn.builder()
                .userUUID(userUuid)
                .age(age)
                .participateGender(convertStringToGender(genderString))
                .participateCompanies(processSingleCompanyCategoryInput(companiesString))
                .build();

        // 서비스 메소드 호출
        MeetingListOut meetingListOut = categoryService.getMeetingListByCategory(userPreferences, categoryId);

        return ResponseEntity.ok(meetingListOut);
    }
    @Operation(summary = "모임 상세 조회", description = "모임 상세 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = MeetingDetailOut.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/meeting/{id}")
    public ResponseEntity<ApiResult<MeetingDetailOut>> getMeetingListByCategory(@PathVariable Long id) {
        MeetingDetailGetDto meetingDetailGetDto = categoryService.getMeetingId(id);	// 모임 조회
        MeetingDetailOut response = modelMapper.map(meetingDetailGetDto, MeetingDetailOut.class);	// 모임 상세 조회 후 반환
        return ResponseEntity.ok(ApiResult.ofSuccess(response));
    }

    private CanParticipateGender convertStringToGender(String genderString) {
        if (genderString == null || genderString.isEmpty()) {
            return null;
        }
        return CanParticipateGender.valueOf(genderString.toUpperCase());
    }

    /**
     * 사용자가 선택한 단일 회사 카테고리를 처리하여 문자열로 반환하는 함수
     *
     * @param companyCategoryInput 사용자 입력 문자열
     * @return 처리된 회사 카테고리 문자열
     */
    private String processSingleCompanyCategoryInput(String companyCategoryInput) {
        if (companyCategoryInput == null || companyCategoryInput.isEmpty()) {
            return "";
        }
        // 입력된 문자열로부터 CompanyCategory 열거형 값 추출
        CompanyCategory selectedCategory = CompanyCategory.valueOf(companyCategoryInput);

        // 추출된 값을 Set으로 변환
        Set<CompanyCategory> categories = Collections.singleton(selectedCategory);

        // Set을 문자열로 변환
        return convertCompanyCategoriesToString(categories);
    }

    /**
     * CompanyCategory의 Set을 콤마로 구분된 문자열로 변환
     *
     * @param categories CompanyCategory의 Set
     * @return 콤마로 구분된 문자열
     */
    private String convertCompanyCategoriesToString(Set<CompanyCategory> categories) {
        return categories.stream()
                .map(CompanyCategory::getCode)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
