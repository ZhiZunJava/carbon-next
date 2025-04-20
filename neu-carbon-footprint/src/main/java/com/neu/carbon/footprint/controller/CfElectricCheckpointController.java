package com.neu.carbon.footprint.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import com.neu.carbon.footprint.domain.CfElectricCheckpoint;
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
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.carbon.footprint.service.ICfElectricCheckpointService;
import com.neu.common.core.page.TableDataInfo;

/**
 * 能效检测点Controller
 *
 * @author carbon_anning
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/cfElectric/checkpoint")
public class CfElectricCheckpointController extends BaseController
{
    @Autowired
    private ICfElectricCheckpointService cfElectricCheckpointService;

    /**
     * 查询能效检测点列表
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:list')")
    @GetMapping("/list")
    public TableDataInfo list(CfElectricCheckpoint cfElectricCheckpoint)
    {
        startPage();
        List<CfElectricCheckpoint> list = cfElectricCheckpointService.selectCfElectricCheckpointList(cfElectricCheckpoint);
        return getDataTable(list);
    }

    /**
     * 导出能效检测点列表
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:export')")
    @Log(title = "能效检测点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CfElectricCheckpoint cfElectricCheckpoint)
    {
        List<CfElectricCheckpoint> list = cfElectricCheckpointService.selectCfElectricCheckpointList(cfElectricCheckpoint);
        ExcelUtil<CfElectricCheckpoint> util = new ExcelUtil<CfElectricCheckpoint>(CfElectricCheckpoint.class);
        util.exportExcel(response, list, "能效检测点数据");
    }

    /**
     * 获取能效检测点详细信息
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cfElectricCheckpointService.selectCfElectricCheckpointById(id));
    }

    /**
     * 新增能效检测点
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:add')")
    @Log(title = "能效检测点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CfElectricCheckpoint cfElectricCheckpoint)
    {
        return toAjax(cfElectricCheckpointService.insertCfElectricCheckpoint(cfElectricCheckpoint));
    }

    /**
     * 修改能效检测点
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:edit')")
    @Log(title = "能效检测点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CfElectricCheckpoint cfElectricCheckpoint)
    {
        return toAjax(cfElectricCheckpointService.updateCfElectricCheckpoint(cfElectricCheckpoint));
    }

    /**
     * 删除能效检测点
     */
    @PreAuthorize("@ss.hasPermi('cfElectric:checkpoint:remove')")
    @Log(title = "能效检测点", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cfElectricCheckpointService.deleteCfElectricCheckpointByIds(ids));
    }
}
