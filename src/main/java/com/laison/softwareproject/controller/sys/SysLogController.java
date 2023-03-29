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
import com.laison.softwareproject.model.sys.SysLog;
import com.laison.softwareproject.service.sys.SysLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:40:39
*/
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

	@Autowired
	SysLogService sysLogService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysLog/findById/1")
	public SysLog findById(@PathVariable String id) throws Exception {
		SysLog sysLog = sysLogService.selectByPrimaryKey(id);
		return sysLog;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysLog> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysLog> list = sysLogService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysLog> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysLog> pageInfo = sysLogService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysLog", notes = "添加sysLog")
	@PreAuthorize("hasAuthority('sysLog:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysLog sysLog) throws Exception {
		sysLogService.save(sysLog);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysLog);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysLog", notes = "更新sysLog")
	@PreAuthorize("hasAuthority('sysLog:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysLog sysLog) throws Exception {
		sysLogService.updateByPrimaryKey(sysLog);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysLog);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysLog", notes = "根据主键删除sysLog ")
	@PreAuthorize("hasAuthority('sysLog:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysLog delete = new SysLog().setId(id);
		sysLogService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysLog", notes = "根据主键删除sysLog ")
	@PreAuthorize("hasAuthority('sysLog:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysLogService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysLog", notes = "根据主键删除sysLog [111,222,333]")
	@PreAuthorize("hasAuthority('sysLog:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysLogService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
