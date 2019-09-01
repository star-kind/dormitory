package college.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import college.dorm.pojo.Houseparent;

/**
 * 宿管,道映射
 */
public interface HouseparentMapper {
	/**
	 * 搜索身份证号码为指定值的数量
	 * 
	 * @param idCard
	 * @return
	 */
	Integer selectCountByIdCard(@Param("idCard") String idCard);

	/**
	 * 据id改密
	 * 
	 * @param password
	 * @param hpid
	 * @return
	 */
	Integer updatePartialByHpid(@Param("password") String password, @Param("hpid") Integer hpid);

	/**
	 * 根据hpid更改名字,电话,身份证号
	 * 
	 * @param hpname
	 * @param phone
	 * @param idCard
	 * @param hpid
	 * @return
	 */
	Integer updatePartialByHpid(@Param("hpname") String hpname, @Param("phone") String phone, @Param("idCard") String idCard,
			@Param("hpid") Integer hpid);

	/**
	 * 批量查找范围内的权限
	 * 
	 * @param hpids
	 * @return
	 */
	Integer[] batchSelectCompetenceHouseparent(@Param("hpids") Integer[] hpids);

	/**
	 * 批量查找
	 * 
	 * @param hpids
	 * @return
	 */
	List<Houseparent> batchSelectHouseparent(@Param("hpids") Integer[] hpids);

	/**
	 * 批量删除
	 * 
	 * @param hpids
	 * @return
	 */
	Integer batchDeleteByHpids(@Param("hpids") Integer[] hpids);

	/**
	 * 批量更新是否在职
	 * 
	 * @param isIncumbency
	 * @param hpids
	 * @return
	 */
	Integer batchSetIsIncumbencyByHpid(@Param("isIncumbency") Integer isIncumbency, @Param("hpids") Integer[] hpids);

	/**
	 * 批量更新权限
	 * 
	 * @param competence
	 * @param hpids
	 * @return
	 */
	Integer batchSetCompetenceByHpid(@Param("competence") Integer competence, @Param("hpids") Integer[] hpids);

	/**
	 * 
	 * @return
	 */
	List<Houseparent> selectAllHouseparent();

	/**
	 * @param hpname
	 * @return
	 */
	Houseparent selectByHpname(@Param("hpname") String hpname);

	/**
	 * @param hpid
	 * @return
	 */
	Houseparent selectByHpid(@Param("hpid") Integer hpid);

	/**
	 * 新添一名宿管
	 * 
	 * @param houseparent
	 * @return
	 */
	Integer insertHouseparent(Houseparent houseparent);

	/**
	 * 
	 * @param idCard
	 * @return
	 */
	Houseparent selectByIdCard(@Param("idCard") String idCard);

	/**
	 * 改名,电话,头像,据ID <br>
	 * 自改
	 * 
	 * @param hpname
	 * @param phone
	 * @param portrait
	 * @param hpid
	 * @return
	 */
	Integer updateOwnProfileByHpid(@Param("hpname") String hpname, @Param("phone") String phone,
			@Param("portrait") String portrait, @Param("hpid") Integer hpid);

	/**
	 * 查找权限为n的账户数量
	 * 
	 * @param compentence
	 * @return
	 */
	Integer selectCountCompentence(@Param("compentence") Integer compentence);

	/**
	 * 更新"是否任职",据目标ID和权限
	 * 
	 * @param hpid
	 * @param competence
	 * @param isIncumbency
	 * @return
	 */
	Integer updateisIncumbencyByHpidAndCompetence(@Param("hpid") Integer hpid, @Param("competence") Integer competence,
			@Param("isIncumbency") Integer isIncumbency);

	/**
	 * 更新"是否任职",据目标身份证和权限
	 * 
	 * @param idCard
	 * @param competence
	 * @param isIncumbency
	 * @return
	 */
	Integer updateisIncumbencyByIdCardAndCompetence(@Param("idCard") String idCard, @Param("competence") Integer competence,
			@Param("isIncumbency") Integer isIncumbency);

	/**
	 * 更新目标宿管员的权限据其ID
	 * 
	 * @param hpid
	 * @param compentence
	 * @return
	 */
	Integer updateCompetenceByHpid(@Param("hpid") Integer hpid, @Param("competence") Integer competence);

	/**
	 * 更新目标宿管员的权限据目标身份证
	 * 
	 * @param idCard
	 * @param competence
	 * @return
	 */
	Integer updateCompetenceByIdCard(@Param("idCard") String idCard, @Param("competence") Integer competence);

	/**
	 * 修改密码据其id
	 * 
	 * @param hpid
	 * @param password
	 * @return
	 */
	Integer updatePasswordByHpId(@Param("hpid") Integer hpid, @Param("password") String password);

	/**
	 * 修改密码据其目标身份证
	 * 
	 * @param idCard
	 * @param password
	 * @return
	 */
	Integer updatePasswordByIdCard(@Param("idCard") String idCard, @Param("password") String password);

	/**
	 * 据宿管员ID们删除
	 * 
	 * @param hpids
	 * @return
	 */
	Integer deleteHouseparentByHpids(@Param("hpids") Integer[] hpids);

	/**
	 * 据id而改肖像名称
	 * 
	 * @param hpid
	 * @param portrait
	 * @return
	 */
	Integer updatePortraitByHpid(@Param("hpid") Integer hpid, @Param("portrait") String portrait);
}
