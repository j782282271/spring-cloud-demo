package cn.org.zhixiang.controller;

import cn.org.zhixiang.domain.User;
import cn.org.zhixiang.feign.DirectConnUserFeignClient;
import cn.org.zhixiang.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DirectConnUserFeignClient directConnUserFeignClient;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userFeignClient.getUser(id);
    }

    @GetMapping("/getUser2")
    public User getUser2(@RequestParam("id") Long id) {
        Map<String, Long> map = new HashMap<>();
        map.put("id", id);
        return userFeignClient.getUser2(map);
    }

    @PostMapping("/putUser")
    public User putUser(@RequestBody User user) {
        return userFeignClient.putUser(user);
    }

    @GetMapping("/getUser/direct/{id}")
    public User getUserDirect(@PathVariable("id") Long id) {
        return directConnUserFeignClient.getUser(id);
    }
}
