package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.FriendsDao;
import io.renren.modules.generator.entity.FriendsEntity;
import io.renren.modules.generator.service.FriendsService;


@Service("friendsService")
public class FriendsServiceImpl extends ServiceImpl<FriendsDao, FriendsEntity> implements FriendsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FriendsEntity> page = this.page(
                new Query<FriendsEntity>().getPage(params),
                new QueryWrapper<FriendsEntity>()
        );

        return new PageUtils(page);
    }

}