package com.atlzq.mybatisplusdemo.service.impl;

import com.atlzq.mybatisplusdemo.entity.Dept;
import com.atlzq.mybatisplusdemo.mapper.DeptMapper;
import com.atlzq.mybatisplusdemo.service.IDeptService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author lzq
 * @since 2023-02-26
 */

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
