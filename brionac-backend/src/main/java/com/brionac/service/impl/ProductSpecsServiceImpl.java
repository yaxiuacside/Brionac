package com.brionac.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brionac.entity.domain.ProductSpecs;
import com.brionac.service.ProductSpecsService;
import com.brionac.mapper.ProductSpecsMapper;
import org.springframework.stereotype.Service;

/**
* @author 亚修的小破机
* @description 针对表【product_specs(商品规格表)】的数据库操作Service实现
* @createDate 2023-12-23 01:07:08
*/
@Service
public class ProductSpecsServiceImpl extends ServiceImpl<ProductSpecsMapper, ProductSpecs>
    implements ProductSpecsService {

}




