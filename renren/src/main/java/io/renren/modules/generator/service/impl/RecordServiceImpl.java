package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.RecordDao;
import io.renren.modules.generator.entity.RecordEntity;
import io.renren.modules.generator.service.RecordService;

import javax.annotation.Resource;


@Service("recordService")
public class RecordServiceImpl extends ServiceImpl<RecordDao, RecordEntity> implements RecordService {
    @Resource
    private RecordDao recordDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecordEntity> page = this.page(
                new Query<RecordEntity>().getPage(params),
                new QueryWrapper<RecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<RecordEntity> getByrecRId(int recRId) {
        return recordDao.getByrecRId(recRId);
    }

}