package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`occ_categoty`) REFER `hrdb/category`(`cat_id`) ON UPDATE
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@Data
@TableName("occupation")
public class OccupationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 职位ID
	 */
	@TableId
	private Long occId;
	/**
	 * 职位名称
	 */
	private String occName;
	/**
	 * 所属类别
	 */
	private Long occCategoty;
	/**
	 * 所属城市
	 */
	private String occCity;
	/**
	 * 当前时间
	 */
	private Date occTime;
	/**
	 * 发布人
	 */
	private Long occHr;
	/**
	 * 职位描述
	 */
	private String occDescription;
	/**
	 * 当前状态
	 */
	private Long occState;
	/**
	 * 工作性质
	 */
	private Long occNature;
	/**
	 * 月薪范围
	 */
	private String occSalaryRange;
	/**
	 * 工作地点
	 */
	private String occWorkAddress;
	/**
	 * 搜索关键字
	 */
	private String occKeyworks;
	/**
	 * 公司名称
	 */
	private String occCompany;
	/**
	 * 公司简介
	 */
	private String occCompanydesc;
	/**
	 * 招聘人数
	 */
	private Long occCount;
	/**
	 * 工作年限
	 */
	private String occWorkYear;
	/**
	 * 学历
	 */
	private String occEducation;
	/**
	 * 备注1
	 */
	private String occBz1;
	/**
	 * 备注2
	 */
	private Long occBz2;

}
