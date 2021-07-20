package com.kentonking.babynames.controllers;

import com.kentonking.babynames.entites.Baby;
import com.kentonking.babynames.exceptions.BabyNotFoundException;
import com.kentonking.babynames.repositories.BabyRepository;
import com.kentonking.babynames.ui.response.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/babies")
public class BabyController {

    private final BabyRepository babyRepository;

    @Autowired
    public BabyController(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }


    @GetMapping
    @ApiOperation(
            value = "Find all",
            notes = "Find all baby names. Returns the 20 most recent names by default.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> findAll(@ApiParam(value = "Page numbers start at 0")
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @ApiParam(value = "Size of page results. Max size is 100")
                                                @RequestParam(value = "size", defaultValue = "20") int size,
                                                @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                                @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                                @RequestParam(value = "sort", defaultValue = "desc") String sort) {

        Page<Baby> babies;
        gender = gender.toUpperCase();

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {
            babies = babyRepository.findAllByGender(gender, page, size, sort);
        } else {
            babies = babyRepository.findAll(page, size, sort);
        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    @ApiOperation(
            value = "Find all by name",
            notes = "Find all baby names by a given name. Returns the 20 most recent names by default.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> search(@PathVariable String name,
                                               @ApiParam(value = "Page numbers start at 0")
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @ApiParam(value = "Size of page results. Max size is 100")
                                               @RequestParam(value = "size", defaultValue = "20") int size,
                                               @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                               @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                               @RequestParam(value = "exact", defaultValue = "false") boolean exact,
                                               @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                               @RequestParam(value = "sort", defaultValue = "desc") String sort) {

        Page<Baby> babies;
        gender = gender.toUpperCase();
        name = formatName(name);

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {

            if (exact) {
                babies = babyRepository.findAllByNameAndGender(name, gender, page, size, sort);
            } else {
                babies = babyRepository.searchByNameGender(gender, name, page, size, sort);
            }

        } else {

            if (exact) {
                babies = babyRepository.findAllByName(name, page, size, sort);
            } else {
                babies = babyRepository.searchByName(name, page, size, sort);
            }

        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/search/year/{birthYear}/name/{name}")
    @ApiOperation(
            value = "Find all by name and year",
            notes = "Find all baby names by a given name and year. Returns the 20 most recent names by default.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> search(@PathVariable int birthYear,
                                               @PathVariable String name,
                                               @ApiParam(value = "Page numbers start at 0")
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @ApiParam(value = "Size of page results. Max size is 100")
                                               @RequestParam(value = "size", defaultValue = "20") int size,
                                               @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                               @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                               @RequestParam(value = "exact", defaultValue = "false") boolean exact,
                                               @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                               @RequestParam(value = "sort", defaultValue = "desc") String sort) {

        Page<Baby> babies;
        gender = gender.toUpperCase();
        name = formatName(name);

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {

            if (exact) {
                babies = babyRepository.findAllByNameAndGenderAndBirthYear(name, gender, birthYear, page, size, sort);
            } else {
                babies = babyRepository.searchByNameYearGender(gender, name, birthYear, page, size, sort);
            }

        } else {

            if (exact) {
                babies = babyRepository.findAllByNameAndBirthYear(name, birthYear, page, size, sort);
            } else {
                babies = babyRepository.searchByNameYear(name, birthYear, page, size, sort);
            }

        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/year/{birthYear}")
    @ApiOperation(
            value = "Find all by year",
            notes = "Find all baby names by a given year. Returns the 20 most recent names by default.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> searchYear(@PathVariable int birthYear,
                                                   @ApiParam(value = "Page numbers start at 0")
                                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                                   @ApiParam(value = "Size of page results. Max size is 100")
                                                   @RequestParam(value = "size", defaultValue = "20") int size,
                                                   @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                   @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                                   @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                                   @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        Page<Baby> babies;
        gender = gender.toUpperCase();

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {
            babies = babyRepository.findAllByGenderAndBirthYear(gender, birthYear, page, size, sort);
        } else {
            babies = babyRepository.findAllByBirthYear(birthYear, page, size, sort);
        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/ranking/name/{name}")
    @ApiOperation(
            value = "Find highest ranking",
            notes = "Find the highest ranking overall years for a given name. Returns the most recent highest ranking if there is a tie")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 404, message = "NOT FOUND")})
    public ResponseEntity<Baby> findHighestRanking(@PathVariable String name,
                                                   @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                   @RequestParam(value = "gender", defaultValue = "Neutral") String gender) {

        gender = gender.toUpperCase();
        name = formatName(name);
        Optional<Baby> baby;

        if (gender.equals("M") || gender.equals("F")) {
            baby = babyRepository.findHighestRanking(name, gender);
        } else {
            baby = babyRepository.findHighestRanking(name);
        }

        String finalName = name;
        return baby.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseThrow(() ->
                new BabyNotFoundException("The resource with the name " + finalName + " could not be found"));

    }

    @GetMapping("/start/{startYear}/end/{endYear}")
    @ApiOperation(
            value = "Find all with in a given range",
            notes = "Find all baby names in a given range of years. Returns the 20 most recent names by default.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> searchRangeOfYears(@PathVariable int startYear,
                                                           @PathVariable int endYear,
                                                           @ApiParam(value = "Page numbers start at 0")
                                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                                           @ApiParam(value = "Size of page results. Max size is 100")
                                                           @RequestParam(value = "size", defaultValue = "20") int size,
                                                           @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                           @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                                           @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                                           @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        Page<Baby> babies;
        gender = gender.toUpperCase();

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {
            babies = babyRepository.findAllWithInRangeByGender(startYear, endYear, gender, page, size, sort);
        } else {
            babies = babyRepository.findAllWithInRange(startYear, endYear, page, size, sort);
        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/year/{birthYear}/ranking/{ranking}")
    @ApiOperation(
            value = "Find name by year and ranking",
            notes = "Find baby names by year and ranking. Returns at most two results.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> findFirstByBirthYearAndRanking(@PathVariable int birthYear,
                                                                       @PathVariable int ranking,
                                                                       @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                                       @RequestParam(value = "gender", defaultValue = "Neutral") String gender) {
        Page<Baby> babies;
        gender = gender.toUpperCase();

        if (gender.equals("M") || gender.equals("F")) {
            babies = babyRepository.findAllByBirthYearAndRankingAndGender(birthYear, ranking, gender);
        } else {
            babies = babyRepository.findAllByBirthYearAndRanking(birthYear, ranking);
        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/popularity/name/{name}")
    @ApiOperation(
            value = "Calculate popularity",
            notes = "Calculates popularity for a given name overall by each decade.")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PopularityResponse> calculatePopularity(@PathVariable String name,
                                                                  @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                                  @RequestParam(value = "gender", defaultValue = "Neutral") String gender) {
        List<PopularityDecade> popularityDecadeList;
        gender = gender.toUpperCase();
        name = formatName(name);

        if (gender.equals("M") || gender.equals("F")) {
            popularityDecadeList = babyRepository.calculatePopularity(name, gender);
        } else {
            gender = "Neutral";
            popularityDecadeList = babyRepository.calculatePopularity(name);
        }

        return new ResponseEntity<>(new PopularityResponse(name, gender, popularityDecadeList), HttpStatus.OK);
    }

    @GetMapping("/decade/{decade}")
    @ApiOperation(
            value = "Find all by decade",
            notes = "Find all baby names by decade. Returns the 20 most recent names by default. Ex. (1970, 1980, 1990)")
    @ApiResponse(code = 400, message = "BAD REQUEST")
    public ResponseEntity<PageResponse> findAllByDecade(@ApiParam(value = "The first year of the decade to search. Ex. (1970, 1980, 1990)") @PathVariable int decade,
                                                        @RequestParam(value = "page", defaultValue = "0") int page,
                                                        @ApiParam(value = "Size of page results. Max size is 100")
                                                        @RequestParam(value = "size", defaultValue = "20") int size,
                                                        @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                        @RequestParam(value = "gender", defaultValue = "Neutral") String gender,
                                                        @ApiParam(value = "Sort can be <strong>asc</strong> - for ascending or <strong>desc</strong> - for descending by year.")
                                                        @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        Page<Baby> babies;
        gender = gender.toUpperCase();

        if (size > 100) {
            size = 100;
        }

        if (gender.equals("M") || gender.equals("F")) {
            babies = babyRepository.findAllByDecade(decade, gender, page, size, sort);
        } else {
            babies = babyRepository.findAllByDecade(decade, page, size, sort);
        }

        return new ResponseEntity<>(new PageResponse(babies), HttpStatus.OK);
    }

    @GetMapping("/average/name/{name}")
    @ApiOperation(
            value = "Find average ranking",
            notes = "Find average ranking overall years for a given name")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 404, message = "NOT FOUND")})
    public ResponseEntity<AverageRankingResponse> findAverageRanking(@PathVariable String name,
                                                                     @ApiParam(value = "Gender can be <strong>m</strong> - for male or <strong>f</strong> - for female.")
                                                                     @RequestParam(value = "gender", defaultValue = "Neutral") String gender) {

        gender = gender.toUpperCase();
        name = formatName(name);
        Optional<Integer> ranking;

        if (gender.equals("M") || gender.equals("F")) {
            ranking = babyRepository.findAverageRanking(name, gender);
        } else {
            gender = "Neutral";
            ranking = babyRepository.findAverageRanking(name);
        }

        if (ranking.isEmpty()) {
            throw new BabyNotFoundException("The resource with the name " + name + " could not be found");
        }

        return new ResponseEntity<>(new AverageRankingResponse(name, ranking.get(), gender), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Find by baby ID",
            notes = "Find first name by given ID.")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 404, message = "NOT FOUND")})
    public ResponseEntity<Baby> findById(@PathVariable long id) {
        Optional<Baby> baby = babyRepository.findById(id);

        return baby.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseThrow(() ->
                new BabyNotFoundException("The resource with the id " + id + " could not be found"));
    }

    private String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleBabyNotFoundException(BabyNotFoundException e) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.name());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleNumberFormatException(NumberFormatException e) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.name());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        CustomErrorResponse response = new CustomErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.name());
        response.setMessage(e.getMessage());
        response.setDate(LocalDateTime.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
