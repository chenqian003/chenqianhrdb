package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * InnoDB free: 9216 kB
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:04:20
 */
@Data
@TableName("share")
public class ShareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long shaId;
	/**
	 * 
	 */
	private Long shaSender;
	/**
	 * 
	 */
	private Long shaRecevier;
	/**
	 * 
	 */
	private Long shaReId;
	/**
	 * 
	 */
	private Date shaTime;
	/**
	 * 
	 */
	private String shaBz1;
	/**
	 * 
	 */
	private Long shaBz2;

}
