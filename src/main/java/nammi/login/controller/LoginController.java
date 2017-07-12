package nammi.login.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nammi.login.model.LoginInfo;
import nammi.login.service.LoginInfoService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login/*")//根路径
public class LoginController {
	@Resource
	private LoginInfoService loginService;
	
	@RequestMapping(value="toLoginPage.htm")
	public String toLoginPage(){
		return "login/login";
	}
	
	@RequestMapping(value="success.htm")
	public ModelAndView toMainPage(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mv = new ModelAndView("main");
		//没有参数true：html获取不到session
		HttpSession session = req.getSession(true);
		String loginCode = (String)session.getAttribute("loginCode");
		mv.addObject("loginCode", loginCode);
		return mv;
	}
	
	/**
	 * @ModelAttribute("userInfo")获取页面name="userInfo.*"的属性值
	 * @param userInfo
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value="doLogin.htm")
	public ModelAndView doLogin(@ModelAttribute("userInfo")LoginInfo userInfo, HttpServletRequest req, HttpServletResponse resp){
		String _userId = userInfo.getLoginCode();
		String _password = userInfo.getPassword();
		/*Map conMap = new HashMap();
		conMap.put("loginCode", _userId);
		LoginInfo info = loginService.findLoginInfoByMap(conMap);*/
		if("admin".equals(_userId) && "spring".equals(_password)){
			//使用session：req.getSession(true)强制生成Session
			HttpSession session = req.getSession(true);
			session.setAttribute("loginCode", _userId);
			System.out.println("nammi@session value:"+session.toString());
			System.out.println("nammi@session value:loginCode="+session.getAttribute("loginCode"));
			//重定向:需要根目录
			try {
				String root = req.getContextPath();
				//servlet重定向
				resp.sendRedirect(root + "/login/success.htm");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
			//方式2：springMVC重定向
			//return new ModelAndView("redirect:/login/success.htm");
		}else{
			ModelAndView mv = new ModelAndView("login/login.htm");
			mv.addObject("errorMsg", "用户名或密码错误");
			return mv;
		}
	}
}
