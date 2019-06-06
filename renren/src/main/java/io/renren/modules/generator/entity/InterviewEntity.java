package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@Data
@TableName("interview")
public class InterviewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 面试ID
	 */
	@TableId
	private Long intwId;
	/**
	 * 简历ID
	 */
	private Long intwResumeId;
	/**
	 * 应聘者姓名
	 */
	private String intwName;
	/**
	 * 应聘者电话
	 */
	private String intwMobile;
	/**
	 * 预约时间
	 */
	private String intwBookTime;
	/**
	 * 预约人
	 */
	private Long intwHrId;
	/**
	 * 当前状态
	 */
	private Long intwState;
	/**
	 * 操作时间
	 */
	private Date intwTime;
	/**
	 * 备注1
	 */
	private String intwBz1;
	/**
	 * 备注2
	 */
	private Long intwBz2;


	public Long getIntwId() {
		return intwId;
	}

	public void setIntwId(Long intwId) {
		this.intwId = intwId;
	}

	public Long getIntwResumeId() {
		return intwResumeId;
	}

	public void setIntwResumeId(Long intwResumeId) {
		this.intwResumeId = intwResumeId;
	}

	public String getIntwName() {
		return intwName;
	}

	public void setIntwName(String intwName) {
		this.intwName = intwName;
	}

	public String getIntwMobile() {
		return intwMobile;
	}

	public void setIntwMobile(String intwMobile) {
		this.intwMobile = intwMobile;
	}

	public String getIntwBookTime() {
		return intwBookTime;
	}

	public void setIntwBookTime(String intwBookTime) {
		this.intwBookTime = intwBookTime;
	}

	public Long getIntwHrId() {
		return intwHrId;
	}

	public void setIntwHrId(Long intwHrId) {
		this.intwHrId = intwHrId;
	}

	public Long getIntwState() {
		return intwState;
	}

	public void setIntwState(Long intwState) {
		this.intwState = intwState;
	}

	public Date getIntwTime() {
		return intwTime;
	}

	public void setIntwTime(Date intwTime) {
		this.intwTime = intwTime;
	}

	public String getIntwBz1() {
		return intwBz1;
	}

	public void setIntwBz1(String intwBz1) {
		this.intwBz1 = intwBz1;
	}

	public Long getIntwBz2() {
		return intwBz2;
	}

	public void setIntwBz2(Long intwBz2) {
		this.intwBz2 = intwBz2;
	}

	@Override
	public String toString() {
		return "InterviewEntity{" +
				"intwId=" + intwId +
				", intwResumeId=" + intwResumeId +
				", intwName='" + intwName + '\'' +
				", intwMobile='" + intwMobile + '\'' +
				", intwBookTime='" + intwBookTime + '\'' +
				", intwHrId=" + intwHrId +
				", intwState=" + intwState +
				", intwTime=" + intwTime +
				", intwBz1='" + intwBz1 + '\'' +
				", intwBz2=" + intwBz2 +
				'}';
	}
}
