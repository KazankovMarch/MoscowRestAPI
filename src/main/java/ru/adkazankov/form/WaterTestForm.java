package ru.adkazankov.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.adkazankov.dao.AreaRepository;
import ru.adkazankov.domain.Area;
import ru.adkazankov.domain.WaterTest;

import java.util.Optional;

@Data
@AllArgsConstructor
public class WaterTestForm {
    private String name;
    private String resVal;

    public WaterTest toWaterTest(Long id, Area area){
        WaterTest test = new WaterTest();
        test.setArea(area);
        //если id == null,
        // оно будет сгенерированно в дальнейшем Spring JPA
        test.setId(id);
        test.setResVal(resVal);
        test.setName(name);
        return test;
    }
}
