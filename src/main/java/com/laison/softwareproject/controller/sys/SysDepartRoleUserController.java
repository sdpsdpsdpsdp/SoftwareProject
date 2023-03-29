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
import com.laison.softwareproject.model.sys.SysDepartRoleUser;
import com.laison.softwareproject.service.sys.SysDepartRoleUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:39:40
*/
@RestController
@RequestMapping("/sysDepartRoleUser")
public class SysDepartRoleUserController {

	@Autowired
	SysDepartRoleUserService sysDepartRoleUserService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDepartRoleUser/findById/1")
	public SysDepartRoleUser findById(@PathVariable String id) throws Exception {
		SysDepartRoleUser sysDepartRoleUser = sysDepartRoleUserService.selectByPrimaryKey(id);
		return sysDepartRoleUser;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDepartRoleUser> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDepartRoleUser> list = sysDepartRoleUserService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDepartRoleUser> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDepartRoleUser> pageInfo = sysDepartRoleUserService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDepartRoleUser", notes = "添加sysDepartRoleUser")
	@PreAuthorize("hasAuthority('sysDepartRoleUser:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDepartRoleUser sysDepartRoleUser) throws Exception {
		sysDepartRoleUserService.save(sysDepartRoleUser);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDepartRoleUser);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDepartRoleUser", notes = "更新sysDepartRoleUser")
	@PreAuthorize("hasAuthority('sysDepartRoleUser:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDepartRoleUser sysDepartRoleUser) throws Exception {
		sysDepartRoleUserService.updateByPrimaryKey(sysDepartRoleUser);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDepartRoleUser);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartRoleUser", notes = "根据主键删除sysDepartRoleUser ")
	@PreAuthorize("hasAuthority('sysDepartRoleUser:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDepartRoleUser delete = new SysDepartRoleUser().setId(id);
		sysDepartRoleUserService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepartRoleUser", notes = "根据主键删除sysDepartRoleUser ")
	@PreAuthorize("hasAuthority('sysDepartRoleUser:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDepartRoleUserService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDepartRoleUser", notes = "根据主键删除sysDepartRoleUser [111,222,333]")
	@PreAuthorize("hasAuthority('sysDepartRoleUser:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDepartRoleUserService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
