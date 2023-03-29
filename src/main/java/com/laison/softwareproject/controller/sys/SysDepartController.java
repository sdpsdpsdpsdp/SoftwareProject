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
import com.laison.softwareproject.model.sys.SysDepart;
import com.laison.softwareproject.service.sys.SysDepartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:38:10
*/
@RestController
@RequestMapping("/sysDepart")
public class SysDepartController {

	@Autowired
	SysDepartService sysDepartService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysDepart/findById/1")
	public SysDepart findById(@PathVariable String id) throws Exception {
		SysDepart sysDepart = sysDepartService.selectByPrimaryKey(id);
		return sysDepart;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysDepart> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysDepart> list = sysDepartService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysDepart> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysDepart> pageInfo = sysDepartService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysDepart", notes = "添加sysDepart")
	@PreAuthorize("hasAuthority('sysDepart:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysDepart sysDepart) throws Exception {
		sysDepartService.save(sysDepart);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysDepart);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysDepart", notes = "更新sysDepart")
	@PreAuthorize("hasAuthority('sysDepart:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysDepart sysDepart) throws Exception {
		sysDepartService.updateByPrimaryKey(sysDepart);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysDepart);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepart", notes = "根据主键删除sysDepart ")
	@PreAuthorize("hasAuthority('sysDepart:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysDepart delete = new SysDepart().setId(id).setDelFlag(true);
		sysDepartService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysDepart", notes = "根据主键删除sysDepart ")
	@PreAuthorize("hasAuthority('sysDepart:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysDepartService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysDepart", notes = "根据主键删除sysDepart [111,222,333]")
	@PreAuthorize("hasAuthority('sysDepart:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysDepartService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
