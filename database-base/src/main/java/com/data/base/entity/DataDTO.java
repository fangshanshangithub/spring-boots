package com.data.base.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DataDTO implements Serializable {

    private Integer id;

    private Integer orderDetailId;


    private Integer refundStatus;

    private BigDecimal coursePrice;

    private BigDecimal favourablePrice;

    private Integer bId;

    private Date dateStartTime;

    private Date dateEndTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    public BigDecimal getFavourablePrice() {
        return favourablePrice;
    }

    public void setFavourablePrice(BigDecimal favourablePrice) {
        this.favourablePrice = favourablePrice;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Date getDateStartTime() {
        return dateStartTime;
    }

    public void setDateStartTime(Date dateStartTime) {
        this.dateStartTime = dateStartTime;
    }

    public Date getDateEndTime() {
        return dateEndTime;
    }

    public void setDateEndTime(Date dateEndTime) {
        this.dateEndTime = dateEndTime;
    }
}
