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
import com.laison.softwareproject.model.sys.SysDataLog;
import com.laison.softwareproject.service.sys.SysDataLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-29 14:09:20
*/
@RestController
@RequestMapping("/sysDataLog")
public class SysDataLogController {

	@Autowired
	SysDataLogService sysDataLogService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDataLog/findById/1")
	public SysDataLog findById(@PathVariable String id) throws Exception {
		SysDataLog sysDataLog = sysDataLogService.selectByPrimaryKey(id);
		return sysDataLog;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDataLog> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDataLog> list = sysDataLogService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDataLog> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDataLog> pageInfo = sysDataLogService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDataLog", notes = "添加sysDataLog")
	@PreAuthorize("hasAuthority('sysDataLog:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDataLog sysDataLog) throws Exception {
		sysDataLogService.save(sysDataLog);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDataLog);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDataLog", notes = "更新sysDataLog")
	@PreAuthorize("hasAuthority('sysDataLog:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDataLog sysDataLog) throws Exception {
		sysDataLogService.updateByPrimaryKey(sysDataLog);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDataLog);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDataLog", notes = "根据主键删除sysDataLog ")
	@PreAuthorize("hasAuthority('sysDataLog:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDataLog delete = new SysDataLog().setId(id);
		sysDataLogService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDataLog", notes = "根据主键删除sysDataLog ")
	@PreAuthorize("hasAuthority('sysDataLog:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDataLogService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDataLog", notes = "根据主键删除sysDataLog [111,222,333]")
	@PreAuthorize("hasAuthority('sysDataLog:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDataLogService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
