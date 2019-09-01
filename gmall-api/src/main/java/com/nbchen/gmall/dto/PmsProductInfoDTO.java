package com.nbchen.gmall.dto;

import com.nbchen.gmall.bean.PmsProductImage;
import com.nbchen.gmall.bean.PmsProductSaleAttr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
public class PmsProductInfoDTO implements Serializable {

    private String id;

    private String spuName;

    private String description;

    private  String catalog3Id;

    private List<PmsProductSaleAttrDTO> spuSaleAttrList;

    private List<PmsProductImage> spuImageList;

}
