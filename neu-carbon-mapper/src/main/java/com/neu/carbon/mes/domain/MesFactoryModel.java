package com.neu.carbon.mes.domain;

import java.io.Serial;
import java.util.List;

import com.neu.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

/**
 * 工厂建模对象 mes_factory_model
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
public class MesFactoryModel extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 物料 */
    @Excel(name = "物料")
    private Long materialId;

    /** 生产线名称 */
    @Excel(name = "生产线名称")
    private String productLineName;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "产品型号")
    private String productModel;

    /** 规格 */
    @Excel(name = "产品规格")
    private String productSpecification;

    /** 工厂建模明细信息 */
    private List<MesFactoryModelDetail> mesFactoryModelDetailList;

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

    public void setProductLineName(String productLineName)
    {
        this.productLineName = productLineName;
    }

    public String getProductLineName()
    {
        return productLineName;
    }

    public List<MesFactoryModelDetail> getMesFactoryModelDetailList()
    {
        return mesFactoryModelDetailList;
    }

    public void setMesFactoryModelDetailList(List<MesFactoryModelDetail> mesFactoryModelDetailList)
    {
        this.mesFactoryModelDetailList = mesFactoryModelDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("materialId", getMaterialId())
                .append("productLineName", getProductLineName())
                .append("remark", getRemark())
                .append("mesFactoryModelDetailList", getMesFactoryModelDetailList())
                .toString();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }
}
