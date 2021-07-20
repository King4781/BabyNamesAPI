package com.kentonking.babynames;

import com.kentonking.babynames.entites.Baby;
import com.kentonking.babynames.repositories.BabyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class BabynamesApplicationTests {

	@Autowired
	private BabyRepository babyRepository;

	@Test
	@DisplayName("Should equal 275")
	void shouldFindAll() {
		Page<Baby> babies = babyRepository.findAllFree("John", PageRequest.of(0, 20));
		long totalElements = babies.getTotalElements();
		Assertions.assertEquals(275, totalElements);
	}

	@Test
	@DisplayName("Should equal 106")
	void shouldFindAllByGender() {
		Page<Baby> babies = babyRepository.findAllByGenderFree("John", "F", PageRequest.of(0, 20));
		long totalElements = babies.getTotalElements();
		Assertions.assertEquals(106, totalElements);
	}

	@Test
	@DisplayName("Should equal 4")
	void shouldFindAllByNameAndYear() {
		Page<Baby> babies = babyRepository.findAllByYearFree("Paul", 1880, PageRequest.of(0, 20));
		long totalElements = babies.getTotalElements();
		Assertions.assertEquals(4, totalElements);
	}

	@Test
	@DisplayName("Should equal 1")
	void shouldFindAllByNameAndYearAndGender() {
		Page<Baby> babies = babyRepository.findAllByGenderAndYearFree("Paul", "M", 1880, PageRequest.of(0, 20));
		long totalElements = babies.getTotalElements();
		Assertions.assertEquals(1, totalElements);
	}

	@Test
	@DisplayName("Should equal 197")
	void shouldFindAverageRanking() {
		Optional<Integer> ranking = babyRepository.findAverageRanking("John");
		ranking.ifPresent(integer -> Assertions.assertEquals(197, integer));
	}

	@Test
	@DisplayName("Should equal 197")
	void shouldFindAverageRankingByGender() {
		Optional<Integer> ranking = babyRepository.findAverageRanking("John", "F");
		ranking.ifPresent(integer -> Assertions.assertEquals(393, integer));
	}

	@Test
	@DisplayName("Should equal 147")
	void shouldFindAverageRankingByDecade() {
		Optional<Integer> ranking = babyRepository.findAverageRankingByDecade("Francis", 1880);
		ranking.ifPresent(integer -> Assertions.assertEquals(147, integer));
	}

	@Test
	@DisplayName("Should equal 238")
	void shouldFindAverageRankingByDecadeAndGender() {
		Optional<Integer> ranking = babyRepository.findAverageRankingByDecade("Francis", "F", 1880);
		ranking.ifPresent(integer -> Assertions.assertEquals(238, integer));
	}

	@Test
	@DisplayName("Should equal 33")
	void shouldFindHighestRanking() {
		Optional<Integer> ranking = babyRepository.findHighestRankingByName("Francis");
		ranking.ifPresent(integer -> Assertions.assertEquals(33, integer));
	}

	@Test
	@DisplayName("Should equal 206")
	void shouldFindHighestRankingByGender() {
		Optional<Integer> ranking = babyRepository.findHighestRankingByName("Francis", "F");
		ranking.ifPresent(integer -> Assertions.assertEquals(206, integer));
	}

	@Test
	@DisplayName("Should equal { 1880, 1890, 1900 }")
	void shouldFindAllDecades() {
		List<Integer> decades = babyRepository.findAllByDecade();
		int[] expected = { 1880, 1890, 1900 };
		int[] values = new int[decades.size()];
		for(int i = 0; i < decades.size(); i++) values[i] = decades.get(i);

		Assertions.assertArrayEquals(expected, values);
	}

}
