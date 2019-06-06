package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB; (`cat_parent_id`) REFER `hrdb/category`(`cat_id`) ON UPDAT
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@Data
@TableName("category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 类别ID
	 */
	@TableId
	private Long catId;
	/**
	 * 父类别ID
	 */
	private Long catParentId;
	/**
	 * 职位名称
	 */
	private String catName;
	/**
	 * 备注1
	 */
	private String catBz1;
	/**
	 * 备注2
	 */
	private Long catBz2;

}
