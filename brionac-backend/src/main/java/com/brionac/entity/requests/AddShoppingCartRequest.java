package com.brionac.entity.requests;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 购物车表
 * @TableName shopping_cart
 */
@Schema(name = "添加购物车request",description = "添加购物车request")
@Data
public class AddShoppingCartRequest{

    /**
     * 用户id
     */
    @Hidden
    @Schema(description = "用户id")
    private Integer userId;


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


}