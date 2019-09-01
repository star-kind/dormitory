package college.dorm.service.ex;

/**
 * 业务异常枚举
 * 
 * @author gzh
 *
 */
public enum ServiceExceptionEnum {
	SYSTEM_ERROR(500, "系统异常"),
	/** 上传头像错误,读写文件时出现错误 */
	FILE_IO_EXCEPTION(424, "上传头像错误,读写文件时出现错误"),
	/** 上传错误,文件为空 */
	FILE_EMPTY_EXCEPTION(425, "上传错误,文件为空"),
	/** 文件过大,请另行选择不超过2MB的文件 */
	FILE_SIZE_EXCEPTION(426, "文件过大,请另行选择不超过2MB的文件"),
	/** 不支持选择的文件类型 */
	FILE_CONTENT_TYPE_EXCEPTION(427, "不支持选择的文件类型"),
	/** 存储头像文件出现异常 */
	FILE_ILLEGAL_STATE_EXCEPTION(428, "存储头像文件出现异常"),
	/** 尚未登录 */
	HAD_NOT_LOGIN(429, "尚未登录"),
	/** 身份证号已存在 */
	IDCARD_CONFLICT(430, "身份证号已存在"),
	/** 密码错误 */
	PASSWORD_ERROR(431, "密码错误"),
	/** 身份证号不存在 */
	IDCARD_NOT_EXIST(432, "身份证号不存在"),
	/** 您无此权限 */
	HAVE_NOT_COMPETENCE(433, "您无此权限"),
	/** 操作重复,该账号已经意向状态 */
	DUPLICATE_IS_INCUMBENCY(434, "操作重复,该账号已经意向状态"),
	/** 超级宿管已存在,您无权限注册新的超级宿管 */
	SUPER_REGISTRATION_ERROR(435, "超级宿管已存在,您无权限注册新的超级宿管"),
	/** Qualifications:资格 */
	LOST_QUALIFICATIONS(436, "你已失格(非在职),禁止登录"),
	/** 脱离登录 */
	OFFLINE_LOGIN(437, "您已下线,请重新登录"),
	/** 汉尼拔异常 */
	HANNIBAL_LECTER(438, "除超级宿管外,禁止其余人改动高级宿管的在岗状态,高级宿管之间亦不得互相改动"),
	/** 自我放逐异常 */
	SELF_EXILE(439, "超级宿管员无权自我改动"),
	/**原旧密码错误*/
	ORIGINAL_OLD_KEYWORD_ERROR(440,"原旧密码错误"),
	/** 实例 */
	INSTANCE;

	ServiceExceptionEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	private ServiceExceptionEnum() {
	}

	private Integer code;
	private String description;

	public Integer getCode() {
		return code;
	}

	private void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 据代号而获描述
	 * 
	 * @param code
	 * @return
	 */
	public String getDescriptionByCode(Integer code) {
		for (ServiceExceptionEnum e : ServiceExceptionEnum.values()) {
			if (e.getCode() == code) {
				return e.description;
			}
		}
		return null;
	}

	/**
	 * 据描述而获代号
	 * 
	 * @param description
	 * @return
	 */
	public Integer getCodeByDescription(String description) {
		for (ServiceExceptionEnum e : ServiceExceptionEnum.values()) {
			if (description.equals(e.getDescription())) {
				System.err.println(this.getClass().getName() + ":code:" + e.code);
				return e.code;
			}
		}
		return null;
	}

	/* 懒汉式 */
	private static ServiceExceptionEnum instance = null;

	public static ServiceExceptionEnum getInstance() {
		if (instance == null) {
			instance = ServiceExceptionEnum.INSTANCE;
		}
		return instance;
	}

}