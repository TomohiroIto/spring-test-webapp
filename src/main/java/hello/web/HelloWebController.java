package hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWebController {

	@RequestMapping("/test")
    public String home() {
        return "hello";
    }
}
