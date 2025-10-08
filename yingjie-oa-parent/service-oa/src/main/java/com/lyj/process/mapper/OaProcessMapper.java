package com.lyj.process.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyj.model.process.Process;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyj.vo.process.ProcessQueryVo;
import com.lyj.vo.process.ProcessVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 审批类型 Mapper 接口
 * </p>
 *
 * @author lyj
 * @since 2025-09-27
 */
public interface OaProcessMapper extends BaseMapper<Process> {
    Page<ProcessVo> selectPage(Page<ProcessVo> pageParam, @Param("vo") ProcessQueryVo processQueryVo);
}
