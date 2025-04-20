package com.neu.carbon.footprint.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.footprint.mapper.CfElectricCheckpointMapper;
import com.neu.carbon.footprint.domain.CfElectricCheckpoint;
import com.neu.carbon.footprint.service.ICfElectricCheckpointService;

/**
 * 能效预警Service业务层处理
 *
 * @author carbon_anning
 * @date 2025-04-20
 */
@Service
public class CfElectricCheckpointServiceImpl implements ICfElectricCheckpointService
{
    @Autowired
    private CfElectricCheckpointMapper cfElectricCheckpointMapper;

    /**
     * 查询能效预警
     *
     * @param id 能效预警主键
     * @return 能效预警
     */
    @Override
    public CfElectricCheckpoint selectCfElectricCheckpointById(Long id)
    {
        return cfElectricCheckpointMapper.selectCfElectricCheckpointById(id);
    }

    /**
     * 查询能效预警列表
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 能效预警
     */
    @Override
    public List<CfElectricCheckpoint> selectCfElectricCheckpointList(CfElectricCheckpoint cfElectricCheckpoint)
    {
        return cfElectricCheckpointMapper.selectCfElectricCheckpointList(cfElectricCheckpoint);
    }

    /**
     * 新增能效预警
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 结果
     */
    @Override
    public int insertCfElectricCheckpoint(CfElectricCheckpoint cfElectricCheckpoint)
    {
        cfElectricCheckpoint.setCreateTime(DateUtils.getNowDate());
        return cfElectricCheckpointMapper.insertCfElectricCheckpoint(cfElectricCheckpoint);
    }

    /**
     * 修改能效预警
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 结果
     */
    @Override
    public int updateCfElectricCheckpoint(CfElectricCheckpoint cfElectricCheckpoint)
    {
        return cfElectricCheckpointMapper.updateCfElectricCheckpoint(cfElectricCheckpoint);
    }

    /**
     * 批量删除能效预警
     *
     * @param ids 需要删除的能效预警主键
     * @return 结果
     */
    @Override
    public int deleteCfElectricCheckpointByIds(Long[] ids)
    {
        return cfElectricCheckpointMapper.deleteCfElectricCheckpointByIds(ids);
    }

    /**
     * 删除能效预警信息
     *
     * @param id 能效预警主键
     * @return 结果
     */
    @Override
    public int deleteCfElectricCheckpointById(Long id)
    {
        return cfElectricCheckpointMapper.deleteCfElectricCheckpointById(id);
    }
}
