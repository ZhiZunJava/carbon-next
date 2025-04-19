package com.neu.generator.domain;

import com.neu.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

import java.io.Serial;

/**
 * 通用查询对象 sys_com_query
 * 
 * @author carbon_anning
 * @date 2025-04-19
 */
public class SysComQuery extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 关键字 */
    @Excel(name = "关键字")
    private String code;

    /** sql语句 */
    private String customSql;

    /** 类型 */
    @Excel(name = "类型", dictType = "sys_query_type")
    private String type;

    /** 配置项 */
    private String config;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }

    public void setCustomSql(String customSql) 
    {
        this.customSql = customSql;
    }

    public String getCustomSql() 
    {
        return customSql;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setConfig(String config) 
    {
        this.config = config;
    }

    public String getConfig() 
    {
        return config;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("remark", getRemark())
            .append("customSql", getCustomSql())
            .append("type", getType())
            .append("config", getConfig())
            .toString();
    }
}
