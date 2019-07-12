package college.dorm.service;

import javax.servlet.http.HttpSession;

import college.dorm.databean.Houseparent;
import college.dorm.service.except.ServiceException;
/**
 * 宿管 服务接口
 * @author gzh
 *
 */
public interface IHouseparentService {
	/**
	 * 宿管登录
	 * 
	 * @param hpname
	 * @param password
	 * @param session
	 * @return
	 * @throws ServiceException
	 */
	Houseparent houseParentLogin(String hpname, String password,
			HttpSession session) throws ServiceException;

	/**
	 * 
	 * @param hpname
	 * @param password
	 * @return
	 * @throws ServiceException
	 */
	Integer regNewHouseParent(String hpname, String password)
			throws ServiceException;
}
