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
import com.laison.softwareproject.model.sys.SysUserTenant;
import com.laison.softwareproject.service.sys.SysUserTenantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:44:11
*/
@RestController
@RequestMapping("/sysUserTenant")
public class SysUserTenantController {

	@Autowired
	SysUserTenantService sysUserTenantService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysUserTenant/findById/1")
	public SysUserTenant findById(@PathVariable String id) throws Exception {
		SysUserTenant sysUserTenant = sysUserTenantService.selectByPrimaryKey(id);
		return sysUserTenant;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysUserTenant> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysUserTenant> list = sysUserTenantService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysUserTenant> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysUserTenant> pageInfo = sysUserTenantService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysUserTenant", notes = "添加sysUserTenant")
	@PreAuthorize("hasAuthority('sysUserTenant:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysUserTenant sysUserTenant) throws Exception {
		sysUserTenantService.save(sysUserTenant);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysUserTenant);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysUserTenant", notes = "更新sysUserTenant")
	@PreAuthorize("hasAuthority('sysUserTenant:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysUserTenant sysUserTenant) throws Exception {
		sysUserTenantService.updateByPrimaryKey(sysUserTenant);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysUserTenant);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserTenant", notes = "根据主键删除sysUserTenant ")
	@PreAuthorize("hasAuthority('sysUserTenant:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysUserTenant delete = new SysUserTenant().setId(id);
		sysUserTenantService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserTenant", notes = "根据主键删除sysUserTenant ")
	@PreAuthorize("hasAuthority('sysUserTenant:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysUserTenantService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysUserTenant", notes = "根据主键删除sysUserTenant [111,222,333]")
	@PreAuthorize("hasAuthority('sysUserTenant:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysUserTenantService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
