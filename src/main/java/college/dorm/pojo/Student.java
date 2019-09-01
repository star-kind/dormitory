package college.dorm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Student {
    private Integer sid;
    private Integer studentNo;
    private String studentName;
    private Integer buildingNo;
    private Integer chamberNo;
    private Date enterTime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getChamberNo() {
        return chamberNo;
    }

    public void setChamberNo(Integer chamberNo) {
        this.chamberNo = chamberNo;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", studentNo=" + studentNo +
                ", studentName='" + studentName + '\'' +
                ", buildingNo=" + buildingNo +
                ", chamberNo=" + chamberNo +
                ", enterTime=" + enterTime +
                '}';
    }
}
