package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * InnoDB free: 9216 kB; (`cat_parent_id`) REFER `hrdb/category`(`cat_id`) ON UPDAT
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
