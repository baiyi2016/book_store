package com.zeng.dao.vo;

/**
 * 
 * @author zeng
 */
public class UserVo {
	/**
	 *  用户主键ID
	 */
	private Integer userId;
	/**
	 *  用户名
	 */
	private String username;
	/**
	 *  密码
	 */
	private String password;
	/**
	 *  用户邮箱
	 */
	private String email;
	/**
	 * 用户主键ID
	 * @param userId
	 */
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
    /**
     * 用户主键ID
     * @return Integer
     */	
    public Integer getUserId(){
    	return userId;
    }
	/**
	 * 用户名
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
    /**
     * 用户名
     * @return String
     */	
    public String getUsername(){
    	return username;
    }
	/**
	 * 密码
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
    /**
     * 密码
     * @return String
     */	
    public String getPassword(){
    	return password;
    }
	/**
	 * 用户邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 用户邮箱
     * @return String
     */	
    public String getEmail(){
    	return email;
    }
}