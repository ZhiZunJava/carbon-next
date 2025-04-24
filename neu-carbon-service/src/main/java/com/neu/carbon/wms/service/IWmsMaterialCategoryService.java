package com.neu.carbon.wms.service;

import java.util.List;
import com.neu.carbon.wms.domain.WmsMaterialCategory;

/**
 * 物料分类Service接口
 *
 * @author carbon_anning
 * @date 2025-04-24
 */
public interface IWmsMaterialCategoryService
{
    /**
     * 查询物料分类
     *
     * @param id 物料分类主键
     * @return 物料分类
     */
    public WmsMaterialCategory selectWmsMaterialCategoryById(Long id);

    /**
     * 查询物料分类列表
     *
     * @param wmsMaterialCategory 物料分类
     * @return 物料分类集合
     */
    public List<WmsMaterialCategory> selectWmsMaterialCategoryList(WmsMaterialCategory wmsMaterialCategory);

    /**
     * 新增物料分类
     *
     * @param wmsMaterialCategory 物料分类
     * @return 结果
     */
    public int insertWmsMaterialCategory(WmsMaterialCategory wmsMaterialCategory);

    /**
     * 修改物料分类
     *
     * @param wmsMaterialCategory 物料分类
     * @return 结果
     */
    public int updateWmsMaterialCategory(WmsMaterialCategory wmsMaterialCategory);

    /**
     * 批量删除物料分类
     *
     * @param ids 需要删除的物料分类主键集合
     * @return 结果
     */
    public int deleteWmsMaterialCategoryByIds(Long[] ids);

    /**
     * 删除物料分类信息
     *
     * @param id 物料分类主键
     * @return 结果
     */
    public int deleteWmsMaterialCategoryById(Long id);
}
