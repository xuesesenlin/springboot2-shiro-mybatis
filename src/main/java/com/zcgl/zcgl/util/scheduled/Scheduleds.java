package com.zcgl.zcgl.util.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * CRON表达式    含义
 * "0 0 12 * * ?"    每天中午十二点触发
 * "0 15 10 ? * *"    每天早上10：15触发
 * "0 15 10 * * ?"    每天早上10：15触发
 * "0 15 10 * * ? *"    每天早上10：15触发
 * "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
 * "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
 * "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
 * "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
 * "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
 * "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
 * "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 * 0 0 0 * * ? 每天0点执行
 * 0 0 * * * ? 每小时零分执行
 * 0 * * * * ? 每分钟0秒执行
 */
@Component
public class Scheduleds {

    //    每小时0分执行
//    根据实际时间执行
    @Scheduled(cron = "0 0 6 * * ?")
//    根据系统开始运行后每个多长时间运行
//    @Scheduled(fixedRate = 3600000)
    public void xs() {

    }

    //    每天0点执行
    @Scheduled(cron = "0 0 0 * * ?")
    public void ld() {
    }

    /**
     * 每天的0点跟新上一天的最新数据至新表
     */
//    @Scheduled(cron = "0 10 0 * * ?")
    @Scheduled(cron = "0 */5 * * * ?")
    public void ld2() {
    }
}
