package com.example.demo.dto;

import lombok.Data;
import org.seasar.doma.*;

@Entity
@Data
@Table(name = "users")
public class User {
    //自動採番設定
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}
