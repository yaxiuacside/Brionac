package com.brionac.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.entity.domain.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 亚修的小破机
* @description 针对表【shopping_cart】的数据库操作Mapper
* @createDate 2023-12-23 01:07:09
* @Entity generator.domain.ShoppingCart
*/
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {


    Page<ShoppingCart> getCart(@Param("page") IPage page, @Param("userId") Integer userId);

}




