package college.dorm.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.databean.Houseparent;
import college.dorm.service.IHouseparentService;
import college.dorm.service.except.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseparentServiceTest {
	@Autowired
	private IHouseparentService ihps;
	
	@Test
	public void testLogin() {
		try {
			Houseparent h = ihps.houseParentLogin("admin01", "0123456", null);
			System.out.println(h.toString());
		} catch (ServiceException e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
}
