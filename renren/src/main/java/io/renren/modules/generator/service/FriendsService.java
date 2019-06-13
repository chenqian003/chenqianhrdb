package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.FriendsEntity;

import java.util.Map;

/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
public interface FriendsService extends IService<FriendsEntity> {
    /**
     * 传递登录ID只会显示有关的列表  徐夫立
     */
    PageUtils queryPage(Map<String, Object> params,Long fri_sender);
}

