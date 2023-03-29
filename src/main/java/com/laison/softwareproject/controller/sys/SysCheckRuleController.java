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
import com.laison.softwareproject.model.sys.SysCheckRule;
import com.laison.softwareproject.service.sys.SysCheckRuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-29 14:08:42
*/
@RestController
@RequestMapping("/sysCheckRule")
public class SysCheckRuleController {

	@Autowired
	SysCheckRuleService sysCheckRuleService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysCheckRule/findById/1")
	public SysCheckRule findById(@PathVariable String id) throws Exception {
		SysCheckRule sysCheckRule = sysCheckRuleService.selectByPrimaryKey(id);
		return sysCheckRule;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysCheckRule> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysCheckRule> list = sysCheckRuleService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysCheckRule> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysCheckRule> pageInfo = sysCheckRuleService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysCheckRule", notes = "添加sysCheckRule")
	@PreAuthorize("hasAuthority('sysCheckRule:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysCheckRule sysCheckRule) throws Exception {
		sysCheckRuleService.save(sysCheckRule);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysCheckRule);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysCheckRule", notes = "更新sysCheckRule")
	@PreAuthorize("hasAuthority('sysCheckRule:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysCheckRule sysCheckRule) throws Exception {
		sysCheckRuleService.updateByPrimaryKey(sysCheckRule);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysCheckRule);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysCheckRule", notes = "根据主键删除sysCheckRule ")
	@PreAuthorize("hasAuthority('sysCheckRule:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysCheckRule delete = new SysCheckRule().setId(id);
		sysCheckRuleService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysCheckRule", notes = "根据主键删除sysCheckRule ")
	@PreAuthorize("hasAuthority('sysCheckRule:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysCheckRuleService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysCheckRule", notes = "根据主键删除sysCheckRule [111,222,333]")
	@PreAuthorize("hasAuthority('sysCheckRule:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysCheckRuleService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
