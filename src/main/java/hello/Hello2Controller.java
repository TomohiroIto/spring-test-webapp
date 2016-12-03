package hello;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

	@RequestMapping("/hello")
	public Map<String, String> index() {
		return Collections.singletonMap("message", "Hello, World!");
	}
}
