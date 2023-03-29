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
import com.laison.softwareproject.model.sys.SysTenantPackUser;
import com.laison.softwareproject.service.sys.SysTenantPackUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:42:54
*/
@RestController
@RequestMapping("/sysTenantPackUser")
public class SysTenantPackUserController {

	@Autowired
	SysTenantPackUserService sysTenantPackUserService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysTenantPackUser/findById/1")
	public SysTenantPackUser findById(@PathVariable String id) throws Exception {
		SysTenantPackUser sysTenantPackUser = sysTenantPackUserService.selectByPrimaryKey(id);
		return sysTenantPackUser;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysTenantPackUser> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysTenantPackUser> list = sysTenantPackUserService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysTenantPackUser> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysTenantPackUser> pageInfo = sysTenantPackUserService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysTenantPackUser", notes = "添加sysTenantPackUser")
	@PreAuthorize("hasAuthority('sysTenantPackUser:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysTenantPackUser sysTenantPackUser) throws Exception {
		sysTenantPackUserService.save(sysTenantPackUser);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysTenantPackUser);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysTenantPackUser", notes = "更新sysTenantPackUser")
	@PreAuthorize("hasAuthority('sysTenantPackUser:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysTenantPackUser sysTenantPackUser) throws Exception {
		sysTenantPackUserService.updateByPrimaryKey(sysTenantPackUser);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysTenantPackUser);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPackUser", notes = "根据主键删除sysTenantPackUser ")
	@PreAuthorize("hasAuthority('sysTenantPackUser:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysTenantPackUser delete = new SysTenantPackUser().setId(id);
		sysTenantPackUserService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPackUser", notes = "根据主键删除sysTenantPackUser ")
	@PreAuthorize("hasAuthority('sysTenantPackUser:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysTenantPackUserService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysTenantPackUser", notes = "根据主键删除sysTenantPackUser [111,222,333]")
	@PreAuthorize("hasAuthority('sysTenantPackUser:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysTenantPackUserService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
