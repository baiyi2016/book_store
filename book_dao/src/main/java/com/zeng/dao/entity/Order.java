package com.zeng.dao.entity;

import java.util.List;

/**
 * 
 * @author zeng
 */
public class Order {
	/**
	 *  订单主键ID
	 */
	private String orderId;
	/**
	 *  用户的外键
	 */
	private Integer userId;
	/**
	 *  创建时间
	 */
	private java.util.Date createTime;
	/**
	 *  订单价格
	 */
	private Double orderPrice;
	/**
	 *  订单状态
	 */
	private String orderStatus;
	/**
	 * 订单主键ID
	 * @param orderId
	 */

	private List<OrderDetail> orderDetailList;

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
    /**
     * 订单主键ID
     * @return
     */	
    public String getOrderId(){
    	return orderId;
    }
	/**
	 * 用户的外键
	 * @param userId
	 */
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
    /**
     * 用户的外键
     * @return
     */	
    public Integer getUserId(){
    	return userId;
    }
	/**
	 * 创建时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 创建时间
     * @return
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
	/**
	 * 订单价格
	 * @param orderPrice
	 */
	public void setOrderPrice(Double orderPrice){
		this.orderPrice = orderPrice;
	}
	
    /**
     * 订单价格
     * @return
     */	
    public Double getOrderPrice(){
    	return orderPrice;
    }
	/**
	 * 订单状态
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus){
		this.orderStatus = orderStatus;
	}
	
    /**
     * 订单状态
     * @return
     */	
    public String getOrderStatus(){
    	return orderStatus;
    }
}