package college.dorm.servicetest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import college.dorm.pojo.Houseparent;
import college.dorm.service.IHouseparentService;
import college.dorm.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseparentServiceTest {
	@Autowired
	private IHouseparentService ihps;

	@Test
	public void testLogin() {
		try {
			Houseparent h = ihps.houseParentLogin("43323319981123177x", "336", null);
			System.out.println(h.toString());
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void regTest() {
		try {
			Integer r = ihps.registration("admin-13210", "13210", "1576334", "567977x");
			System.out.println(r);

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void exhibitTest() {
		try {
			Houseparent profile = ihps.showOwnProfile(15);
			System.err.println(profile.toString());

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
