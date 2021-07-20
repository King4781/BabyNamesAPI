package com.kentonking.babynames.repositories;

import com.kentonking.babynames.entites.Baby;
import com.kentonking.babynames.ui.response.PopularityDecade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface BabyRepository extends JpaRepository<Baby, Long> {

    // CUSTOM QUERIES
    @Query("select b from Baby b where lower(b.name) like lower( concat('%', ?1, '%') )")
    Page<Baby> findAllFree(String name, Pageable pageable);

    @Query("select b from Baby b where lower(b.name) like lower( concat('%', ?1, '%') ) and b.gender = ?2")
    Page<Baby> findAllByGenderFree(String name, String gender, Pageable pageable);

    @Query("select b from Baby b where lower(b.name) like lower( concat('%', ?1, '%') ) and b.birthYear = ?2")
    Page<Baby> findAllByYearFree(String name, int year, Pageable pageable);

    @Query("select b from Baby b where lower(b.name) like lower( concat('%', ?1, '%') ) and b.gender = ?2 and b.birthYear = ?3")
    Page<Baby> findAllByGenderAndYearFree(String name, String gender, int year, Pageable pageable);

    @Query("select avg(b.ranking) from Baby b where b.name = ?1 and b.gender = ?2")
    Optional<Integer> findAverageRanking(String name, String gender);

    @Query("select avg(b.ranking) from Baby b where b.name = ?1")
    Optional<Integer> findAverageRanking(String name);

    @Query("select avg(b.ranking) from Baby b where b.name = ?1 and b.decade = ?2")
    Optional<Integer> findAverageRankingByDecade(String name, int decade);

    @Query("select avg(b.ranking) from Baby b where b.name = ?1 and b.gender = ?2 and b.decade = ?3")
    Optional<Integer> findAverageRankingByDecade(String name, String gender, int decade);

    @Query("select b from Baby b where b.gender = ?1 and b.ranking <= 10")
    List<Baby> findAllTopTenNames(String gender);

    @Query("select min(b.ranking) from Baby b where b.name = ?1 and b.gender = ?2")
    Optional<Integer> findHighestRankingByName(String name, String gender);

    @Query("select min(b.ranking) from Baby b where b.name = ?1")
    Optional<Integer> findHighestRankingByName(String name);

    @Query("select distinct b.decade from Baby b")
    List<Integer> findAllByDecade();

    // NAME QUERIES
    Page<Baby> findAllByDecade(int decade, Pageable pageable);
    Page<Baby> findAllByDecadeAndGender(int decade, String gender, Pageable pageable);
    Optional<Baby> findFirstByNameAndRankingOrderByBirthYearDesc(String name, int ranking);
    Optional<Baby> findFirstByNameAndRankingAndGenderOrderByBirthYearDesc(String name, int ranking, String gender);
    Page<Baby> findAllByNameAndGenderAndBirthYear(String name, String gender, int birthYear, Pageable pageable);
    Page<Baby> findAllByNameAndBirthYear(String name, int birthYear, Pageable pageable);
    Page<Baby> findAllByNameAndGender(String name, String gender, Pageable pageable);
    Page<Baby> findAllByName(String name, Pageable pageable);
    Page<Baby> findAllByGender(String gender, Pageable pageable);
    Page<Baby> findAllByBirthYearAndRanking(int birthYear, int ranking, Pageable pageable);
    Page<Baby> findAllByBirthYearAndRankingAndGender(int birthYear, int ranking, String gender, Pageable pageable);
    Page<Baby> findAllByGenderAndBirthYear(String gender, int birthYear, Pageable pageable);
    Page<Baby> findAllByBirthYear(int birthYear, Pageable pageable);
    Page<Baby> findAllByBirthYearIsGreaterThanEqualAndBirthYearLessThanEqual(int startYear, int endYear, Pageable pageable);
    Page<Baby> findAllByBirthYearIsGreaterThanEqualAndBirthYearLessThanEqualAndGender(int startYear, int endYear, String gender, Pageable pageable);

    default Optional<Baby> findHighestRanking(String name) {
        Optional<Integer> ranking = findHighestRankingByName(name);

        if (ranking.isPresent()) {
            return findFirstByNameAndRankingOrderByBirthYearDesc(name, ranking.get());
        }

        return Optional.empty();
    }

    default Optional<Baby> findHighestRanking(String name, String gender) {
        Optional<Integer> ranking = findHighestRankingByName(name, gender);

        if (ranking.isPresent()) {
            return findFirstByNameAndRankingAndGenderOrderByBirthYearDesc(name, ranking.get(), gender);
        }

        return Optional.empty();
    }

    default List<PopularityDecade> calculatePopularity(String name) {
        List<Integer> decades = findAllByDecade();
        List<PopularityDecade> responses = new ArrayList<>();

        decades.forEach(decade -> {
            Optional<Integer> ranking = findAverageRankingByDecade(name, decade);
            if (ranking.isPresent()) {
                responses.add(new PopularityDecade(decade, ranking.get()));
            } else {
                responses.add(new PopularityDecade(decade, 0));
            }
        });

        return responses;
    }

    default List<PopularityDecade> calculatePopularity(String name, String gender) {
        List<Integer> decades = findAllByDecade();
        List<PopularityDecade> responses = new ArrayList<>();

        decades.forEach(decade -> {
            Optional<Integer> ranking = findAverageRankingByDecade(name, gender, decade);
            if (ranking.isPresent()) {
                responses.add(new PopularityDecade(decade, ranking.get()));
            } else {
                responses.add(new PopularityDecade(decade, 0));
            }
        });

        return responses;
    }

    default Page<Baby> findAllByDecade(int decade, int page, int size, String sort) {
        return findAllByDecade(decade, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByDecade(int decade, String gender, int page, int size, String sort) {
        return findAllByDecadeAndGender(decade, gender, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByNameAndBirthYear(String name, int birthYear, int page, int size, String sort) {
        return findAllByNameAndBirthYear(name, birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByNameAndGenderAndBirthYear(String name, String gender, int birthYear, int page, int size, String sort) {
        return findAllByNameAndGenderAndBirthYear(name, gender, birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByName(String name, int page, int size, String sort) {
        return findAllByName(name, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByNameAndGender(String name, String gender, int page, int size, String sort) {
        return findAllByNameAndGender(name, gender, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAll(int page, int size, String sort) {
        return findAll(PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByGender(String gender, int page, int size, String sort) {
        return findAllByGender(gender, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> searchByNameGender(String gender, String name, int page, int size, String sort) {
        return findAllByGenderFree(name, gender, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> searchByName(String name, int page, int size, String sort) {
        return findAllFree(name, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> searchByNameYearGender(String gender, String name, int birthYear, int page, int size, String sort) {
        return findAllByGenderAndYearFree(name, gender, birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> searchByNameYear(String name, int birthYear, int page, int size, String sort) {
        return findAllByYearFree(name, birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByGenderAndBirthYear(String gender, int birthYear, int page, int size, String sort) {
        return findAllByGenderAndBirthYear(gender, birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByBirthYear(int birthYear, int page, int size, String sort) {
        return findAllByBirthYear(birthYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllWithInRange(int startYear, int endYear, int page, int size, String sort) {
        return findAllByBirthYearIsGreaterThanEqualAndBirthYearLessThanEqual(startYear, endYear, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllWithInRangeByGender(int startYear, int endYear, String gender, int page, int size, String sort) {
        return findAllByBirthYearIsGreaterThanEqualAndBirthYearLessThanEqualAndGender(startYear, endYear, gender, PageRequest.of(page, size, sort(sort)));
    }

    default Page<Baby> findAllByBirthYearAndRanking(int birthYear, int ranking) {
        return findAllByBirthYearAndRanking(birthYear, ranking, PageRequest.of(0, 2));
    }

    default Page<Baby> findAllByBirthYearAndRankingAndGender(int birthYear, int ranking, String gender) {
        return findAllByBirthYearAndRankingAndGender(birthYear, ranking, gender, PageRequest.of(0, 2));
    }

    default Sort sort(String sortDirection) {
        Sort sortChoice = Sort.by("birthYear").descending().and(Sort.by("ranking").ascending());

        if (sortDirection.equalsIgnoreCase("asc")) {
            sortChoice = Sort.by("birthYear").ascending().and(Sort.by("ranking").ascending());
        }

        return sortChoice;
    }
}
