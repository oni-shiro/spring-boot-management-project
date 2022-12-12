package com.sinchan.hibernateproject.workflow.dto;

import java.util.List;
import java.util.Map;



public class NewBookReq {
    private List<String> orderDetails;
    private Integer holdingPeriod;
    @Override
    public String toString() {
        return "NewBookReq [orderDetails=" + orderDetails + ", holdingPeriod=" + holdingPeriod + "]";
    }
    public NewBookReq() {
        super();
        // TODO Auto-generated constructor stub
    }
    public NewBookReq(List<String> orderDetails, Integer holdingPeriod) {
        super();
        this.orderDetails = orderDetails;
        this.holdingPeriod = holdingPeriod;
    }
    public List<String> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<String> orderDetails) {
        this.orderDetails = orderDetails;
    }
    public Integer getHoldingPeriod() {
        return holdingPeriod;
    }
    public void setHoldingPeriod(Integer holdingPeriod) {
        this.holdingPeriod = holdingPeriod;
    }
    
    

}
