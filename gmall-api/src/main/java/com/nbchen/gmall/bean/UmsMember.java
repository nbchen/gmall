package com.nbchen.gmall.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 会员表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ums_member") // 指定目标数据库表的表名
public class UmsMember implements Serializable {

    @Id
//    @KeySql(useGeneratedKeys = true) // 主键返回策略
    private String id; // 主键
    private String memberLevelId;
    private String username; // 用户名
    private String password; // 密码
    private String nickname; // 昵称
    private String phone; // 手机号码
    private int status; // 帐号启用状态:0->禁用；1->启用
    private Date createTime; // 注册时间
    private String icon; // 头像
    private int gender; // 性别：0->未知；1->男；2->女
    private Date birthday; // 生日
    private String city; // 所做城市
    private String job; // 职业
    private String personalizedSignature; // 个性签名
    private int sourceType; // 用户来源
    private int integration; // 积分
    private int growth; // 成长值
    private int luckeyCount; // 剩余抽奖次数
    private int historyIntegration; // 历史积分数量
}