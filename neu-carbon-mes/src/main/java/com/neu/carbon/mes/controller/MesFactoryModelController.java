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
import com.neu.carbon.mes.domain.MesFactoryModel;
import com.neu.carbon.mes.service.IMesFactoryModelService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 工厂建模Controller
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
@RestController
@RequestMapping("/mesModel/factoryModel")
public class MesFactoryModelController extends BaseController
{
    @Autowired
    private IMesFactoryModelService mesFactoryModelService;
    @Autowired
    private IWmsMaterialInfoService wmsMaterialInfoService;

    /**
     * 查询工厂建模列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesFactoryModel mesFactoryModel)
    {
        startPage();
        List<MesFactoryModel> list = mesFactoryModelService.selectMesFactoryModelList(mesFactoryModel);
        list.stream().forEach(model->{
            WmsMaterialInfo material = wmsMaterialInfoService.selectWmsMaterialInfoById(model.getMaterialId());
            if(material!=null) {
                model.setMaterialName(material.getName());
            }
        });
        return getDataTable(list);
    }

    /**
     * 导出工厂建模列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:export')")
    @Log(title = "工厂建模", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesFactoryModel mesFactoryModel)
    {
        List<MesFactoryModel> list = mesFactoryModelService.selectMesFactoryModelList(mesFactoryModel);
        ExcelUtil<MesFactoryModel> util = new ExcelUtil<MesFactoryModel>(MesFactoryModel.class);
        util.exportExcel(response, list, "工厂建模数据");
    }

    /**
     * 获取工厂建模详细信息
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        MesFactoryModel model = mesFactoryModelService.selectMesFactoryModelById(id);
        WmsMaterialInfo material = wmsMaterialInfoService.selectWmsMaterialInfoById(model.getMaterialId());
        if(material!=null) {
            model.setMaterialName(material.getName());
            model.setProductModel(material.getModel());
            model.setProductSpecification(material.getSpecification());
        }
        return success(model);
    }

    /**
     * 新增工厂建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:add')")
    @Log(title = "工厂建模", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesFactoryModel mesFactoryModel)
    {
        return toAjax(mesFactoryModelService.insertMesFactoryModel(mesFactoryModel));
    }

    /**
     * 修改工厂建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:edit')")
    @Log(title = "工厂建模", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesFactoryModel mesFactoryModel)
    {
        return toAjax(mesFactoryModelService.updateMesFactoryModel(mesFactoryModel));
    }

    /**
     * 删除工厂建模
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModel:remove')")
    @Log(title = "工厂建模", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesFactoryModelService.deleteMesFactoryModelByIds(ids));
    }
}
