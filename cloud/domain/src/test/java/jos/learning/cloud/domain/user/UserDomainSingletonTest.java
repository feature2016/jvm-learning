package jos.learning.cloud.domain.user;


import jos.learning.cloud.domain.user.dto.User;
import jos.learning.cloud.domain.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

/**
 * Created by jos on 2018/6/14.
 */
@RunWith(SpringRunner.class)
/**
 * 自动装配和扫描对应的controller bean
 */
@WebMvcTest(UserDomain.class)
@Slf4j
public class UserDomainSingletonTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup(){
        BDDMockito.given(userService.listUser()).willReturn(Collections.singletonList(
                User.builder().name("test").build()
        ));
    }

    @Test
    public void list() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> {
                    log.info(result.getResponse().getContentAsString());
                });
    }
}