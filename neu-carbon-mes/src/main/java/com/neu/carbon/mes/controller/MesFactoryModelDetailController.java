package com.neu.carbon.mes.controller;

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
import com.neu.carbon.mes.domain.MesFactoryModelDetail;
import com.neu.carbon.mes.service.IMesFactoryModelDetailService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 工厂建模明细Controller
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
@RestController
@RequestMapping("/mesModel/factoryModelDetail")
public class MesFactoryModelDetailController extends BaseController
{
    @Autowired
    private IMesFactoryModelDetailService mesFactoryModelDetailService;

    /**
     * 查询工厂建模明细列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesFactoryModelDetail mesFactoryModelDetail)
    {
        startPage();
        List<MesFactoryModelDetail> list = mesFactoryModelDetailService.selectMesFactoryModelDetailList(mesFactoryModelDetail);
        return getDataTable(list);
    }

    /**
     * 导出工厂建模明细列表
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:export')")
    @Log(title = "工厂建模明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesFactoryModelDetail mesFactoryModelDetail)
    {
        List<MesFactoryModelDetail> list = mesFactoryModelDetailService.selectMesFactoryModelDetailList(mesFactoryModelDetail);
        ExcelUtil<MesFactoryModelDetail> util = new ExcelUtil<MesFactoryModelDetail>(MesFactoryModelDetail.class);
        util.exportExcel(response, list, "工厂建模明细数据");
    }

    /**
     * 获取工厂建模明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesFactoryModelDetailService.selectMesFactoryModelDetailById(id));
    }

    /**
     * 新增工厂建模明细
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:add')")
    @Log(title = "工厂建模明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesFactoryModelDetail mesFactoryModelDetail)
    {
        return toAjax(mesFactoryModelDetailService.insertMesFactoryModelDetail(mesFactoryModelDetail));
    }

    /**
     * 修改工厂建模明细
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:edit')")
    @Log(title = "工厂建模明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesFactoryModelDetail mesFactoryModelDetail)
    {
        return toAjax(mesFactoryModelDetailService.updateMesFactoryModelDetail(mesFactoryModelDetail));
    }

    /**
     * 删除工厂建模明细
     */
    @PreAuthorize("@ss.hasPermi('mesModel:factoryModelDetail:remove')")
    @Log(title = "工厂建模明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesFactoryModelDetailService.deleteMesFactoryModelDetailByIds(ids));
    }
}
