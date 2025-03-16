package com.ming.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class TestAll {
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 测试密码加密
     */
    @Test
    public void testPwd(){
        String pwd = "123456";
        String encode = passwordEncoder.encode(pwd);
        System.out.println(encode);
        boolean flag = passwordEncoder.matches(pwd,
                "$2a$10$m/6DwbWS7Ex2bGVEwMdA1.pUNZeeL8KX85Ouj5moSBTXWmY1aQdui");
        System.out.println(flag);
    }
}
