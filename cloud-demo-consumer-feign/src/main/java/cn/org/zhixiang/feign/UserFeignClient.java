package cn.org.zhixiang.feign;

import cn.org.zhixiang.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//@FeignClient(value = "provider-demo",configuration = Configuration.class)修改契约为Feign的契约
@FeignClient(value = "provider-demo", decode404 = true)
public interface UserFeignClient {

    @GetMapping(value = "/user/getUser/{id}")
    User getUser(@PathVariable("id") Long id);

//    @GetMapping(value = "/user/getUser/{id}", headers = {"Content-Type=application/json", "Accept=application/json"})
//    User getUser(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestHeader("contentType") String type);

    @GetMapping(value = "/user/getUser")
    User getUser2(@RequestParam Map<String, Long> map);

    @PostMapping(value = "/user/put")
    User putUser(User user);

}
