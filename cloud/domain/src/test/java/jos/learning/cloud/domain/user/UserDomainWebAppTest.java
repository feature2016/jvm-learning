package jos.learning.cloud.domain.user;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by jos on 2018/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class UserDomainWebAppTest {

    private MockMvc mvc;

    private Long userId = 1L;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void list() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> {
                    log.info(result.getResponse().getContentAsString());
                });
    }


    @Test
    public void get() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/get").requestAttr("id",userId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(result -> {
                    log.info(result.getResponse().getContentAsString());
                });
    }
}