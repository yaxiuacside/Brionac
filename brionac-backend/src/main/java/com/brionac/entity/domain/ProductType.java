package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品类别表
 * @TableName product_type
 */
@TableName(value ="product_type")
@Data
public class ProductType implements Serializable {
    /**
     * 类别id
     */
    @TableId(value = "type_id", type = IdType.AUTO)
    private Integer typeId;

    /**
     * 类别名称
     */
    @TableField(value = "type_name")
    private String typeName;

    /**
     * 类别描述
     */
    @TableField(value = "type_describe")
    private String typeDescribe;

    /**
     * 左侧宣传图
     */
    @TableField(value = "type_url_left")
    private String typeUrlLeft;

    /**
     * 横幅宣传图
     */
    @TableField(value = "type_url_top")
    private String typeUrlTop;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProductType other = (ProductType) that;
        return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getTypeDescribe() == null ? other.getTypeDescribe() == null : this.getTypeDescribe().equals(other.getTypeDescribe()))
            && (this.getTypeUrlLeft() == null ? other.getTypeUrlLeft() == null : this.getTypeUrlLeft().equals(other.getTypeUrlLeft()))
            && (this.getTypeUrlTop() == null ? other.getTypeUrlTop() == null : this.getTypeUrlTop().equals(other.getTypeUrlTop()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getTypeDescribe() == null) ? 0 : getTypeDescribe().hashCode());
        result = prime * result + ((getTypeUrlLeft() == null) ? 0 : getTypeUrlLeft().hashCode());
        result = prime * result + ((getTypeUrlTop() == null) ? 0 : getTypeUrlTop().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", typeName=").append(typeName);
        sb.append(", typeDescribe=").append(typeDescribe);
        sb.append(", typeUrlLeft=").append(typeUrlLeft);
        sb.append(", typeUrlTop=").append(typeUrlTop);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}