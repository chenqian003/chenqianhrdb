package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ResumeEntity;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
public interface ResumeService extends IService<ResumeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void insertResume(ResumeEntity resumeEntity);
    List<ResumeEntity> getByresHrId(long id);
}

