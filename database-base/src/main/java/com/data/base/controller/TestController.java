package com.data.base.controller;

import com.data.base.entity.DataDTO;
import com.data.base.service.DataClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@RestController
public class TestController {

    public static int pageCount = 0;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DataClassService dataClassService;

    @RequestMapping("/test")
    public String test() {
        pageCount ++;

        if(pageCount > 1) {
            logger.info("只允许访问一次" , pageCount);
            return "只允许访问一次";
        }
        List<DataDTO>  orderDetailIdList = dataClassService.findAllOrderDetailIds();
        Map<Integer, List<DataDTO>> map = new HashMap<>();
        for(DataDTO dataDTO : orderDetailIdList) {
            Integer key = dataDTO.getOrderDetailId();
            List<DataDTO> dList =  map.get(key);
            if(null == dList) {
                dList = new ArrayList<>();
                dList.add(dataDTO);
            }
            else {
                dList.add(dataDTO);
            }
            map.put(key ,dList);
        }

        for (Map.Entry<Integer, List<DataDTO>> entry : map.entrySet()) {
             Integer key = entry.getKey();
             List<DataDTO> vlist =  entry.getValue();
             int courseSum = vlist.size();
             if(courseSum == 0) {
                 logger.error("**@@###异常订单详情ID{} 获取个数为0", key);
                 continue;
             }
             BigDecimal totalMoney = BigDecimal.ZERO;
             for(DataDTO ddto : vlist) {
                 totalMoney = totalMoney.add(ddto.getCoursePrice());
             }

             // 排序获得最后一节课的记录id
            Collections.sort(vlist,new Comparator<DataDTO>() {
                @Override
                public int compare(DataDTO arg0, DataDTO arg1) {
                    /**
                     * 升序排的话就是第一个参数.compareTo(第二个参数);
                     * 降序排的话就是第二个参数.compareTo(第一个参数);
                     */
                    return arg1.getDateStartTime().compareTo(arg0.getDateStartTime());
                }
            });
            Integer lastId = vlist.get(0).getId();


            //平均取整
            BigDecimal  coursePrice = totalMoney.divide(new BigDecimal(courseSum),0, RoundingMode.DOWN);
            //余数之和
            BigDecimal remainder = totalMoney.subtract(coursePrice.multiply(new BigDecimal(courseSum)));
            //最后一节
            BigDecimal lastCoursePrice = coursePrice.add(remainder);

            logger.info("####订单详情Id为{},对应有{}个course记录,总金额是{},非最后一节课的价格是{},最后一节课{}(di)的价格是{}"
                    , key, courseSum, totalMoney, coursePrice,lastId , lastCoursePrice);

            //dataClassService.changeCourse(key,coursePrice,lastCoursePrice,lastId);


         }

        return "操作成功";
    }

}
