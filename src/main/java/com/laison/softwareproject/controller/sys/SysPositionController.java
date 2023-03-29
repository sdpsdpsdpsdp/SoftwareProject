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
import com.laison.softwareproject.model.sys.SysPosition;
import com.laison.softwareproject.service.sys.SysPositionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-27 16:41:21
*/
@RestController
@RequestMapping("/sysPosition")
public class SysPositionController {

	@Autowired
	SysPositionService sysPositionService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysPosition/findById/1")
	public SysPosition findById(@PathVariable String id) throws Exception {
		SysPosition sysPosition = sysPositionService.selectByPrimaryKey(id);
		return sysPosition;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysPosition> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysPosition> list = sysPositionService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysPosition> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysPosition> pageInfo = sysPositionService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysPosition", notes = "添加sysPosition")
	@PreAuthorize("hasAuthority('sysPosition:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysPosition sysPosition) throws Exception {
		sysPositionService.save(sysPosition);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysPosition);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysPosition", notes = "更新sysPosition")
	@PreAuthorize("hasAuthority('sysPosition:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysPosition sysPosition) throws Exception {
		sysPositionService.updateByPrimaryKey(sysPosition);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysPosition);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysPosition", notes = "根据主键删除sysPosition ")
	@PreAuthorize("hasAuthority('sysPosition:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysPosition delete = new SysPosition().setId(id);
		sysPositionService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysPosition", notes = "根据主键删除sysPosition ")
	@PreAuthorize("hasAuthority('sysPosition:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysPositionService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysPosition", notes = "根据主键删除sysPosition [111,222,333]")
	@PreAuthorize("hasAuthority('sysPosition:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysPositionService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
