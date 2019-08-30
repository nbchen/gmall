package com.nbchen.gmall.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员等级表
 * @author nbchen
 * @date 2019/08/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ums_member_level")
public class UmsMemberLevel implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String id;
    private String name;
    private int growthPoint; // 成长值
    private int defaultStatus; // 是否为默认等级：0->不是；1->是
    private BigDecimal freeFreightPoint; // 免运费标准
    private int commentGrowthPoint; // 每次评价获取的成长值
    private int priviledgeFreeFreight; // 是否有免邮特权
    private int priviledgeSignIn; // 是否有签到特权
    private int priviledgeComment; // 是否有评论获奖励特权
    private int priviledgePromotion; // 是否有专享活动特权
    private int priviledgeMemberPrice; // 是否有会员价格特权
    private int priviledgeBirthday; // 是否有生日特权
    private String note;
}
