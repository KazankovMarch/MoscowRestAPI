package ru.adkazankov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.dao.NoiseReportRepository;
import ru.adkazankov.domain.NoiseReport;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area/{areaId}/noiseReport")
public class NoiseReportController {

    @Autowired
    private NoiseReportRepository noiseReportRepository;

    @GetMapping
    public List<NoiseReport> getAllReports(@PathVariable(name = "areaId") Long areaId){
        return noiseReportRepository.findAllByArea_id(areaId);
    }
    @GetMapping("{id}")
    public Optional<NoiseReport> getReport(@PathVariable(name = "areaId") Long areaId, @PathVariable(name = "id") Long id){
        return noiseReportRepository.findByArea_idAndId(areaId,id);
    }



}
