package college.dorm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import college.dorm.json.ResponseEntity;
import college.dorm.pojo.Houseparent;
import college.dorm.service.IHouseparentService;
import college.dorm.service.ex.ServiceException;

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

	private String mark = this.getClass().getName() + ": ";

	/**
	 * http://localhost:8080/dormitory/HouseParents/logining?idCard=43323319981123077x&password=0000
	 * 
	 * @param idCard
	 * @param password
	 * @param session
	 * @return
	 */
	@PostMapping("logining")
	// @GetMapping("logining")
	public ResponseEntity<Void> houseparentLoginHandler(@RequestParam("idCard") String idCard,
			@RequestParam("password") String password, HttpSession session) {
		System.err.println(mark + idCard + "&" + password);

		Houseparent h = ihps.houseParentLogin(idCard, password, session);
		return new ResponseEntity<Void>(SUCCESS);

	}

	/**
	 * http://localhost:8080/dormitory/HouseParents/registration?hpname=iopkl&password=7777&idCard=56489700x&phone=35795146820
	 * 
	 * @param hpname
	 * @param password
	 * @param idCard
	 * @param phone
	 * @return
	 */
	@PostMapping("registration")
	public ResponseEntity<Void> houseparentRegHandler(@RequestParam("hpname") String hpname,
			@RequestParam("password00") String password, @RequestParam("idCard") String idCard,
			@RequestParam("phone") String phone) {

		Integer affects = ihps.registration(hpname, password, phone, idCard);
		return new ResponseEntity<Void>(SUCCESS);
	}

	/**
	 * http://localhost:8080/dormitory/HouseParents/exhibitProfile?houseparentID=15
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("exhibitProfile")
	public ResponseEntity<Houseparent> exhibitProfile(HttpSession session) {
		Integer houseparentID = getIdFromSession(session);
		System.err.println(mark + houseparentID);
		Houseparent profile = ihps.showOwnProfile(houseparentID);

		return new ResponseEntity<Houseparent>(SUCCESS, profile);
	}

	/**
	 * 
	 * @param request
	 * @param portrait
	 * @return
	 * @throws ServiceException
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ServletException
	 */
	@PostMapping("uploadAvatarHandler")
	public ResponseEntity<String> uploadAvatarHandler(HttpServletRequest request,
			@RequestParam("portrait") MultipartFile portrait)
			throws ServiceException, IllegalStateException, IOException, ServletException {
		String avatar = ihps.revampAvatar(request, portrait);

		return new ResponseEntity<String>(SUCCESS, avatar);
	}

	/**
	 * http://localhost:8080/dormitory/HouseParents/exhibitionAllHandler
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("exhibitionAllHandler")
	// @PostMapping("exhibitionAllHandler")
	public ResponseEntity<List<Houseparent>> exhibitionAllHandler(HttpSession session) {
		List<Houseparent> list = ihps.gainHouseParentList(session);
		return new ResponseEntity<List<Houseparent>>(SUCCESS, list);
	}

	/**
	 * 
	 * @param session
	 * @param hpids
	 * @param isIncumbency
	 * @return
	 */
	@PostMapping("multiSetCancelHandler")
	public ResponseEntity<Integer> multiSetCancelHandler(HttpSession session, @RequestParam("hpids") Integer[] hpids,
			@RequestParam("isIncumbency") Integer isIncumbency) {
		Integer effects = ihps.batchSetIsIncumbency(hpids, session, isIncumbency);

		return new ResponseEntity<Integer>(SUCCESS, effects);
	}

	/**
	 * 
	 * @param session
	 * @param hpids
	 * @param isIncumbency
	 * @return
	 */
	@PostMapping("multiSetActiveHandler")
	public ResponseEntity<Integer> multiSetActiveHandler(HttpSession session, @RequestParam("hpids") Integer[] hpids,
			@RequestParam("isIncumbency") Integer isIncumbency) {
		Integer effects = ihps.batchSetIsIncumbency(hpids, session, isIncumbency);

		return new ResponseEntity<Integer>(SUCCESS, effects);
	}

	/**
	 * 
	 * @param session
	 * @param hpids
	 * @param option
	 * @return
	 */
	@PostMapping("manipulateBySuDoHandler")
	public ResponseEntity<Integer> manipulateBySuDoHandler(HttpSession session, @RequestParam("hpids") Integer[] hpids,
			@RequestParam("option") Integer option) {
		Integer affects = ihps.manipulateBySuperDo(session, option, hpids);
		return new ResponseEntity<Integer>(SUCCESS, affects);
	}

	/**
	 * 
	 * @param session
	 * @param hpname
	 * @param phone
	 * @param idCard
	 * @return
	 */
	@PostMapping("revampPartialProfileHandler")
	public ResponseEntity<Integer> revampPartialProfileHandler(HttpSession session, @RequestParam("hpname") String hpname,
			@RequestParam("phone") String phone, @RequestParam("idCard") String idCard) {
		Integer hpid = Integer.parseInt(session.getAttribute("houseparentID").toString());

		Integer affects = ihps.revampMineProfile(hpname, phone, idCard, hpid);

		return new ResponseEntity<Integer>(SUCCESS, affects);

	}

	/**
	 * 
	 * @param session
	 * @param password
	 * @return
	 */
	@PostMapping("revampPasswordHandler")
	public ResponseEntity<Integer> revampPasswordHandler(HttpSession session, @RequestParam("password") String password,
			@RequestParam("oldPassword") String oldPassword) {
		Integer hpid = Integer.parseInt(session.getAttribute("houseparentID").toString());

		Integer affects = ihps.revampPassword(password, oldPassword, hpid);

		return new ResponseEntity<Integer>(SUCCESS, affects);
	}

}
