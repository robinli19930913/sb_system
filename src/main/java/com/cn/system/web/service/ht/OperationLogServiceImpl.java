package com.cn.system.web.service.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.dao.mapper.OperationLogMapper;
import com.cn.system.dao.model.OperationLog;
import com.cn.system.dao.model.OperationLogExample;
import com.cn.system.web.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class OperationLogServiceImpl {
	@Resource
	private OperationLogMapper operationLogMapper;

	public BaseResult list(BaseRequest request) {
		BaseResult result = new BaseResult();
		String startTime = request.getStartTime();
		String endTime = request.getEndTime();
		if(StringUtils.isBlank(startTime)) {
			startTime = DateUtil.getDateStrOfFormat(DateUtil.getLastDayOfDate(-1),"yyyy-MM-dd") + " 00:00:00";
			request.setStartTime(startTime);
		}
		
		OperationLogExample example = new OperationLogExample();
		OperationLogExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(startTime)) {
			criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.getDateToStr(startTime));
		}
		if(StringUtils.isNotBlank(endTime)) {
			criteria.andCreateTimeLessThanOrEqualTo(DateUtil.getDateToStr(endTime));
		}
		
		example.setOrderByClause("create_time DESC");
		
		PageHelper.startPage(request.getPage(), request.getRows());
		List<OperationLog> list = operationLogMapper.selectByExample(example);
		result.setData(request);
		result.setRowsPage(list);
		return result;
	}
	
	public static void main(String[] args) {
		String id = UUID.randomUUID().toString();
		System.out.println(id);
	}

	public void insert(OperationLog operationLog) {
		operationLogMapper.insertSelective(operationLog);
	}

}
