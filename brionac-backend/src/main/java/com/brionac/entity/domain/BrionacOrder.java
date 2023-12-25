package com.brionac.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName order
 */
@TableName(value ="brionac_order")
@Data
public class BrionacOrder implements Serializable {
    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单编号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    private Date orderTime;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Integer productId;

    /**
     * 商品编号
     */
    @TableField(value = "product_no")
    private String productNo;

    /**
     * 商品规格
     */
    @TableField(value = "product_specs")
    private String productSpecs;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 用户账号
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 联系方式
     */
    @TableField(value = "contact_way")
    private String contactWay;

    /**
     * 商品金额
     */
    @TableField(value = "pay_price")
    private BigDecimal payPrice;

    /**
     * 购买数量
     */
    @TableField(value = "pay_amount")
    private Integer payAmount;

    /**
     * 支付方式
     */
    @TableField(value = "pay_type")
    private String payType;

    /**
     * 订单状态
     */
    @TableField(value = "order_state")
    private String orderState;

    /**
     * 收货地址
     */
    @TableField(value = "accept_address")
    private String acceptAddress;

    /**
     * 退货状态
     */
    @TableField(value = "return_state")
    private Integer returnState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}