package com.nbchen.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 1级类目表
 * @param
 * @return
 */
@Data
public class PmsBaseCatalog1 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;

    @Transient // 告诉mybatis,这个字段不保存数据库;transient,暂时的,游离态的.
    private List<PmsBaseCatalog2> catalog2s;


}

