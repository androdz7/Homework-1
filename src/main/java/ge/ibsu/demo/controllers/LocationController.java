package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Location;
import ge.ibsu.demo.repositories.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/all")
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @PostMapping("/add")
    public Location add(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}