package college.dorm.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import college.dorm.mapper.HouseparentMapper;
import college.dorm.pojo.Houseparent;
import college.dorm.service.IHouseparentService;
import college.dorm.service.ex.ServiceException;
import college.dorm.service.ex.ServiceExceptionEnum;
import college.dorm.service.kit.HouserparentServiceUtil;

@Service
public class HouseparentServiceImpl implements IHouseparentService {
	@Autowired
	private HouseparentMapper hpm;

	/* 工具类 */
	public HouserparentServiceUtil hsu = HouserparentServiceUtil.getInstance();

	/**
	 * 确定上传文件的名称
	 */
	private static final String UPLOAD_DIR = "upload";

	/**
	 * 确定上传文件的最大大小
	 */
	private static final long UPLOAD_MAX_SIZE = 1 * 1024 * 1024;

	/* 标记桩 */
	private String mark = this.getClass().getName() + ": ";

	@Override
	public Houseparent houseParentLogin(String idCard, String password, HttpSession session) throws ServiceException {
		Houseparent h = hpm.selectByIdCard(idCard);

		HouseparentServiceImpl impl = new HouseparentServiceImpl();
		String description = null;

		if (h == null) {
			description = ServiceExceptionEnum.IDCARD_NOT_EXIST.getDescription();
			throw new ServiceException(description);
		}
		System.out.println(impl.getClass().getName() + ":" + h.getPassword());

		boolean verify = hsu.verify(password, h.getPassword());

		if (!verify) {
			description = ServiceExceptionEnum.PASSWORD_ERROR.getDescription();
			throw new ServiceException(description);
		}
		System.out.println(impl.getClass().getName() + ":" + idCard);

		if (!(h.getIsIncumbency() == 1)) {
			description = ServiceExceptionEnum.LOST_QUALIFICATIONS.getDescription();
			throw new ServiceException(description);
		}

		session.setAttribute("idCard", idCard);
		session.setAttribute("houseparentID", h.getHpid());

		return h;
	}

	@Override
	public Integer registration(String hpname, String password, String phone, String idCard) throws ServiceException {
		Houseparent houseparent = hpm.selectByIdCard(idCard);

		// 判断身份证号是否已被使用
		if (!(houseparent == null)) {
			String description = ServiceExceptionEnum.IDCARD_CONFLICT.getDescription();
			throw new ServiceException(description);
		}

		Houseparent h1 = new Houseparent();

		h1.setHpname(hpname);
		h1.setPhone(phone);
		h1.setIdCard(idCard);

		// 获取盐值
		String salt = hsu.extractSalt();
		h1.setSalt(salt);

		// 制作密文
		String keywordText = hsu.generateKeywordText(password, salt);
		h1.setPassword(keywordText);

		// 注册日期
		h1.setRegTime(new Date());

		h1.setCompetence(0);
		h1.setIsIncumbency(1);

		Integer affects = hpm.insertHouseparent(h1);

		return affects;

	}

	@Override
	public Houseparent showOwnProfile(Integer houseparentID) throws ServiceException {
		if (houseparentID == null) {
			String description = ServiceExceptionEnum.HAD_NOT_LOGIN.getDescription();
			throw new ServiceException(description);
		}

		Houseparent houseparent = hpm.selectByHpid(houseparentID);

		houseparent.setPassword(null);
		houseparent.setSalt(null);

		return houseparent;
	}

	@Override
	public String revampAvatar(HttpServletRequest request, MultipartFile portrait)
			throws ServiceException, IllegalStateException, IOException, ServletException {
		// 检查文件是否为空
		if (portrait.isEmpty()) {
			// 为空：抛出异常：FileEmptyException
			throw new ServiceException(ServiceExceptionEnum.FILE_EMPTY_EXCEPTION.getDescription());
		}

		// 检查文件大小
		if (portrait.getSize() > UPLOAD_MAX_SIZE) {
			// 超出范围(> UPLOAD_MAX_SIZE)：抛出异常：FileSizeException
			throw new ServiceException(ServiceExceptionEnum.FILE_SIZE_EXCEPTION.getDescription());
		}

		// 检查文件类型
		String contentType = portrait.getContentType();
		System.err.println(mark + "contentType:" + contentType);

		boolean type = hsu.checkFileContentType(contentType);

		if (!type) {
			// 类型不符(contains()为false)：抛出异常：FileContentTypeException
			throw new ServiceException(ServiceExceptionEnum.FILE_CONTENT_TYPE_EXCEPTION.getDescription());
		}

		// 确定文件夹路径：request.getServletContext().getRealPath(UPLOAD_DIR);
		String parentPath = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println(mark + "parentPath:" + parentPath);

		// 创建上传文件夹的File对象parent
		File parent = new File(parentPath);

		// 检查文件夹是否存在，如果不存在，则创建
		if (!parent.exists()) {
			parent.mkdirs();
		}
		System.out.println(mark + "parent:" + parent.getAbsolutePath());

		// 获取原文件名：file.getOriginalFilename()
		String originalFilename = portrait.getOriginalFilename();
		System.err.println(mark + "originalFilename:" + originalFilename);

		String suffix = "";

		// 从原文件名中得到扩展名
		int beginIndex = originalFilename.lastIndexOf(".");
		if (beginIndex > 0) {
			suffix = originalFilename.substring(beginIndex);
		}

		// 确定文件名：uuid/nanoTime/...
		String filename = System.nanoTime() + suffix;

		// 创建dest对象：new File(parent, filename);
		File dest = new File(parent, filename);
		System.err.println(mark + "dest: " + dest.getAbsolutePath());

		try {
			// 执行上传：file.transferTo(dest);
			portrait.transferTo(dest);
		} catch (IllegalStateException e) {
			// catch:IllegalStateException：抛出FileIllegalStateException
			e.printStackTrace();
			throw new ServiceException(ServiceExceptionEnum.FILE_ILLEGAL_STATE_EXCEPTION.getDescription());
		} catch (IOException e) {
			// catch:IOException：抛出FileIOException
			e.printStackTrace();
			throw new ServiceException(ServiceExceptionEnum.FILE_IO_EXCEPTION.getDescription());
		}

		// 获取ID
		String houseparentID = request.getSession().getAttribute("houseparentID").toString();
		Integer hpid = Integer.parseInt(houseparentID);

		// 生成肖像全名：/UPLOAD_DIR/文件名.扩展名
		String avatar = "/" + UPLOAD_DIR + "/" + filename;
		System.err.println(mark + "avatar:" + avatar);

		// 执行更新：据id而改化身名称
		Integer affect = hpm.updatePortraitByHpid(hpid, avatar);
		System.err.println(mark + "affect:" + affect);

		// 返回String avatar
		return avatar;
	}

