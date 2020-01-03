package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:08
 */

@Data
@Table(name = "tb_spec_group")
public class SpecGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cid;

    private String name;

    @Transient
    private List<SpecParam> params;

}