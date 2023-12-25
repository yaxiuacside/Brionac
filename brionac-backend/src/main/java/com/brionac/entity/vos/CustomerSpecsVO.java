package com.brionac.entity.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格表
 * @TableName specs
 */
@Data
@Schema(name = "商品规格详情VO",description = "商品规格详情VO")
public class CustomerSpecsVO{
    /**
     * 规格id
     */
    @Schema(description = "规格id")
    private Integer specsId;

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
     * 是否缺货
     */
    @Schema(description = "是否缺货 0-不缺货, 1-缺货")
    private Integer isStockout;

    /**
     * 规格图片
     */
    @Schema(description = "规格图片")
    private String specsImg;


}