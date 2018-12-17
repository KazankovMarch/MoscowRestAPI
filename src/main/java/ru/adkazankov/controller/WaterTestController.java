package ru.adkazankov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.dao.AreaRepository;
import ru.adkazankov.dao.WaterTestRepository;
import ru.adkazankov.domain.Area;
import ru.adkazankov.domain.WaterTest;
import ru.adkazankov.form.WaterTestForm;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area/{areaId}/waterTest")
public class WaterTestController {
    //Здесь Spring JPA подставляет нужную реализацию этих интерфейсов
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private WaterTestRepository waterTestRepository;
    //первые два аргумента передаются в адресной строке,
    // последний - в теле запроса
    @PutMapping("/{id}")
    public WaterTest putWaterTest(@PathVariable(name = "areaId") Long areaId,
                                  @PathVariable(name = "id") Long id,
                                  @RequestBody WaterTestForm waterTestForm){
        Optional<Area> area = areaRepository.findById(areaId);
        //проверяем корректность запроса
        if(area.isPresent()){
            return waterTestRepository
                    .save(waterTestForm.toWaterTest(id, area.get()));
        }
        else {
            return null;
        }
    }
    //далее другие обработчики...

    @GetMapping
    public List<WaterTest> getAllWaterTests(@PathVariable(name = "areaId") Long areaId){
        return waterTestRepository.findAllByArea_id(areaId);
    }

    @GetMapping("/{id}")
    public Optional<WaterTest> getWaterTest(@PathVariable(name = "areaId") Long areaId, @PathVariable(name = "id") Long id){
        return waterTestRepository.findById(id);
    }

    @PostMapping()
    public WaterTest postWaterTest(@PathVariable(name = "areaId") Long areaId, @RequestBody WaterTestForm waterTestForm){
        Optional<Area> area = areaRepository.findById(areaId);
        if(area.isPresent()){
            return waterTestRepository.save(waterTestForm.toWaterTest(null, area.get()));
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteWaterTest(@PathVariable(name = "areaId") Long areaId, @PathVariable(name = "id") Long id){
        Optional<WaterTest> waterTest = waterTestRepository.findByIdAndArea_id(id, areaId);
        if(waterTest.isPresent()){
            waterTestRepository.delete(waterTest.get());
            return true;
        }
        else {
            return false;
        }
    }
}
