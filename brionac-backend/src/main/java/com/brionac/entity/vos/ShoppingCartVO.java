package com.brionac.entity.vos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 购物车表
 * @TableName shopping_cart
 */
@Schema(name = "显示购物车内容VO",description = "显示购物车内容VO")
@Data
public class ShoppingCartVO {

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Integer userId;

    /**
     * 用户帐号
     */
    @Schema(description = "用户帐号")
    private String accountNumber;

    /**
     * 商品id
     */
    @Schema(description = "商品id")
    private Integer productId;

    /**
     * 购买数量
     */
    @Schema(description = "购买数量")
    private Integer payAmount;

    /**
     * 商品规格ID
     */
    @Schema(description = "商品规格ID")
    private Integer specsId;

    /**
     * 商品规格
     */
    @Schema(description = "商品规格")
    private String productSpecs;

}