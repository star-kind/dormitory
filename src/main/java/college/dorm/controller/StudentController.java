package college.dorm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import college.dorm.databean.Student;
import college.dorm.json.ResponseEntity;
import college.dorm.service.IStudentService;

/**
 * 住宿生 控制器
 * @author gzh
 *
 */
@RestController
@RequestMapping("Students")
public class StudentController extends BaseController {
	@Autowired
	private IStudentService iss;

	@PostMapping("add_stud")
	public ResponseEntity<Void> addNewStudHandler(
			@RequestParam("studentNo") Integer studentNo,
			@RequestParam("studentName") String studentName,
			@RequestParam("buildingNo") Integer buildingNo,
			@RequestParam("chamberNo") Integer chamberNo) {
		Integer affect = iss.addNewStudent(studentNo, studentName, buildingNo,
				chamberNo);
		return new ResponseEntity<Void>(SUCCESS);
	}

	@GetMapping("show_stud_list")
	public ResponseEntity<List<Student>> previewStudListHandler(
			HttpSession session) {
		List<Student> sList = iss.previewAllStudents(getIdFromSession(session));
		return new ResponseEntity<List<Student>>(SUCCESS, sList);
	}

	@PostMapping("delete_stud")
	public ResponseEntity<Void> deleteStudHandler(
			@RequestParam("sid") Integer sid, HttpSession session) {
		System.out.println("del Integer sid:" + sid);
		Integer hpid = getIdFromSession(session);

		Integer aff = iss.deleteStudent(hpid, sid);

		return new ResponseEntity<Void>(SUCCESS);
	}

	@PostMapping("show_edit_stud")
	public ResponseEntity<Student> showEditStudHandler(
			@RequestParam("sid") Integer sid, HttpSession session) {
		System.out.println("show edit Integer sid:" + sid);

		Student s = iss.getStudentBySid(sid, session);

		return new ResponseEntity<Student>(SUCCESS, s);
	}

	@GetMapping("show_will_edit_stud")
	public ResponseEntity<Student> showWillEditStudHandler(
			HttpSession session) {
		return new ResponseEntity<Student>(SUCCESS,
				iss.getStudentBySidNoSession(
						objCastToInteger(session.getAttribute("specStudid"))));
	}

	@PostMapping("exe_edit_stud")
	public ResponseEntity<Void> exeEditStudHandler(
			@RequestParam("studentNo") Integer studentNo,
			@RequestParam("studentName") String studentName,
			@RequestParam("buildingNo") Integer buildingNo,
			@RequestParam("chamberNo") Integer chamberNo) {
		Integer e = iss.editStdBySno(studentName, buildingNo, chamberNo,
				studentNo);
		return new ResponseEntity<Void>(SUCCESS);
	}
}