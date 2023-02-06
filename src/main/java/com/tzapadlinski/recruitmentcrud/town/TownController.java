package com.tzapadlinski.recruitmentcrud.town;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
Towns should be pre-populated, so I added small API
to add new via Postman or CommandlineRunner.
 */
@RestController
@RequestMapping("/town")
public class TownController {
    private final TownServiceImpl townService;

    @Autowired
    public TownController(TownServiceImpl townService) {
        this.townService = townService;
    }

    @PostMapping("/add")
    public Town addTown(@RequestBody Town newTown){
        return townService.addTown(newTown);
    }

    @GetMapping("/all")
    public List<Town> getAllTowns(){
        return townService.getAllTowns();
    }

    @DeleteMapping("/delete")
    public void deleteTown(@PathVariable Long townId){
        townService.deleteTown(townId);
    }
}
