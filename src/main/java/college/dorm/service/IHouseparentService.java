package college.dorm.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import college.dorm.pojo.Houseparent;
import college.dorm.service.ex.ServiceException;

/**
 * 宿管 服务接口
 * 
 * @author gzh
 *
 */
public interface IHouseparentService {
	/**
	 * 
	 * @param password
	 *            新密
	 * @param oldPassword
	 *            旧密
	 * @param hpid
	 * @return
	 * @throws ServiceException
	 */
	Integer revampPassword(String password, String oldPassword, Integer hpid) throws ServiceException;

	/**
	 * 宿管登录
	 * 
	 * @param idCard
	 * @param password
	 * @param session
	 * @return
	 * @throws ServiceException
	 */
	Houseparent houseParentLogin(String idCard, String password, HttpSession session) throws ServiceException;

	/**
	 * 前页之提交
	 * 
	 * @param hpname
	 * @param password
	 * @param phone
	 * @param idCard
	 * @return
	 * @throws ServiceException
	 */
	Integer registration(String hpname, String password, String phone, String idCard) throws ServiceException;

	/**
	 * 展示宿管员个人资料
	 * 
	 * @param houseparentID
	 * @return
	 * @throws ServiceException
	 */
	Houseparent showOwnProfile(Integer houseparentID) throws ServiceException;

	/**
	 * 
	 * @param request
	 * @param portrait
	 * @return
	 * @throws ServiceException
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ServletException
	 */
	String revampAvatar(HttpServletRequest request, MultipartFile portrait)
			throws ServiceException, IllegalStateException, IOException, ServletException;

	/**
	 * 
	 * @param session
	 * @return
	 * @throws ServiceException
	 */
	List<Houseparent> gainHouseParentList(HttpSession session) throws ServiceException;

	/**
	 * 批量设在岗状态,可销可激
	 * 
	 * @param hpids
	 * @param session
	 * @param isIncumbency
	 * @return
	 * @throws ServiceException
	 */
	Integer batchSetIsIncumbency(Integer[] hpids, HttpSession session, Integer isIncumbency) throws ServiceException;

	/**
	 * 超级宿管员根据hpid们进行的操作<br>
	 * 选项:删/举/贬
	 * 
	 * @param session
	 * @param option
	 * @param hpids
	 * @return
	 * @throws ServiceException
	 */
	Integer manipulateBySuperDo(HttpSession session, Integer option, Integer[] hpids) throws ServiceException;

	/**
	 * 修改资料:名字,电话,身份证
	 * 
	 * @param hpname
	 * @param phone
	 * @param idCard
	 * @param hpid
	 * @return
	 * @throws ServiceException
	 */
	Integer revampMineProfile(String hpname, String phone, String idCard, Integer hpid) throws ServiceException;

}
