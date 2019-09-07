package college.dorm.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import college.dorm.intercept.LoginInterceptor;

/**
 * 拦截器的配置类
 * 
 * @author gzh
 *
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LoginInterceptor interceptor = new LoginInterceptor();

		// 豁免列表
		ArrayList<String> remit = new ArrayList<>();

		// 静态页面文件
		remit.add("/CssFrame/**");
		remit.add("/Jquery/**");
		remit.add("/MySelfJS/**");
		remit.add("/MinePages/**");

		// 控制器访问路径
		remit.add("/HouseParents/**");
		remit.add("/Visit/**");
		remit.add("/Students/**");

		// 注册拦截器
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(remit);
	}

}