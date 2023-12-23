package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.ProductType;
import com.brionac.service.ProductTypeService;
import com.brionac.mapper.ProductTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【product_type(商品类别表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType>
    implements ProductTypeService {

}




