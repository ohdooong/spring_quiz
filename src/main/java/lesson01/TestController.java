package lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {

	@ResponseBody
	@RequestMapping("/test1")
	public String test1 () {
		return "헬로월드";
	}
}
