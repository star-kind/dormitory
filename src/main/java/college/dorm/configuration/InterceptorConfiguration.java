package college.dorm.configuration;

import java.util.ArrayList;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import college.dorm.intercept.LoginInterceptor;

/**
 * 拦截器的配置类
 * 
 * @author gzh
 *
 */
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoginInterceptor interceptor = new LoginInterceptor();

		// 豁免列表
		ArrayList<String> remit = new ArrayList<>();

		remit.add("/CssFrame/**");
		remit.add("/Jquery/**");
		remit.add("/MySelfJS/**");
		remit.add("/MinePages/**");

		remit.add("/HouseParents/**");
		remit.add("/Visit/**");
		remit.add("/Students/**");

		// 注册拦截器
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(remit);
	}

}