package com.neu.carbon.mes.domain;

import com.neu.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

import java.io.Serial;

/**
 * 工艺建模对象 mes_process_model
 *
 * @author carbon_anning
 * @date 2025-04-30
 */
public class MesProcessModel extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private Long materialId;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String processName;

    /** 工艺描述 */
    private String description;

    /** 单位耗电量 */
    @Excel(name = "单位耗电量")
    private Long powerConsume;

    /** 产品编码 */
    @Excel(name = "产品编码")
    private String materialCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "产品型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "产品规格")
    private String materialSpecification;

    /** 单位 */
    @Excel(name = "产品单位")
    private String materialUnit;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }

    public void setProcessName(String processName)
    {
        this.processName = processName;
    }

    public String getProcessName()
    {
        return processName;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPowerConsume(Long powerConsume)
    {
        this.powerConsume = powerConsume;
    }

    public Long getPowerConsume()
    {
        return powerConsume;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("materialId", getMaterialId())
                .append("processName", getProcessName())
                .append("description", getDescription())
                .append("powerConsume", getPowerConsume())
                .append("remark", getRemark())
                .toString();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialModel() {
        return materialModel;
    }

    public void setMaterialModel(String materialModel) {
        this.materialModel = materialModel;
    }

    public String getMaterialSpecification() {
        return materialSpecification;
    }

    public void setMaterialSpecification(String materialSpecification) {
        this.materialSpecification = materialSpecification;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }
}
