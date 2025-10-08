package com.lyj.auth.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyj.auth.service.SysUserService;
import com.lyj.common.result.Result;
import com.lyj.model.process.Process;
import com.lyj.model.process.ProcessTemplate;
import com.lyj.model.process.ProcessType;
import com.lyj.process.service.OaProcessService;
import com.lyj.process.service.OaProcessTemplateService;
import com.lyj.process.service.OaProcessTypeService;
import com.lyj.vo.process.ApprovalVo;
import com.lyj.vo.process.ProcessFormVo;
import com.lyj.vo.process.ProcessVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "审批流程管理")
@RestController
@RequestMapping("/admin/process")
@CrossOrigin
public class ProcessController {
    @Autowired
    private OaProcessService processService;
    @Autowired
    private OaProcessTypeService processTypeService;
    @Autowired
    private OaProcessTemplateService processTemplateService;
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "已发起")
    @GetMapping("/findStarted/{page}/{limit}")
    public Result findStarted(@PathVariable Long page, @PathVariable Long limit) {
        Page<ProcessVo> pageParam = new Page<>(page, limit);
        Page<ProcessVo> pageModel = processService.findStarted(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "已处理")
    @GetMapping("/findProcessed/{page}/{limit}")
    public Result findProcessed(@PathVariable Long page, @PathVariable Long limit) {
        Page<Process> pageParam = new Page<>(page, limit);
        Page<ProcessVo> pageModel = processService.findProcessed(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "审批")
    @PostMapping("/approve")
    public Result approve(@RequestBody ApprovalVo approvalVo) {
        processService.approve(approvalVo);
        return Result.ok();
    }

    @GetMapping("/show/{id}")
    public Result show(@PathVariable Long id) {
        Map<String, Object> map = processService.show(id);
        return Result.ok(map);
    }

    @ApiOperation(value = "待处理")
    @GetMapping("/findPending/{page}/{limit}")
    public Result findPending(@PathVariable Long page, @PathVariable Long limit) {
        Page<Process> pageParam = new Page<>(page, limit);
        Page<ProcessVo> pageModel = processService.findPending(pageParam);
        return Result.ok(pageModel);
    }

    @GetMapping("/findProcessType")
    public Result findProcessType() {
        List<ProcessType> list = processTypeService.findProcessType();
        return Result.ok(list);
    }

    @GetMapping("/getProcessTemplate/{processTemplateId}")
    public Result getProcessTemplate(@PathVariable Long processTemplateId) {
        ProcessTemplate processTemplate = processTemplateService.getById(processTemplateId);
        return Result.ok(processTemplate);
    }

    @ApiOperation(value = "启动流程")
    @PostMapping("/startUp")
    public Result startUp(@RequestBody ProcessFormVo processFormVo) {
        processService.startUp(processFormVo);
        return Result.ok();
    }

    @GetMapping("/getCurrentUser")
    public Result getCurrentUser() {
        Map<String, Object> map = sysUserService.getCurrentUser();
        return Result.ok(map);
    }
}
