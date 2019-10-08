package com.sen.myshop.service.search.dto;

import java.io.Serializable;

/**
 * @Auther: Sen
 * @Date: 2019/10/6 04:07
 * @Description: 商品搜索结果传输对象
 */
public class TbSearchDto implements Serializable {
    private static final long serialVersionUID = -6365471094054960982L;

    private Long id;
    private String TbItemTile;
    private String TbItemSellPoint;
    private String  TbItemCname;
    private Long TbItemCid;
    private String TbItemDesc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTbItemTile() {
        return TbItemTile;
    }

    public void setTbItemTile(String tbItemTile) {
        TbItemTile = tbItemTile;
    }

    public String getTbItemSellPoint() {
        return TbItemSellPoint;
    }

    public void setTbItemSellPoint(String tbItemSellPoint) {
        TbItemSellPoint = tbItemSellPoint;
    }

    public String getTbItemCname() {
        return TbItemCname;
    }

    public void setTbItemCname(String tbItemCname) {
        TbItemCname = tbItemCname;
    }

    public Long getTbItemCid() {
        return TbItemCid;
    }

    public void setTbItemCid(Long tbItemCid) {
        TbItemCid = tbItemCid;
    }

    public String getTbItemDesc() {
        return TbItemDesc;
    }

    public void setTbItemDesc(String tbItemDesc) {
        TbItemDesc = tbItemDesc;
    }
}
