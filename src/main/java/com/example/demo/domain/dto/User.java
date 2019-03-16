package com.example.demo.domain.dto;

import lombok.Data;
import org.seasar.doma.*;

@Entity
@Data
@Table(name = "users")
public class User extends DomaDto{
    //自動採番設定
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

}
