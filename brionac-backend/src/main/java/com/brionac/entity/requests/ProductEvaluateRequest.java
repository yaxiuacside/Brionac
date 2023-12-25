package com.brionac.entity.requests;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评价VO
 * @TableName product_review
 */
@Schema(name = "商品评价VO",description = "商品评价VO")
@Data
public class ProductEvaluateRequest{

    /**
     * 订单Id
     */
    @Schema(description = "订单Id")
    private String orderId;

    /**
     * 订单编号
     */
    @Schema(description = "订单编号")
    private String orderNo;

    /**
     * 商品ID
     */
    @Schema(description = "商品ID")
    private Integer productId;

    /**
     * 商品编号
     */
    @Schema(description = "商品编号")
    private String productNo;

    /**
     * 商品规格
     */
    @Schema(description = "商品规格")
    private String productSpecs;

    /**
     * 商品评星
     */
    @Schema(description = "商品评星")
    private Double starLevel;


    /**
     * 商品评价
     */
    @Schema(description = "商品评价")
    private String productReview;

}