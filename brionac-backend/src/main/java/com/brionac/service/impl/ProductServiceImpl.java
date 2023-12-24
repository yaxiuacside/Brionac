package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Specs;
import com.brionac.entity.requests.ProductAddRequest;
import com.brionac.service.ProductService;
import com.brionac.mapper.ProductMapper;
import com.brionac.service.SpecsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author 亚修的小破机
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService {

    @Resource
    SpecsService specsService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addDefaultSpecs(ProductAddRequest request, Integer storeId) {

        Product product = new Product();
        BeanUtil.copyProperties(request, product);
        product.setStoreId(storeId);
        this.save(product);

        //默认规格
        Specs defaltSpecs = new Specs();
        BeanUtil.copyProperties(request,defaltSpecs);
        defaltSpecs.setProductId(product.getProductId());
        specsService.save(defaltSpecs);

        return true;
    }

    @Override
    public boolean sale(Integer productId, Integer saleStatus) {
        //product表的数据修改
        this.update(Wrappers.<Product>lambdaUpdate()
                .eq(Product::getProductId, productId)
                .set(Product::getIsSale, saleStatus));

        return true;
    }
}




