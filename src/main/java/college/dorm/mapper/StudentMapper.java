package college.dorm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import college.dorm.databean.Student;

/**
 * 学子,映射接口 DAO
 * 
 * @author gzh
 *
 */
public interface StudentMapper {

	/**
	 * 
	 * @param studentNo
	 * @param studentName
	 * @param buildingNo
	 * @param chamberNo
	 * @param enterTime
	 * @return
	 */
	Integer insertIntoStudent(@Param("studentNo") Integer studentNo,
			@Param("studentName") String studentName,
			@Param("buildingNo") Integer buildingNo,
			@Param("chamberNo") Integer chamberNo,
			@Param("enterTime") Date enterTime);

	/**
	 * 
	 * @return
	 */
	List<Student> selectAllStudents();

	/**
	 * 根据学号(唯一性)查找住宿生
	 * 
	 * @param studentNo
	 * @return
	 */
	Student selectStudentByStudentNo(Integer studentNo);

	/**
	 * 
	 * @param sid
	 * @return
	 */
	Integer deleteBySid(Integer sid);

	/**
	 * 
	 * @param sid
	 * @return
	 */
	Student selectStudentBySid(Integer sid);

	/**
	 * 
	 * @param sid
	 * @return
	 */
	Integer updateStudentBySid(@Param("studentName") String studentName,
			@Param("buildingNo") Integer buildingNo,
			@Param("chamberNo") Integer chamberNo, @Param("sid") Integer sid);
	
	/**
	 * 
	 * @param studentName
	 * @param buildingNo
	 * @param chamberNo
	 * @param studentNo
	 * @return
	 */
	Integer updateStudentByStudentNo(@Param("studentName") String studentName,
			@Param("buildingNo") Integer buildingNo,
			@Param("chamberNo") Integer chamberNo,
			@Param("studentNo") Integer studentNo);
}
