package com.data.base;

import com.data.base.entity.DataDTO;
import com.data.base.service.DataClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseBaseApplicationTests {

    @Autowired
    private DataClassService dataClassService;

    @Test
    public void contextLoads() {
        List<DataDTO>  orderDetailIdList = dataClassService.findAllOrderDetailIds();
        System.out.println("size ====== " + orderDetailIdList.size());
    }

}
