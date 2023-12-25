package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
     * 所属商品Id
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 规格名字
     */
    @TableField(value = "specs_name")
    private String specsName;

    /**
     * 规格描述
     */
    @TableField(value = "specs_desc")
    private String specsDesc;

    /**
     * 进价
     */
    @TableField(value = "specs_in_price")
    private BigDecimal specsInPrice;

    /**
     * 规格出售价格
     */
    @TableField(value = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 规格库存
     */
    @TableField(value = "specs_stock")
    private Integer specsStock;

    /**
     * 是否缺货
     */
    @TableField(value = "is_stockout")
    private Integer isStockout;

    /**
     * 规格图片
     */
    @TableField(value = "specs_img")
    private String specsImg;

    /**
     * 规格状态
     */
    @TableField(value = "specs_status")
    private Integer specsStatus;

    /**
     * 上架时间
     */
    @TableField(value = "sale_time")
    private Date saleTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}