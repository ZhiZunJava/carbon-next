package com.neu.carbon.mes.mapper;

import java.util.List;
import com.neu.carbon.mes.domain.MesEquipment;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备信息Mapper接口
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
@Mapper
public interface MesEquipmentMapper
{
    /**
     * 查询设备信息
     *
     * @param id 设备信息主键
     * @return 设备信息
     */
    public MesEquipment selectMesEquipmentById(Long id);

    /**
     * 查询设备信息列表
     *
     * @param mesEquipment 设备信息
     * @return 设备信息集合
     */
    public List<MesEquipment> selectMesEquipmentList(MesEquipment mesEquipment);

    /**
     * 新增设备信息
     *
     * @param mesEquipment 设备信息
     * @return 结果
     */
    public int insertMesEquipment(MesEquipment mesEquipment);

    /**
     * 修改设备信息
     *
     * @param mesEquipment 设备信息
     * @return 结果
     */
    public int updateMesEquipment(MesEquipment mesEquipment);

    /**
     * 删除设备信息
     *
     * @param id 设备信息主键
     * @return 结果
     */
    public int deleteMesEquipmentById(Long id);

    /**
     * 批量删除设备信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesEquipmentByIds(Long[] ids);
}
