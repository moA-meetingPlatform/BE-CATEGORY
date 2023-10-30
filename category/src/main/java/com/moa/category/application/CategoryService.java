package com.moa.category.application;

import com.moa.category.vo.CategoriesListOut;

import java.util.List;

public interface CategoryService {
    List<CategoriesListOut> categoriesList();
}
