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
import com.laison.softwareproject.model.sys.SysTenantPackPerms;
import com.laison.softwareproject.service.sys.SysTenantPackPermsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:42:41
*/
@RestController
@RequestMapping("/sysTenantPackPerms")
public class SysTenantPackPermsController {

	@Autowired
	SysTenantPackPermsService sysTenantPackPermsService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysTenantPackPerms/findById/1")
	public SysTenantPackPerms findById(@PathVariable String id) throws Exception {
		SysTenantPackPerms sysTenantPackPerms = sysTenantPackPermsService.selectByPrimaryKey(id);
		return sysTenantPackPerms;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysTenantPackPerms> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysTenantPackPerms> list = sysTenantPackPermsService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysTenantPackPerms> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysTenantPackPerms> pageInfo = sysTenantPackPermsService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysTenantPackPerms", notes = "添加sysTenantPackPerms")
	@PreAuthorize("hasAuthority('sysTenantPackPerms:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysTenantPackPerms sysTenantPackPerms) throws Exception {
		sysTenantPackPermsService.save(sysTenantPackPerms);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysTenantPackPerms);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysTenantPackPerms", notes = "更新sysTenantPackPerms")
	@PreAuthorize("hasAuthority('sysTenantPackPerms:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysTenantPackPerms sysTenantPackPerms) throws Exception {
		sysTenantPackPermsService.updateByPrimaryKey(sysTenantPackPerms);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysTenantPackPerms);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPackPerms", notes = "根据主键删除sysTenantPackPerms ")
	@PreAuthorize("hasAuthority('sysTenantPackPerms:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysTenantPackPerms delete = new SysTenantPackPerms().setId(id);
		sysTenantPackPermsService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPackPerms", notes = "根据主键删除sysTenantPackPerms ")
	@PreAuthorize("hasAuthority('sysTenantPackPerms:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysTenantPackPermsService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysTenantPackPerms", notes = "根据主键删除sysTenantPackPerms [111,222,333]")
	@PreAuthorize("hasAuthority('sysTenantPackPerms:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysTenantPackPermsService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
