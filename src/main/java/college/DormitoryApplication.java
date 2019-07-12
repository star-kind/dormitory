package college;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
/**
 * 自定义启动器类
 * 
 * @author gzh
 *
 */
// 扫描道层接口包
@MapperScan("college.dorm.mapper")
public class DormitoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DormitoryApplication.class, args);
	}

}
