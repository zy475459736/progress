package utils.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/me")
public class MeController {

	@RequestMapping("/get_info")
	@ResponseBody
	public ResponseData getInfo(@RequestParam String token) {
		User user = Jwt.unsign(token, User.class);
		if (user != null) {
			return ResponseData.ok().putDataValue("user", user);
		}
		return ResponseData.customerError().putDataValue(ResponseData.ERRORS_KEY, new String[] { "token?????" });
	}
}
