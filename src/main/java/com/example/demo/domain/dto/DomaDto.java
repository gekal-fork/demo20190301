package com.example.demo.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(listener = DefaultEntityListener.class)// 自動的にシステム制御項目を更新するためにリスナーを指定する
@Data
public class DomaDto implements Serializable {

    // 作成者
    @JsonIgnore
    @Column
    private String created_by;

    //作成日時
    @JsonIgnore
    @Column
    private LocalDateTime Created_at;

    //更新者
    @JsonIgnore
    @Column
    private String updated_by;

    //更新日時
    @JsonIgnore
    @Column
    private  LocalDateTime updated_at;

    //削除者
    @JsonIgnore
    @Column
    private String deleted_by;

    //削除日
    @JsonIgnore
    @Column
    private LocalDateTime deleted_at;

    //バージョン
    @JsonIgnore
    @Column
    private int version;

}
