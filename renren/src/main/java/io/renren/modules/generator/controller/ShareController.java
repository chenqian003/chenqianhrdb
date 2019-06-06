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

import io.renren.modules.generator.entity.ShareEntity;
import io.renren.modules.generator.service.ShareService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:04:20
 */
@RestController
@RequestMapping("generator/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:share:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = shareService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{shaId}")
    @RequiresPermissions("generator:share:info")
    public R info(@PathVariable("shaId") Long shaId){
		ShareEntity share = shareService.getById(shaId);

        return R.ok().put("share", share);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:share:save")
    public R save(@RequestBody ShareEntity share){
		shareService.save(share);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:share:update")
    public R update(@RequestBody ShareEntity share){
		shareService.updateById(share);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:share:delete")
    public R delete(@RequestBody Long[] shaIds){
		shareService.removeByIds(Arrays.asList(shaIds));

        return R.ok();
    }

}
