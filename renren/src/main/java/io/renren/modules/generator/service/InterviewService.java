package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.InterviewEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
public interface InterviewService extends IService<InterviewEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

