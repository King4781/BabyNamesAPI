package com.kentonking.babynames.ui.response;

import com.kentonking.babynames.entites.Baby;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponse {

    private final List<Baby> babies;
    private final PageInfo pageInfo;

    private static class PageInfo {
        public int size;
        public long totalElements;
        public int totalPages;
        public int number;
    }

    public PageResponse(Page<Baby> page) {
        pageInfo = new PageInfo();
        pageInfo.size = page.getNumberOfElements();
        pageInfo.totalElements = page.getTotalElements();
        pageInfo.totalPages = page.getTotalPages();
        pageInfo.number = page.getNumber();
        this.babies = page.getContent();
    }

    public List<Baby> getBabies() {
        return babies;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }
}
