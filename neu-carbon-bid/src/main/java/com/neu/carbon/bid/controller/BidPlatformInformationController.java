package com.neu.carbon.bid.controller;

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
import com.neu.carbon.bid.domain.BidPlatformInformation;
import com.neu.carbon.bid.service.IBidPlatformInformationService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 平台动态Controller
 *
 * @author carbon_anning
 * @date 2025-04-30
 */
@RestController
@RequestMapping("/bid/information")
public class BidPlatformInformationController extends BaseController
{
    @Autowired
    private IBidPlatformInformationService bidPlatformInformationService;

    /**
     * 查询平台动态列表
     */
    @PreAuthorize("@ss.hasPermi('bid:information:list')")
    @GetMapping("/list")
    public TableDataInfo list(BidPlatformInformation bidPlatformInformation)
    {
        startPage();
        List<BidPlatformInformation> list = bidPlatformInformationService.selectBidPlatformInformationList(bidPlatformInformation);
        return getDataTable(list);
    }

    /**
     * 导出平台动态列表
     */
    @PreAuthorize("@ss.hasPermi('bid:information:export')")
    @Log(title = "平台动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BidPlatformInformation bidPlatformInformation)
    {
        List<BidPlatformInformation> list = bidPlatformInformationService.selectBidPlatformInformationList(bidPlatformInformation);
        ExcelUtil<BidPlatformInformation> util = new ExcelUtil<BidPlatformInformation>(BidPlatformInformation.class);
        util.exportExcel(response, list, "平台动态数据");
    }

    /**
     * 获取平台动态详细信息
     */
    @PreAuthorize("@ss.hasPermi('bid:information:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(bidPlatformInformationService.selectBidPlatformInformationById(id));
    }

    /**
     * 新增平台动态
     */
    @PreAuthorize("@ss.hasPermi('bid:information:add')")
    @Log(title = "平台动态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BidPlatformInformation bidPlatformInformation)
    {
        return toAjax(bidPlatformInformationService.insertBidPlatformInformation(bidPlatformInformation));
    }

    /**
     * 修改平台动态
     */
    @PreAuthorize("@ss.hasPermi('bid:information:edit')")
    @Log(title = "平台动态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BidPlatformInformation bidPlatformInformation)
    {
        return toAjax(bidPlatformInformationService.updateBidPlatformInformation(bidPlatformInformation));
    }

    /**
     * 删除平台动态
     */
    @PreAuthorize("@ss.hasPermi('bid:information:remove')")
    @Log(title = "平台动态", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bidPlatformInformationService.deleteBidPlatformInformationByIds(ids));
    }
}
