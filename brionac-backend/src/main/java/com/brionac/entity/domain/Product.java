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
     * 店铺ID
     */
    @TableField(value = "store_id")
    private Integer storeId;

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
}