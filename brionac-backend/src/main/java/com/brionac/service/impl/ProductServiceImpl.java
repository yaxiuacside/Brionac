package com.brionac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Product;
import com.brionac.entity.domain.Specs;
import com.brionac.entity.requests.ProductAddRequest;
import com.brionac.entity.vos.CustomerSpecsVO;
import com.brionac.entity.vos.ProductDetailVO;
import com.brionac.service.ProductService;
import com.brionac.mapper.ProductMapper;
import com.brionac.service.SpecsService;
import com.brionac.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.brionac.common.Common.COMMON_YES;

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

    @Override
    public ProductDetailVO detail(Integer productId) {

        //从数据库查出商品信息
        Product product = this.getById(productId);
        //从数据库查出有关这个商品的规格信息
        List<Specs> list = specsService.list();

        ProductDetailVO vo = new ProductDetailVO();
        BeanUtil.copyProperties(product,vo);
        BeanUtil.copyProperties(list.get(0),vo);

        return vo;
    }

    @Override
    public List<CustomerSpecsVO> getSpecs(Integer productId) {
        //从数据库查出有关这个商品的规格信息
        //再转为VO
        return CommonUtil.convertList2List(specsService.list(Wrappers.<Specs>lambdaQuery()
                .eq(Specs::getProductId, productId)
                .eq(Specs::getSpecsStatus, COMMON_YES)
        ), CustomerSpecsVO.class);
    }
}




