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
import com.laison.softwareproject.model.sys.SysDepartRolePermission;
import com.laison.softwareproject.service.sys.SysDepartRolePermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:39:18
*/
@RestController
@RequestMapping("/sysDepartRolePermission")
public class SysDepartRolePermissionController {

	@Autowired
	SysDepartRolePermissionService sysDepartRolePermissionService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDepartRolePermission/findById/1")
	public SysDepartRolePermission findById(@PathVariable String id) throws Exception {
		SysDepartRolePermission sysDepartRolePermission = sysDepartRolePermissionService.selectByPrimaryKey(id);
		return sysDepartRolePermission;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDepartRolePermission> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDepartRolePermission> list = sysDepartRolePermissionService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDepartRolePermission> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDepartRolePermission> pageInfo = sysDepartRolePermissionService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDepartRolePermission", notes = "添加sysDepartRolePermission")
	@PreAuthorize("hasAuthority('sysDepartRolePermission:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDepartRolePermission sysDepartRolePermission) throws Exception {
		sysDepartRolePermissionService.save(sysDepartRolePermission);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDepartRolePermission);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDepartRolePermission", notes = "更新sysDepartRolePermission")
	@PreAuthorize("hasAuthority('sysDepartRolePermission:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDepartRolePermission sysDepartRolePermission) throws Exception {
		sysDepartRolePermissionService.updateByPrimaryKey(sysDepartRolePermission);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDepartRolePermission);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartRolePermission", notes = "根据主键删除sysDepartRolePermission ")
	@PreAuthorize("hasAuthority('sysDepartRolePermission:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDepartRolePermission delete = new SysDepartRolePermission().setId(id);
		sysDepartRolePermissionService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartRolePermission", notes = "根据主键删除sysDepartRolePermission ")
	@PreAuthorize("hasAuthority('sysDepartRolePermission:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDepartRolePermissionService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDepartRolePermission", notes = "根据主键删除sysDepartRolePermission [111,222,333]")
	@PreAuthorize("hasAuthority('sysDepartRolePermission:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDepartRolePermissionService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
