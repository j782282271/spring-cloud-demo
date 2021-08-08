package cn.org.zhixiang.feign;

import cn.org.zhixiang.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "direct-conn-provider-demo", url = "localhost:5672")
public interface DirectConnUserFeignClient {

    @GetMapping(value = "/user/getUser/{id}")
    User getUser(@PathVariable("id") Long id);
}
