package com.neu.generator.service;

import java.util.List;

import com.neu.common.core.domain.entity.SysDictData;
import com.neu.generator.domain.SysComQuery;

/**
 * 通用查询Service接口
 * 
 * @author carbon_anning
 * @date 2025-04-19
 */
public interface ISysComQueryService 
{
    /**
     * 查询通用查询
     * 
     * @param id 通用查询主键
     * @return 通用查询
     */
    public SysComQuery selectSysComQueryById(Long id);

    /**
     * 查询通用查询列表
     * 
     * @param sysComQuery 通用查询
     * @return 通用查询集合
     */
    public List<SysComQuery> selectSysComQueryList(SysComQuery sysComQuery);

    /**
     * 新增通用查询
     * 
     * @param sysComQuery 通用查询
     * @return 结果
     */
    public int insertSysComQuery(SysComQuery sysComQuery);

    /**
     * 修改通用查询
     * 
     * @param sysComQuery 通用查询
     * @return 结果
     */
    public int updateSysComQuery(SysComQuery sysComQuery);

    /**
     * 批量删除通用查询
     * 
     * @param ids 需要删除的通用查询主键集合
     * @return 结果
     */
    public int deleteSysComQueryByIds(Long[] ids);

    /**
     * 删除通用查询信息
     * 
     * @param id 通用查询主键
     * @return 结果
     */
    public int deleteSysComQueryById(Long id);

    public List<SysDictData> selectQueryData(SysComQuery sysComQuery);
}
