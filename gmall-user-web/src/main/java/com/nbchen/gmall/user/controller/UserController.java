package com.nbchen.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nbchen.gmall.bean.UmsMember;
import com.nbchen.gmall.bean.UmsMemberReceiveAddress;
import com.nbchen.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author nbchen
 * @date 2019/08/30
 */
@Controller
public class UserController {

//    @Autowired
    @Reference // 用dubbo的自动注入
    private UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "hello user module";
    }


    /**
     * 查询所有的用户集合--test方法
     * @return
     */
    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMember = this.userService.getAllUser();
        return umsMember;
    }

    /**
     * 根据会员id查询收货地址
     * <p>
     *     前端传JSON类型的参数,用@RequestBody接收
     *     测试的时候,没办法模拟json,可以先注释掉
     * </p>
     * @param memberId
     * @return
     */
    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(/*@RequestBody*/ String memberId) {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = this.userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }

}
