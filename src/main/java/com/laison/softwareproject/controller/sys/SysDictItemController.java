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
import com.laison.softwareproject.model.sys.SysDictItem;
import com.laison.softwareproject.service.sys.SysDictItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:40:28
*/
@RestController
@RequestMapping("/sysDictItem")
public class SysDictItemController {

	@Autowired
	SysDictItemService sysDictItemService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDictItem/findById/1")
	public SysDictItem findById(@PathVariable String id) throws Exception {
		SysDictItem sysDictItem = sysDictItemService.selectByPrimaryKey(id);
		return sysDictItem;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDictItem> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDictItem> list = sysDictItemService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDictItem> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDictItem> pageInfo = sysDictItemService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDictItem", notes = "添加sysDictItem")
	@PreAuthorize("hasAuthority('sysDictItem:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDictItem sysDictItem) throws Exception {
		sysDictItemService.save(sysDictItem);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDictItem);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDictItem", notes = "更新sysDictItem")
	@PreAuthorize("hasAuthority('sysDictItem:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDictItem sysDictItem) throws Exception {
		sysDictItemService.updateByPrimaryKey(sysDictItem);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDictItem);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDictItem", notes = "根据主键删除sysDictItem ")
	@PreAuthorize("hasAuthority('sysDictItem:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDictItem delete = new SysDictItem().setId(id);
		sysDictItemService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDictItem", notes = "根据主键删除sysDictItem ")
	@PreAuthorize("hasAuthority('sysDictItem:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDictItemService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDictItem", notes = "根据主键删除sysDictItem [111,222,333]")
	@PreAuthorize("hasAuthority('sysDictItem:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDictItemService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
