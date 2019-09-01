package college.dorm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Visitor {
    private Integer vid;

    private String visitorName;
    private String visitorCardno;
    private String visitedStudentName;

    private Integer visitedStudentBuilding;
    private Integer visitedStudentChamber;
    private Integer relation;

    private Date visitorTime;
    private Date leaveTime;

    public Integer getVid() {
	return vid;
    }

    public void setVid(Integer vid) {
	this.vid = vid;
    }

    public String getVisitorName() {
	return visitorName;
    }

    public void setVisitorName(String visitorName) {
	this.visitorName = visitorName;
    }

    public String getVisitorCardno() {
	return visitorCardno;
    }

    public void setVisitorCardno(String visitorCardno) {
	this.visitorCardno = visitorCardno;
    }

    public String getVisitedStudentName() {
	return visitedStudentName;
    }

    public void setVisitedStudentName(String visitedStudentName) {
	this.visitedStudentName = visitedStudentName;
    }

    public Integer getVisitedStudentBuilding() {
	return visitedStudentBuilding;
    }

    public void setVisitedStudentBuilding(Integer visitedStudentBuilding) {
	this.visitedStudentBuilding = visitedStudentBuilding;
    }

    public Integer getVisitedStudentChamber() {
	return visitedStudentChamber;
    }

    public void setVisitedStudentChamber(Integer visitedStudentChamber) {
	this.visitedStudentChamber = visitedStudentChamber;
    }

    public Integer getRelation() {
	return relation;
    }

    public void setRelation(Integer relation) {
	this.relation = relation;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getVisitorTime() {
	return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
	this.visitorTime = visitorTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getLeaveTime() {
	return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
	this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Visitor [vid=");
	builder.append(vid);
	builder.append(", visitorName=");
	builder.append(visitorName);
	builder.append(", visitorCardno=");
	builder.append(visitorCardno);
	builder.append(", visitedStudentName=");
	builder.append(visitedStudentName);
	builder.append(", visitedStudentBuilding=");
	builder.append(visitedStudentBuilding);
	builder.append(", visitedStudentChamber=");
	builder.append(visitedStudentChamber);
	builder.append(", relation=");
	builder.append(relation);
	builder.append(", visitorTime=");
	builder.append(visitorTime);
	builder.append(", leaveTime=");
	builder.append(leaveTime);
	builder.append("]");
	return builder.toString();
    }

}
