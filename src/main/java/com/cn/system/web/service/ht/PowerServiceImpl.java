package com.cn.system.web.service.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.dao.bean.Combotree;
import com.cn.system.dao.mapper.MenuTreeMapper;
import com.cn.system.dao.mapper.RolesMapper;
import com.cn.system.dao.mapper.RolesMenuMapper;
import com.cn.system.dao.mapper.UserRolesMapper;
import com.cn.system.dao.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PowerServiceImpl {
	@Resource
	private MenuTreeMapper menuTreeMapper;
	@Resource
	private RolesMapper rolesMapper;
	@Resource
	private UserRolesMapper userRolesMapper;
	@Resource
	private RolesMenuMapper rolesMenuMapper;

	public List<MenuTree> getMenu() {
		MenuTreeExample example = new MenuTreeExample();
		example.createCriteria()
			.andDelEqualTo((short)0)
			.andPidEqualTo(0L);
		return menuTreeMapper.selectByExample(example);
	}

	/**
	 * 添加菜单
	 * @param menuTree 菜单bean
	 * @param powerids 角色标识
	 * @return
	 */
	public BaseResult addMenu(MenuTree menuTree, String powerids) {
		BaseResult result = new BaseResult();
		String name = menuTree.getName();
		if(StringUtils.isBlank(name)) {
			result.setSuccess(false);
			result.setMsg("请输入菜单名称");
		}
		if(menuTree.getPid() == null) {
			menuTree.setPid(0L);
		}
		if(result.isSuccess()) {
			MenuTreeExample example = new MenuTreeExample();
			example.createCriteria()
				.andPidEqualTo(menuTree.getPid())
				.andNameEqualTo(name);
			List<MenuTree> list = menuTreeMapper.selectByExample(example);
			if(list != null && list.size() > 0) {
				result.setSuccess(false);
				result.setMsg("菜单名称重复");
			}
		}
		if(result.isSuccess()) {
			menuTreeMapper.insertSelective(menuTree);
			if(StringUtils.isNotBlank(powerids)) {
				String[] ids = powerids.split(",");
				for(String id : ids) {
					RolesMenu rmMenu = new RolesMenu();
					rmMenu.setMid(menuTree.getId());
					rmMenu.setRid(Long.parseLong(id));
					rolesMenuMapper.insertSelective(rmMenu);
				}
			}
		}
		
		return result;
	}


	public List<Combotree> getPowerList(HtUser htUser) {
		List<Combotree> pList = new ArrayList<>();
		if(htUser != null) {
			Short type = htUser.getType();
			if(type != null && type.shortValue() != 0) {
				Long userId = htUser.getUserId();
				UserRolesExample example = new UserRolesExample();
				example.createCriteria()
					.andUidEqualTo(userId);
				example.isDistinct();
				List<UserRoles> urList = userRolesMapper.selectByExample(example);
				List<Long> rList = new ArrayList<>();
				rList.add(0L);
				if(urList != null && urList.size() > 0) {
					for(UserRoles userRoles : urList) {
						rList.add(userRoles.getRid());
					}
				}
				RolesMenuExample rolesMenuExample = new RolesMenuExample();
				rolesMenuExample.createCriteria()
					.andRidIn(rList);
				rolesMenuExample.isDistinct();
				List<RolesMenu> rmList = rolesMenuMapper.selectByExample(rolesMenuExample);
				List<Long> mList = new ArrayList<>();
				mList.add(0L);
				if(rmList != null && rmList.size() > 0) {
					for(RolesMenu rolesMenu : rmList) {
						mList.add(rolesMenu.getMid());
					}
				}
				
				MenuTreeExample menuTreeExample = new MenuTreeExample();
				menuTreeExample.createCriteria()
					.andDelEqualTo((short)0)
					.andIdIn(mList);
				menuTreeExample.setOrderByClause("pid");
				List<MenuTree> list = menuTreeMapper.selectByExample(menuTreeExample);
				pList = getMenuTreeList(list);
			}else {
				MenuTreeExample menuTreeExample = new MenuTreeExample();
				menuTreeExample.createCriteria()
					.andDelEqualTo((short)0);
				menuTreeExample.setOrderByClause("pid");
				List<MenuTree> list = menuTreeMapper.selectByExample(menuTreeExample);
				pList = getMenuTreeList(list);
			}
		}
		return pList;
	}


	private List<Combotree> getMenuTreeList(List<MenuTree> list) {
		List<Combotree> pList = new ArrayList<>();
		Map<Long, List<Combotree>> map = new HashMap<>();
		if(list != null && list.size() > 0) {
			for(MenuTree menuTree : list) {
				Combotree combotree = new Combotree();
				combotree.setId(menuTree.getId().intValue());
				combotree.setPid(menuTree.getPid().intValue());
				combotree.setText(menuTree.getName());
				Long pid = menuTree.getPid();
				if(pid != null && pid.longValue() != 0) {
					List<Combotree> ctList = map.get(pid);
					if(ctList != null && ctList.size() > 0) {
						ctList.add(combotree);
					}else {
						ctList = new ArrayList<>();
						ctList.add(combotree);
						map.put(pid, ctList);
					}
				}
				if(pid != null && pid.longValue() == 0) {
					pList.add(combotree);
				}
			}
			
			for(Combotree combotree : pList) {
				combotree.setChildren(map.get(combotree.getId()));
			}
		}
		return pList;
	}


	public List<Combotree> getRolesList() {
		RolesExample example = new RolesExample();
		example.createCriteria()
			.andDelEqualTo((short)0);
		List<Roles> rolesList = rolesMapper.selectByExample(example);
		List<Combotree> list = new ArrayList<>();
		if(rolesList != null && rolesList.size() > 0) {
			for(Roles roles : rolesList) {
				Combotree combotree = new Combotree();
				combotree.setId(roles.getId().intValue());
				combotree.setText(roles.getName());
				list.add(combotree);
			}
		}
		return list;
	}

	public BaseResult getMenuList(BaseRequest request, String name, Short del) {
		BaseResult result = new BaseResult();
		MenuTreeExample example = new MenuTreeExample();
		MenuTreeExample.Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(name)) {
			criteria.andNameLike("%"+name+"%");
		}
		if(del != null && (del.shortValue() == 1 || del.shortValue() == 0)) {
			criteria.andDelEqualTo(del);
		}
		List<MenuTree> list = menuTreeMapper.selectByExample(example);
		result.setData(request);
		result.setRows(list);
		return result;
	}

	public List getMenulist() {
		MenuTreeExample example = new MenuTreeExample();
		return menuTreeMapper.selectByExample(example);
	}

	public BaseResult delMenu(Long id, Short del) {
		BaseResult result = new BaseResult();
		if(id == null) {
			result.setSuccess(false);
			result.setMsg("请选择禁用菜单");
		}
		MenuTree menuTree = null;
		if(result.isSuccess()) {
			menuTree = menuTreeMapper.selectByPrimaryKey(id);
			if(menuTree == null) {
				result.setSuccess(false);
				result.setMsg("菜单不存在");
			}
		}
		if(result.isSuccess()) {
			menuTree.setDel(del);
			menuTreeMapper.updateByPrimaryKeySelective(menuTree);
		}
		return result;
	}

	public BaseResult updateMenu(MenuTree mt,String mrids) {
		BaseResult result = new BaseResult();
		Long id = mt.getId();
		if(id == null) {
			result.setSuccess(false);
			result.setMsg("请选择修改菜单");
		}
		MenuTree menuTree = null;
		if(result.isSuccess()) {
			menuTree = menuTreeMapper.selectByPrimaryKey(id);
			if(menuTree == null) {
				result.setSuccess(false);
				result.setMsg("菜单不存在");
			}
		}
		if(result.isSuccess()) {
			MenuTreeExample example = new MenuTreeExample();
			example.createCriteria()
				.andPidEqualTo(menuTree.getPid())
				.andNameEqualTo(mt.getName());
			List<MenuTree> list = menuTreeMapper.selectByExample(example);
			if(list != null && list.size() > 0 && list.get(0).getId().longValue() != id.longValue()) {
				result.setSuccess(false);
				result.setMsg("菜单名称重复");
			}
		}
		if(result.isSuccess()) {
			if(StringUtils.isNotBlank(mrids)) {
				RolesMenuExample rmExample = new RolesMenuExample();
				rmExample.createCriteria()
					.andMidEqualTo(id);
				rolesMenuMapper.deleteByExample(rmExample);
				String[] ids = mrids.split(",|，");
				for(String rid : ids) {
					RolesMenu rmMenu = new RolesMenu();
					rmMenu.setMid(id);
					rmMenu.setRid(Long.parseLong(rid));
					rolesMenuMapper.insertSelective(rmMenu);
				}
			}
			menuTreeMapper.updateByPrimaryKeySelective(mt);
		}
		return result;
	}

	public List<Combotree> getRolesListByPower(HttpServletRequest request,Long userId, Long menuId) {
		Object object = request.getSession().getAttribute("user");
		HtUser htUser = null;
		if(object != null) {
			htUser = (HtUser) object;
		}
		List<Combotree> list = new ArrayList<>();
		if(htUser != null && htUser.getType().shortValue() != 0) {//其他人员
			List<Long> ids = new ArrayList<>();
			ids.add(0L);
			UserRolesExample example = new UserRolesExample();
			example.createCriteria()
				.andUidEqualTo(htUser.getUserId());
			List<UserRoles> urList = userRolesMapper.selectByExample(example);
			if(urList != null && urList.size() > 0) {
				for(UserRoles urRoles : urList) {
					ids.add(urRoles.getRid());
				}
			}
			RolesExample rexample = new RolesExample();
			rexample.createCriteria()
				.andIdIn(ids)
				.andDelEqualTo((short)0);
			list = getRolesListByExample(rexample);
		}else {//技术人员
			RolesExample example = new RolesExample();
			example.createCriteria()
				.andDelEqualTo((short)0);
			list = getRolesListByExample(example);
		}
		
		if(userId != null && list != null && list.size() > 0) {//回显
			UserRolesExample example = new UserRolesExample();
			example.createCriteria()
				.andUidEqualTo(userId);
			List<UserRoles> urList = userRolesMapper.selectByExample(example);
			if(urList != null && urList.size() > 0) {
				List<Long> ids = new ArrayList<>();
				ids.add(0L);
				for(UserRoles ur : urList) {
					ids.add(ur.getRid());
				}
				for(Combotree ct : list) {
					if(ids.contains(ct.getId().longValue())) {
						ct.setChecked(true);
					}
				}
			}
		}
		if(menuId != null && list != null && list.size() > 0) {//回显
			RolesMenuExample rmexample = new RolesMenuExample();
			rmexample.createCriteria()
			.andMidEqualTo(menuId);
			List<RolesMenu> rmList = rolesMenuMapper.selectByExample(rmexample);
			if(rmList != null && rmList.size() > 0) {
				List<Long> ids = new ArrayList<>();
				ids.add(0L);
				for(RolesMenu ur : rmList) {
					ids.add(ur.getRid());
				}
				for(Combotree ct : list) {
					if(ids.contains(ct.getId().longValue())) {
						ct.setChecked(true);
					}
				}
			}
		}
		return list;
	}
	
	public List<Combotree> getRolesListByExample(RolesExample example){
		List<Roles> rolesList = rolesMapper.selectByExample(example);
		List<Combotree> list = new ArrayList<>();
		if(rolesList != null && rolesList.size() > 0) {
			for(Roles roles : rolesList) {
				Combotree combotree = new Combotree();
				combotree.setId(roles.getId().intValue());
				combotree.setText(roles.getName());
				list.add(combotree);
			}
		}
		
		return list;
	}

	public List<Roles> getRolesList(HtUser htUser) {
		RolesExample example = new RolesExample();
		example.createCriteria()
			.andLevelGreaterThanOrEqualTo(htUser.getType().intValue());
		return rolesMapper.selectByExample(example);
	}

}
