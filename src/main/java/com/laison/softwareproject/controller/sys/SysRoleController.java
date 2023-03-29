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
import com.laison.softwareproject.model.sys.SysRole;
import com.laison.softwareproject.service.sys.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:41:34
*/
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

	@Autowired
	SysRoleService sysRoleService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysRole/findById/1")
	public SysRole findById(@PathVariable String id) throws Exception {
		SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
		return sysRole;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysRole> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysRole> list = sysRoleService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysRole> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysRole> pageInfo = sysRoleService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysRole", notes = "添加sysRole")
	@PreAuthorize("hasAuthority('sysRole:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysRole sysRole) throws Exception {
		sysRoleService.save(sysRole);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysRole);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysRole", notes = "更新sysRole")
	@PreAuthorize("hasAuthority('sysRole:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysRole sysRole) throws Exception {
		sysRoleService.updateByPrimaryKey(sysRole);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysRole);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysRole", notes = "根据主键删除sysRole ")
	@PreAuthorize("hasAuthority('sysRole:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysRole delete = new SysRole().setId(id);
		sysRoleService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysRole", notes = "根据主键删除sysRole ")
	@PreAuthorize("hasAuthority('sysRole:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysRoleService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysRole", notes = "根据主键删除sysRole [111,222,333]")
	@PreAuthorize("hasAuthority('sysRole:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysRoleService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
