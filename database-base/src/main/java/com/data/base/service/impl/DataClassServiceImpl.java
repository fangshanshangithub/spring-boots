package com.data.base.service.impl;

import com.data.base.entity.DataDTO;
import com.data.base.mapper.ClassCourseMapper;
import com.data.base.mapper.OrderCourseMapper;
import com.data.base.service.DataClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class DataClassServiceImpl implements DataClassService {

    @Autowired
    private ClassCourseMapper classCourseMapper;

    @Autowired
    private OrderCourseMapper orderCourseMapper;


    @Override
    public List<DataDTO> findAllOrderDetailIds() {


        return orderCourseMapper.selectOldUnRefund();
    }

    @Override
    public boolean changeCourse(Integer orderDetailId, BigDecimal coursePrice, BigDecimal lastCoursePrice, Integer lastId) {
        orderCourseMapper.updateByOrderDetailId(orderDetailId, coursePrice);

        orderCourseMapper.updateById(lastId, lastCoursePrice);

        return true;
    }
}
