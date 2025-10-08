package com.lyj.process.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyj.model.process.ProcessTemplate;

/**
 * <p>
 * 审批模板 服务类
 * </p>
 *
 * @author lyj
 * @since 2025-09-26
 */
public interface OaProcessTemplateService extends IService<ProcessTemplate> {

    Page<ProcessTemplate> selectPageProcessTemplate(Page<ProcessTemplate> pageParam);

    void publish(Long id);
}
