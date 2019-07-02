package com.sunny.doubledatasource.Controller;

import com.sunny.doubledatasource.bean.User;
import com.sunny.doubledatasource.mapper.ds0.UserMapper1;
import com.sunny.doubledatasource.mapper.ds1.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-07-01 16:52
 */
@RestController
public class TestController {
    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    @Value("${datasource.ds0.driver-class-name}")
    String className;
    @Value("${datasource.ds0.type}")
    String name;

    @RequestMapping("/getUsers")
    @ResponseBody
    public Map<String, List<User>> getUsers() {
        System.out.println(name + ":" + className);
        List<User> list1 = userMapper1.queryAll();
        List<User> list2 = userMapper2.queryAll();
        Map<String, List<User>> map = new HashMap<>(2);
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String, List<User>> insertUser(User user) {
        userMapper1.insert(user);
        userMapper2.insert(user);
        List<User> list1 = userMapper1.queryAll();
        List<User> list2 = userMapper2.queryAll();
        Map<String, List<User>> map = new HashMap<>(2);
        map.put("list1", list1);
        map.put("list2", list2);
        return map;
    }
}
