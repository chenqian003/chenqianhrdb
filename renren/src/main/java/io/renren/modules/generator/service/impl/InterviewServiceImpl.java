package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.InterviewDao;
import io.renren.modules.generator.entity.InterviewEntity;
import io.renren.modules.generator.service.InterviewService;


@Service("interviewService")
public class InterviewServiceImpl extends ServiceImpl<InterviewDao, InterviewEntity> implements InterviewService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InterviewEntity> page = this.page(
                new Query<InterviewEntity>().getPage(params),
                new QueryWrapper<InterviewEntity>()
        );

        return new PageUtils(page);
    }

}