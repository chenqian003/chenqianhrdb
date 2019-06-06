package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.FriendsEntity;
import io.renren.modules.generator.service.FriendsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@RestController
@RequestMapping("generator/friends")
public class FriendsController {
    @Autowired
    private FriendsService friendsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:friends:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = friendsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{friId}")
    @RequiresPermissions("generator:friends:info")
    public R info(@PathVariable("friId") Long friId){
		FriendsEntity friends = friendsService.getById(friId);

        return R.ok().put("friends", friends);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:friends:save")
    public R save(@RequestBody FriendsEntity friends){
		friendsService.save(friends);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:friends:update")
    public R update(@RequestBody FriendsEntity friends){
		friendsService.updateById(friends);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:friends:delete")
    public R delete(@RequestBody Long[] friIds){
		friendsService.removeByIds(Arrays.asList(friIds));

        return R.ok();
    }

}
