package com.example.aerial;

import com.example.aerial.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println(userDao.getUserList());
    }

    @Test
    void print(){
    }


}
