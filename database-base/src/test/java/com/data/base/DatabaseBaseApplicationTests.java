package com.data.base;

import com.data.base.entity.UserInfo;
import com.data.base.service.UserService;
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
    private UserService userService;

    @Test
    public void contextLoads() {
        List<UserInfo> list = userService.findAll();


        Collections.sort(list,new Comparator<UserInfo>() {

            @Override
            public int compare(UserInfo arg0, UserInfo arg1) {
                /**
                 * 升序排的话就是第一个参数.compareTo(第二个参数);
                 * 降序排的话就是第二个参数.compareTo(第一个参数);
                 */
                return arg1.getTime().compareTo(arg0.getTime());
            }
        });
        for(UserInfo bean: list) {
            System.out.print("@@@@@@@@@@@@@@@@@"+ new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(bean.getTime()) +"\n");
        }

        System.out.println("=====" + list.toString());
    }

}
