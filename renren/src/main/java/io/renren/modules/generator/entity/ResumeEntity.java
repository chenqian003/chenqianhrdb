package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@Data
@TableName("resume")
public class ResumeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 简历ID
	 */
	@TableId
	private Long resId;
	/**
	 * 姓名
	 */
	private String resName;
	/**
	 * 年龄
	 */
	private Long resAge;
	/**
	 * 性别
	 */
	private String resGender;
	/**
	 * 婚姻
	 */
	private String resMarriage;
	/**
	 * 学历
	 */
	private String resEducation;
	/**
	 * 毕业院校
	 */
	private String resCollege;
	/**
	 * 所学专业
	 */
	private String resMajor;
	/**
	 * 英语水平
	 */
	private String resEnglish;
	/**
	 * 入学时间
	 */
	private String resInCollege;
	/**
	 * 毕业时间
	 */
	private String resOutCollege;
	/**
	 * 居住城市
	 */
	private String resCity;
	/**
	 * 工作年限
	 */
	private String resWorkYear;
	/**
	 * 出生年月
	 */
	private String resBirthday;
	/**
	 * 户籍
	 */
	private String resHometown;
	/**
	 * 手机号码
	 */
	private String resMobile;
	/**
	 * 邮箱
	 */
	private String resMail;
	/**
	 * 自我评价
	 */
	private String resEvaluate;
	/**
	 * 期望工作地区
	 */
	private String resExpectedArea;
	/**
	 * 期望工作性质
	 */
	private String resExpectedWork;
	/**
	 * 期望工作职业
	 */
	private String resExpectedOccupation;
	/**
	 * 期望月薪
	 */
	private String resExpectedSalary;
	/**
	 * 目前状况
	 */
	private String resCurrentAtate;
	/**
	 * 期望从事行业
	 */
	private String resExpectedIndustry;
	/**
	 * 工作经历
	 */
	private String resWorkExperience;
	/**
	 * 项目经验
	 */
	private String resProjectExperience;
	/**
	 * 专业技能
	 */
	private String resProfessionalSkill;
	/**
	 * 兴趣爱好
	 */
	private String resInterest;
	/**
	 * 录入时间
	 */
	private Date resTime;
	/**
	 * 录入人
	 */
	private Long resHrId;
	/**
	 * 来源
	 */
	private Long resFrom;
	/**
	 * 备注1
	 */
	private String resBz1;
	/**
	 * 备注2
	 */
	private Long resBz2;
	/**
	 * 预约时间
	 * */
    @TableField(exist = false)
	private String intwBookTime;

	public Long getResId() {
		return resId;
	}

	public String getResBirthday() {
		return resBirthday;
	}

	public void setResBirthday(String resBirthday) {
		this.resBirthday = resBirthday;
	}

	public String getResInCollege() {
		return resInCollege;
	}

	public void setResInCollege(String resInCollege) {
		this.resInCollege = resInCollege;
	}

	public String getResOutCollege() {
		return resOutCollege;
	}

	public void setResOutCollege(String resOutCollege) {
		this.resOutCollege = resOutCollege;
	}

	public String getIntwBookTime() {
        return intwBookTime;
    }

    public void setIntwBookTime(String intwBookTime) {
        this.intwBookTime = intwBookTime;
    }

    public Long getResHrId() {
        return resHrId;
    }

    public void setResHrId(Long resHrId) {
        this.resHrId = resHrId;
    }

    public String getResMobile() {
        return resMobile;
    }

    public void setResMobile(String resMobile) {
        this.resMobile = resMobile;
    }

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Date getResTime() {
		return resTime;
	}

	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}

	@Override
	public String toString() {
		return "ResumeEntity{" +
				"resId=" + resId +
				", resName='" + resName + '\'' +
				", resAge=" + resAge +
				", resGender='" + resGender + '\'' +
				", resMarriage='" + resMarriage + '\'' +
				", resEducation='" + resEducation + '\'' +
				", resCollege='" + resCollege + '\'' +
				", resMajor='" + resMajor + '\'' +
				", resEnglish='" + resEnglish + '\'' +
				", resInCollege='" + resInCollege + '\'' +
				", resOutCollege='" + resOutCollege + '\'' +
				", resCity='" + resCity + '\'' +
				", resWorkYear='" + resWorkYear + '\'' +
				", resBirthday='" + resBirthday + '\'' +
				", resHometown='" + resHometown + '\'' +
				", resMobile='" + resMobile + '\'' +
				", resMail='" + resMail + '\'' +
				", resEvaluate='" + resEvaluate + '\'' +
				", resExpectedArea='" + resExpectedArea + '\'' +
				", resExpectedWork='" + resExpectedWork + '\'' +
				", resExpectedOccupation='" + resExpectedOccupation + '\'' +
				", resExpectedSalary='" + resExpectedSalary + '\'' +
				", resCurrentAtate='" + resCurrentAtate + '\'' +
				", resExpectedIndustry='" + resExpectedIndustry + '\'' +
				", resWorkExperience='" + resWorkExperience + '\'' +
				", resProjectExperience='" + resProjectExperience + '\'' +
				", resProfessionalSkill='" + resProfessionalSkill + '\'' +
				", resInterest='" + resInterest + '\'' +
				", resTime=" + resTime +
				", resHrId=" + resHrId +
				", resFrom=" + resFrom +
				", resBz1='" + resBz1 + '\'' +
				", resBz2=" + resBz2 +
				", intwBookTime='" + intwBookTime + '\'' +
				'}';
	}
}
