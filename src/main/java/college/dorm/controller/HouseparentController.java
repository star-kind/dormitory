package college.dorm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import college.dorm.databean.Houseparent;
import college.dorm.json.ResponseEntity;
import college.dorm.service.IHouseparentService;

/**
 * 宿管 控制器 
 * 
 * @author gzh
 *
 */
@RestController
@RequestMapping("HouseParents")
public class HouseparentController extends BaseController {
	@Autowired
	private IHouseparentService ihps;

	@PostMapping("logining")
	public ResponseEntity<Void> houseparentLoginHandler(
			@RequestParam("hpname") String hpname,
			@RequestParam("password") String password, HttpSession session) {

		System.err.println(hpname + "," + password);
		Houseparent h = ihps.houseParentLogin(hpname, password, session);
		return new ResponseEntity<Void>(SUCCESS);
	}

	@PostMapping("registration")
	public ResponseEntity<Void> houseparentRegHandler(
			@RequestParam("hpname") String hpname,
			@RequestParam("password") String password) {
		System.err.println(hpname + "+" + password);

		Integer affects = ihps.regNewHouseParent(hpname, password);
		return new ResponseEntity<Void>(SUCCESS);
	}
}
