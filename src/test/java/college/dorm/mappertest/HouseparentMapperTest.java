package college.dorm.mappertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.databean.Houseparent;
import college.dorm.mapper.HouseparentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseparentMapperTest {
    @Autowired
    private HouseparentMapper hpm;

    @Test
    public void testSeleHpId(){
        Houseparent houseparent = hpm.selectByHpid(1);
        System.out.println(houseparent.toString());
    }

    @Test
    public void testSeleHpname(){
        Houseparent houseparent = hpm.selectByHpname("admin01");
        System.out.println(houseparent.toString());
    }

    @Test
    public void testInsertIntoHp(){
        Integer integer = hpm.insertHouseparent("admin01", "0123456");
        System.out.println(integer);
    }
}
