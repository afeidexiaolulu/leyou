package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author
 * @version 1.00
 * @time 2019/12/27 0027  下午 2:58
 */
@Repository
public interface BrandMapper extends Mapper<Brand> {

    //插入品牌和分类中间表
    @Insert("insert into tb_category_brand(brand_id, category_id) VALUES(#{id},#{cid})")
    void insertCategoryAndBrand(@Param("id") Long id, @Param("cid") Long cid);
}
