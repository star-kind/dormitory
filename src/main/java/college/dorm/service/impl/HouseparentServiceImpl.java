package college.dorm.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.dorm.databean.Houseparent;
import college.dorm.mapper.HouseparentMapper;
import college.dorm.service.IHouseparentService;
import college.dorm.service.except.ServiceException;

@Service
public class HouseparentServiceImpl implements IHouseparentService {
	@Autowired
	private HouseparentMapper hpm;

	@Override
	public Houseparent houseParentLogin(String hpname, String password,
			HttpSession session) throws ServiceException {
		Houseparent h = hpm.selectByHpname(hpname);

		if (h == null) {
			throw new ServiceException("宿管账号名有误");
		}
		System.out.println("名字正确:" + h.getPassword());

		if (!(password.equals(h.getPassword()))) {
			throw new ServiceException("密码有误");
		}
		System.out.println("PWD正确");

		session.setAttribute("houseparentName", hpname);
		session.setAttribute("houseparentID", h.getHpid());

		return h;
	}

	@Override
	public Integer regNewHouseParent(String hpname, String password)
			throws ServiceException {
		Houseparent h = hpm.selectByHpname(hpname);

		if ("".equals(hpname) || "".equals(password)) {
			throw new ServiceException("不许为空");
		}

		if (!(h == null)) {
			throw new ServiceException("此账号名已被注册,请另换");
		}

		if (password.length() < 6) {
			throw new ServiceException("密码的长度至少要到6位");
		}

		return hpm.insertHouseparent(hpname, password);

	}

}