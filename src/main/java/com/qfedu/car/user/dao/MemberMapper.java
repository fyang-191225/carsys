package com.qfedu.car.user.dao;


import com.qfedu.car.user.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    /**
     *
     * @param record
     * @return
     */
    int insert(Member record);

    /**
     *
     * @param msg
     * @return
     */
    Member selectByMsg(String msg);

    /**
     *
     * @param page
     * @param size
     * @return
     */
    List<Member> selectPage(@Param("page") int page, @Param("size") int size);

    long selectCount();
}