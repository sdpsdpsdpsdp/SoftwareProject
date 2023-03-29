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
import com.laison.softwareproject.model.sys.SysTenantPack;
import com.laison.softwareproject.service.sys.SysTenantPackService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:42:29
*/
@RestController
@RequestMapping("/sysTenantPack")
public class SysTenantPackController {

	@Autowired
	SysTenantPackService sysTenantPackService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysTenantPack/findById/1")
	public SysTenantPack findById(@PathVariable String id) throws Exception {
		SysTenantPack sysTenantPack = sysTenantPackService.selectByPrimaryKey(id);
		return sysTenantPack;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysTenantPack> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysTenantPack> list = sysTenantPackService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysTenantPack> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysTenantPack> pageInfo = sysTenantPackService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysTenantPack", notes = "添加sysTenantPack")
	@PreAuthorize("hasAuthority('sysTenantPack:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysTenantPack sysTenantPack) throws Exception {
		sysTenantPackService.save(sysTenantPack);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysTenantPack);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysTenantPack", notes = "更新sysTenantPack")
	@PreAuthorize("hasAuthority('sysTenantPack:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysTenantPack sysTenantPack) throws Exception {
		sysTenantPackService.updateByPrimaryKey(sysTenantPack);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysTenantPack);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPack", notes = "根据主键删除sysTenantPack ")
	@PreAuthorize("hasAuthority('sysTenantPack:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysTenantPack delete = new SysTenantPack().setId(id);
		sysTenantPackService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysTenantPack", notes = "根据主键删除sysTenantPack ")
	@PreAuthorize("hasAuthority('sysTenantPack:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysTenantPackService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysTenantPack", notes = "根据主键删除sysTenantPack [111,222,333]")
	@PreAuthorize("hasAuthority('sysTenantPack:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysTenantPackService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
