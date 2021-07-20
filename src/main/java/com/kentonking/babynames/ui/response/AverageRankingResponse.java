package com.kentonking.babynames.ui.response;

public class AverageRankingResponse {
    private final String name;
    private final int averageRanking;
    private final String gender;

    public AverageRankingResponse(String name, int averageRanking, String gender) {
        this.name = name;
        this.averageRanking = averageRanking;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAverageRanking() {
        return averageRanking;
    }

    public String getGender() {
        return gender;
    }
}
