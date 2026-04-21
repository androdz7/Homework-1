package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Country;
import ge.ibsu.demo.repositories.CountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/all")
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @PostMapping("/add")
    public Country add(@RequestBody Country country) {
        return countryRepository.save(country);
    }
}