package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.OccupationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`occ_categoty`) REFER `hrdb/category`(`cat_id`) ON UPDATE
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@Mapper
public interface OccupationDao extends BaseMapper<OccupationEntity> {
	
}
