package com.lyj.auth.activiti;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
    public String getUsername(Integer id) {
        if (id == 1) {
            return "lilei";
        } else if (id == 2) {
            return "hanmeimei";
        }
        return "admin";
    }
}
