package com.cn.system.web.aop;

import com.cn.system.dao.model.HtUser;
import com.cn.system.dao.model.OperationLog;
import com.cn.system.web.service.ht.OperationLogServiceImpl;
import com.cn.system.web.utils.DataUtil;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by robin on 2018/4/20.
 */
public class HandlerInterceptorInit implements HandlerInterceptor {
    private static final Logger log = Logger.getLogger(HandlerInterceptorInit.class);

    @Resource
    public OperationLogServiceImpl operationLogServiceImpl;

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        try {
            long startTime = (Long) request.getAttribute("startTimeHandle");
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            if (handler instanceof HandlerMethod) {
                OperationLog operationLog = new OperationLog();
                operationLog.setId(DataUtil.getDateRandomStr(6));
                operationLog.setUrl(request.getRequestURI());
                operationLog.setIp(DataUtil.getIpAddr(request));
                Object object = request.getSession().getAttribute("user");
                if(object != null) {
                    HtUser htUser = (HtUser)object;
                    operationLog.setOperationId(htUser.getUserId());
                    operationLog.setOperationName(htUser.getUserName());
                }
                operationLog.setCreateTime(new Date());
                HandlerMethod h = (HandlerMethod) handler;
                operationLog.setController(h.getBean().getClass().getName());
                operationLog.setMethod(h.getMethod().getName());
                operationLog.setParams(getParamString(request.getParameterMap()));
                operationLog.setCosttime(executeTime+"ms");
                operationLogServiceImpl.insert(operationLog);
            }
        } catch (Exception e) {
            log.error("记录操作日志异常：" +e.getMessage(),e);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getRequestURI();
        Object object = request.getSession().getAttribute("user");
        if(path.equals("/system/login")
                ||path.equals("/system/")
                ||path.equals("/rabbitmq/addRabbitMq")
                ||path.equals("/version/v")
                ||path.equals("/system")
                || object != null) {
            //记录操作开始时间
            long startTime = System.currentTimeMillis();
            request.setAttribute("startTimeHandle", startTime);
            return true;
        }else {
            response.sendRedirect(request.getContextPath());
        }
        return false;
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String[]> e:map.entrySet()){
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if(value != null && value.length == 1){
                sb.append(value[0]).append("&");
            }else{
                sb.append(Arrays.toString(value)).append("&");
            }
        }
        return sb.toString();
    }
}
