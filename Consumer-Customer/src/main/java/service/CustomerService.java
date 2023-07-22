package service;

import domain.Meal;
import domain.dto.MealDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MealRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {
    private final MealRepository  mealRepository ;
    public  final ModelMapper modelMapper;
    @Autowired
    public CustomerService(MealRepository mealRepository , ModelMapper modelMapper)
    {
        this.mealRepository = mealRepository;
        this.modelMapper = modelMapper;
    }
    public void persistMeal(MealDto mealDto)
    {
        Meal meal = modelMapper.map(mealDto,Meal.class);
        Meal persistedMeal =mealRepository.save(meal);
        log.info("Meal persisted {}",persistedMeal);
    }
    public Meal getMeal(Long id){
        Optional<Meal> meal = mealRepository.findById(id);
        log.info("Meal fetched {}",meal);
        return meal.orElse(null);
    }
    public List<Meal> getAllMeals(){
        List<Meal> meals =mealRepository.findAll();
        log.info("Meals size {}",meals.size());
        return meals;
    }
    public String deleteMeal(Meal meal){
        mealRepository.deleteById(meal.getId());
        log.info("Meal deleted {}",meal.getId());
        return  "Meal with id:"+meal.getId()+"deleted successfully.";
    }

}
