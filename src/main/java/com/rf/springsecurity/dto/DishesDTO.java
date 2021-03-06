package com.rf.springsecurity.dto;

import com.rf.springsecurity.entity.Dish;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DishesDTO {
    private List<Dish> dishes;
}
