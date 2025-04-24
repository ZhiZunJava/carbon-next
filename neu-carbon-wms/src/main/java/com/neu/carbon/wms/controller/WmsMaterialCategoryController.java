package com.neu.carbon.wms.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neu.common.annotation.Log;
import com.neu.common.core.controller.BaseController;
import com.neu.common.core.domain.AjaxResult;
import com.neu.common.enums.BusinessType;
import com.neu.carbon.wms.domain.WmsMaterialCategory;
import com.neu.carbon.wms.service.IWmsMaterialCategoryService;
import com.neu.common.utils.poi.ExcelUtil;

/**
 * 物料分类Controller
 *
 * @author carbon_anning
 * @date 2025-04-24
 */
@RestController
@RequestMapping("/material/materialCategory")
public class WmsMaterialCategoryController extends BaseController
{
    @Autowired
    private IWmsMaterialCategoryService wmsMaterialCategoryService;

    /**
     * 查询物料分类列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:list')")
    @GetMapping("/list")
    public AjaxResult list(WmsMaterialCategory wmsMaterialCategory)
    {
        List<WmsMaterialCategory> list = wmsMaterialCategoryService.selectWmsMaterialCategoryList(wmsMaterialCategory);
        return success(list);
    }

    /**
     * 导出物料分类列表
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:export')")
    @Log(title = "物料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsMaterialCategory wmsMaterialCategory)
    {
        List<WmsMaterialCategory> list = wmsMaterialCategoryService.selectWmsMaterialCategoryList(wmsMaterialCategory);
        ExcelUtil<WmsMaterialCategory> util = new ExcelUtil<WmsMaterialCategory>(WmsMaterialCategory.class);
        util.exportExcel(response, list, "物料分类数据");
    }

    /**
     * 获取物料分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wmsMaterialCategoryService.selectWmsMaterialCategoryById(id));
    }

    /**
     * 新增物料分类
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:add')")
    @Log(title = "物料分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsMaterialCategory wmsMaterialCategory)
    {
        return toAjax(wmsMaterialCategoryService.insertWmsMaterialCategory(wmsMaterialCategory));
    }

    /**
     * 修改物料分类
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:edit')")
    @Log(title = "物料分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsMaterialCategory wmsMaterialCategory)
    {
        return toAjax(wmsMaterialCategoryService.updateWmsMaterialCategory(wmsMaterialCategory));
    }

    /**
     * 删除物料分类
     */
    @PreAuthorize("@ss.hasPermi('material:materialCategory:remove')")
    @Log(title = "物料分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsMaterialCategoryService.deleteWmsMaterialCategoryByIds(ids));
    }
}
