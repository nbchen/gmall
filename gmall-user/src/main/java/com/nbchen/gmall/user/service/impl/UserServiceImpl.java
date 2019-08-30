package com.nbchen.gmall.user.service.impl;

import com.nbchen.gmall.user.bean.UmsMember;
import com.nbchen.gmall.user.bean.UmsMemberReceiveAddress;
import com.nbchen.gmall.user.mapper.UmsMemberMapper;
import com.nbchen.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.nbchen.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/30
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    /**
     * 查询所有的用户集合--test方法
     *
     * @return
     */
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = this.umsMemberMapper.selectAll();
        return umsMembers;
    }

    /**
     * 根据会员id查询收货地址
     *
     * @param memberId
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        // 方式一:创建对象设置id属性查询
        UmsMemberReceiveAddress memberReceiveAddress = UmsMemberReceiveAddress.builder().memberId(memberId).build();
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = this.umsMemberReceiveAddressMapper.select(memberReceiveAddress);

        // 方式二:创建example设置条件
//        Example example = new Example(UmsMemberReceiveAddress.class);
//        example.createCriteria().andEqualTo("memberId",memberId);
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = this.umsMemberReceiveAddressMapper.selectByExample(example);
        return umsMemberReceiveAddresses;
    }
}
