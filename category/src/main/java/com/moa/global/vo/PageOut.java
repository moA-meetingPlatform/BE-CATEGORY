package com.moa.global.vo;

import lombok.Setter;


@Setter
public class PageOut {
    private Integer pageNo;
    private Integer size;
    private Integer totalRows;
    private Boolean lastPage;
}