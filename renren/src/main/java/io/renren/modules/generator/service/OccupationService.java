package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.OccupationEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB; (`occ_categoty`) REFER `hrdb/category`(`cat_id`) ON UPDATE
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
public interface OccupationService extends IService<OccupationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

