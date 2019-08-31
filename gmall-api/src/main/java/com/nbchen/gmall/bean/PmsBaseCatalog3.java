package com.nbchen.gmall.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 3级类目表
 * @author nbchen
 * @date 2019/08/31
 */
@Data
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id; // 编号
    private String name; // 三级分类名称
    private String catalog2Id; // 二级分类编号

}
