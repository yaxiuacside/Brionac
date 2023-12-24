package com.brionac.entity.requests;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品添加request
 */
@Data
@Schema(name = "商品添加request",description = "商品添加request")
public class ProductAddRequest {

    /**
     * 商品编号
     */
    @Schema(description = "商品编号")
    private String productNo;

    /**
     * 商品名称
     */
    @Schema(description = "商品名称")
    private String productName;

    /**
     * 商品类别
     */
    @Schema(description = "商品类别")
    private String productType;

    //规格表字段


    /**
     * 规格名字
     */
    @Schema(description = "规格名字")
    private String specsName;

    /**
     * 规格描述
     */
    @Schema(description = "规格描述")
    private String specsDesc;

    /**
     * 进价
     */
    @Schema(description = "进价")
    private Double specsInPrice;

    /**
     * 规格出售价格
     */
    @Schema(description = "规格出售价格")
    private BigDecimal specsPrice;

    /**
     * 规格库存
     */
    @Schema(description = "规格库存")
    private Integer specsStock;

    /**
     * 规格图片
     */
    @Schema(description = "规格图片")
    private String specsImg;


}