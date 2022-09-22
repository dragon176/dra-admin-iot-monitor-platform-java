package com.dra.mqtt.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dra.mqtt.utils.ControllerFinalSet;
import com.dra.mqtt.utils.RestTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Controller CRUD基本操作
 *
 * @param <T> 实体类
 * @author dra
 * @since 2022-05-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseController<T> {
    private IService<T> iService;

    public RestTemplate<?> baseAdd(T var) {
        boolean save = iService.save(var);
        if (!save) {
            return new RestTemplate<>(null, ControllerFinalSet.FAIL_CODE, ControllerFinalSet.ADD_FAIL_MES);
        }
        return new RestTemplate<>(null, ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.ADD_SUCCESS_MES);
    }


    public RestTemplate<?> baseUpdate(T var) {
        boolean update = iService.updateById(var);
        if (!update) {
            return new RestTemplate<>(null, ControllerFinalSet.FAIL_CODE, ControllerFinalSet.UPDATE_FAIL_MES);
        }
        return new RestTemplate<>(null, ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.UPDATE_SUCCESS_MES);
    }


    public RestTemplate<?> baseDel(Long id) {
        boolean del = iService.removeById(id);
        if (!del) {
            return new RestTemplate<>(null, ControllerFinalSet.FAIL_CODE, ControllerFinalSet.DEL_FAIL_MES);
        }
        return new RestTemplate<>(null, ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.DEL_SUCCESS_MES);
    }

    public RestTemplate<?> baseSelect(Long id,
                                           Long pageSize,
                                           Long pageNum) {
        Object byId = null;
        if (id != -1) {
            byId = iService.getById(id);

        } else {
            byId = iService.page(Page.of(pageNum, pageSize)).getRecords();
        }

        if (byId == null) {
            return new RestTemplate<>(null, ControllerFinalSet.FAIL_CODE, ControllerFinalSet.SELECT_FAIL_MES);
        }
        return new RestTemplate<>(byId, ControllerFinalSet.SUCCESS_CODE, ControllerFinalSet.SELECT_SUCCESS_MES);
    }
}
