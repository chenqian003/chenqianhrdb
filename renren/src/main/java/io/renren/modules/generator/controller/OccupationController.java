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

import io.renren.modules.generator.entity.OccupationEntity;
import io.renren.modules.generator.service.OccupationService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`occ_categoty`) REFER `hrdb/category`(`cat_id`) ON UPDATE
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:25
 */
@RestController
@RequestMapping("generator/occupation")
public class OccupationController {
    @Autowired
    private OccupationService occupationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:occupation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = occupationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{occId}")
    @RequiresPermissions("generator:occupation:info")
    public R info(@PathVariable("occId") Long occId){
		OccupationEntity occupation = occupationService.getById(occId);

        return R.ok().put("occupation", occupation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:occupation:save")
    public R save(@RequestBody OccupationEntity occupation){
		occupationService.save(occupation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:occupation:update")
    public R update(@RequestBody OccupationEntity occupation){
		occupationService.updateById(occupation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:occupation:delete")
    public R delete(@RequestBody Long[] occIds){
		occupationService.removeByIds(Arrays.asList(occIds));

        return R.ok();
    }

}
