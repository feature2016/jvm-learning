package jos.learning.cloud.domain.global;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jos on 2018/6/14.
 */
@Controller
public class DomainErrorEndpoint  implements ErrorController {




    @RequestMapping(produces = "text/html")
    @ResponseBody
    public String errorHtml() {
        return "客官~小二正忙";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}