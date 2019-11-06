package model;

public enum AdminChangeStatus {
	
	/**
	 * Announcement when any change made is successful in the Admin Section
	 */
	SUCCESSFUL("All changes have been successfully applied."),
	
	/**
	 * Announcement when any change made is unsuccessful in the Admin Section
	 */
	FAILED("Changes failed to be applied."),
	
	/**
	 * Announcement when any change made is rejected in the Admin Section
	 */
	REJECTED("Changes are not allowed to be applied.");
	
	private String status;
	
	/**
	 * set status
	 * @param status the current status of the change made
	 */
	AdminChangeStatus(String status) {
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
