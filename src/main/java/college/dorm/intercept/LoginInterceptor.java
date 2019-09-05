package college.dorm.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录拦截器
 * 
 * @author gzh
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String contextPath = request.getServletContext().getContextPath();
		System.out.println("contextPath:" + contextPath);

		if (session.getAttribute("houseparentID") == null || "".equals(session.getAttribute("houseparentID"))) {
			response.sendRedirect(contextPath + "/HouseParents/logining");
			return false;
		}

		return true;
	}

}