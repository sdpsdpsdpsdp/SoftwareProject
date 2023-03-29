package com.laison.softwareproject.controller.sys;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.laison.softwareproject.common.constants.ContentConstant;
import com.laison.softwareproject.common.validatgroup.AddGroup;
import com.laison.softwareproject.common.validatgroup.UpdateGroup;
import com.laison.softwareproject.model.common.Result;
import com.laison.softwareproject.common.utils.MyIDGenId;
import com.laison.softwareproject.model.sys.SysUserAgent;
import com.laison.softwareproject.service.sys.SysUserAgentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:43:33
*/
@RestController
@RequestMapping("/sysUserAgent")
public class SysUserAgentController {

	@Autowired
	SysUserAgentService sysUserAgentService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysUserAgent/findById/1")
	public SysUserAgent findById(@PathVariable String id) throws Exception {
		SysUserAgent sysUserAgent = sysUserAgentService.selectByPrimaryKey(id);
		return sysUserAgent;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysUserAgent> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysUserAgent> list = sysUserAgentService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysUserAgent> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysUserAgent> pageInfo = sysUserAgentService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysUserAgent", notes = "添加sysUserAgent")
	@PreAuthorize("hasAuthority('sysUserAgent:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysUserAgent sysUserAgent) throws Exception {
		sysUserAgentService.save(sysUserAgent);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysUserAgent);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysUserAgent", notes = "更新sysUserAgent")
	@PreAuthorize("hasAuthority('sysUserAgent:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysUserAgent sysUserAgent) throws Exception {
		sysUserAgentService.updateByPrimaryKey(sysUserAgent);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysUserAgent);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserAgent", notes = "根据主键删除sysUserAgent ")
	@PreAuthorize("hasAuthority('sysUserAgent:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysUserAgent delete = new SysUserAgent().setId(id);
		sysUserAgentService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserAgent", notes = "根据主键删除sysUserAgent ")
	@PreAuthorize("hasAuthority('sysUserAgent:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysUserAgentService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysUserAgent", notes = "根据主键删除sysUserAgent [111,222,333]")
	@PreAuthorize("hasAuthority('sysUserAgent:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysUserAgentService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
