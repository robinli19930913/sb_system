package com.cn.system.web.service.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.dao.mapper.HtUserMapper;
import com.cn.system.dao.mapper.MenuTreeMapper;
import com.cn.system.dao.mapper.RolesMenuMapper;
import com.cn.system.dao.mapper.UserRolesMapper;
import com.cn.system.dao.model.*;
import com.cn.system.web.utils.DataUtil;
import com.cn.system.web.utils.Token;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HtUserServiceImpl {
	@Resource
	private HtUserMapper htUserMapper;
	@Resource
	private UserRolesMapper userRolesMapper;
	@Resource
	private RolesMenuMapper rolesMenuMapper;
	@Resource
	private MenuTreeMapper menuTreeMapper;

	public HtUser info(String userName) {
		HtUserExample example = new HtUserExample();
		example.createCriteria()
			.andUserNameEqualTo(userName);
		List<HtUser> list = htUserMapper.selectByExample(example);
		HtUser htUser = null;
		if(list != null && list.size() > 0){
			htUser = list.get(0);
		}
		return htUser;
	}
	public BaseResult list(BaseRequest request) {
		BaseResult result = new BaseResult();
		HtUserExample example = new HtUserExample();
		example.createCriteria()
			.andTypeNotEqualTo((short)0);
		PageHelper.startPage(request.getPage(), request.getRows());
		List<HtUser> list = htUserMapper.selectByExample(example);
		result.setRowsPage(list);
		return result;
	}

	public BaseResult login(HttpServletRequest req,HttpServletResponse res,String username, String password) {
		BaseResult result = new BaseResult();
		/**
		 * 参数校验
		 */
		if(StringUtils.isBlank(username)) {
			result.setSuccess(false);
			result.setMsg("请输入账号");
			return result;
		}
		if(StringUtils.isBlank(password)) {
			result.setSuccess(false);
			result.setMsg("请输入密码");
			return result;
		}
		
		HtUserExample example = new HtUserExample();
		example.createCriteria()
			.andUserNameEqualTo(username);
		List<HtUser> list = htUserMapper.selectByExample(example);
		if(list == null || list.size() < 1) {
			result.setSuccess(false);
			result.setMsg("账号不存在");
		}
		if(result.isSuccess() && list.size() != 1) {
			result.setSuccess(false);
			result.setMsg("账号异常");
		}
		
		if(result.isSuccess() && !DataUtil.getMd5Password(password).equals(list.get(0).getPassword())) {
			result.setSuccess(false);
			result.setMsg("密码错误");
		}
		
		if(result.isSuccess() && list.get(0).getState().shortValue() != 1) {
			result.setSuccess(false);
			result.setMsg("没有登录权限");
		}
		if(result.isSuccess()) {
			result.setData(list.get(0));
			HttpSession  httpSession = req.getSession();
			httpSession.setAttribute("token", Token.makeToken());
			httpSession.setAttribute("user", list.get(0));
		}
		return result;
	}
	public BaseResult addUser(HttpServletRequest request, HtUser htUser, String urids) {
		BaseResult result = new BaseResult();
		String userName = htUser.getUserName();
		String nickName = htUser.getNickName();
		String password = htUser.getPassword();
		Short type = htUser.getType();
		Object object = request.getSession().getAttribute("user");
		HtUser user = null;
		if(object != null) {
			user = (HtUser) object;
		}
		if(StringUtils.isBlank(userName)) {
			result.setSuccess(false);
			result.setMsg("请输入用户账号");
			return result;
		}
		if(StringUtils.isBlank(nickName)) {
			result.setSuccess(false);
			result.setMsg("请输入用户姓名");
			return result;
		}
		if(StringUtils.isBlank(password)) {
			result.setSuccess(false);
			result.setMsg("请输入密码");
			return result;
		}
		if(StringUtils.isNotBlank(password)) {
			password = DataUtil.getMd5Password(password);
			htUser.setPassword(password);
		}
		HtUser hu = getHtUserByUserName(userName);
		if(hu != null) {
			result.setSuccess(false);
			result.setMsg("该账号已存在");
			return result;
		}
		if(result.isSuccess()) {
			if(type == null) {
				htUser.setType((short)3);
			}
			Date now = new Date();
			htUser.setCreateTime(now);
			htUser.setUpdateTime(now);
			if(user != null) {
				htUser.setFkCreateId(user.getUserId());
				htUser.setFkUpdateId(user.getUserId());
				htUser.setFkCreateName(user.getNickName());
				htUser.setFkUpdateName(user.getNickName());
			}
			htUserMapper.insertSelective(htUser);
			
			if(StringUtils.isNotBlank(urids)) {
				Long userId = htUser.getUserId();
				String[] ids = urids.split(",|，");
				for(String id : ids) {
					UserRoles userRoles = new UserRoles();
					userRoles.setRid(Long.parseLong(id));
					userRoles.setUid(userId);
					userRolesMapper.insertSelective(userRoles);
				}
			}
		}
		return result;
	}

	public HtUser getHtUserByUserName(String userName) {
		HtUser htUser = null;
		if(StringUtils.isBlank(userName)) {
			return htUser;
		}
		HtUserExample example = new HtUserExample();
		example.createCriteria()
			.andUserNameEqualTo(userName);
		List<HtUser> list = htUserMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			htUser = list.get(0);
		}
		return htUser;
	}
	public BaseResult updateState(HttpServletRequest req, Long userId, Short state) {
		BaseResult result = new BaseResult();
		Object object = req.getSession().getAttribute("user");
		HtUser user = null;
		if(object != null) {
			user = (HtUser) object;
		}
		
		HtUser htUser = htUserMapper.selectByPrimaryKey(userId);
		if(htUser == null) {
			result.setSuccess(false);
			result.setMsg("账号不存在");
		}
		if(result.isSuccess()) {
			Date now = new Date();
			htUser.setState(state);
			htUser.setUpdateTime(now);
			if(user != null) {
				htUser.setFkUpdateId(user.getUserId());
				htUser.setFkUpdateName(user.getNickName());
			}
			htUserMapper.updateByPrimaryKeySelective(htUser);
		}
		return result;
	}
	
	public BaseResult updateUser(HttpServletRequest request, Long uuserId, String uphone, String unickName, String uurids) {
		BaseResult result = new BaseResult();
		Object object = request.getSession().getAttribute("user");
		HtUser user = null;
		if(object != null) {
			user = (HtUser) object;
		}
		if(StringUtils.isBlank(unickName)) {
			result.setSuccess(false);
			result.setMsg("请输入用户姓名");
			return result;
		}
		HtUser htUser = htUserMapper.selectByPrimaryKey(uuserId);
		if(htUser == null) {
			result.setSuccess(false);
			result.setMsg("账号不存在");
		}
		Date now = new Date();
		htUser.setUpdateTime(now);
		List<Long> rids = new ArrayList<>();
		rids.add(0L);
		if(user != null) {
			htUser.setFkUpdateId(user.getUserId());
			htUser.setFkUpdateName(user.getNickName());
			UserRolesExample userRolesExample = new UserRolesExample();
			userRolesExample.createCriteria()
				.andUidEqualTo(user.getUserId());
			List<UserRoles> urlist = userRolesMapper.selectByExample(userRolesExample);
			if(urlist != null && urlist.size() > 0){
				for(UserRoles ur : urlist){
					rids.add(ur.getRid());
				}
			}
		}
		if(result.isSuccess()) {
			htUser.setNickName(unickName);
			htUser.setPhone(uphone);
			htUserMapper.updateByPrimaryKeySelective(htUser);
			UserRolesExample userRolesExample = new UserRolesExample();
			userRolesExample.createCriteria()
				.andUidEqualTo(uuserId)
				.andRidIn(rids);
			userRolesMapper.deleteByExample(userRolesExample);
			if(StringUtils.isNotBlank(uurids)) {
				Long userId = htUser.getUserId();
				String[] ids = uurids.split(",|，");
				for(String id : ids) {
					UserRoles userRoles = new UserRoles();
					userRoles.setRid(Long.parseLong(id));
					userRoles.setUid(uuserId);
					userRolesMapper.insertSelective(userRoles);
				}
			}
		}
		return result;
	}
	
	public List<MenuTree> getPowerTreeList(HtUser user) {
		if(user.getType().shortValue() == 0) {
			MenuTreeExample mtExample = new MenuTreeExample();
			mtExample.createCriteria()
				.andDelEqualTo((short)0);
			return menuTreeMapper.selectByExample(mtExample);
		}
		
		UserRolesExample urExample = new UserRolesExample();
		urExample.createCriteria()
			.andUidEqualTo(user.getUserId());
		List<UserRoles> urList = userRolesMapper.selectByExample(urExample);
		List<Long> rids = new ArrayList<>();
		rids.add(0L);
		if(urList != null && urList.size() > 0) {
			for(UserRoles userRoles : urList) {
				rids.add(userRoles.getRid());
			}
		}
		
		List<Long> mids = new ArrayList<>();
		mids.add(0L);
		if(rids != null && rids.size() > 1) {
			RolesMenuExample rmExample = new RolesMenuExample();
			rmExample.createCriteria()
				.andRidIn(rids);
			List<RolesMenu> rmList = rolesMenuMapper.selectByExample(rmExample);
			if(rmList != null && rmList.size() > 0) {
				for(RolesMenu rolesMenu : rmList) {
					mids.add(rolesMenu.getMid());
				}
			}
		}
		
		if(mids != null && mids.size() > 1) {
			MenuTreeExample mtExample = new MenuTreeExample();
			mtExample.createCriteria()
				.andDelEqualTo((short)0)
				.andIdIn(mids);
			return menuTreeMapper.selectByExample(mtExample);
		}
		// TODO Auto-generated method stub
		return null;
	}
}
