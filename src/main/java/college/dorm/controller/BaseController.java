package college.dorm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import college.dorm.json.ResponseEntity;
import college.dorm.service.ex.ServiceException;
import college.dorm.service.ex.ServiceExceptionEnum;

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
		Object houseparentID = session.getAttribute("houseparentID");
		if (houseparentID != null) {
			return Integer.valueOf(houseparentID.toString());
		}
		return null;

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
	public ResponseEntity<Void> exceptionHandler(Exception e) {
		// 声明返回对象
		ResponseEntity<Void> respEntity = new ResponseEntity<Void>();

		Integer code = null;

		ServiceExceptionEnum instance = ServiceExceptionEnum.getInstance();

		// 在返回对象封装错误提示的文字
		String message = e.getMessage();
		respEntity.setMessage(message);

		// 根据异常的不同，返回的错误代码也不同
		if (message.equals(instance.DUPLICATE_IS_INCUMBENCY.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.DUPLICATE_IS_INCUMBENCY.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.HAVE_NOT_COMPETENCE.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.HAVE_NOT_COMPETENCE.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.IDCARD_CONFLICT.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.IDCARD_CONFLICT.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.IDCARD_NOT_EXIST.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.IDCARD_NOT_EXIST.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.PASSWORD_ERROR.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.PASSWORD_ERROR.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.SUPER_REGISTRATION_ERROR.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.SUPER_REGISTRATION_ERROR.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.SYSTEM_ERROR.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.SYSTEM_ERROR.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.HAD_NOT_LOGIN.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.HAD_NOT_LOGIN.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.FILE_CONTENT_TYPE_EXCEPTION.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.FILE_CONTENT_TYPE_EXCEPTION.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.FILE_EMPTY_EXCEPTION.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.FILE_EMPTY_EXCEPTION.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.FILE_ILLEGAL_STATE_EXCEPTION.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.FILE_ILLEGAL_STATE_EXCEPTION.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.FILE_IO_EXCEPTION.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.FILE_IO_EXCEPTION.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.FILE_SIZE_EXCEPTION.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.FILE_SIZE_EXCEPTION.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.LOST_QUALIFICATIONS.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.LOST_QUALIFICATIONS.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.OFFLINE_LOGIN.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.OFFLINE_LOGIN.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.HANNIBAL_LECTER.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.HANNIBAL_LECTER.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.SELF_EXILE.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.SELF_EXILE.getDescription());
			respEntity.setState(code);

		} else if (message.equals(instance.ORIGINAL_OLD_KEYWORD_ERROR.getDescription())) {
			code = instance.getCodeByDescription(ServiceExceptionEnum.ORIGINAL_OLD_KEYWORD_ERROR.getDescription());
			respEntity.setState(code);

		}

		return respEntity;
	}

}
