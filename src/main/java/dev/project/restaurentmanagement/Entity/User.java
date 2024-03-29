package dev.project.restaurentmanagement.Entity;

import dev.project.restaurentmanagement.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false)
    @Digits(integer = 11, fraction = 0)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 8)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
