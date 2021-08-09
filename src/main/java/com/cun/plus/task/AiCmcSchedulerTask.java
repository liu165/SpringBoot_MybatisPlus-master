package com.cun.plus.task;

import com.cun.plus.entity.AiCmcInfo;
import com.cun.plus.mapper.AiCmcInfoMapper;
import com.cun.plus.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author liukai
 * @Title:
 * @Package
 * @Description: 发送短信
 * @date 2021/8/916:57
 */
@Component
public class AiCmcSchedulerTask {

    @Autowired
    private AiCmcInfoMapper aicmcinfomapper;
    private static final Logger log = LoggerFactory.getLogger(AiCmcSchedulerTask.class);
//   发送单条数据
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        AiCmcInfo info = aicmcinfomapper.selectById("UN2DDD86B");
        HttpClientUtil client = HttpClientUtil.getInstance();
        //UTF发送
        String text = "亲爱的"+info.getName()+":"+"测试群发cmc全员";
        int result = client.sendMsgUtf8("xiao", "735f6a1ee18bff2241", text,info.getMobile());
        if(result>0){
            System.out.println("UTF8成功发送条数=="+result+"手机号码为："+info.getMobile());
        }else{
            System.out.println(client.getErrorMsg(result));
        }
    }
}
