package college.dorm.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import college.dorm.mapper.VisitorMapper;
import college.dorm.pojo.Visitor;
import college.dorm.service.IVisitorService;
import college.dorm.service.ex.ServiceException;

@Service
public class VisitorServiceImpl implements IVisitorService {
	@Autowired
	private VisitorMapper vm;

	@Override
	public Integer writerInNewVisitor(Visitor visitor) {
		return vm.insertIntoVisitor(visitor.getVisitorName(),
				visitor.getVisitorCardno(), visitor.getVisitedStudentName(),
				visitor.getVisitedStudentBuilding(),
				visitor.getVisitedStudentChamber(), visitor.getRelation(),
				new Date(), new Date());

	}

	@Override
	public List<Visitor> exhibitionAllVisitor() {
		return vm.selectAllVisitor();
	}

	@Override
	public Integer deleVisitor(Integer vid) {
		Integer rows = vm.deleteByVid(vid);
		return rows;
	}

	@Override
	public Visitor gainVisitor(Integer vid, HttpSession session)
			throws ServiceException {
		Visitor v = vm.selectByVid(vid);
		if (v == null) {
			throw new ServiceException("系统繁忙,请稍后重试");
		}
		session.setAttribute("vvid", vid);
		return v;
	}

	@Override
	public Integer changeProfile(Visitor visitor, Integer vid)
			throws ServiceException {
		if ("".equals(visitor.getVisitorName())) {
			throw new ServiceException("名字不许为空");
		}

		return vm.updateVisitorByVid(visitor.getVisitorName(),
				visitor.getVisitedStudentName(),
				visitor.getVisitedStudentBuilding(),
				visitor.getVisitedStudentChamber(), visitor.getRelation(), vid);
	}

}
