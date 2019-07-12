package college.dorm.mapper;


import org.apache.ibatis.annotations.Param;

import college.dorm.databean.Houseparent;

/**
 * 宿管,道映射
 */
public interface HouseparentMapper {
    /**
     * @param hpname
     * @return
     */
    Houseparent selectByHpname(String hpname);

    /**
     * @param hpid
     * @return
     */
    Houseparent selectByHpid(@Param("hpid") Integer hpid);

    /**
     *
     * @param hpname
     * @param password
     * @return
     */
    Integer insertHouseparent(@Param("hpname") String hpname, @Param("password") String password);
}
