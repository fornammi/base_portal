package nammi.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	/**
	 * 不能拦截访问登录页面的请求，否则就造成死循环
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object handler) throws Exception {
		
		//设置不拦截的对象:除了登陆界面和静态资源,其他都要拦截
		String[] noFilters = {"js","images","css","common",
				"/login/toLoginPage.htm",
				//"/login/success.htm",//该请求需要获取session，所以需要拦截
				"/login/doLogin.htm"
				};
		String reqUri = req.getRequestURI();
		System.out.println("[LoginInterceptor@preHandle]request uri is:"+reqUri);
		boolean beFilter = true;
		for(String s : noFilters){
			//不包含时，直接跳出for循环,执行拦截
			if(reqUri.indexOf(s)!=-1){
				beFilter = false;
				break;
			}
		}
		if(beFilter){
			HttpSession session = req.getSession(true);
			String loginCode = (String)session.getAttribute("loginCode");
			if(StringUtils.isBlank(loginCode)){
				System.out.println("页面过期，重新登录");
				String root = req.getContextPath();
				resp.sendRedirect(root+"/login/toLoginPage.htm");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
	throws Exception {
		// TODO Auto-generated method stub
		
	}

}
