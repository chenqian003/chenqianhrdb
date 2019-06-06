package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.OccupationDao;
import io.renren.modules.generator.entity.OccupationEntity;
import io.renren.modules.generator.service.OccupationService;


@Service("occupationService")
public class OccupationServiceImpl extends ServiceImpl<OccupationDao, OccupationEntity> implements OccupationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OccupationEntity> page = this.page(
                new Query<OccupationEntity>().getPage(params),
                new QueryWrapper<OccupationEntity>()
        );

        return new PageUtils(page);
    }

}