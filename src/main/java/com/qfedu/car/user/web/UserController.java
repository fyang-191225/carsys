package com.qfedu.car.user.web;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.MemberQueryDto;
import com.qfedu.car.user.entity.Member;
import com.qfedu.car.user.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FYY
 * @date 2019/12/12 0012 上午 11:10
 */

@Api(value = "实现会员的操作", tags = "实现会员的操作")
@RestController
public class UserController {

    @Autowired
    private MemberService memberServiceImpl;

    @ApiOperation(value = "校验会员的注册名称是否存在", notes = "校验会员的注册名称是否存在")
    @GetMapping("/api/user/member/checkName.do")
    public R checkMsg(String msg) {
        return memberServiceImpl.queryBymsg(msg);
    }

    @ApiOperation(value = "实现会员注册", notes = "实现会员注册")
    @PostMapping("/api/user/member/register.do")
    public R register(@RequestBody Member member) {
        return memberServiceImpl.register(member);
    }

    @ApiOperation(value = "实现会员登录", notes = "实现会员登录")
    @GetMapping("/api/user/member/login.do")
    public R login(String name, String password) {
        return memberServiceImpl.login(name,password);
    }

    @ApiOperation(value = "查询全部内容分页", notes = "查询全部内容分页")
    @GetMapping("/api/user/member/page.do")
    public R page(@RequestBody MemberQueryDto memberQueryDto) {
        return memberServiceImpl.search(memberQueryDto);
    }

}
