package com.softserve.academy.entity;


public class ItemEntity{

	
	private Long id;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String title;
    private String description;
    private String userlogin;
    
    public ItemEntity(Long id) {
    	this.id = id;
    }
    
    
	public ItemEntity(String title, String description, String userlogin) {
		this.title = title;
		this.description = description;
		this.userlogin = userlogin;
	}
	public ItemEntity(Long id,String title, String description, String userlogin) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.userlogin = userlogin;
	}
	
	public ItemEntity() {}
	
	// setters

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserlogin(String userId) {
		this.userlogin = userId;
	}

	// getters

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getUserlogin() {
		return userlogin;
	}
	
	//To string 

	@Override
	public String toString() {
		return "ItemEntity [title=" + title + ", description=" + description + ", userlogin=" + userlogin + "]";
	}
	    
}
