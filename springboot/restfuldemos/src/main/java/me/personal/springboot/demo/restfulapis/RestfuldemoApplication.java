package me.personal.springboot.demo.restfulapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestfuldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfuldemoApplication.class, args);
	}

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
