package tw.elliot.ms.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleCtrl {

	@Value("${minispring.title}")
	private String title;

	@GetMapping("/example")
	public String example() {
		return "Success";
	}

	@GetMapping("/title")
	public String title() {
		return title;
	}
}
