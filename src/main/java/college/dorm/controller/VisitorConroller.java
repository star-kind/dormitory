package college.dorm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import college.dorm.json.ResponseEntity;
import college.dorm.pojo.Visitor;
import college.dorm.service.IVisitorService;

/**
 * 访客 控制器
 * 
 * @author gzh
 *
 */
@RestController
@RequestMapping("Visit")
public class VisitorConroller extends BaseController {

	@Autowired
	private IVisitorService ivs;

	/**
	 * 
	 * @param v
	 * @return
	 */
	@PostMapping("add_visitor")
	public ResponseEntity<Void> addVisitHandler(Visitor v) {
		Integer row = ivs.writerInNewVisitor(v);
		return new ResponseEntity<Void>(SUCCESS);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("exhibi_visitor")
	public ResponseEntity<List<Visitor>> lookOverVisitorHandler() {
		List<Visitor> list = ivs.exhibitionAllVisitor();
		return new ResponseEntity<List<Visitor>>(SUCCESS, list);
	}

	/**
	 * 
	 * @param vid
	 * @return
	 */
	@PostMapping("del_visitor")
	public ResponseEntity<Void> delVisitorHandler(
			@RequestParam("vid") Integer vid) {
		Integer i = ivs.deleVisitor(vid);
		return new ResponseEntity<Void>(SUCCESS);
	}

	/**
	 * 
	 * @param vid
	 * @return
	 */
	@PostMapping("show_edit_vi")
	public ResponseEntity<Void> showEditViHandler(
			@RequestParam("vid") Integer vid, HttpSession session) {
		Integer vi = objCastToInteger(vid);
		Visitor v = ivs.gainVisitor(vi, session);
		return new ResponseEntity<Void>(SUCCESS);
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("show_will_edit_vi")
	public ResponseEntity<Visitor> showWillEditStudHandler(
			HttpSession session) {
		Integer vvid = objCastToInteger(session.getAttribute("vvid"));
		Visitor v = ivs.gainVisitor(vvid, session);
		return new ResponseEntity<Visitor>(SUCCESS, v);
	}

	/**
	 * 
	 * @param session
	 * @return
	 */
	@PostMapping("exec_edit_vi")
	public ResponseEntity<Void> execEditViHandler(Visitor v,
			HttpSession session) {
		Integer i = ivs.changeProfile(v,
				objCastToInteger(session.getAttribute("vvid")));
		return new ResponseEntity<Void>(SUCCESS);
	}
}
