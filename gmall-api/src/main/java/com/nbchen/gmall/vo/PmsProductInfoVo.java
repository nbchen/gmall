package com.nbchen.gmall.vo;

import com.nbchen.gmall.bean.PmsProductImage;
import com.nbchen.gmall.bean.PmsProductSaleAttr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * PmsProductInfo给页面展示的,页面有个spuName对应实体的productName
 * @author nbchen
 * @date 2019/09/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PmsProductInfoVo implements Serializable {

    private String id;

    private String spuName;

    private String description;

    private  String catalog3Id;

}
