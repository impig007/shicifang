package com.huawei.service.impl;

import com.huawei.dao.FriendDao;
import com.huawei.friend.service.FriendService;
import com.huawei.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;
    @Override
    public int addFriend(String userId, String friendId) {
        Friend friend = new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendId);
        friend.setIslike("0");
        friendDao.save(friend);
        return 1;
    }
}
