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
import com.laison.softwareproject.model.sys.SysDict;
import com.laison.softwareproject.service.sys.SysDictService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:40:14
*/
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

	@Autowired
	SysDictService sysDictService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDict/findById/1")
	public SysDict findById(@PathVariable String id) throws Exception {
		SysDict sysDict = sysDictService.selectByPrimaryKey(id);
		return sysDict;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDict> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDict> list = sysDictService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDict> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDict> pageInfo = sysDictService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDict", notes = "添加sysDict")
	@PreAuthorize("hasAuthority('sysDict:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDict sysDict) throws Exception {
		sysDictService.save(sysDict);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDict);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDict", notes = "更新sysDict")
	@PreAuthorize("hasAuthority('sysDict:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDict sysDict) throws Exception {
		sysDictService.updateByPrimaryKey(sysDict);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDict);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDict", notes = "根据主键删除sysDict ")
	@PreAuthorize("hasAuthority('sysDict:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDict delete = new SysDict().setId(id);
		sysDictService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDict", notes = "根据主键删除sysDict ")
	@PreAuthorize("hasAuthority('sysDict:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDictService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDict", notes = "根据主键删除sysDict [111,222,333]")
	@PreAuthorize("hasAuthority('sysDict:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDictService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
