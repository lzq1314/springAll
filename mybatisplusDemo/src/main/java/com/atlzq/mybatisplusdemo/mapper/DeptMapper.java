package com.atlzq.mybatisplusdemo.mapper;

import com.atlzq.mybatisplusdemo.entity.Dept;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 部门 Mapper 接口
 * </p>
 *
 * @author lzq
 * @since 2023-02-26
 */
@DS("slave_1")
public interface DeptMapper extends BaseMapper<Dept> {

}
