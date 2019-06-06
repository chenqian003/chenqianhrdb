package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`rec_r_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE NO AC
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@Data
@TableName("record")
public class RecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 面试记录ID
	 */
	@TableId
	private Long recId;
	/**
	 * 简历ID
	 */
	private Long recRId;
	/**
	 * HR_ID
	 */
	private Long recHrId;
	/**
	 * 沟通能力
	 */
	private Long recCommunicate;
	/**
	 * 技能水平
	 */
	private Long recSkill;
	/**
	 * 学习能力
	 */
	private String recStudy;
	/**
	 * 情商
	 */
	private String recEq;
	/**
	 * 面试印象
	 */
	private String recImpression;
	/**
	 * 操作时间
	 */
	private Date recTime;
	/**
	 * 备注1
	 */
	private String recBz1;
	/**
	 * 备注2
	 */
	private Long recBz2;

	@TableField(exist = false)
	private long intwId;

	public long getIntwId() {
		return intwId;
	}

	public void setIntwId(long intwId) {
		this.intwId = intwId;
	}

	public Long getRecId() {
		return recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	public Long getRecRId() {
		return recRId;
	}

	public void setRecRId(Long recRId) {
		this.recRId = recRId;
	}

	public Long getRecHrId() {
		return recHrId;
	}

	public void setRecHrId(Long recHrId) {
		this.recHrId = recHrId;
	}

	public Long getRecCommunicate() {
		return recCommunicate;
	}

	public void setRecCommunicate(Long recCommunicate) {
		this.recCommunicate = recCommunicate;
	}

	public Long getRecSkill() {
		return recSkill;
	}

	public void setRecSkill(Long recSkill) {
		this.recSkill = recSkill;
	}

	public String getRecStudy() {
		return recStudy;
	}

	public void setRecStudy(String recStudy) {
		this.recStudy = recStudy;
	}

	public String getRecEq() {
		return recEq;
	}

	public void setRecEq(String recEq) {
		this.recEq = recEq;
	}

	public String getRecImpression() {
		return recImpression;
	}

	public void setRecImpression(String recImpression) {
		this.recImpression = recImpression;
	}

	public Date getRecTime() {
		return recTime;
	}

	public void setRecTime(Date recTime) {
		this.recTime = recTime;
	}

	public String getRecBz1() {
		return recBz1;
	}

	public void setRecBz1(String recBz1) {
		this.recBz1 = recBz1;
	}

	public Long getRecBz2() {
		return recBz2;
	}

	public void setRecBz2(Long recBz2) {
		this.recBz2 = recBz2;
	}

	@Override
	public String toString() {
		return "RecordEntity{" +
				"recId=" + recId +
				", recRId=" + recRId +
				", recHrId=" + recHrId +
				", recCommunicate=" + recCommunicate +
				", recSkill=" + recSkill +
				", recStudy='" + recStudy + '\'' +
				", recEq='" + recEq + '\'' +
				", recImpression='" + recImpression + '\'' +
				", recTime=" + recTime +
				", recBz1='" + recBz1 + '\'' +
				", recBz2=" + recBz2 +
				'}';
	}
}
