package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.ShoppingCart;
import com.brionac.entity.domain.Specs;
import com.brionac.entity.domain.User;
import com.brionac.entity.requests.AddShoppingCartRequest;
import com.brionac.service.ProductService;
import com.brionac.service.ShoppingCartService;
import com.brionac.mapper.ShoppingCartMapper;
import com.brionac.service.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
* @author 亚修的小破机
* @description 针对表【shopping_cart】的数据库操作Service实现
* @createDate 2023-12-23 01:07:09
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

    @Autowired
    ProductService productService;

    @Autowired
    SpecsService specsService;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    @Override
    public boolean add(AddShoppingCartRequest request, Integer userId, String accountNumber) {

        ShoppingCart shoppingCart = new ShoppingCart();

        BeanUtil.copyProperties(request, shoppingCart);

        Product product = productService.getById(request.getProductId());
        Specs specs = specsService.getById(request.getSpecsId());

        //字段填充
        shoppingCart.setUserId(userId);
        shoppingCart.setAccountNumber(accountNumber);
        shoppingCart.setProductName(product.getProductName());
        shoppingCart.setSpecsImg(specs.getSpecsImg());
        shoppingCart.setProductSpecs(specs.getSpecsName());
        BigDecimal payAmount = new BigDecimal(request.getPayAmount());
        shoppingCart.setSpecsPrice(specs.getSpecsPrice().multiply(payAmount));

        return this.save(shoppingCart);
    }

    @Override
    public Page<ShoppingCart> getCar(User user) {

        //此方法因为有数据库原因 和 无法准确删除订单原因
        /*Page<ShoppingCart> page = new Page<>();
        shoppingCartMapper.getCart(page,user.getUserId());*/

        return this.page(new Page<>(),Wrappers.<ShoppingCart>lambdaQuery().eq(ShoppingCart::getUserId,user.getUserId()));
    }

    @Override
    public boolean updateAmount(Integer cartId, Integer amount) {

        //查询出购物车对应的规格信息, 拿到规格的价钱
        ShoppingCart cart = this.getById(cartId);
        Specs specs = specsService.getById(cart.getSpecsId());

        return this.update(Wrappers.<ShoppingCart>lambdaUpdate()
                .eq(ShoppingCart::getCartId,cartId)
                .set(ShoppingCart::getPayAmount,amount)
                .set(ShoppingCart::getSpecsPrice,specs.getSpecsPrice().multiply(new BigDecimal(amount))));

    }
}




