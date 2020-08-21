package tw.elliot.ms.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleCtrl {

	@GetMapping("/example")
	public String example() {
		return "Success";
	}
}
