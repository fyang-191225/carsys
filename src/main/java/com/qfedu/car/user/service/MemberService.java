package com.qfedu.car.user.service;

import com.qfedu.car.common.vo.R;
import com.qfedu.car.dto.MemberQueryDto;
import com.qfedu.car.user.entity.Member;

/**
 * @author FYY
 * @date 2019/12/10 0010 下午 20:29
 */

public interface MemberService {
    /**
     *  查询信息
     * @param msg
     * @return
     */
    R queryBymsg(String msg);

    /**
     * 注册
     * @param member
     * @return
     */
    R register(Member member);

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    R login(String name,String password);

    /**
     * 后台管理系统 搜索接口 分页
     * @param memberQueryDto
     * @return
     */
    R search(MemberQueryDto memberQueryDto);
}
