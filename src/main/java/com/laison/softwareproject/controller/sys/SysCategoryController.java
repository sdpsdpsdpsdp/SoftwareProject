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
import com.laison.softwareproject.model.sys.SysCategory;
import com.laison.softwareproject.service.sys.SysCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:23:23
*/
@RestController
@RequestMapping("/sysCategory")
public class SysCategoryController {

	@Autowired
	SysCategoryService sysCategoryService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysCategory/findById/1")
	public SysCategory findById(@PathVariable String id) throws Exception {
		SysCategory sysCategory = sysCategoryService.selectByPrimaryKey(id);
		return sysCategory;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysCategory> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysCategory> list = sysCategoryService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysCategory> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysCategory> pageInfo = sysCategoryService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysCategory", notes = "添加sysCategory")
	@PreAuthorize("hasAuthority('sysCategory:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysCategory sysCategory) throws Exception {
		sysCategoryService.save(sysCategory);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysCategory);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysCategory", notes = "更新sysCategory")
	@PreAuthorize("hasAuthority('sysCategory:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysCategory sysCategory) throws Exception {
		sysCategoryService.updateByPrimaryKey(sysCategory);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysCategory);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysCategory", notes = "根据主键删除sysCategory ")
	@PreAuthorize("hasAuthority('sysCategory:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysCategory delete = new SysCategory().setId(id);
		sysCategoryService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysCategory", notes = "根据主键删除sysCategory ")
	@PreAuthorize("hasAuthority('sysCategory:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysCategoryService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysCategory", notes = "根据主键删除sysCategory [111,222,333]")
	@PreAuthorize("hasAuthority('sysCategory:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysCategoryService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/getChildListBatch")
	@ApiOperation(value = "批量获取child", notes = "查找所有pid的child")
	public Result getChildListBatch(@RequestBody List<String> pids) throws Exception {
		HashMap<String, Object> condition=new HashMap<>();
		condition.put("pids", pids);
		List<SysCategory> list = sysCategoryService.selectAllByCondition(condition);
		Result ok = Result.ok(ContentConstant.QUERY_SUCCESS);
		ok.put("list", list);
		return ok;
	}
}
