package com.zeng.dao.entity;

/**
 * 
 * @author zeng
 */
public class OrderDetail {
	/**
	 *  订单详情表主键ID
	 */
	private Integer id;
	/**
	 *  订单外键
	 */
	private Integer orderId;
	/**
	 *  图书外键
	 */
	private Integer bookId;
	/**
	 *  数量
	 */
	private String number;
	/**
	 *  交易价格
	 */
	private Double tradePrice;
	/**
	 * 订单详情表主键ID
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 订单详情表主键ID
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 订单外键
	 * @param orderId
	 */
	public void setOrderId(Integer orderId){
		this.orderId = orderId;
	}
	
    /**
     * 订单外键
     * @return
     */	
    public Integer getOrderId(){
    	return orderId;
    }
	/**
	 * 图书外键
	 * @param bookId
	 */
	public void setBookId(Integer bookId){
		this.bookId = bookId;
	}
	
    /**
     * 图书外键
     * @return
     */	
    public Integer getBookId(){
    	return bookId;
    }
	/**
	 * 数量
	 * @param number
	 */
	public void setNumber(String number){
		this.number = number;
	}
	
    /**
     * 数量
     * @return
     */	
    public String getNumber(){
    	return number;
    }
	/**
	 * 交易价格
	 * @param tradePrice
	 */
	public void setTradePrice(Double tradePrice){
		this.tradePrice = tradePrice;
	}
	
    /**
     * 交易价格
     * @return
     */	
    public Double getTradePrice(){
    	return tradePrice;
    }
}