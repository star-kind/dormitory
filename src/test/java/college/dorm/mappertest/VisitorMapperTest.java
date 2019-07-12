package college.dorm.mappertest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.databean.Visitor;
import college.dorm.mapper.VisitorMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorMapperTest {
	@Autowired
	private VisitorMapper vm;
	
	@Test
	public void seleTest() {
		List<Visitor> list = vm.selectAllVisitor();
		
		for (Visitor visitor : list) {
			System.err.println(visitor);
		}
	}
}
