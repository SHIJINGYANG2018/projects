package com.sjy.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;


public class TestApplication {
    private static Logger logger = LoggerFactory.getLogger(TestApplication.class);
    public static void main(String[] args) throws Exception {
        User user = new User("id","2s");
        System.out.println(JSONObject.toJSONString(user));
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}
class User{
    @JSONField(name = "user_id")
    private String userId;
    @JSONField(name = "user_id1")
    private String userId1;

    public User() {
    }

    public User(String userId, String userId1) {
        this.userId = userId;
        this.userId1 = userId1;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }
}
