package com.xu.xu7x.config;

import com.xu.xu7x.bean.ButtonType;
import com.xu.xu7x.bean.TopicEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xuhongda on 2019/7/3
 * com.xu.xu7x.config
 * xu7x
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private ButtonType buttonType;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DAY_OF_MONTH);

        if (TopicEnum.GIRL.getName().equals(buttonType.getTopic()) && month == Calendar.JULY && day == 7) {
            log.info("into girl topic");
            request.getRequestDispatcher("/girl").forward(request, response);
        }
        return true;
    }

}
