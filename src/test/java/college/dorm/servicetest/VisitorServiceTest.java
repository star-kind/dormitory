package college.dorm.servicetest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.pojo.Visitor;
import college.dorm.service.IVisitorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorServiceTest {
	@Autowired
	private IVisitorService ivs;
	
	@Test
	public void showAll() {
		List<Visitor> list = ivs.exhibitionAllVisitor();
		
		for (Visitor visitor : list) {
			System.out.println(visitor.toString());
		}
	}
}
