package tw.elliot.ms.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisCtrl {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@GetMapping(path = "/putdata")
	public String putDate(@RequestParam String key, @RequestParam String value) {
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.set(key, value);
		return "put data success.";
	}

	@GetMapping(path = "/getdata")
	public String getData(@RequestParam String key) {
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		String value = operations.get(key);
		return value;
	}

}
