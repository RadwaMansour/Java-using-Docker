package service.consumer;
import domain.dto.MealDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {
    private static final String mealTopic ="${topic.name}";
    private final ObjectMapper objectMapper;
    private final CustomerService customerService;
    @Autowired
    public Consumer(ObjectMapper objectMapper ,CustomerService customerService){
        this.objectMapper=objectMapper;
        this.customerService=customerService;
    }
    @KafkaListener(topics = mealTopic)
    public void consumeMessage(String message)throws
            JsonProcessingException{
        log.info(" message consumed {}",message);
        MealDto mealDto = objectMapper.readValue(message,MealDto.class);
        customerService.persistMeal(mealDto);
    }
}
