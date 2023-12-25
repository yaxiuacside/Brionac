package com.brionac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.*;
import com.brionac.entity.vos.StoreOrderVO;
import com.brionac.service.BrionacOrderService;
import com.brionac.mapper.BrionacOrderMapper;
import com.brionac.service.ProductService;
import com.brionac.service.ShoppingCartService;
import com.brionac.service.SpecsService;
import com.brionac.utils.CommonUtil;
import com.brionac.utils.PageResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 亚修的小破机
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class BrionacOrderServiceImpl extends ServiceImpl<BrionacOrderMapper, BrionacOrder>
    implements BrionacOrderService {

    @Autowired
    ProductService productService;

    @Autowired
    SpecsService specsService;

    @Autowired
    ShoppingCartService shoppingCartService;

    Integer orderNo = 100;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean settlement(List<Integer> cartIds, User user) {
        List<BrionacOrder> brionacOrders = new ArrayList<>();
        cartIds.forEach(cartId ->
                {
                    ShoppingCart cart = shoppingCartService.getById(cartId);
                    //获得商品
                    Product product = productService.getById(cart.getProductId());
                    //获得规格
                    Specs specs = specsService.getById(cart.getSpecsId());
                    //创建订单
                    BrionacOrder brionacOrder = new BrionacOrder();
                    brionacOrder.setOrderNo("o" + orderNo++);
                    brionacOrder.setProductId(cart.getProductId());
                    brionacOrder.setProductNo(product.getProductNo());
                    brionacOrder.setProductSpecs(specs.getSpecsName());
                    brionacOrder.setUserId(user.getUserId());
                    brionacOrder.setUserAccount(user.getAccountNumber());
                    brionacOrder.setUserName(user.getUserName());
                    brionacOrder.setContactWay(user.getTelephone());
                    brionacOrder.setPayPrice(cart.getSpecsPrice());
                    brionacOrder.setPayAmount(cart.getPayAmount());
                    brionacOrder.setAcceptAddress(user.getUserAddress());

                    //订单加入合集
                    brionacOrders.add(brionacOrder);
                }
                );

        return this.saveBatch(brionacOrders);
    }

    @Override
    public Page<StoreOrderVO> getStoreOrder(Store store) {
        //根据店铺id查到店铺的商品
        List<Product> products = productService.list(Wrappers.<Product>lambdaQuery().eq(Product::getStoreId, store.getStoreId()));

        //根据商品id查到对应的订单
        Page<BrionacOrder> page = this.page(new Page<>(), Wrappers.<BrionacOrder>lambdaQuery()
                .in(BrionacOrder::getProductId, products.stream().map(Product::getProductId).collect(Collectors.toList())));

        List<StoreOrderVO> storeOrderVOS = CommonUtil.convertList2List(page.getRecords(), StoreOrderVO.class);

        Page<StoreOrderVO> resultPage = PageResultUtil.listToPage(storeOrderVOS, 1, 10);

        return resultPage;
    }
}




