//package com.msdemo.post.model;
package com.msdemo.model;

public class Posts {
	
	private String postId;
	private String postAttribute;
	
	
	public Posts() {
	
	}


	public Posts(String postId, String postAttribute) {
		super();
		this.postId = postId;
		this.postAttribute = postAttribute;
	}


	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public String getPostAttribute() {
		return postAttribute;
	}


	public void setPostAttribute(String postAttribute) {
		this.postAttribute = postAttribute;
	}
	
	
	
	
	

}
