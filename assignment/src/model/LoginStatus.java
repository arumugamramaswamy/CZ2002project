package model;

/**
 * Admin Section - Login Status Codes
 * @version 1.0
 */

public enum LoginStatus {
	
	/**
	 * Successful Login
	 */
	SUCCESSFUL("Login Successfull!"),
	
	/**
	 * Failed Login
	 */
	FAILED("Please enter valid credentials!");
	
	
	private String status;
	
	/**
	 * set status of the announcement
	 * @param status the current status of the change made
	 */
	LoginStatus(String status) {
		this.status = status;
	}
	
	/**
	 * returns the status of the change
	 * @return status of the change
	 */
    public String returningStatus() {
        return status;
    }
	
}

