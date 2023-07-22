package service.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import domain.Meal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class producer {
    @Value("${topic.name}")
    private String mealTopic;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String , String> KafkaTemplate ;
    @Autowired
    public producer(KafkaTemplate<String , String> KafkaTemplate,ObjectMapper objectMapper) {
        this.KafkaTemplate = KafkaTemplate;
        this.objectMapper = objectMapper;
    }
    public String sendMessage (Meal meal)throws JsonProcessingException{
        String mealAsMessage = objectMapper.writeValueAsString(meal);
        KafkaTemplate.send(mealTopic,mealAsMessage);
        log.info("Meal Produced{}",mealAsMessage);
        return "Meal sent";
    }
}
