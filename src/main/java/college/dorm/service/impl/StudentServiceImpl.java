package college.dorm.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.dorm.mapper.StudentMapper;
import college.dorm.pojo.Student;
import college.dorm.service.IStudentService;
import college.dorm.service.ex.ServiceException;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper sm;

	@Override
	public Integer addNewStudent(Integer studentNo, String studentName,
			Integer buildingNo, Integer chamberNo) throws ServiceException {
		Student s1 = sm.selectStudentByStudentNo(studentNo);

		System.out.println(studentNo + "," + studentName + "," + buildingNo
				+ "," + chamberNo);

		if ("".equals(studentNo) || studentNo == null || "".equals(studentName)
				|| "".equals(buildingNo) || buildingNo == null
				|| "".equals(chamberNo) || chamberNo == null) {
			throw new ServiceException("资料尚未填完");
		}

		if (s1 != null) {
			throw new ServiceException("该学号业已存在,不得重复入住");
		}

		Integer affect = sm.insertIntoStudent(studentNo, studentName,
				buildingNo, chamberNo, new Date());

		System.out.println(":::" + affect);

		return affect;
	}

	@Override
	public List<Student> previewAllStudents(Integer hpid)
			throws ServiceException {
		if ("".equals(hpid) || hpid == null) {
			throw new ServiceException("请重新登录宿管账号");
		}
		List<Student> list = sm.selectAllStudents();
		return list;
	}

	@Override
	public Integer deleteStudent(Integer hpid, Integer sid)
			throws ServiceException {
		if ("".equals(hpid) || hpid == null) {
			throw new ServiceException("请重新登录宿管账号");
		}
		return sm.deleteBySid(sid);
	}

	@Override
	public Student getStudentBySid(Integer sid, HttpSession session)
			throws ServiceException {
		Student st = sm.selectStudentBySid(sid);
		if (st == null) {
			throw new ServiceException("系统繁忙,请稍后重试");
		}

		session.setAttribute("specStudid", sid);

		return st;
	}

	@Override
	public Student getStudentBySidNoSession(Integer sid)
			throws ServiceException {
		Student st = sm.selectStudentBySid(sid);
		if (st == null) {
			throw new ServiceException("系统繁忙,请稍后重试");
		}

		return st;
	}

	@Override
	public Integer editStdBySno(String studentName, Integer buildingNo,
			Integer chamberNo, Integer studentNo) throws ServiceException {
		if ("".equals(studentName) || "".equals(buildingNo)
				|| buildingNo == null || "".equals(chamberNo)
				|| chamberNo == null) {
			throw new ServiceException("资料尚未填完");
		}

		Integer row = sm.updateStudentByStudentNo(studentName, buildingNo,
				chamberNo, studentNo);
		return row;
	}

}