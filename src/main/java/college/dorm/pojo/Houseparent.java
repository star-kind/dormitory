package college.dorm.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 对应数据表 宿管 其他循例
 * 
 * @author gzh
 *
 */
public class Houseparent implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer hpid;
	private String hpname;
	private String password;
	private String phone;
	private String salt;
	private String idCard;
	private Date regTime;
	private String portrait;
	private Integer competence;
	private Integer isIncumbency;

	public Integer getHpid() {
		return hpid;
	}

	public void setHpid(Integer hpid) {
		this.hpid = hpid;
	}

	public String getHpname() {
		return hpname;
	}

	public void setHpname(String hpname) {
		this.hpname = hpname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Integer getCompetence() {
		return competence;
	}

	public void setCompetence(Integer competence) {
		this.competence = competence;
	}

	public Integer getIsIncumbency() {
		return isIncumbency;
	}

	public void setIsIncumbency(Integer isIncumbency) {
		this.isIncumbency = isIncumbency;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Houseparent [hpid=");
		builder.append(hpid);
		builder.append(", hpname=");
		builder.append(hpname);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", salt=");
		builder.append(salt);
		builder.append(", idCard=");
		builder.append(idCard);
		builder.append(", regTime=");
		builder.append(regTime);
		builder.append(", portrait=");
		builder.append(portrait);
		builder.append(", competence=");
		builder.append(competence);
		builder.append(", isIncumbency=");
		builder.append(isIncumbency);
		builder.append("]");
		return builder.toString();
	}

}
