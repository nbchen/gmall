package com.nbchen.gmall.service;


import com.nbchen.gmall.bean.UmsMember;
import com.nbchen.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/30
 */
public interface UserService {
    /**
     * 查询所有的用户集合--test方法
     * @return
     */
    List<UmsMember> getAllUser();

    /**
     * 根据会员id查询收货地址
     * @param memberId
     * @return
     */
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
