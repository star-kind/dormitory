package college.dorm.databean;

import java.util.Date;

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

    public Date getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(Date visitorTime) {
        this.visitorTime = visitorTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "vid=" + vid +
                ", visitorName='" + visitorName + '\'' +
                ", visitorCardno='" + visitorCardno + '\'' +
                ", visitedStudentName='" + visitedStudentName + '\'' +
                ", visitedStudentBuilding=" + visitedStudentBuilding +
                ", visitedStudentChamber=" + visitedStudentChamber +
                ", relation=" + relation +
                ", visitorTime=" + visitorTime +
                ", leaveTime=" + leaveTime +
                '}';
    }
}
