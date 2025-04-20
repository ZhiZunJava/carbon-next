package com.neu.carbon.footprint.mapper;

import java.util.List;
import com.neu.carbon.footprint.domain.CfElectricCheckpoint;
import org.apache.ibatis.annotations.Mapper;

/**
 * 能效预警Mapper接口
 *
 * @author carbon_anning
 * @date 2025-04-20
 */
@Mapper
public interface CfElectricCheckpointMapper
{
    /**
     * 查询能效预警
     *
     * @param id 能效预警主键
     * @return 能效预警
     */
    public CfElectricCheckpoint selectCfElectricCheckpointById(Long id);

    /**
     * 查询能效预警列表
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 能效预警集合
     */
    public List<CfElectricCheckpoint> selectCfElectricCheckpointList(CfElectricCheckpoint cfElectricCheckpoint);

    /**
     * 新增能效预警
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 结果
     */
    public int insertCfElectricCheckpoint(CfElectricCheckpoint cfElectricCheckpoint);

    /**
     * 修改能效预警
     *
     * @param cfElectricCheckpoint 能效预警
     * @return 结果
     */
    public int updateCfElectricCheckpoint(CfElectricCheckpoint cfElectricCheckpoint);

    /**
     * 删除能效预警
     *
     * @param id 能效预警主键
     * @return 结果
     */
    public int deleteCfElectricCheckpointById(Long id);

    /**
     * 批量删除能效预警
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCfElectricCheckpointByIds(Long[] ids);
}
