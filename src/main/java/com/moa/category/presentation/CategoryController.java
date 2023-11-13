package com.moa.category.presentation;
import com.moa.category.application.CategoryService;
import com.moa.category.dto.CategoryMeetingGetDto;
import com.moa.category.dto.UserInterestGetDto;
import com.moa.category.infrastructure.CategoryMeetingListRepository;
import com.moa.category.vo.request.*;
import com.moa.category.vo.response.CategoriesListOut;
import com.moa.global.vo.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    // 카테고리 선택시 그에 맞는 모임 리스트로 보여주기\
    // 로그인 X
    @GetMapping("/meeting")
    public ResponseEntity<?> getMeetingListByCategory(
            @RequestParam(value = "categoryId", defaultValue = "0") int categoryId,
            @RequestParam(value = "userUuid", required = false) UUID userUuid,
            @RequestParam(value = "birthYear", required = false) String birthYear,
            @RequestParam(value = "gender", required = false) Character gender,
            @RequestParam(value = "company", required = false) String company) {

        // UserCategoriesIn 객체를 사용하여 사용자 선호도 정보를 설정
        UserCategoriesIn userPreferences = UserCategoriesIn.builder()
                .userUUID(userUuid)
                .birthYear(birthYear)
                .gender(gender)
                .company(company)
                .build();

        // 서비스 메소드를 호출하여 필터링된 모임 목록을 가져옴
        CategoriesListOut meetingListOut = categoryService.getMeetingListByCategory(userPreferences, categoryId);

        return ResponseEntity.ok(ApiResult.ofSuccess(meetingListOut));
    }

}
