package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.generator.entity.RecordEntity;
import io.renren.modules.generator.entity.ResumeEntity;
import io.renren.modules.generator.service.RecordService;
import io.renren.modules.generator.service.ResumeService;
import io.renren.modules.generator.service.impl.RecordServiceImpl;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.InterviewEntity;
import io.renren.modules.generator.service.InterviewService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * InnoDB free: 9216 kB; (`intw_resume_id`) REFER `hrdb/resume`(`res_id`) ON UPDATE
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-05-17 12:05:14
 */
@RestController
@RequestMapping("generator/interview")
public class InterviewController extends AbstractController {
    @Autowired
    private InterviewService interviewService;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private RecordService recordService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:interview:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = interviewService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{intwId}")
    @RequiresPermissions("generator:interview:info")
    public R info(@PathVariable("intwId") Long intwId){
		InterviewEntity interview = interviewService.getById(intwId);

        return R.ok().put("interview", interview);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:interview:save")
    public R save(@RequestBody InterviewEntity interview){
//		interviewService.save(interview);
        System.out.println(interview.toString());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:interview:update")
    public R update(@RequestBody InterviewEntity interview){
		interviewService.updateById(interview);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:interview:delete")
    public R delete(@RequestBody Long[] intwIds){
		interviewService.removeByIds(Arrays.asList(intwIds));

        return R.ok();
    }


    /**
     * 新增预约
     */

    @RequestMapping("/saveRes")
    public R saveRes(@RequestBody ResumeEntity resumeEntity){

        // 前台传来的Data 长度过长  截取 xxxx-xx-xx 格式的时间
        resumeEntity.setResInCollege(resumeEntity.getResInCollege().substring(0,10));
        resumeEntity.setResOutCollege(resumeEntity.getResOutCollege().substring(0,10));
        resumeEntity.setResBirthday(resumeEntity.getResBirthday().substring(0,10));

        resumeEntity.setResTime(new Date());
        resumeEntity.setResHrId(getUserId());
        InterviewEntity interviewEntity = new InterviewEntity();
        //添加 新增的resume
        resumeService.insertResume(resumeEntity);
        interviewEntity.setIntwResumeId(resumeEntity.getResId());
        // status 2 未面试  1 已面试
        interviewEntity.setIntwState(Long.parseLong(Integer.toString(2)));
        interviewEntity.setIntwTime(new Date());
        interviewEntity.setIntwBookTime(resumeEntity.getIntwBookTime());
        interviewEntity.setIntwMobile(resumeEntity.getResMobile());
        interviewEntity.setIntwName(resumeEntity.getResName());
        // extends AbstractController 获取当前登陆用户的ID
        interviewEntity.setIntwHrId(getUserId());
        //添加新增的interview
        interviewService.save(interviewEntity);
        return R.ok();
    }

    /**
     * 新增面试详情
     */
    @RequestMapping("/saveRec")
    public R saveRec(@RequestBody RecordEntity recordEntity){
        InterviewEntity interviewEntity = interviewService.getById(recordEntity.getIntwId());
        // 修改状态为 已面试
        interviewEntity.setIntwState(Long.parseLong(Integer.toString(1)));
        // 修改操作时间
        interviewEntity.setIntwTime(new Date());
        interviewService.updateById(interviewEntity);
        recordEntity.setRecHrId(getUserId());
        recordEntity.setRecTime(new Date());
        //新增record
        recordService.save(recordEntity);
        return R.ok();
    }

}
