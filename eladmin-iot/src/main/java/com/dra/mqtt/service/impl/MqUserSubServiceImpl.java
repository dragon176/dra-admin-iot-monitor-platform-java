package com.dra.mqtt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dra.mqtt.entity.MqUserSub;
import com.dra.mqtt.mapper.MqUserSubMapper;
import com.dra.mqtt.service.IMqUserSubService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户订阅 服务实现类
 * </p>
 *
 * @author dra
 * @since 2022-05-23
 */
@Service
public class MqUserSubServiceImpl extends ServiceImpl<MqUserSubMapper, MqUserSub> implements IMqUserSubService {

}
