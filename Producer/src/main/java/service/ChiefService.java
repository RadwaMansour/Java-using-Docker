package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Meal;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.Producer.producer;

@Slf4j
@Service
public class ChiefService {
  private final producer producer;
    private ObjectMapper objectMapper;

    @Autowired
    public ChiefService(producer producer)
    {
        this.producer=producer;
    }
     public String sendMeal(Meal meal)throws JsonProcessingException { return producer.sendMessage(meal);}


}
