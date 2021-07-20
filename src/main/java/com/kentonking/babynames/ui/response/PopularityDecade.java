package com.kentonking.babynames.ui.response;

public class PopularityDecade {
    private final int decade;
    private final int ranking;

    public PopularityDecade(int decade, int ranking) {
        this.decade = decade;
        this.ranking = ranking;
    }

    public int getDecade() {
        return decade;
    }

    public int getRanking() {
        return ranking;
    }
}
