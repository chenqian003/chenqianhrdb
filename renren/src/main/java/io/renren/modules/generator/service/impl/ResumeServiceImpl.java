package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ResumeDao;
import io.renren.modules.generator.entity.ResumeEntity;
import io.renren.modules.generator.service.ResumeService;

import javax.annotation.Resource;


@Service("resumeService")
public class ResumeServiceImpl extends ServiceImpl<ResumeDao, ResumeEntity> implements ResumeService {

    @Resource
    private ResumeDao resumeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ResumeEntity> page = this.page(
                new Query<ResumeEntity>().getPage(params),
                new QueryWrapper<ResumeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insertResume(ResumeEntity resumeEntity) {
         resumeDao.insertResume(resumeEntity);
    }

    @Override
    public List<ResumeEntity> getByresHrId(long id) {
        return resumeDao.getByresHrId(id);
    }

}