package com.cun.plus;

import com.cun.plus.entity.AiCmcInfo;
import com.cun.plus.entity.User;
import com.cun.plus.mapper.AiCmcInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liukai
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/916:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AiTest {
    @Autowired
    private AiCmcInfoMapper aicmcinfomapper;
    @Test
    public void selectTest() {
        // 根据id 查询一条记录
        AiCmcInfo aicmcinfo = aicmcinfomapper.selectById("U00HHHSB6");
        System.out.println(aicmcinfo);
    }
}
