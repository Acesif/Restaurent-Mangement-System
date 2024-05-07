package dev.project.restaurantmanagement.Dto;

import dev.project.restaurantmanagement.Entity.Role;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Boolean isSuccess;
    private Integer code;
    private String message;
    private T values;
}
