package nammi.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {

	@RequestMapping(value = "toUserPage")
	public String toUserPage(){
		return "user/user_manage";
	}
	
	@RequestMapping(value = "toPrivPage")
	public String toPrivPage(){
		return "priv/priv_manage";
	}
}
