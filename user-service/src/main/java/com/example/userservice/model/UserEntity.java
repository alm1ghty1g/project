package com.example.userservice.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "department_id", nullable = false)
    private int departmentId;

}