	@Override
	public List<Houseparent> gainHouseParentList(HttpSession session) throws ServiceException {
		String description = ServiceExceptionEnum.OFFLINE_LOGIN.getDescription();

		var houseparentID = session.getAttribute("houseparentID");

		if (houseparentID == null || "".equals(houseparentID)) {
			throw new ServiceException(description);
		}
		return hpm.selectAllHouseparent();

	}

	@Override
	public Integer batchSetIsIncumbency(Integer[] hpids, HttpSession session, Integer isIncumbency) throws ServiceException {
		Integer id = Integer.parseInt(session.getAttribute("houseparentID").toString());

		Houseparent hp = hpm.selectByHpid(id);

		// 权限=0,抛权限不足异常
		if (hp.getCompetence() == 0) {
			String description = ServiceExceptionEnum.HAVE_NOT_COMPETENCE.getDescription();
			throw new ServiceException(description);
		}

		// 除超级宿管外,禁止其余人改动高级宿管的在岗状态,高级宿管之间亦不得互相改动
		Integer[] competences = hpm.batchSelectCompetenceHouseparent(hpids);
		boolean checkCompetence = hsu.checkCompetence(competences);
		if (!checkCompetence) {
			String description = ServiceExceptionEnum.HANNIBAL_LECTER.getDescription();
			throw new ServiceException(description);
		}

		Integer affects = hpm.batchSetIsIncumbencyByHpid(isIncumbency, hpids);
		System.err.println(mark + "affects:" + affects);

		return affects;
	}

	@Override
	public Integer manipulateBySuperDo(HttpSession session, Integer option, Integer[] hpids) throws ServiceException {
		Integer id = Integer.parseInt(session.getAttribute("houseparentID").toString());

		Houseparent hp = hpm.selectByHpid(id);

		// 权限!=2,抛权限不足异常
		if (!(hp.getCompetence() == 2)) {
			String description = ServiceExceptionEnum.HAVE_NOT_COMPETENCE.getDescription();
			throw new ServiceException(description);
		}

		// 禁止超级账号自我变动权限和值守态
		Integer[] competences = hpm.batchSelectCompetenceHouseparent(hpids);
		boolean checkCompetence = hsu.checkCompetenceAsSuper(competences);
		if (!checkCompetence) {
			String description = ServiceExceptionEnum.SELF_EXILE.getDescription();
			throw new ServiceException(description);
		}

		Integer affects = 0;

		switch (option) {
			case 0 :
				affects = hpm.batchDeleteByHpids(hpids);// 剥除
				break;

			case 1 :
				affects = hpm.batchSetCompetenceByHpid(1, hpids);// 举
				break;

			case 2 :
				affects = hpm.batchSetCompetenceByHpid(0, hpids);// 贬
				break;

			case 3 :
				affects = hpm.batchSetIsIncumbencyByHpid(1, hpids);// 当班
				break;

			case 4 :
				affects = hpm.batchSetIsIncumbencyByHpid(0, hpids);// 离班
				break;

		}

		return affects;
	}

	@Override
	public Integer revampMineProfile(String hpname, String phone, String idCard, Integer hpid) throws ServiceException {
		Integer row = hpm.selectCountByIdCard(idCard);

		if (row != 1) {
			String description = ServiceExceptionEnum.IDCARD_CONFLICT.getDescription();
			throw new ServiceException(description);
		}

		Integer affects = hpm.updatePartialByHpid(hpname, phone, idCard, hpid);

		return affects;
	}

	@Override
	public Integer revampPassword(String password, String oldPassword, Integer hpid) throws ServiceException {
		Houseparent houseparent = hpm.selectByHpid(hpid);

		// 校验旧密是否正确
		boolean verify = hsu.verify(oldPassword, houseparent.getPassword());
		if (!verify) {
			String description = ServiceExceptionEnum.ORIGINAL_OLD_KEYWORD_ERROR.getDescription();
			throw new ServiceException(description);
		}

		// 取盐
		String salt = houseparent.getSalt();

		// 产生密文
		String text = hsu.generateKeywordText(password, salt);

		// 执行
		Integer affect = hpm.updatePasswordByHpId(hpid, text);

		return affect;
	}

}