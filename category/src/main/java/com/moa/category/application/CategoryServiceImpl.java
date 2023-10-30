package com.moa.category.application;

import com.moa.category.vo.CategoriesListOut;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{
    private final JPAQueryFactory query;


    @Override
    public List<CategoriesListOut> categoriesList() {
        return null;
    }
}
