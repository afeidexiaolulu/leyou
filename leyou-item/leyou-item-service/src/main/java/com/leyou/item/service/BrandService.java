package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2019/12/27 0027  下午 3:35
 */
@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    //分页查询
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {

        Example example = new Example(Brand.class);
        //创建条件
        Example.Criteria criteria = example.createCriteria();
        // 根据name模糊查询，或者根据首字母查询
        if(StringUtils.isNotBlank(key)){
            criteria.andLike("name", "%"+key+"%").orEqualTo("letter",key);
        }
        //添加分页条件
        PageHelper.startPage(page,rows);
        //添加排序条件
        if(StringUtils.isNotBlank(sortBy)){
            //添加排序子句
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }
        List<Brand> brands = brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<Brand>(pageInfo.getTotal(), pageInfo.getList());

    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    public void addBrand(Brand brand, List<Long> cids) {
        //新增品牌
        brandMapper.insertSelective(brand);
        //插入中间表数据
        cids.forEach(cid ->{
            brandMapper.insertCategoryAndBrand(brand.getId(), cid);
        });
    }
}
