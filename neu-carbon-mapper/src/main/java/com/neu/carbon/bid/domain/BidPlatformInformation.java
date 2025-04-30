package com.neu.carbon.bid.domain;

import java.io.Serial;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.neu.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;

/**
 * 平台动态对象 bid_platform_information
 *
 * @author carbon_anning
 * @date 2025-04-30
 */
public class BidPlatformInformation extends BaseEntity
{
    @Serial
    private static final long serialVersionUID = 1L;

    /** No. */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    private String content;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDatetime;

    /** 发布者 */
    @Excel(name = "发布者")
    private String publisher;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }

    public void setPublishDatetime(Date publishDatetime)
    {
        this.publishDatetime = publishDatetime;
    }

    public Date getPublishDatetime()
    {
        return publishDatetime;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getPublisher()
    {
        return publisher;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("content", getContent())
                .append("publishDatetime", getPublishDatetime())
                .append("publisher", getPublisher())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
