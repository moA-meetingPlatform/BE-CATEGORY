package com.moa.global;

import com.moa.global.vo.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/category")
@Slf4j
@RequiredArgsConstructor
public class HealthCheckController {

    @GetMapping("/test")
    public ResponseEntity<ApiResult<String>> test() {
        return ResponseEntity.ok(ApiResult.ofSuccess("category test"));
    }

}
