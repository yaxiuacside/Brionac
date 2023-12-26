package com.brionac.entity.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 商品评价VO
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