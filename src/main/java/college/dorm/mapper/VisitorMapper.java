package college.dorm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import college.dorm.pojo.Visitor;

/**
 * DAO 映射接口 访客
 * @author gzh
 *
 */
public interface VisitorMapper {

	/**
	 * 
	 * @return
	 */
	List<Visitor> selectAllVisitor();

	/**
	 * 
	 * @param visitorName
	 * @param visitorCardno
	 * @param visitedStudentName
	 * @param visitedStudentBuilding
	 * @param visitedStudentChamber
	 * @param relation
	 * @param visitorTime
	 * @param leaveTime
	 * @return
	 */
	Integer insertIntoVisitor(@Param("visitorName") String visitorName,
			@Param("visitorCardno") String visitorCardno,
			@Param("visitedStudentName") String visitedStudentName,
			@Param("visitedStudentBuilding") Integer visitedStudentBuilding,
			@Param("visitedStudentChamber") Integer visitedStudentChamber,
			@Param("relation") Integer relation,
			@Param("visitorTime") Date visitorTime,
			@Param("leaveTime") Date leaveTime);

	/**
	 * 
	 * @param vid
	 * @return
	 */
	Integer deleteByVid(Integer vid);

	/**
	 * 
	 * @param vid
	 * @return
	 */
	Visitor selectByVid(Integer vid);

	/**
	 * 
	 * @param visitorName
	 * @param visitedStudentName
	 * @param visitedStudentBuilding
	 * @param visitedStudentChamber
	 * @param relation
	 * @param visitorTime
	 * @param leaveTime
	 * @param vid
	 * @return
	 */
	Integer updateVisitorByVid(@Param("visitorName") String visitorName,
			@Param("visitedStudentName") String visitedStudentName,
			@Param("visitedStudentBuilding") Integer visitedStudentBuilding,
			@Param("visitedStudentChamber") Integer visitedStudentChamber,
			@Param("relation") Integer relation, @Param("vid") Integer vid);
}
