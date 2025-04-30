package com.neu.carbon.mes.mapper;

import java.util.List;
import com.neu.carbon.mes.domain.MesProcessModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 工艺建模Mapper接口
 *
 * @author carbon_anning
 * @date 2025-04-30
 */
@Mapper
public interface MesProcessModelMapper
{
    /**
     * 查询工艺建模
     *
     * @param id 工艺建模主键
     * @return 工艺建模
     */
    public MesProcessModel selectMesProcessModelById(Long id);

    /**
     * 查询工艺建模列表
     *
     * @param mesProcessModel 工艺建模
     * @return 工艺建模集合
     */
    public List<MesProcessModel> selectMesProcessModelList(MesProcessModel mesProcessModel);

    /**
     * 新增工艺建模
     *
     * @param mesProcessModel 工艺建模
     * @return 结果
     */
    public int insertMesProcessModel(MesProcessModel mesProcessModel);

    /**
     * 修改工艺建模
     *
     * @param mesProcessModel 工艺建模
     * @return 结果
     */
    public int updateMesProcessModel(MesProcessModel mesProcessModel);

    /**
     * 删除工艺建模
     *
     * @param id 工艺建模主键
     * @return 结果
     */
    public int deleteMesProcessModelById(Long id);

    /**
     * 批量删除工艺建模
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMesProcessModelByIds(Long[] ids);
}
