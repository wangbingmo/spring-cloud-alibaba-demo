package com.example.mallcommon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

// 商品
@TableName("mall_product")
public class Product implements Serializable {
    @TableId
    private Integer pid; //主键
    private String pname; //商品名称
    private Double pprice; //商品价格
    private Integer stock; //库存

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", stock=" + stock +
                '}';
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
