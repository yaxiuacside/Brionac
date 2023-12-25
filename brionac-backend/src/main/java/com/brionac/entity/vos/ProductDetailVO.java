package com.brionac.entity.vos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品的细节
 */
@Data
@Schema(name = "商品的详情VO",description = "商品的详情VO")
public class ProductDetailVO {

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

    /**
     * 商品缩略图
     */
    @Schema(description = "商品缩略图")
    private String thumbnail;

    /**
     * 商品介绍图
     */
    @Schema(description = "商品介绍图")
    private String introDiagram;

    /**
     * 流量热度
     */
    @Schema(description = "流量热度")
    private Long traffic;

    /**
     * 是否新品
     */
    @Schema(description = "是否新品, 0不是新品, 1为新品")
    private Integer isNew;

    //规格表字段


    /**
     * 规格出售价格
     */
    @Schema(description = "出售价格")
    private BigDecimal specsPrice;

    /**
     * 规格库存
     */
    @Schema(description = "规格库存")
    private Integer specsStock;

}