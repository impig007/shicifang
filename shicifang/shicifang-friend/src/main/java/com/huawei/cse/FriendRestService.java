package com.huawei.cse;

import com.huawei.entity.Result;
import com.huawei.friend.service.FriendService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.QueryParam;

@RestSchema(schemaId = "friend")
@RequestMapping("/friend")
public class FriendRestService {
    @Autowired
    private FriendService friendService;
    @PostMapping("/like")
    public Result addFriend(@QueryParam("userId") String userId, @QueryParam("friendId")String friendId){
        friendService.addFriend(userId,friendId);
        return new Result(true,"关注成功","1");
    }

}
