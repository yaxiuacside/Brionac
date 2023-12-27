package com.brionac.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.constants.OrderState;
import com.brionac.common.PageResult;
import com.brionac.common.Result;
import com.brionac.entity.domain.BrionacOrder;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.ProductReview;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.ProductEvaluateRequest;
import com.brionac.entity.vos.CustomerSpecsVO;
import com.brionac.entity.vos.ProductDetailVO;
import com.brionac.service.BrionacOrderService;
import com.brionac.service.ProductReviewService;
import com.brionac.service.ProductService;
import com.brionac.utils.PageResultUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.brionac.constants.Common.USER_SESSION_KEY;

/**
 * @author 亚修的小破机
 * Description: 顾客controller
 * ClassName: CustomerController
 * date: 2023/12/25
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    ProductService productService;
    @Resource
    ProductReviewService productReviewService;
    @Resource
    BrionacOrderService brionacOrderService;

    //商品管理
    @ApiOperationSupport(order = 15)
    @Operation(summary = "商品显示",description = "查看商城商品",tags = "顾客、一般浏览者- 商品查询")
    @GetMapping("/product/list")
    public Result<PageResult<Product>> list(
            @RequestParam(name = "当前页",defaultValue = "1") Integer pageNum,
            @RequestParam(name = "每页页数",defaultValue = "10") Integer pageSize,
            @RequestParam(name = "查询商品关键字",defaultValue = "") String productSearch
    ) {

        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();

        //如果搜索的关键字不为空
        if (StrUtil.isNotBlank(productSearch)){
            wrapper.like(Product::getProductName,productSearch);
        }

        return Result.success(PageResultUtil.getPageResult( productService.page(new Page<>(pageNum,pageSize),wrapper)));
    }

    @ApiOperationSupport(order = 15)
    @Operation(summary = "商品详情",description = "商品详情",tags = "顾客、一般浏览者- 商品查询")
    @Parameter(name = "productId",description = "商品id",in = ParameterIn.PATH)
    @GetMapping("/product/detail/{productId}")
    public Result<ProductDetailVO> detail(
            @PathVariable("productId")
            Integer productId
    ) {

        return Result.success(productService.detail(productId));
    }

    @ApiOperationSupport(order = 15)
    @Operation(summary = "商品规格详情",description = "商品规格详情",tags = "顾客、一般浏览者- 商品查询")
    @Parameter(name = "productId",description = "商品id",in = ParameterIn.PATH)
    @GetMapping("/product/detail/specs/{productId}")
    public Result<List<CustomerSpecsVO>> specsDetail(
            @PathVariable("productId")
            Integer productId
    ) {

        return Result.success(productService.getSpecs(productId));
    }

    @Operation(summary = "查看商品的评论",description = "查看商品的评论",tags = "顾客、一般浏览者- 商品查询")
    @Parameter(name = "orderId",description = "订单id",in = ParameterIn.PATH)
    @GetMapping("/evaluate/{productId}")
    public Result<PageResult<ProductReview>> getEvaluate(
            @PathVariable("productId")
            Integer productId
    ) {
        PageResult<ProductReview> result = PageResultUtil.getPageResult(productReviewService.page(new Page<>(), Wrappers.<ProductReview>lambdaQuery()
                .eq(ProductReview::getProductId, productId)));
        return Result.success(result);
    }


    @Operation(summary = "商品确认收货",description = "商品确认收货",tags = "顾客 - 订单管理")
    @Parameter(name = "orderId",description = "订单id",in = ParameterIn.PATH)
    @PutMapping("/receive/{orderId}")
    public Result<?> receive(
            @PathVariable("orderId")
            Integer orderId,
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ) {
        return brionacOrderService.update(Wrappers.<BrionacOrder>lambdaUpdate()
                .eq(BrionacOrder::getOrderId, orderId)
                .set(BrionacOrder::getOrderState, OrderState.RECEIVE)
        ) ? Result.success() : Result.error("501","确认收货失败");
    }

    @Operation(summary = "评价商品",description = "评价商品",tags = "顾客 - 订单管理")
    @PostMapping("/evaluate")
    public Result<?> evaluate(
            @RequestBody
            ProductEvaluateRequest request,
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ) {
        return productReviewService.savaReview(request,user) ?  Result.success() : Result.error("501","评论失败");
    }



}
