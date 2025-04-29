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
import com.neu.carbon.mes.domain.MesEquipment;
import com.neu.carbon.mes.service.IMesEquipmentService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 设备信息Controller
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
@RestController
@RequestMapping("/baseInfo/equipmentInfo")
public class MesEquipmentController extends BaseController
{
    @Autowired
    private IMesEquipmentService mesEquipmentService;

    /**
     * 查询设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesEquipment mesEquipment)
    {
        startPage();
        List<MesEquipment> list = mesEquipmentService.selectMesEquipmentList(mesEquipment);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:export')")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesEquipment mesEquipment)
    {
        List<MesEquipment> list = mesEquipmentService.selectMesEquipmentList(mesEquipment);
        ExcelUtil<MesEquipment> util = new ExcelUtil<MesEquipment>(MesEquipment.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesEquipmentService.selectMesEquipmentById(id));
    }

    /**
     * 新增设备信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:add')")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesEquipment mesEquipment)
    {
        return toAjax(mesEquipmentService.insertMesEquipment(mesEquipment));
    }

    /**
     * 修改设备信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:edit')")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesEquipment mesEquipment)
    {
        return toAjax(mesEquipmentService.updateMesEquipment(mesEquipment));
    }

    /**
     * 删除设备信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:equipmentInfo:remove')")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesEquipmentService.deleteMesEquipmentByIds(ids));
    }
}
