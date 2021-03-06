package com.example.mallcommon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

// 订单
@TableName("mall_order")
public class Order {
    @TableId
    private Long oid; // 订单id

    // 用户
    private Integer uid; // 用户id
    private String username; // 用户名

    // 商品
    private Integer pid; // 商品id
    private String pname; // 商品名称
    private Double pprice; // 商品单价

    // 数量
    private Integer number; // 购买数量

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", number=" + number +
                '}';
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
