package com.moa.category.presentation;
import com.moa.category.application.CategoryService;
import com.moa.category.vo.CategoriesListOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/categories")
    public ResponseEntity<?>getCategoriesList(){

        List<CategoriesListOut> categoriesList = categoryService.categoriesList();

        return ResponseEntity.ok(ResponseOut.success(eventEndListOut));
    }
}
