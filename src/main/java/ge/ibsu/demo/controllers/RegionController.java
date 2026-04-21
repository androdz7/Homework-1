package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Region;
import ge.ibsu.demo.repositories.RegionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping("/all")
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @PostMapping("/add")
    public Region add(@RequestBody Region region) {
        return regionRepository.save(region);
    }
}