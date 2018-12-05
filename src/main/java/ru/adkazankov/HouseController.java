package ru.adkazankov;


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
    @GetMapping()
    public List<House> getHouse(){
        return houseRepository.findAll();
    }

    @PutMapping
    public Optional<House> saveHouse(@RequestBody HouseForm houseForm){
        houseForm.setAreaRepository(areaRepository);
        Optional<House> house = Optional.of(houseForm.toHouse());
        houseRepository.save(house.get());
        return house;
    }

    @PostMapping
    public Optional<House> updateHouse(@RequestBody HouseForm houseForm){
        return saveHouse(houseForm);
    }

    @DeleteMapping
    public String deleteHouse(@RequestBody House house){
        try {
            houseRepository.delete(house);
        }catch (HibernateException e){
            return e.toString();
        }
        return "DELETED "+house.toString();
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
