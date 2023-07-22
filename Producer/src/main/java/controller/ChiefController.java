package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Meal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ChiefService;

@Slf4j
@RestController
@RequestMapping("/chief")
public class ChiefController {

    private final ChiefService chiefService;

    @Autowired
    public ChiefController(ChiefService chiefService) {
        this.chiefService = chiefService;
    }
    @PostMapping("/publishMeal")
    public String publishMeal(@RequestBody Meal meal) throws JsonProcessingException {
        log.info("publish Meal Request received");
        return chiefService.sendMeal(meal);
    }




}


