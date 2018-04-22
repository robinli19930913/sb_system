package com.cn.system.web.api.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.web.service.ht.OperationLogServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("log/")
public class OperationLogController {
	private static final Logger log = Logger.getLogger(OperationLogController.class); 
	
	@Resource
	private OperationLogServiceImpl operationLogServiceImpl;
	
	@RequestMapping("tolist")
    public String tolist(){
    	return "log_list";
    }
	
	@RequestMapping("list")
	@ResponseBody
    public BaseResult list(BaseRequest request){
		BaseResult result = null;
		try {
			result = operationLogServiceImpl.list(request);
		} catch (Exception e) {
			log.info("获取操作日志异常："+e.getMessage(),e);
			result.setSuccess(false);
			result.setMsg("获取操作日志异常，请联系管理员");
		}
    	return result;
    }
}
