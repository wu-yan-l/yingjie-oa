package com.lyj.process.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyj.model.process.ProcessTemplate;
import com.lyj.model.process.ProcessType;
import com.lyj.process.mapper.OaProcessTypeMapper;
import com.lyj.process.service.OaProcessTemplateService;
import com.lyj.process.service.OaProcessTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 审批类型 服务实现类
 * </p>
 *
 * @author lyj
 * @since 2025-09-26
 */
@Service
public class OaProcessTypeServiceImpl extends ServiceImpl<OaProcessTypeMapper, ProcessType> implements OaProcessTypeService {
    @Autowired
    private OaProcessTemplateService processTemplateService;
    @Override
    public List<ProcessType> findProcessType() {
        List<ProcessType> processTypeList = baseMapper.selectList(null);
        for (ProcessType processType : processTypeList) {
            Long id = processType.getId();
            LambdaQueryWrapper<ProcessTemplate> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ProcessTemplate::getProcessTypeId, id);
            List<ProcessTemplate> processTemplateList = processTemplateService.list(wrapper);
            processType.setProcessTemplateList(processTemplateList);
        }
        return processTypeList;
    }
}
