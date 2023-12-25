package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 购物车表
 * @TableName shopping_cart
 */
@TableName(value ="shopping_cart")
@Data
public class ShoppingCart implements Serializable {
    /**
     * 购物车id
     */
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 用户帐号
     */
    @TableField(value = "account_number")
    private String accountNumber;

    /**
     * 商品id
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 购买数量
     */
    @TableField(value = "pay_amount")
    private Integer payAmount;

    /**
     * 商品规格ID
     */
    @TableField(value = "specs_id")
    private Integer specsId;

    /**
     * 规格图片
     */
    @TableField(value = "specs_img")
    private String specsImg;

    /**
     * 商品规格
     */
    @TableField(value = "product_specs")
    private String productSpecs;

    /**
     * 该商品应付价钱
     */
    @TableField(value = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 支付状态
     */
    @TableField(value = "state")
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}