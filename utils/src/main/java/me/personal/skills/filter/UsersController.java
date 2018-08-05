package me.personal.skills.filter;

/**
 * Created by zhongyi on 2017/10/25.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.xt.tutorial.models.User;
//import com.xt.tutorial.utils.JWT;
//import com.xt.tutorial.utils.ResponseData;

@Controller
@RequestMapping("/users")
public class UsersController {

    @RequestMapping("/login")
    @ResponseBody
    public ResponseData login(@RequestParam String username, @RequestParam String password) {
        if ("imjack".equals(username) && "123456".equals(password)) {
            ResponseData responseData = ResponseData.ok();
            User user = new User();
            user.setId(1);
            user.setUsername(username);
            user.setPassword(password);
            responseData.putDataValue("user", user);
            String token = Jwt.sign(user, 30L * 24L * 3600L * 1000L);
            if (token != null) {
                responseData.putDataValue("token", token);
            }
            return responseData;
        }
        return ResponseData.customerError().putDataValue(ResponseData.ERRORS_KEY, new String[] { "�û��������������" });
    }
}