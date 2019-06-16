package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysUserService;
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

import static io.renren.common.utils.ShiroUtils.getUserId;


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

    @Autowired
    private SysUserService sysUserService;
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:friends:list")
    public R list(@RequestParam Map<String, Object> params){
        Long id=getUserId();
        PageUtils page = friendsService.queryPage(params,id);

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
    /**
     * 回显得到用户的电话和姓名  徐夫立
     */
    @RequestMapping("getInformation")
    public R getInformation(@RequestParam String keywords) {
        System.out.println(keywords);
        List<SysUserEntity> list = sysUserService.list(new QueryWrapper<SysUserEntity>().eq("mobile", keywords));
        System.out.println(list);
        return R.ok().put("user", list.get(0));
    }

    /**
     * 发送验证信息让他人添加你为朋友  徐夫立
     */
    @RequestMapping("add")
    public R add(String mobile, String msg) {
        System.out.println(mobile);
        System.out.println(msg);
        List<SysUserEntity> list =  sysUserService.list(new QueryWrapper<SysUserEntity>().eq("mobile",mobile));
        //System.out.println(list);
        Long fri_receiver=list.get(0).getUserId();
        Long fri_sender=getUserId();
        Long fri_state = (long) 1;
        String fri_msg=msg;
        Date day=new Date();
        FriendsEntity friend=new FriendsEntity();
        friend.setFriReceiver(fri_receiver);
        friend.setFriSender(fri_sender);
        friend.setFriState(fri_state);
        friend.setFriMsg(fri_msg);
        friend.setFriTime(day);
        friendsService.save(friend);
        return R.ok();

    }
    /**
     * 通过验证消息  徐夫立
     */
    @RequestMapping("pass")
    public R pass(String id,String t) {
        List<FriendsEntity> list = friendsService.list(new QueryWrapper<FriendsEntity>().eq("fri_id", id));
        FriendsEntity fri=list.get(0);
        Long friSender = fri.getFriSender();
        Long fid=getUserId();
        if(friSender!=fid) {
            FriendsEntity friend = new FriendsEntity();
            Long fri_state = (long) 2;
            friend.setFriState(fri_state);
            friend.setFriId(Long.parseLong(id));
            friendsService.updateById(friend);

        }
        return R.ok();
    }
    /**
     * 拒绝验证消息  徐夫立
     */
    @RequestMapping("refuse")
    public R refuse(String id,String t) {
        List<FriendsEntity> list = friendsService.list(new QueryWrapper<FriendsEntity>().eq("fri_id", id));
        FriendsEntity fri=list.get(0);
        Long friSender = fri.getFriSender();
        Long fid=getUserId();
        if(friSender!=fid) {
            FriendsEntity friend = new FriendsEntity();
            Long fri_state = (long) 3;
            friend.setFriState(fri_state);
            friend.setFriId(Long.parseLong(id));
            friendsService.updateById(friend);

        }
        return R.ok();
    }
}
