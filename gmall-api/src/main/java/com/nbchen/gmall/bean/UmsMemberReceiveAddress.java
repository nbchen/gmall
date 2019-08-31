package com.nbchen.gmall.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 会员收获地址表
 * @author nbchen
 * @date 2019/08/30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ums_member_receive_address")
public class UmsMemberReceiveAddress implements Serializable {

    @Id
//    @KeySql(useGeneratedKeys = true)
    private String id;
    private String memberId;
    private String name; // 收货人名称
    private String phoneNumber;
    private String defaultStatus; // 是否为默认
    private String postCode; // 邮政编码
    private String province; // 省份/直辖市
    private String city; // 城市
    private String region; // 区
    private String detailAddress; // 详细地址(街道)

}
