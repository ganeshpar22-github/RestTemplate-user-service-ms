//package com.msdemo.notification.model;
package com.msdemo.model;

public class Notifications {
	
	public String notificationId;
	public String notificationDescription;
	
	
	public Notifications(String notificationId, String notificationDescription) {
		super();
		this.notificationId = notificationId;
		this.notificationDescription = notificationDescription;
	}
	
	


	public Notifications() {
		super();
		
	}




	public String getNotificationId() {
		return notificationId;
	}


	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}


	public String getNotificationDescription() {
		return notificationDescription;
	}


	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}
	
	
	
	
	

}
