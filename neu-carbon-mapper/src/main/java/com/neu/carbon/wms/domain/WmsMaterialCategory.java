package com.neu.carbon.wms.domain;

import com.neu.common.core.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

import java.io.Serial;

/**
 * 物料分类对象 wms_material_category
 *
 * @author carbon_anning
 * @date 2025-04-24
 */
public class WmsMaterialCategory extends TreeEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 分类编码 */
    @Excel(name = "分类编码")
    private String code;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("code", getCode())
                .append("name", getName())
                .append("remark", getRemark())
                .append("parentId", getParentId())
                .toString();
    }
}
