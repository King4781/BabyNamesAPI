package com.kentonking.babynames.ui.response;

import java.util.List;

public class PopularityResponse {
    private final String name;
    private final String gender;
    private final List<PopularityDecade> decades;

    public PopularityResponse(String name, String gender, List<PopularityDecade> decades) {
        this.name = name;
        this.gender = gender;
        this.decades = decades;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<PopularityDecade> getDecades() {
        return decades;
    }
}
