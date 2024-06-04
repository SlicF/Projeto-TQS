package ua.tqs.airportManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.tqs.airportManager.entity.Luggage;
import ua.tqs.airportManager.service.LuggageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/luggage")
public class LuggageController {

    @Autowired
    private LuggageService luggageService;

    @GetMapping("/luggage")
    public List<Luggage> getAllLuggage() {
        return luggageService.getAllLuggages();
    }

    @GetMapping("/luggage/{luggageId}")
    public ResponseEntity<Luggage> getLuggageById(@PathVariable String id) {
        Optional<Luggage> luggage = luggageService.findByLuggageId(id);
        return luggage.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createLuggage")
    public ResponseEntity<Luggage> createLuggage(@RequestBody Luggage luggage) {
        Luggage savedLuggage = luggageService.createLuggage(luggage);
        return new ResponseEntity<>(savedLuggage, HttpStatus.CREATED);
    }

}