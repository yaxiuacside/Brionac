package com.brionac.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;
import com.brionac.common.Result;
import com.brionac.entity.domain.BrionacOrder;
import com.brionac.entity.domain.ShoppingCart;
import com.brionac.entity.domain.Store;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.AddShoppingCartRequest;
import com.brionac.entity.requests.StoreDeliverRequest;
import com.brionac.entity.vos.StoreOrderVO;
import com.brionac.service.BrionacOrderService;
import com.brionac.service.ShoppingCartService;
import com.brionac.utils.PageResultUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.brionac.common.Common.STORE_SESSION_KEY;
import static com.brionac.common.Common.USER_SESSION_KEY;

/**
 * @author 亚修的小破机
 * Description: 订单 - 购物车相关接口
 * ClassName: OrderController
 * date: 2023/12/25
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    BrionacOrderService brionacOrderService;

    @Resource
    ShoppingCartService shoppingCartService;

    @ApiOperationSupport(order = 5)
    @Operation(summary = "添加商品到购物车",description = "添加商品到购物车",tags = "顾客 - 购物车管理")
    @PostMapping("/customer/shoppingCar")
    public Result<?> addToCar(
            @RequestBody
            AddShoppingCartRequest request,
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ){
        return shoppingCartService.add(request,user.getUserId(),user.getAccountNumber()) ? Result.success():Result.error("501","添加购物车失败");
    }

    @Operation(summary = "查看购物车",description = "查看购物车",tags = "顾客 - 购物车管理")
    @GetMapping("/customer/shoppingCar")
    public Result<PageResult<?>> getCar(
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ){
        Page<ShoppingCart> page = shoppingCartService.getCar(user);
        return Result.success(PageResultUtil.getPageResult(page));
    }

    @Operation(summary = "删除购物车中的商品",description = "删除购物车中的商品",tags = "顾客 - 购物车管理")
    @DeleteMapping ("/customer/shoppingCar")
    public Result<?> delete(
            @RequestParam(name = "购物车Id")
            Integer cartId
    ){
        return shoppingCartService.removeById(cartId) ? Result.success():Result.error("501","删除购物车失败");
    }

    @Operation(summary = "修改购物车中某商品购买数量",description = "修改购物车中某商品购买数量",tags = "顾客 - 购物车管理")
    @PutMapping ("/customer/shoppingCar")
    public Result<?> updateAmount(
            @RequestParam(name = "购物车Id")
            Integer cartId,
            @RequestParam(name = "修改数量")
            Integer amount
    ){
        return shoppingCartService.updateAmount(cartId,amount) ? Result.success():Result.error("501"," 修改购物车失败");
    }

    @ApiOperationSupport(order = 6)
    @Operation(summary = "购物车结算 - 下订单",description = "购物车结算 - 下订单",tags = "顾客 - 订单管理")
    @PostMapping ("/customer/shoppingCar/settlement")
    public Result<?> settlement(
            @RequestBody
            List<Integer> cartIds,
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ){
        return brionacOrderService.settlement(cartIds,user) ? Result.success():Result.error("501"," 修改购物车失败");
    }

    @Operation(summary = "查看订单",description = "查看订单",tags = "顾客 - 订单管理")
    @GetMapping ("/customer/order")
    public Result<PageResult<BrionacOrder>> list(
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user
    ){
        Page<BrionacOrder> orderPage = brionacOrderService.page(new Page<>(), Wrappers.<BrionacOrder>lambdaQuery().eq(BrionacOrder::getUserId, user.getUserId()));

        return Result.success(PageResultUtil.getPageResult(orderPage));
    }

    @Operation(summary = "取消订单",description = "取消订单",tags = "顾客 - 订单管理")
    @DeleteMapping ("/customer/order")
    public Result<?> orderDelete(
            @RequestParam
            Integer orderId,
            @SessionAttribute(value = USER_SESSION_KEY)
            @Parameter(hidden = true)
            User user

    ){
        return brionacOrderService.removeById(orderId) ? Result.success():Result.error("501"," 修改购物车失败");
    }

    @ApiOperationSupport(order = 7)
    @Operation(summary = "查看店铺所有订单",description = "查看店铺所有订单",tags = "店铺 - 订单管理")
    @GetMapping ("/store/order")
    public Result<PageResult<StoreOrderVO>> listOrder(
            @SessionAttribute(value = STORE_SESSION_KEY)
            @Parameter(hidden = true)
            Store store
    ){
        Page<StoreOrderVO> page = brionacOrderService.getStoreOrder(store);
        return Result.success(PageResultUtil.getPageResult(page));
    }

    @ApiOperationSupport(order = 7)
    @Operation(summary = "商家发货",description = "商家发货",tags = "店铺 - 订单管理")
    @GetMapping ("/store/deliver")
    public Result<?> deliver(
            @RequestBody
            StoreDeliverRequest request,
            @SessionAttribute(value = STORE_SESSION_KEY)
            @Parameter(hidden = true)
            Store store
    ){
        return brionacOrderService.deliver(request,store) ? Result.success() : Result.error("501"," 发货失败");
    }
}
