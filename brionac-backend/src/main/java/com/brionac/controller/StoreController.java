package com.brionac.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;
import com.brionac.common.Result;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Specs;
import com.brionac.entity.domain.Store;
import com.brionac.entity.requests.ProductAddRequest;
import com.brionac.entity.requests.SpecsAddRequest;
import com.brionac.entity.requests.StoreUpdateRequest;
import com.brionac.service.ProductService;
import com.brionac.service.SpecsService;
import com.brionac.service.StoreService;
import com.brionac.utils.PageResultUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.brionac.common.Common.STORE_SESSION_KEY;

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

    @Resource
    ProductService productService;

    @Resource
    SpecsService specsService;

    //店铺管理
    @ApiOperationSupport(order = 4)
    @Operation(summary = "店铺列表",description = "查询出全部店铺",tags = "运行商店铺管理")
    @GetMapping("/list")
    public Result<PageResult<Store>> storeList(){
        Page<Store> storePage = storeService.storeList();
        return Result.success(PageResultUtil.getPageResult(storePage));
    }

    @Operation(summary = "店铺列表 - 过滤",description = "根据店铺名字过滤",tags = "运行商店铺管理")
    @GetMapping("/list/filter")
    public Result<PageResult<Store>> findPage(
            @RequestParam(name = "当前页",defaultValue = "1") Integer pageNum,
             @RequestParam(name = "每页页数",defaultValue = "10") Integer pageSize,
             @RequestParam(name = "storeNameSearch",defaultValue = "") String storeNameSearch)
    {
        //新建分页对象
        Page<Store> page = new Page<>(pageNum, pageSize);
        //新建模糊查询对象,这里有个注意事项，你模糊项查询的对应项不能为null，为null就查不出来
        LambdaQueryWrapper<Store> queryWrapper = Wrappers.lambdaQuery();
        if (!storeNameSearch.isEmpty())
            queryWrapper.like(Store::getStoreName, storeNameSearch);
        Page<Store> storePage = storeService.page(page, queryWrapper);

        return Result.success(PageResultUtil.getPageResult(storePage));
    }

    @Operation(summary = "店铺详情",description = "根据传入店铺id查看店铺信息",tags = "运行商店铺管理")
    @Parameter(name = "id",description = "店铺id",in = ParameterIn.PATH)
    @GetMapping("/{id}")
    public Result<Store> storeCurrent(@PathVariable("id") String id){
        Store store = storeService.detail(Integer.getInteger(id));
        return Result.success(store);
    }

    @Operation(summary = "店铺删除",description = "根据店铺id删除店铺",tags = "运行商店铺管理")
    @Parameter(name = "id",description = "店铺id",in = ParameterIn.PATH)
    @DeleteMapping("/{id}")
    public Result<?> storeDelete(@PathVariable("id") String id,HttpServletRequest request){
        return storeService.storeDelete(id,request) ? Result.success():Result.error("501","删除失败");
    }


    @ApiOperationSupport(order = 8)
    @Operation(summary = "当前登录店铺信息",description = "当前登录店铺信息",tags = "店铺管理")
    @GetMapping("/current")
    public Result<Store> storeCurrent(HttpServletRequest request){

        Store store = storeService.detail(request);
        return Result.success(store);
    }

    @Operation(summary = "店铺信息修改",description = "当前登录店铺信息修改",tags = "店铺管理")
    @PutMapping
    public Result<?> update(@RequestBody StoreUpdateRequest storeUpdateRequest, HttpServletRequest request){
        storeService.updateStoreInfo(storeUpdateRequest,request);
        return Result.success();
    }

    //店铺管理 end



    //商品管理
    @ApiOperationSupport(order = 9)
    @Operation(summary = "店铺商品显示",description = "显示自己店铺的商品",tags = "店铺 - 商品管理")
    @GetMapping("/product/list")
    public Result<PageResult<Product>> productList(HttpServletRequest request) {

        Page<Product> productPage = storeService.productList(request);

        return Result.success(PageResultUtil.getPageResult(productPage));
    }

    @Operation(summary = "店铺商品添加",description = "添加商品到自己的店铺, 商品第一次添加,填的的默认规格, 后续可以添加其他规格",tags = "店铺 - 商品管理")
    @PostMapping("/product/add")
    public Result<?> addProduct(
            @RequestBody
            ProductAddRequest request,
            @SessionAttribute(value = STORE_SESSION_KEY)
            @Parameter(hidden = true)
            Store store
    ) {
        return productService.addDefaultSpecs(request,store.getStoreId()) ? Result.success():Result.error("501","添加商品失败");
    }

    @Operation(summary = "店铺商品取消上架/重新上架",description = "店铺商品取消上架/重新上架",tags = "店铺 - 商品管理")
    @PutMapping("/product/sale")
    public Result<?> sale(
            @RequestParam(name= "商品id")
            Integer productId,
            @RequestParam(name= "商品状态码, 1为上架, 0为下架", defaultValue = "1")
            Integer saleStatus
    ) {
        productService.sale(productId,saleStatus);
        return Result.success();
    }

    @ApiOperationSupport(order = 10)
    @Operation(summary = "商品规格显示",description = "查看商品规格",tags = "店铺 - 商品 - 规格管理")
    @Parameter(name = "productId",description = "商品id",in = ParameterIn.PATH)
    @PostMapping("/product/specs/{productId}")
    public Result<PageResult<?>> getSpecs(
            @PathVariable("productId")
            Integer productId
    ) {

        Page<Specs> page = specsService.page(new Page<>(), Wrappers.<Specs>lambdaQuery()
                .eq(Specs::getProductId, productId));

        return Result.success(PageResultUtil.getPageResult(page));
    }

    @Operation(summary = "商品规格添加",description = "给商品添加新的规格",tags = "店铺 - 商品 - 规格管理")
    @Parameter(name = "productId",description = "商品id",in = ParameterIn.PATH)
    @PostMapping("/product/addSpecs/{productId}")
    public Result<?> addSpecs(
            @PathVariable("productId")
            Integer productId,
            @RequestBody
            SpecsAddRequest request
    ) {
        Specs specs = new Specs();
        BeanUtil.copyProperties(request,specs);
        specs.setProductId(productId);
        specsService.save(specs);
        return Result.success();
    }

    @Operation(summary = "商品规格修改",description = "修改商品规格",tags = "店铺 - 商品 - 规格管理")
    @Parameter(name = "productId",description = "规格id",in = ParameterIn.PATH)
    @PutMapping("/product/updateSpecs/{specsId}")
    public Result<?> updateSpecs(
            @PathVariable("specsId")
            Integer specsId,
            @RequestBody
            SpecsAddRequest request
    ) {
        Specs specs = new Specs();
        BeanUtil.copyProperties(request,specs);
        specs.setSpecsId(specsId);
        specsService.updateById(specs);
        return Result.success();
    }

    @Operation(summary = "商品规格删除",description = "删除商品规格",tags = "店铺 - 商品 - 规格管理")
    @Parameter(name = "productId",description = "规格id",in = ParameterIn.PATH)
    @DeleteMapping("/product/deleteSpecs/{specsId}")
    public Result<?> deleteSpecs(
            @PathVariable("specsId")
            Integer specsId
    ){
        return specsService.remove(Wrappers.<Specs>lambdaQuery().
                eq(Specs::getSpecsId,specsId)) ? Result.success() : Result.error("500","删除失败");
    }

    //商品管理end
}
