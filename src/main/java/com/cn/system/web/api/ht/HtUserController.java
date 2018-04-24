package com.cn.system.web.api.ht;

import com.cn.system.dao.bean.BaseRequest;
import com.cn.system.dao.bean.BaseResult;
import com.cn.system.dao.model.HtUser;
import com.cn.system.dao.model.MenuTree;
import com.cn.system.web.service.ht.HtUserServiceImpl;
import com.cn.system.web.utils.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/")
public class HtUserController {
	private static final Logger log = Logger.getLogger(HtUserController.class); 
	
    @Resource
    private HtUserServiceImpl htUserServiceImpl;
    
   
	@RequestMapping("layout")
	public String layout(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/";
	}

	@RequestMapping("/")
	public String login(HttpServletRequest req){
		return "login";
	}

    @RequestMapping("login")
    @ResponseBody
    public BaseResult login(HttpServletRequest req, HttpServletResponse res, String username, String password){
    	BaseResult baseResult = null;
    	try {
    		log.info("后台用户登录，账号："+username+"，登录时间："+ DateUtil.getDateStr(new Date()));
    		baseResult = htUserServiceImpl.login(req,res,username,password);
		} catch (Exception e) {
			log.info("登录异常："+e.getMessage(),e);
			baseResult.setSuccess(false);
			baseResult.setMsg("登录异常，请联系管理员");
		}
    	return baseResult;
    }
    
    @RequestMapping("/index")
    public String index(HttpServletRequest req){
    	Object object = req.getSession().getAttribute("user");
		HtUser user = null;
		if(object != null) {
			user = (HtUser) object;
		}
		if(user == null) {
			return "index";
		}
		List<MenuTree> treeList = htUserServiceImpl.getPowerTreeList(user);
		if(treeList == null || treeList.size() < 1) {
			return "index";
		}
		List<MenuTree> pList = new ArrayList<>();//一级菜单
		Map<String,List<MenuTree>> cMap = new HashMap<>();//二级菜单
		if(treeList != null && treeList.size() > 0) {
			for(MenuTree pt : treeList) {
				if(pt.getPid() != null && pt.getPid().intValue() == 0) {
					pList.add(pt);
				}
				if(pt.getPid() != null && pt.getPid().intValue() != 0){
					List<MenuTree> cList = cMap.get(String.valueOf(pt.getPid()));
					if(cList != null && cList.size() > 0) {
						cList.add(pt);
					}else {
						cList = new ArrayList<>();
						cList.add(pt);
						cMap.put(String.valueOf(pt.getPid()), cList);
					}
				}
			}
		}
		
		StringBuffer sf = new StringBuffer();
		if(pList != null && pList.size() > 0){
			for(MenuTree pt : pList){
				Long id = pt.getId();
				List<MenuTree> cList = cMap.get(id+"");
				sf.append("<li>");
				sf.append("<h4 class=\\\""+pt.getIcon()+"\\\"><span></span>"+pt.getName()+"</h4>");
				sf.append("<div class=\\\"list-item none\\\">");
				if(cList != null && cList.size() > 0){
					for(MenuTree ct : cList){
						sf.append("<a href=\\\"#\\\" onclick=\\\"addTab(\'"+ct.getName()+"\',\'"+ct.getUrl()+"?urlName="+pt.getName()+"-"+ct.getName()+"\')\\\">"+ct.getName()+"</a>");
					}
				}
				sf.append("</div>");
				sf.append("</li>");
			} 
		}
		req.setAttribute("menu", "\"" + sf.toString() + "\"");
		req.setAttribute("length", treeList != null ? treeList.size() : 0);
    	return "index";
    }
    
    @RequestMapping("tolist")
    public String tolist(){
    	return "user_list";
    }
    
    @RequestMapping("tolist2")
    public String tolist2(){
    	return "user_list2";
    }
    
    @RequestMapping("list")
    @ResponseBody
    public BaseResult list(BaseRequest request){
    	BaseResult baseResult = null;
    	baseResult = htUserServiceImpl.list(request);
    	return baseResult;
    }
    
    @RequestMapping("addUser")
    @ResponseBody
    public BaseResult addUser(HttpServletRequest req,HtUser htUser,String urids){
    	BaseResult baseResult = null;
    	try {
    		baseResult = htUserServiceImpl.addUser(req,htUser,urids);
		} catch (Exception e) {
			baseResult.setSuccess(false);
			baseResult.setMsg("添加用户异常");
			log.error("添加用户异常:"+e.getMessage(),e);
		}
    	return baseResult;
    }
    @RequestMapping("updateUser")
    @ResponseBody
    public BaseResult updateUser(HttpServletRequest req,Long uuserId,String uphone,String unickName,String uurids){
    	BaseResult baseResult = null;
    	try {
    		baseResult = htUserServiceImpl.updateUser(req,uuserId,uphone,unickName,uurids);
    	} catch (Exception e) {
    		baseResult.setSuccess(false);
    		baseResult.setMsg("修改用户异常");
    		log.error("修改用户异常:"+e.getMessage(),e);
    	}
    	return baseResult;
    }
    
    @RequestMapping("updateState")
    @ResponseBody
    public BaseResult updateState(HttpServletRequest req,Long userId,Short state){
    	BaseResult baseResult = null;
    	try {
    		baseResult = htUserServiceImpl.updateState(req,userId,state);
    	} catch (Exception e) {
    		baseResult.setSuccess(false);
    		baseResult.setMsg("执行操作异常");
    		log.error("修改用户状态异常异常:"+e.getMessage(),e);
    	}
    	return baseResult;
    }
}
