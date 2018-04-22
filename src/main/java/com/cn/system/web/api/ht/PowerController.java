package com.cn.system.web.api.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.dao.bean.Combotree;
import com.cn.system.dao.model.HtUser;
import com.cn.system.dao.model.MenuTree;
import com.cn.system.dao.model.Roles;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("power/")
public class PowerController {
	private static final Logger log = Logger.getLogger(PowerController.class);
	
	@Resource
	private PowerServiceImpl powerServiceImpl;
	
	@RequestMapping("toMenuAdd")
	public String toMenuAdd(){
    	return "menu/menu_add";
    }
	
	@RequestMapping("toMenuList")
	public String toMenulist(){
		return "menu/menu_list";
	}
	
	@RequestMapping("toRolesList")
	public String toRolesList(){
		return "roles/roles_list";
	}
	
	@RequestMapping("getMenu")
	@ResponseBody
	public List<MenuTree> getMenu(){
		return powerServiceImpl.getMenu();
	}
	
	@RequestMapping("addMenu")
	@ResponseBody
	public BaseResult addMenu(MenuTree menuTree, String powerids){
		return powerServiceImpl.addMenu(menuTree,powerids);
	}
	@RequestMapping("updateMenu")
	@ResponseBody
	public BaseResult updateMenu(MenuTree menuTree,String mrids){
		return powerServiceImpl.updateMenu(menuTree,mrids);
	}
	@RequestMapping("delMenu")
	@ResponseBody
	public BaseResult delMenu(Long id,Short del){
		return powerServiceImpl.delMenu(id,del);
	}
	
	@RequestMapping("getPowerList")
	@ResponseBody
	public List getPowerList(HttpServletRequest request){
		Object object = request.getSession().getAttribute("user");
		HtUser htUser = null;
		if(object != null) {
			htUser = (HtUser) object;
		}
		List<Combotree> list = powerServiceImpl.getPowerList(htUser);
		return list;
	}
	@RequestMapping("rolesList")
	@ResponseBody
	public List rolesList(HttpServletRequest request){
		Object object = request.getSession().getAttribute("user");
		HtUser htUser = null;
		if(object != null) {
			htUser = (HtUser) object;
		}
		List<Roles> list = powerServiceImpl.getRolesList(htUser);
		return list;
	}
	@RequestMapping("getMenuList")
	@ResponseBody
	public BaseResult getMenuList(BaseRequest request, String name, Short del){
		BaseResult result = null;
		try {
			result = powerServiceImpl.getMenuList(request,name,del);
		} catch (Exception e) {
			log.info("获取菜单异常："+e.getMessage(),e);
			result.setSuccess(false);
			result.setMsg("获取菜单异常，请联系管理员");
		}
    	return result;
	}
	
	@RequestMapping("getMenulist")
	@ResponseBody
	public List getMenulist(){
    	return powerServiceImpl.getMenulist();
	}
	@RequestMapping("getRolesList")
	@ResponseBody
	public List getRolesList(){
		List<Combotree> list = powerServiceImpl.getRolesList();
		return list;
	}
	
	@RequestMapping("getRolesListByPower")
	@ResponseBody
	public List getRolesListByPower(HttpServletRequest request,Long userId,Long menuId){
		List<Combotree> list = powerServiceImpl.getRolesListByPower(request,userId,menuId);
		return list;
	}
}
