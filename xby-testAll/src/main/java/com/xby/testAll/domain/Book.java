package com.xby.testAll.domain;

import com.xby.common.annotation.Excel;
import com.xby.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 书籍对象 Book
 *
 * @author xby
 * @date 2025-05-13
 */
public class Book extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long userId;

    /** 唯一id */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("type", getType())
                .append("name", getName())
                .append("description", getDescription())
                .toString();

    }

    //    @Override
//    public String toString() {
//        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
//            .append("id", getId())
//            .append("startIp", getStartIp())
//            .append("endIp", getEndIp())
//            .append("province", getProvince())
//
//            .toString();
//    }
}
