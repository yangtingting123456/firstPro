package edu.ytt.model;

/**
 * ModelUser entity. @author MyEclipse Persistence Tools
 */

public class ModelUser implements java.io.Serializable {

	// Fields

	private String uname;
	private String upw;

	// Constructors

	/** default constructor */
	public ModelUser() {
	}

	/** full constructor */
	public ModelUser(String uname, String upw) {
		this.uname = uname;
		this.upw = upw;
	}

	// Property accessors

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpw() {
		return this.upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

}