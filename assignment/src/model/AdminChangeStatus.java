package model;

public enum AdminChangeStatus {
	
	SUCCESSFUL("All changes have been successfully applied."),
	FAILED("Changes failed to be applied."),
	REJECTED("Changes are not allowed to be applied.");
	
	private String status;
	
	AdminChangeStatus(String status) {
		this.status = status;
	}
	
    public String returningStatus() {
        return status;
    }
	
}
