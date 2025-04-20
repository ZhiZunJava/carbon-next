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
import com.neu.carbon.mes.domain.MesProject;
import com.neu.carbon.mes.service.IMesProjectService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 项目维护Controller
 * 
 * @author carbon_anning
 * @date 2025-04-20
 */
@RestController
@RequestMapping("/baseInfo/projectInfo")
public class MesProjectController extends BaseController
{
    @Autowired
    private IMesProjectService mesProjectService;

    /**
     * 查询项目维护列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(MesProject mesProject)
    {
        startPage();
        List<MesProject> list = mesProjectService.selectMesProjectList(mesProject);
        return getDataTable(list);
    }

    /**
     * 导出项目维护列表
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:export')")
    @Log(title = "项目维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MesProject mesProject)
    {
        List<MesProject> list = mesProjectService.selectMesProjectList(mesProject);
        ExcelUtil<MesProject> util = new ExcelUtil<MesProject>(MesProject.class);
        util.exportExcel(response, list, "项目维护数据");
    }

    /**
     * 获取项目维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mesProjectService.selectMesProjectById(id));
    }

    /**
     * 新增项目维护
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:add')")
    @Log(title = "项目维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MesProject mesProject)
    {
        return toAjax(mesProjectService.insertMesProject(mesProject));
    }

    /**
     * 修改项目维护
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:edit')")
    @Log(title = "项目维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MesProject mesProject)
    {
        return toAjax(mesProjectService.updateMesProject(mesProject));
    }

    /**
     * 删除项目维护
     */
    @PreAuthorize("@ss.hasPermi('baseInfo:projectInfo:remove')")
    @Log(title = "项目维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mesProjectService.deleteMesProjectByIds(ids));
    }
}
