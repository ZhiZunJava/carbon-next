package com.neu.carbon.mes.domain;

import com.neu.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

import java.io.Serial;

/**
 * 工厂建模明细对象 mes_factory_model_detail
 *
 * @author carbon_anning
 * @date 2025-04-29
 */
public class MesFactoryModelDetail extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 生产线编号 */
    private Long productLineId;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private Long equipmentId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductLineId(Long productLineId)
    {
        this.productLineId = productLineId;
    }

    public Long getProductLineId()
    {
        return productLineId;
    }
    public void setEquipmentId(Long equipmentId)
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId()
    {
        return equipmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productLineId", getProductLineId())
                .append("equipmentId", getEquipmentId())
                .toString();
    }
}
