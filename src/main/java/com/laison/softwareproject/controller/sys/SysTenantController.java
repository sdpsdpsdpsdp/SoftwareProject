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
import com.laison.softwareproject.model.sys.SysTenant;
import com.laison.softwareproject.service.sys.SysTenantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:42:15
*/
@RestController
@RequestMapping("/sysTenant")
public class SysTenantController {

	@Autowired
	SysTenantService sysTenantService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysTenant/findById/1")
	public SysTenant findById(@PathVariable Integer id) throws Exception {
		SysTenant sysTenant = sysTenantService.selectByPrimaryKey(id);
		return sysTenant;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysTenant> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysTenant> list = sysTenantService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysTenant> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysTenant> pageInfo = sysTenantService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysTenant", notes = "添加sysTenant")
	@PreAuthorize("hasAuthority('sysTenant:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysTenant sysTenant) throws Exception {
		sysTenantService.save(sysTenant);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysTenant);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysTenant", notes = "更新sysTenant")
	@PreAuthorize("hasAuthority('sysTenant:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysTenant sysTenant) throws Exception {
		sysTenantService.updateByPrimaryKey(sysTenant);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysTenant);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenant", notes = "根据主键删除sysTenant ")
	@PreAuthorize("hasAuthority('sysTenant:delete')")
	public Result deleteById(@PathVariable Integer id) throws Exception {
		SysTenant delete = new SysTenant().setId(id);
		sysTenantService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenant", notes = "根据主键删除sysTenant ")
	@PreAuthorize("hasAuthority('sysTenant:delete')")
	public Result realDeleteById(@PathVariable Integer id) throws Exception {
		int count = sysTenantService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysTenant", notes = "根据主键删除sysTenant [111,222,333]")
	@PreAuthorize("hasAuthority('sysTenant:delete')")
	public Result deleteByIds(@RequestBody List<Integer> ids) throws Exception {
		int count = sysTenantService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
