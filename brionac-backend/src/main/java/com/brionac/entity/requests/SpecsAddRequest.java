package com.brionac.entity.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: SpecsAddRequest
 * date: 2023/12/25
 */
@Data
@Schema(name = "规格添加request",description = "规格添加request")
public class SpecsAddRequest {

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
