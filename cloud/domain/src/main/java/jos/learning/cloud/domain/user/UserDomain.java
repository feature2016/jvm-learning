package jos.learning.cloud.domain.user;

import io.micrometer.core.annotation.Timed;
import jos.learning.cloud.domain.user.dto.User;
import jos.learning.cloud.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by jos on 2018/6/14.
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
/**
 * A controller class to enable timings on every request handler in the controller.
 */
@Timed(value = "user",longTask = true)
public class UserDomain {
    @Autowired
    private UserService userService;

    @Value("${user.voteNumber}")
    @NotNull
    private Long voteNumber;

    @RequestMapping("/echo")
    public String echo() {
        log.info("user {} access echo interface!", "");
        return "Hello world";
    }

    @RequestMapping("/list")
    public List<User> list() {
        return userService.listUser();
    }

    @RequestMapping("/get")
    public User get(Long userId) {
        userId = Math.abs(Optional.ofNullable(userId).orElse(voteNumber).longValue()) % 4;
        return userService.getUser(userId);
    }

    @PostConstruct
    public void init() {
        userService.addUser("张三1", "admin");
        userService.addUser("李四2", "admin");
        userService.addUser("王五3", "admin");
        userService.addUser("陈六4", "admin");
    }
}
