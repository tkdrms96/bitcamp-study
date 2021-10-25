package com.tobabogi.demo.common.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

    private int start, end, page, size, total,last;
    private boolean prev, next;

    public PageMaker(int page, int size, int total){

        this.page = page;
        this.size = size;
        this.total = total;

        //마직막 페이지
        start = (int)Math.floor((page-1)/(double)10.0)*10+1;

        last=(total%size==0) ? total/size : total/size+1;

        if ((end=(int)(Math.ceil(page / 10.0) * 10))>last) {
            end=last;
        }

        prev = start > 1;
        next = end >= (int) Math.ceil(total / (double)size) ? false : true;


    }

}
