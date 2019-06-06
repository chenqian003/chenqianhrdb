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
 * @date 2019-05-17 12:05:14
 */
@Data
@TableName("friends")
public class FriendsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 朋友圈ID
	 */
	@TableId
	private Long friId;
	/**
	 * 发起人ID
	 */
	private Long friSender;
	/**
	 * 接收人ID
	 */
	private Long friReceiver;
	/**
	 * 关系状态
	 */
	private Long friState;
	/**
	 * 验证消息
	 */
	private String friMsg;
	/**
	 * 操作时间
	 */
	private Date friTime;
	/**
	 * 备注1
	 */
	private String friBz1;
	/**
	 * 备注2
	 */
	private Long friBz2;

}
