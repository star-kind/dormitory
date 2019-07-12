package college.dorm.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import college.dorm.databean.Visitor;
import college.dorm.service.except.ServiceException;
/**
 * 访客 服务接口
 * @author gzh
 *
 */
public interface IVisitorService {
	/**
	 * 写入一位新访客
	 * 
	 * @param visitor
	 * @return
	 */
	Integer writerInNewVisitor(Visitor visitor);

	/**
	 * 展览全部访客
	 * 
	 * @return
	 */
	List<Visitor> exhibitionAllVisitor();

	/**
	 * 
	 * @param vid
	 * @return
	 */
	Integer deleVisitor(Integer vid);

	/**
	 * 
	 * @param vid
	 * @param session
	 * @return
	 */
	Visitor gainVisitor(Integer vid, HttpSession session)
			throws ServiceException;
	/**
	 * 
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	Integer changeProfile(Visitor visitor,Integer vid) throws ServiceException;
}
