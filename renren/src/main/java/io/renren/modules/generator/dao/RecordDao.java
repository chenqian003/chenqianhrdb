package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.RecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`rec_r_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE NO AC
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@Mapper
public interface RecordDao extends BaseMapper<RecordEntity> {
	
}
