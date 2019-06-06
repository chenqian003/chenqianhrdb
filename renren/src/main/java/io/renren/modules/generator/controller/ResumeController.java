package io.renren.modules.generator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.generator.utils.SolrUtil;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ResumeEntity;
import io.renren.modules.generator.service.ResumeService;
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
@RequestMapping("generator/resume")
public class ResumeController extends AbstractController {
    @Autowired
    private ResumeService resumeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:resume:list")
    public R list(@RequestParam Map<String, Object> params){
//         分页
//        PageUtils page = resumeService.queryPage(params);
//         登陆人只能看到自己录入的简历
        List<ResumeEntity> list = resumeService.getByresHrId(getUserId());
        System.out.println(list.size());
        for (ResumeEntity entity : list) {
            System.out.println(entity.toString());
        }
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{resId}")
    @RequiresPermissions("generator:resume:info")
    public R info(@PathVariable("resId") Long resId){
		ResumeEntity resume = resumeService.getById(resId);

        return R.ok().put("resume", resume);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:resume:save")
    public R save(@RequestBody ResumeEntity resume){
		resumeService.save(resume);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:resume:update")
    public R update(@RequestBody ResumeEntity resume){
		resumeService.updateById(resume);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:resume:delete")
    public R delete(@RequestBody Long[] resIds){
		resumeService.removeByIds(Arrays.asList(resIds));

        return R.ok();
    }

    /**
     * 查询solr数据
     */

    @RequestMapping("/getSolrData")
    public R getSolrData(String keywords) throws IOException, SolrServerException {
        System.out.println(keywords);
        SolrDocumentList solrList = SolrUtil.query("item_keywords:"+keywords).getResults();
        List<String> resIdList = new ArrayList<>();
        if (solrList != null && solrList.size() > 0){
            for (SolrDocument solrDocument : solrList) {
                resIdList.add(solrDocument.getFieldValue("res_id").toString());
            }
        }
        List<ResumeEntity> list = new ArrayList<>();

        for (String s : resIdList) {
            System.out.println(s);
            list.add(resumeService.getById(Integer.parseInt(s)));
        }

        return R.ok().put("list",list);
    }

    @RequestMapping("getShare")
    public R getShare(){
        return R.ok();
    }

}
