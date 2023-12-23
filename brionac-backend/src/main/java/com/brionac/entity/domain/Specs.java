package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商品规格表
 * @TableName specs
 */
@TableName(value ="specs")
@Data
public class Specs implements Serializable {
    /**
     * 规格id
     */
    @TableId(value = "specs_id", type = IdType.AUTO)
    private Integer specsId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 规格类型
     */
    @TableField(value = "specs_name")
    private String specsName;

    /**
     * 商品类别
     */
    @TableField(value = "product_type")
    private String productType;

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
        Specs other = (Specs) that;
        return (this.getSpecsId() == null ? other.getSpecsId() == null : this.getSpecsId().equals(other.getSpecsId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSpecsName() == null ? other.getSpecsName() == null : this.getSpecsName().equals(other.getSpecsName()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecsId() == null) ? 0 : getSpecsId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSpecsName() == null) ? 0 : getSpecsName().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specsId=").append(specsId);
        sb.append(", productId=").append(productId);
        sb.append(", specsName=").append(specsName);
        sb.append(", productType=").append(productType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}