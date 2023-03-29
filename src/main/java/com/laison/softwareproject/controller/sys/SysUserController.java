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
import com.laison.softwareproject.model.sys.SysUser;
import com.laison.softwareproject.service.sys.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:43:20
*/
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	SysUserService sysUserService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysUser/findById/1")
	public SysUser findById(@PathVariable String id) throws Exception {
		SysUser sysUser = sysUserService.selectByPrimaryKey(id);
		return sysUser;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysUser> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysUser> list = sysUserService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysUser> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysUser> pageInfo = sysUserService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysUser", notes = "添加sysUser")
	@PreAuthorize("hasAuthority('sysUser:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysUser sysUser) throws Exception {
		sysUserService.save(sysUser);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysUser);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysUser", notes = "更新sysUser")
	@PreAuthorize("hasAuthority('sysUser:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysUser sysUser) throws Exception {
		sysUserService.updateByPrimaryKey(sysUser);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysUser);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUser", notes = "根据主键删除sysUser ")
	@PreAuthorize("hasAuthority('sysUser:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysUser delete = new SysUser().setId(id);
		sysUserService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUser", notes = "根据主键删除sysUser ")
	@PreAuthorize("hasAuthority('sysUser:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysUserService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysUser", notes = "根据主键删除sysUser [111,222,333]")
	@PreAuthorize("hasAuthority('sysUser:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysUserService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
