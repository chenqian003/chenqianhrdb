package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ShareDao;
import io.renren.modules.generator.entity.ShareEntity;
import io.renren.modules.generator.service.ShareService;


@Service("shareService")
public class ShareServiceImpl extends ServiceImpl<ShareDao, ShareEntity> implements ShareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ShareEntity> page = this.page(
                new Query<ShareEntity>().getPage(params),
                new QueryWrapper<ShareEntity>()
        );

        return new PageUtils(page);
    }

}