package com.neu.carbon.mes.controller;

import java.util.List;

import com.neu.carbon.wms.domain.WmsMaterialInfo;
import com.neu.carbon.wms.service.IWmsMaterialInfoService;
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
import com.neu.carbon.mes.domain.MesProcessModel;
import com.neu.carbon.mes.service.IMesProcessModelService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 工艺建模Controller
 *
 * @author carbon_anning
 * @date 2025-04-30
 */
@RestController
@RequestMapping("/mesModel/processModel")
public class MesProcessModelController extends BaseController
{
    @Autowired
    private IMesProcessModelService mesProcessModelService;
    @Autowired
    private IWmsMaterialInfoService wmsMaterialInfoService;

    /**
     * 查询工艺建模列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesProcessModel mesProcessModel)
    {
        startPage();
        List<MesProcessModel> list = mesProcessModelService.selectMesProcessModelList(mesProcessModel);
        list.stream().forEach(model -> {
            Long materialId = model.getMaterialId();
            if (materialId!=null) {
                WmsMaterialInfo material = wmsMaterialInfoService.selectWmsMaterialInfoById(materialId);
                model.setMaterialCode(material.getCode());
                model.setMaterialModel(material.getModel());
                model.setMaterialName(material.getName());
                model.setMaterialSpecification(material.getSpecification());
                model.setMaterialUnit(material.getUnit());
            }
        });
        return getDataTable(list);
    }

    /**
     * 导出工艺建模列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:export')")
    @Log(title = "工艺建模", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProcessModel mesProcessModel)
    {
        List<MesProcessModel> list = mesProcessModelService.selectMesProcessModelList(mesProcessModel);
        list.stream().forEach(model->{
            WmsMaterialInfo material = wmsMaterialInfoService.selectWmsMaterialInfoById(model.getMaterialId());
            if(material!=null) {
                model.setMaterialCode(material.getCode());
                model.setMaterialModel(material.getModel());
                model.setMaterialName(material.getName());
                model.setMaterialSpecification(material.getSpecification());
                model.setMaterialUnit(material.getUnit());
            }
        });
        ExcelUtil<MesProcessModel> util = new ExcelUtil<MesProcessModel>(MesProcessModel.class);
        util.exportExcel(response, list, "工艺建模数据");
    }

    /**
     * 获取工艺建模详细信息
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        MesProcessModel model = mesProcessModelService.selectMesProcessModelById(id);
        WmsMaterialInfo material = wmsMaterialInfoService.selectWmsMaterialInfoById(model.getMaterialId());
        if(material!=null) {
            model.setMaterialCode(material.getCode());
            model.setMaterialModel(material.getModel());
            model.setMaterialName(material.getName());
            model.setMaterialSpecification(material.getSpecification());
            model.setMaterialUnit(material.getUnit());
        }
        return success(model);
    }

    /**
     * 新增工艺建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:add')")
    @Log(title = "工艺建模", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesProcessModel mesProcessModel)
    {
        return toAjax(mesProcessModelService.insertMesProcessModel(mesProcessModel));
    }

    /**
     * 修改工艺建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:edit')")
    @Log(title = "工艺建模", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesProcessModel mesProcessModel)
    {
        return toAjax(mesProcessModelService.updateMesProcessModel(mesProcessModel));
    }

    /**
     * 删除工艺建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:processModel:remove')")
    @Log(title = "工艺建模", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesProcessModelService.deleteMesProcessModelByIds(ids));
    }
}
