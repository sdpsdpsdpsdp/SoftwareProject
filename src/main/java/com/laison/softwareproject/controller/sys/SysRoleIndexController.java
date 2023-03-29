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
import com.laison.softwareproject.model.sys.SysRoleIndex;
import com.laison.softwareproject.service.sys.SysRoleIndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:41:48
*/
@RestController
@RequestMapping("/sysRoleIndex")
public class SysRoleIndexController {

	@Autowired
	SysRoleIndexService sysRoleIndexService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysRoleIndex/findById/1")
	public SysRoleIndex findById(@PathVariable String id) throws Exception {
		SysRoleIndex sysRoleIndex = sysRoleIndexService.selectByPrimaryKey(id);
		return sysRoleIndex;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysRoleIndex> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysRoleIndex> list = sysRoleIndexService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysRoleIndex> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysRoleIndex> pageInfo = sysRoleIndexService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysRoleIndex", notes = "添加sysRoleIndex")
	@PreAuthorize("hasAuthority('sysRoleIndex:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysRoleIndex sysRoleIndex) throws Exception {
		sysRoleIndexService.save(sysRoleIndex);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysRoleIndex);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysRoleIndex", notes = "更新sysRoleIndex")
	@PreAuthorize("hasAuthority('sysRoleIndex:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysRoleIndex sysRoleIndex) throws Exception {
		sysRoleIndexService.updateByPrimaryKey(sysRoleIndex);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysRoleIndex);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysRoleIndex", notes = "根据主键删除sysRoleIndex ")
	@PreAuthorize("hasAuthority('sysRoleIndex:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysRoleIndex delete = new SysRoleIndex().setId(id);
		sysRoleIndexService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysRoleIndex", notes = "根据主键删除sysRoleIndex ")
	@PreAuthorize("hasAuthority('sysRoleIndex:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysRoleIndexService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysRoleIndex", notes = "根据主键删除sysRoleIndex [111,222,333]")
	@PreAuthorize("hasAuthority('sysRoleIndex:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysRoleIndexService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
