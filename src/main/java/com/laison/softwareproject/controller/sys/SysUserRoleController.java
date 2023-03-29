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
import com.laison.softwareproject.model.sys.SysUserRole;
import com.laison.softwareproject.service.sys.SysUserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:43:59
*/
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {

	@Autowired
	SysUserRoleService sysUserRoleService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysUserRole/findById/1")
	public SysUserRole findById(@PathVariable String id) throws Exception {
		SysUserRole sysUserRole = sysUserRoleService.selectByPrimaryKey(id);
		return sysUserRole;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysUserRole> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysUserRole> list = sysUserRoleService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysUserRole> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysUserRole> pageInfo = sysUserRoleService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysUserRole", notes = "添加sysUserRole")
	@PreAuthorize("hasAuthority('sysUserRole:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysUserRole sysUserRole) throws Exception {
		sysUserRoleService.save(sysUserRole);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysUserRole);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysUserRole", notes = "更新sysUserRole")
	@PreAuthorize("hasAuthority('sysUserRole:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysUserRole sysUserRole) throws Exception {
		sysUserRoleService.updateByPrimaryKey(sysUserRole);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysUserRole);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserRole", notes = "根据主键删除sysUserRole ")
	@PreAuthorize("hasAuthority('sysUserRole:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysUserRole delete = new SysUserRole().setId(id);
		sysUserRoleService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserRole", notes = "根据主键删除sysUserRole ")
	@PreAuthorize("hasAuthority('sysUserRole:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysUserRoleService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysUserRole", notes = "根据主键删除sysUserRole [111,222,333]")
	@PreAuthorize("hasAuthority('sysUserRole:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysUserRoleService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
