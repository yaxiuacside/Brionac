package com.brionac.utils;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brionac.common.PageResult;

/**
 * @author 亚修的小破机
 * Description:
 * ClassName: PageResultUtil
 * date: 2023/12/24
 */
public class PageResultUtil<T> {
    public static<T> PageResult<T> getPageResult(Page<T> page){
        PageResult<T> pageResult = new PageResult<>();
        BeanUtil.copyProperties(page,pageResult);
        return pageResult;
    }
}
