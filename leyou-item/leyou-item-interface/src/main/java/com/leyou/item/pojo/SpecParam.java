package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author
 * @version 1.00
 * @time 2020/1/2 0002  下午 11:09
 */

@Data
@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private Boolean numeric;
    private String unit;
    private Boolean generic;
    private Boolean searching;
    private String segments;

    // getter和setter ...
}