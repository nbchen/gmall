package com.nbchen.gmall.dto;

import com.nbchen.gmall.bean.PmsProductSaleAttrValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author nbchen
 * @date 2019/09/01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PmsProductSaleAttrDTO implements Serializable {
    String id ;

    String productId;

    String saleAttrId;

    String saleAttrName;


    List<PmsProductSaleAttrValue> spuSaleAttrValueList;
}
