package com.lyj.process.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyj.model.process.Process;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.vo.process.ApprovalVo;
import com.lyj.vo.process.ProcessFormVo;
import com.lyj.vo.process.ProcessQueryVo;
import com.lyj.vo.process.ProcessVo;

import java.util.Map;

/**
 * <p>
 * 审批类型 服务类
 * </p>
 *
 * @author lyj
 * @since 2025-09-27
 */
public interface OaProcessService extends IService<Process> {

    Page<ProcessVo> selectPage(Page<ProcessVo> pageParam, ProcessQueryVo processQueryVo);

    void deployByZip(String deployPath);

    void startUp(ProcessFormVo processFormVo);

    Page<ProcessVo> findPending(Page<Process> pageParam);

    Map<String, Object> show(Long id);

    void approve(ApprovalVo approvalVo);

    Page<ProcessVo> findProcessed(Page<Process> pageParam);

    Page<ProcessVo> findStarted(Page<ProcessVo> pageParam);
}
