package com.brionac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;
import com.brionac.common.Result;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Store;
import com.brionac.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: StoreController
 * date: 2023/12/24
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Resource
    StoreService storeService;

    //店铺管理
    @Operation(summary = "店铺列表",description = "查询出全部店铺",tags = "运行商店铺管理")
    @GetMapping("/list")
    public Result<PageResult> storeList(){

        Page<Store> storePage = storeService.storeList();

        PageResult<Object> pageResult = new PageResult<>();
        BeanUtil.copyProperties(storePage,pageResult);
        return Result.success(pageResult);
    }

    @Operation(summary = "当前登录店铺信息",description = "当前登录店铺信息",tags = "店铺管理")
    @GetMapping("/store/current")
    public Result<Store> storeCurrent(HttpServletRequest request){

        Store store = storeService.detail(request);

        return Result.success(store);
    }

    //店铺管理 end

    //商品管理
    @Operation(summary = "店铺商品显示",description = "显示自己店铺的商品",tags = "店铺 - 商品管理")
    @GetMapping("/product/list")
    public Result<PageResult> productList(HttpServletRequest request) {

        Page<Product> productPage = storeService.productList(request);

        PageResult<Object> pageResult = new PageResult<>();
        BeanUtil.copyProperties(productPage, pageResult);
        return Result.success(pageResult);
    }

}
