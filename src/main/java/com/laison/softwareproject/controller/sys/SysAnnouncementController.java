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
import com.laison.softwareproject.model.sys.SysAnnouncement;
import com.laison.softwareproject.service.sys.SysAnnouncementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
/**
* @author lihua 496583747@qq.com
* @date  2023-03-29 14:06:27
*/
@RestController
@RequestMapping("/sysAnnouncement")
public class SysAnnouncementController {

	@Autowired
	SysAnnouncementService sysAnnouncementService;

	@GetMapping("/findById/{id}")
	@ApiOperation(value = "根据id查找", notes = "/sysAnnouncement/findById/1")
	public SysAnnouncement findById(@PathVariable String id) throws Exception {
		SysAnnouncement sysAnnouncement = sysAnnouncementService.selectByPrimaryKey(id);
		return sysAnnouncement;
	}

	@PostMapping("/findAll")
	@ApiOperation(value = "根据条件查找所有", notes = "条件 {'属性':'value'}")
	public List<SysAnnouncement> findAll(@RequestBody HashMap<String, Object> condition) throws Exception {
		List<SysAnnouncement> list = sysAnnouncementService.selectAllByCondition(condition);
		return list;
	}
	
	
	@PostMapping("/findPage/{page}/{size}")
	@ApiOperation(value = "根据条件分页查找", notes = "条件 {'属性':'value'}")
	public PageInfo<SysAnnouncement> findPage(@RequestBody HashMap<String, Object> condition,@PathVariable  int page, @PathVariable  int size) throws Exception {
		PageInfo<SysAnnouncement> pageInfo = sysAnnouncementService.selectPageByCondition(condition, page, size);
		return pageInfo;
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "添加sysAnnouncement", notes = "添加sysAnnouncement")
	@PreAuthorize("hasAuthority('sysAnnouncement:add')")
	public Result add(@RequestBody @Validated(value = { AddGroup.class }) SysAnnouncement sysAnnouncement) throws Exception {
		sysAnnouncementService.save(sysAnnouncement);
		Result ok = Result.ok(ContentConstant.ADD_SUCCESS);
		ok.put("record", sysAnnouncement);
		return ok;
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "更新sysAnnouncement", notes = "更新sysAnnouncement")
	@PreAuthorize("hasAuthority('sysAnnouncement:update')")
	public Result update(@RequestBody @Validated(value = { UpdateGroup.class }) SysAnnouncement sysAnnouncement) throws Exception {
		sysAnnouncementService.updateByPrimaryKey(sysAnnouncement);
		Result ok = Result.ok(ContentConstant.UPDATE_SUCCESS);
		ok.put("record", sysAnnouncement);
		return ok;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@ApiOperation(value = "根据主键删除sysAnnouncement", notes = "根据主键删除sysAnnouncement ")
	@PreAuthorize("hasAuthority('sysAnnouncement:delete')")
	public Result deleteById(@PathVariable String id) throws Exception {
		SysAnnouncement delete = new SysAnnouncement().setId(id);
		sysAnnouncementService.updateByPrimaryKey(delete);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		return ok;
	}
	
	@DeleteMapping("/realDeleteById/{id}")
	@ApiOperation(value = "根据主键删除sysAnnouncement", notes = "根据主键删除sysAnnouncement ")
	@PreAuthorize("hasAuthority('sysAnnouncement:delete')")
	public Result realDeleteById(@PathVariable String id) throws Exception {
		int count = sysAnnouncementService.deleteByPrimaryKey(id);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
	@PostMapping("/deleteByIds")
	@ApiOperation(value = "根据主键删除sysAnnouncement", notes = "根据主键删除sysAnnouncement [111,222,333]")
	@PreAuthorize("hasAuthority('sysAnnouncement:delete')")
	public Result deleteByIds(@RequestBody List<String> ids) throws Exception {
		int count = sysAnnouncementService.deleteByPrimaryKeys(ids);
		Result ok = Result.ok(ContentConstant.DELETE_SUCCESS);
		ok.put("count", count);
		return ok;
	}
	
}
