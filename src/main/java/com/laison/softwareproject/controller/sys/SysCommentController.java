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
import com.laison.softwareproject.model.sys.SysComment;
import com.laison.softwareproject.service.sys.SysCommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-29 14:09:01
*/
@RestController
@RequestMapping("/sysComment")
public class SysCommentController {

	@Autowired
	SysCommentService sysCommentService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysComment/findById/1")
	public SysComment findById(@PathVariable String id) throws Exception {
		SysComment sysComment = sysCommentService.selectByPrimaryKey(id);
		return sysComment;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysComment> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysComment> list = sysCommentService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysComment> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysComment> pageInfo = sysCommentService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysComment", notes = "添加sysComment")
	@PreAuthorize("hasAuthority('sysComment:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysComment sysComment) throws Exception {
		sysCommentService.save(sysComment);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysComment);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysComment", notes = "更新sysComment")
	@PreAuthorize("hasAuthority('sysComment:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysComment sysComment) throws Exception {
		sysCommentService.updateByPrimaryKey(sysComment);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysComment);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysComment", notes = "根据主键删除sysComment ")
	@PreAuthorize("hasAuthority('sysComment:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysComment delete = new SysComment().setId(id);
		sysCommentService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysComment", notes = "根据主键删除sysComment ")
	@PreAuthorize("hasAuthority('sysComment:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysCommentService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysComment", notes = "根据主键删除sysComment [111,222,333]")
	@PreAuthorize("hasAuthority('sysComment:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysCommentService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
