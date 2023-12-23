package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.Product;
import com.brionac.service.ProductService;
import com.brionac.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【product(商品表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService {

}




