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
import com.laison.softwareproject.model.sys.SysDepartPermission;
import com.laison.softwareproject.service.sys.SysDepartPermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:38:23
*/
@RestController
@RequestMapping("/sysDepartPermission")
public class SysDepartPermissionController {

	@Autowired
	SysDepartPermissionService sysDepartPermissionService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDepartPermission/findById/1")
	public SysDepartPermission findById(@PathVariable String id) throws Exception {
		SysDepartPermission sysDepartPermission = sysDepartPermissionService.selectByPrimaryKey(id);
		return sysDepartPermission;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDepartPermission> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDepartPermission> list = sysDepartPermissionService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDepartPermission> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDepartPermission> pageInfo = sysDepartPermissionService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDepartPermission", notes = "添加sysDepartPermission")
	@PreAuthorize("hasAuthority('sysDepartPermission:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDepartPermission sysDepartPermission) throws Exception {
		sysDepartPermissionService.save(sysDepartPermission);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDepartPermission);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDepartPermission", notes = "更新sysDepartPermission")
	@PreAuthorize("hasAuthority('sysDepartPermission:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDepartPermission sysDepartPermission) throws Exception {
		sysDepartPermissionService.updateByPrimaryKey(sysDepartPermission);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDepartPermission);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartPermission", notes = "根据主键删除sysDepartPermission ")
	@PreAuthorize("hasAuthority('sysDepartPermission:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDepartPermission delete = new SysDepartPermission().setId(id);
		sysDepartPermissionService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartPermission", notes = "根据主键删除sysDepartPermission ")
	@PreAuthorize("hasAuthority('sysDepartPermission:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDepartPermissionService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDepartPermission", notes = "根据主键删除sysDepartPermission [111,222,333]")
	@PreAuthorize("hasAuthority('sysDepartPermission:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDepartPermissionService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
