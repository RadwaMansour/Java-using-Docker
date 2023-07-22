package domain.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class MealDto {
    String name ;
    Double price;
    String offer;
}
