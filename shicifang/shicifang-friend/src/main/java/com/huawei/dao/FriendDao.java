package com.huawei.dao;

import com.huawei.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendDao extends JpaRepository<Friend,String> {
    //根据用户id和好友id查询用户个数
    @Query()
    public int SelectCount(String userId,String friendId);

}
