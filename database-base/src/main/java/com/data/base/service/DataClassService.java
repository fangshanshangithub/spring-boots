package com.data.base.service;

import com.data.base.entity.DataDTO;

import java.math.BigDecimal;
import java.util.List;

public interface DataClassService {


    /**
     * 获取的是未退款，老数据的 orderCourse 记录
     * @return
     */
    List<DataDTO> findAllOrderDetailIds();

    /**
     *
     * @param orderDetailId  订单详情Id
     * @param coursePrice
     * @param lastCoursePrice
     * @param lastId
     * @return
     */
    boolean changeCourse(Integer orderDetailId, BigDecimal coursePrice, BigDecimal lastCoursePrice, Integer lastId);
}
