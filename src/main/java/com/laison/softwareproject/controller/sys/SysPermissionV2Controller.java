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
import com.laison.softwareproject.model.sys.SysPermissionV2;
import com.laison.softwareproject.service.sys.SysPermissionV2Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:41:05
*/
@RestController
@RequestMapping("/sysPermissionV2")
public class SysPermissionV2Controller {

	@Autowired
	SysPermissionV2Service sysPermissionV2Service;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysPermissionV2/findById/1")
	public SysPermissionV2 findById(@PathVariable String id) throws Exception {
		SysPermissionV2 sysPermissionV2 = sysPermissionV2Service.selectByPrimaryKey(id);
		return sysPermissionV2;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysPermissionV2> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysPermissionV2> list = sysPermissionV2Service.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysPermissionV2> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysPermissionV2> pageInfo = sysPermissionV2Service.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysPermissionV2", notes = "添加sysPermissionV2")
	@PreAuthorize("hasAuthority('sysPermissionV2:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysPermissionV2 sysPermissionV2) throws Exception {
		sysPermissionV2Service.save(sysPermissionV2);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysPermissionV2);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysPermissionV2", notes = "更新sysPermissionV2")
	@PreAuthorize("hasAuthority('sysPermissionV2:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysPermissionV2 sysPermissionV2) throws Exception {
		sysPermissionV2Service.updateByPrimaryKey(sysPermissionV2);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysPermissionV2);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysPermissionV2", notes = "根据主键删除sysPermissionV2 ")
	@PreAuthorize("hasAuthority('sysPermissionV2:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysPermissionV2 delete = new SysPermissionV2().setId(id);
		sysPermissionV2Service.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysPermissionV2", notes = "根据主键删除sysPermissionV2 ")
	@PreAuthorize("hasAuthority('sysPermissionV2:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysPermissionV2Service.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysPermissionV2", notes = "根据主键删除sysPermissionV2 [111,222,333]")
	@PreAuthorize("hasAuthority('sysPermissionV2:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysPermissionV2Service.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
