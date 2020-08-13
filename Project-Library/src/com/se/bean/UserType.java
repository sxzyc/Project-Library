package com.se.bean;
/**
 * @ClassName: UserType
 * @Description:
 * @author: 赵越超
 * @date: 2020年4月19日 上午11:34:28
 * @param:
 */
public class UserType {
	private int id;
	private String userTypeName;
	private String power;
	
	public UserType() {
		super();
	}

	public UserType(int id, String userTypeName, String power) {
		super();
		this.id = id;
		this.userTypeName = userTypeName;
		this.power = power;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
}
