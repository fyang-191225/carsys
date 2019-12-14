package com.qfedu.car.user.service.impl;

import com.qfedu.car.common.result.ResultCode;
import com.qfedu.car.common.vo.PageBean;
import com.qfedu.car.common.vo.R;
import com.qfedu.car.config.RedisConfig;
import com.qfedu.car.dto.MemberQueryDto;
import com.qfedu.car.user.dao.MemberMapper;
import com.qfedu.car.user.entity.Member;
import com.qfedu.car.user.service.MemberService;
import com.qfedu.car.util.JedisUtil;
import com.qfedu.car.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FYY
 * @date 2019/12/10 0010 下午 20:35
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private JedisUtil jedisUtil;

    /**
     * 查询
     * @param msg
     * @return
     */
    @Override
    public R queryBymsg(String msg) {
        // 通过名字去数据库获取信息
        Member member = memberMapper.selectByMsg(msg);
        // 判断如果没有找到数据 返回R.OK 表示，数据库没有该条信息，用户名可以用
        // 如果找到数据了，返回R.fail 表示该用户名已被用过，现在不可用
        if (member == null) {
            return R.OK();
        } else {
            return R.fail();
        }
    }

    /**
     * 注册
     * @param member
     * @return
     */
    @Override
    public R register(Member member) {
        // 1. 校验该用户名是否存在
        if (queryBymsg(member.getUsername()).getCode()== ResultCode.OK.getVal()) {
            // 2. 不存在，再新增
            int c = memberMapper.insert(member);
            if (c > 0) {
                //添加成功 注册成功
                return R.OK();
            } else {
                // 添加失败 注册失败
                return R.fail();
            }
        } else {
            return R.fail("用户名已存在");
        }

    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public R login(String name, String password) {
        // 1、根据用户名查询用户信息
        Member member = memberMapper.selectByMsg(name);
        // 2. 校验用户是否存在，member != null 表示用户存在，继续判断
        if (member != null ) {
            // 3. 校验密码是否正确
            if (member.getUsername().equals(password)) {
                // 4. 成功 生成令牌， 存储为当前会员的id信息
                // (member.getId() + "" ): 表示long 类型转换为String类型
                String token = JwtUtil.createJWT(member.getId() + "");
                // 5. 使用jedis连接redis 把令牌存储到redis 中
                jedisUtil.addStr(RedisConfig.TOKEN_KEY + name, token + "", RedisConfig.TOEKN_TIME);

                return R.OK(member.getId());
            }
        }
        return R.fail("用户名或密码错误");
    }

    /**
     * 分页查询
     * @param memberQueryDto 前传入的分页查询需要的数据的对象
     * @return
     */
    @Override
    public R search(MemberQueryDto memberQueryDto) {
        List<Member> list = memberMapper.selectPage(memberQueryDto.getPage(), memberQueryDto.getSize());
        PageBean<Member> pageBean = new PageBean<>();

        pageBean.setData(list);
        pageBean.setPage(memberQueryDto.getPage());
        pageBean.setSize(memberQueryDto.getSize());
        pageBean.setTotal(memberMapper.selectCount());
        //计算总页数
        pageBean.setTotalPage(pageBean.getTotal()%memberQueryDto.getSize()==0?pageBean.getTotal()/pageBean.getSize()
                :pageBean.getTotal()/pageBean.getSize()+1);
        return R.OK(pageBean);
    }
}
