package college.dorm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import college.dorm.databean.Student;
import college.dorm.service.except.ServiceException;
/**
 * 住宿生 服务接口
 * @author gzh
 *
 */
public interface IStudentService {
	// 删除住宿学生

	/**
	 * 添加住宿学生
	 * 
	 * @param studentNo
	 *            学号
	 * @param studentName
	 *            姓名
	 * @param buildingNo
	 *            楼号
	 * @param chamberNo
	 *            寝室号
	 * @return
	 * @throws ServiceException
	 */
	Integer addNewStudent(Integer studentNo, String studentName,
			Integer buildingNo, Integer chamberNo) throws ServiceException;

	// 修改住宿生资料

	/**
	 * 查看住宿生名单
	 * 
	 * @param hpid
	 * @return
	 * @throws ServiceException
	 */
	List<Student> previewAllStudents(Integer hpid) throws ServiceException;

	/**
	 * 
	 * @param hpid
	 * @param sid
	 * @return
	 * @throws ServiceException
	 */
	Integer deleteStudent(Integer hpid, Integer sid) throws ServiceException;

	/**
	 * 
	 * @param sid
	 * @return
	 * @throws ServiceException
	 */
	Student getStudentBySid(Integer sid, HttpSession session)
			throws ServiceException;

	/**
	 * 
	 * @param sid
	 * @return
	 * @throws ServiceException
	 */
	Student getStudentBySidNoSession(Integer sid) throws ServiceException;

	/**
	 * 
	 * @param studentName
	 * @param buildingNo
	 * @param chamberNo
	 * @param studentNo
	 * @return
	 * @throws ServiceException
	 */
	Integer editStdBySno(String studentName, Integer buildingNo,
			Integer chamberNo,Integer studentNo) throws ServiceException;
}
