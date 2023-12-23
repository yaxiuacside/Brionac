package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品表
 * @TableName product
 */
@TableName(value ="product")
@Data
public class Product implements Serializable {
    /**
     * 商品id
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    /**
     * 商品编号
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 商品类别id
     */
    @TableField(value = "product_type_id")
    private Integer productTypeId;

    /**
     * 商品类别
     */
    @TableField(value = "product_type")
    private String productType;

    /**
     * 品牌id
     */
    @TableField(value = "product_brand_id")
    private String productBrandId;

    /**
     * 品牌
     */
    @TableField(value = "product_brand")
    private String productBrand;

    /**
     * 进价
     */
    @TableField(value = "in_price")
    private Double inPrice;

    /**
     * 售价
     */
    @TableField(value = "out_price")
    private Double outPrice;

    /**
     * 库存
     */
    @TableField(value = "product_stock")
    private Integer productStock;

    /**
     * 最低库存
     */
    @TableField(value = "lowest_stock")
    private Integer lowestStock;

    /**
     * 是否缺货
     */
    @TableField(value = "is_stockout")
    private Integer isStockout;

    /**
     * 是否新品
     */
    @TableField(value = "is_new")
    private Integer isNew;

    /**
     * 是否上架
     */
    @TableField(value = "is_sale")
    private Integer isSale;

    /**
     * 上架时间
     */
    @TableField(value = "sale_time")
    private Date saleTime;

    /**
     * 商品图片
     */
    @TableField(value = "product_url")
    private String productUrl;

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
        Product other = (Product) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductTypeId() == null ? other.getProductTypeId() == null : this.getProductTypeId().equals(other.getProductTypeId()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getProductBrandId() == null ? other.getProductBrandId() == null : this.getProductBrandId().equals(other.getProductBrandId()))
            && (this.getProductBrand() == null ? other.getProductBrand() == null : this.getProductBrand().equals(other.getProductBrand()))
            && (this.getInPrice() == null ? other.getInPrice() == null : this.getInPrice().equals(other.getInPrice()))
            && (this.getOutPrice() == null ? other.getOutPrice() == null : this.getOutPrice().equals(other.getOutPrice()))
            && (this.getProductStock() == null ? other.getProductStock() == null : this.getProductStock().equals(other.getProductStock()))
            && (this.getLowestStock() == null ? other.getLowestStock() == null : this.getLowestStock().equals(other.getLowestStock()))
            && (this.getIsStockout() == null ? other.getIsStockout() == null : this.getIsStockout().equals(other.getIsStockout()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getIsSale() == null ? other.getIsSale() == null : this.getIsSale().equals(other.getIsSale()))
            && (this.getSaleTime() == null ? other.getSaleTime() == null : this.getSaleTime().equals(other.getSaleTime()))
            && (this.getProductUrl() == null ? other.getProductUrl() == null : this.getProductUrl().equals(other.getProductUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductTypeId() == null) ? 0 : getProductTypeId().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductBrandId() == null) ? 0 : getProductBrandId().hashCode());
        result = prime * result + ((getProductBrand() == null) ? 0 : getProductBrand().hashCode());
        result = prime * result + ((getInPrice() == null) ? 0 : getInPrice().hashCode());
        result = prime * result + ((getOutPrice() == null) ? 0 : getOutPrice().hashCode());
        result = prime * result + ((getProductStock() == null) ? 0 : getProductStock().hashCode());
        result = prime * result + ((getLowestStock() == null) ? 0 : getLowestStock().hashCode());
        result = prime * result + ((getIsStockout() == null) ? 0 : getIsStockout().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getIsSale() == null) ? 0 : getIsSale().hashCode());
        result = prime * result + ((getSaleTime() == null) ? 0 : getSaleTime().hashCode());
        result = prime * result + ((getProductUrl() == null) ? 0 : getProductUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productNo=").append(productNo);
        sb.append(", productName=").append(productName);
        sb.append(", productTypeId=").append(productTypeId);
        sb.append(", productType=").append(productType);
        sb.append(", productBrandId=").append(productBrandId);
        sb.append(", productBrand=").append(productBrand);
        sb.append(", inPrice=").append(inPrice);
        sb.append(", outPrice=").append(outPrice);
        sb.append(", productStock=").append(productStock);
        sb.append(", lowestStock=").append(lowestStock);
        sb.append(", isStockout=").append(isStockout);
        sb.append(", isNew=").append(isNew);
        sb.append(", isSale=").append(isSale);
        sb.append(", saleTime=").append(saleTime);
        sb.append(", productUrl=").append(productUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}