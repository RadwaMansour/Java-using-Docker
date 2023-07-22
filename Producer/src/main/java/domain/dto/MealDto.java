package domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Data
@Value
@Getter
@Setter
public class MealDto {
    String name ;
    Double price;
    String offer;
    boolean delete;
}
