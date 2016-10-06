package com.zeng.dao.vo;

/**
 * 
 * @author zeng
 */
public class BookVo {
	/**
	 *  书的主键ID
	 */
	private Integer bookId;
	/**
	 *  书名
	 */
	private String bookName;
	/**
	 *  库存
	 */
	private String bookStorage;
	/**
	 *  价格
	 */
	private String bookPrice;
	/**
	 *  图片地址
	 */
	private String bookImgUrl;
	/**
	 * 书的主键ID
	 * @param bookId
	 */
	public void setBookId(Integer bookId){
		this.bookId = bookId;
	}
	
    /**
     * 书的主键ID
     * @return Integer
     */	
    public Integer getBookId(){
    	return bookId;
    }
	/**
	 * 书名
	 * @param bookName
	 */
	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	
    /**
     * 书名
     * @return String
     */	
    public String getBookName(){
    	return bookName;
    }
	/**
	 * 库存
	 * @param bookStorage
	 */
	public void setBookStorage(String bookStorage){
		this.bookStorage = bookStorage;
	}
	
    /**
     * 库存
     * @return String
     */	
    public String getBookStorage(){
    	return bookStorage;
    }
	/**
	 * 价格
	 * @param bookPrice
	 */
	public void setBookPrice(String bookPrice){
		this.bookPrice = bookPrice;
	}
	
    /**
     * 价格
     * @return String
     */	
    public String getBookPrice(){
    	return bookPrice;
    }
	/**
	 * 图片地址
	 * @param bookImgUrl
	 */
	public void setBookImgUrl(String bookImgUrl){
		this.bookImgUrl = bookImgUrl;
	}
	
    /**
     * 图片地址
     * @return String
     */	
    public String getBookImgUrl(){
    	return bookImgUrl;
    }
}