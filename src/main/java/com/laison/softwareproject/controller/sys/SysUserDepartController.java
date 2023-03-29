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
import com.laison.softwareproject.model.sys.SysUserDepart;
import com.laison.softwareproject.service.sys.SysUserDepartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:43:46
*/
@RestController
@RequestMapping("/sysUserDepart")
public class SysUserDepartController {

	@Autowired
	SysUserDepartService sysUserDepartService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysUserDepart/findById/1")
	public SysUserDepart findById(@PathVariable String id) throws Exception {
		SysUserDepart sysUserDepart = sysUserDepartService.selectByPrimaryKey(id);
		return sysUserDepart;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysUserDepart> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysUserDepart> list = sysUserDepartService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysUserDepart> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysUserDepart> pageInfo = sysUserDepartService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysUserDepart", notes = "添加sysUserDepart")
	@PreAuthorize("hasAuthority('sysUserDepart:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysUserDepart sysUserDepart) throws Exception {
		sysUserDepartService.save(sysUserDepart);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysUserDepart);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysUserDepart", notes = "更新sysUserDepart")
	@PreAuthorize("hasAuthority('sysUserDepart:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysUserDepart sysUserDepart) throws Exception {
		sysUserDepartService.updateByPrimaryKey(sysUserDepart);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysUserDepart);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserDepart", notes = "根据主键删除sysUserDepart ")
	@PreAuthorize("hasAuthority('sysUserDepart:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysUserDepart delete = new SysUserDepart().setId(id);
		sysUserDepartService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysUserDepart", notes = "根据主键删除sysUserDepart ")
	@PreAuthorize("hasAuthority('sysUserDepart:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysUserDepartService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysUserDepart", notes = "根据主键删除sysUserDepart [111,222,333]")
	@PreAuthorize("hasAuthority('sysUserDepart:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysUserDepartService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
