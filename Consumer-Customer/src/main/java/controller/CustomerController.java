package controller;

import domain.Meal;
import service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final service.CustomerService customerService;

    @Autowired
    public CustomerController(service.CustomerService  customerService) {
        this. customerService =  customerService;
    }
    @PostMapping("/deleteMeal")
    public String deleteMeal(@RequestBody domain.Meal meal){
        log.info("delete Meal Request received");
        return customerService.deleteMeal(meal);
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity <Meal> getMealById(@PathVariable ("id") long id){
       domain.Meal meal = customerService.getMeal(id);
       if(meal != null){
           return new ResponseEntity<>(meal, HttpStatus.OK);
       }else{
           return new ResponseEntity<>(meal, HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("/getAllMeals")
    public ResponseEntity<List<Meal>>getAllMeals(){
        log.info("get All Meals request recevied");
        return new ResponseEntity<>(customerService.getAllMeals(),HttpStatus.OK);
    }



}


