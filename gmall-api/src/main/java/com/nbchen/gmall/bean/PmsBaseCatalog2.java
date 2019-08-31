package com.nbchen.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 2级类目表
 * @param
 * @return
 */
@Data
public class PmsBaseCatalog2 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String catalog1Id;

    @Transient
    private List<PmsBaseCatalog3> catalog3List;

}
