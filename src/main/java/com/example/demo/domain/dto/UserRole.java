package com.example.demo.domain.dto;

import lombok.Data;
import org.seasar.doma.*;

@Table(name = "user_roles")
@Entity
@Data
public class UserRole {

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //ユーザID
    Long user_id;

    //役割キー
    String role_key;

    //役割名
    String roleName;

    // 権限キー
    String permissionKey;

    // 権限名
    String permissionName;

}
