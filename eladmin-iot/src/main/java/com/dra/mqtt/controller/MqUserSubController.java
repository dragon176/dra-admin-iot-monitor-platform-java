package com.dra.mqtt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dra.mqtt.entity.MqUserSub;
import com.dra.mqtt.service.IMqUserSubService;
import com.dra.mqtt.utils.ControllerFinalSet;
import com.dra.mqtt.utils.RestTemplate;
import me.zhengjie.utils.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户配置信息储存前端控制器
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@RestController
@RequestMapping("/api/mqUserSub")
public class MqUserSubController {

    @Resource
    private IMqUserSubService iMqUserSubService;

    @PostMapping
    private RestTemplate<?> add(String topic){

        System.out.println(topic);
        if (null!=topic&&!"".equals(topic.trim())){
            System.out.println("数据添加");
            String username = SecurityUtils.getCurrentUsername();
            MqUserSub mqUserSub = new MqUserSub();
            mqUserSub.setUsername(username);
            mqUserSub.setTopic(topic);
            //查询是否存在
            LambdaQueryWrapper<MqUserSub> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            MqUserSub one = iMqUserSubService.getOne(lambdaQueryWrapper.eq(MqUserSub::getUsername, username)
                    .and(i -> i.eq(MqUserSub::getTopic, topic)));
            if (null!=one){
                mqUserSub.setIsDelete(0);
                return new RestTemplate<>(iMqUserSubService.update(mqUserSub, lambdaQueryWrapper.eq(MqUserSub::getUsername, username)
                        .and(i -> i.eq(MqUserSub::getTopic, topic))),ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.ADD_SUCCESS_MES);
            }else {
                return new RestTemplate<>(iMqUserSubService.save(mqUserSub),ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.ADD_SUCCESS_MES);
            }





        }
        return new RestTemplate<>(null,ControllerFinalSet.FAIL_CODE, ControllerFinalSet.ADD_FAIL_MES);
    }
    @DeleteMapping
    private RestTemplate<?> remove(String topic){
        if (null!=topic&&!"".equals(topic.trim())){
            String username = SecurityUtils.getCurrentUsername();
            LambdaQueryWrapper<MqUserSub> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            MqUserSub mqUserSub = new MqUserSub();
            mqUserSub.setUsername(username);
            mqUserSub.setTopic(topic);
            mqUserSub.setIsDelete(1);
            return new RestTemplate<>(iMqUserSubService.update(mqUserSub,lambdaQueryWrapper.eq(MqUserSub::getUsername,username).and(i->i.eq(MqUserSub::getTopic,topic))),ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.DEL_SUCCESS_MES);
        }
        return new RestTemplate<>(null,ControllerFinalSet.FAIL_CODE, ControllerFinalSet.DEL_FAIL_MES);
    }

    @GetMapping
//    @AnonymousAccess
    private RestTemplate<?> search(){

        String username = SecurityUtils.getCurrentUsername();
        LambdaQueryWrapper<MqUserSub> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(MqUserSub::getUsername,username).eq(MqUserSub::getIsDelete,0).orderBy(true,true,MqUserSub::getId);
        List<MqUserSub> list = iMqUserSubService.list(lambdaQueryWrapper);
        return new RestTemplate<>(list,ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.SELECT_SUCCESS_MES);
    }
}
