package ru.adkazankov.controller;


import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.dao.AreaRepository;
import ru.adkazankov.dao.HouseRepository;
import ru.adkazankov.domain.House;
import ru.adkazankov.form.HouseForm;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private  AreaRepository areaRepository;

    @GetMapping("/{id}")
    public Optional<House> getHouse(@PathVariable(name = "id") Long id){
        return houseRepository.findById(id);
    }


    @GetMapping("/like")
    public List<House> getTop10LikeThis(@RequestParam String area, @RequestParam String street, @RequestParam String building){
        return houseRepository
                .getTop10ByArea_NameContainsAndStreetNameContainsAndBuildingContains
                        (area, street, building);
    }

    @GetMapping()
    public List<House> getHouse(){
        return houseRepository.findAll();
    }

    @PutMapping("/{id}")
    public Optional<House> putHouse(@RequestBody HouseForm houseForm, @PathVariable(name = "id") Long id){
        houseForm.setAreaRepository(areaRepository);
        Optional<House> house = Optional.of(houseForm.toHouse(id));
        houseRepository.save(house.get());
        return house;
    }

    @PostMapping
    public Optional<House> postHouse(@RequestBody HouseForm houseForm){
        return putHouse(houseForm, null);
    }


    @DeleteMapping("/{id}")
    public String deleteHouse(@PathVariable Long id){
        try {
            houseRepository.deleteById(id);
        }catch (HibernateException e){
            return e.toString();
        }
        return "DELETED "+id;
    }

}
