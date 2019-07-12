package college.dorm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import college.dorm.json.ResponseEntity;
import college.dorm.service.except.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 控制器基类
 * 
 * @author gzh
 *
 */
public class BaseController {
	/**
	 * "成功"意味码
	 */
	public static final int SUCCESS = 200;

	/**
	 * 从Session中获取当前登录的用户的id
	 *
	 * @param session
	 * @return 当前登录的用户的id
	 */
	protected Integer getIdFromSession(HttpSession session) {
		return Integer
				.valueOf(session.getAttribute("houseparentID").toString());
	}

	/**
	 * 将object转换为Integer
	 *
	 * @param obj
	 * @return
	 */
	protected Integer objCastToInteger(Object obj) {
		Integer integer = null;
		if (obj != null) {
			if (obj instanceof Integer) {
				integer = (Integer) obj;
			}
		}
		return integer;
	}

	/**
	 * 将字符串转化为年月日期类型格式
	 *
	 * @param str
	 * @return
	 */
	public Date strCastToDate(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			date = sdf.parse(str);
			System.err.println("str date: " + date);
		} catch (Exception e) {
			try {
				date = sdf.parse("1970-01-01");
				System.err.println("default date: " + date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return date;
	}

	@ExceptionHandler({ServiceException.class})
	public ResponseEntity<Void> handleException(Exception e) {
		// 声明返回对象
		ResponseEntity<Void> rr = new ResponseEntity<Void>();
		// 在返回对象封装错误提示的文字
		rr.setMessage(e.getMessage());

		// 根据异常的不同，返回的错误代码也不同
		if (e instanceof ServiceException) {
			rr.setState(666);
		}

		// 返回
		return rr;
	}
}
