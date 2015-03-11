
package excursions.models;

import java.sql.Timestamp;

public class ResourceSchedule {
	int resourceId;
	int tourId;
	long startTime;
	int duration;
	int statusId;
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
	public int getTourId() {
		return tourId;
	}
	public void setTourId(int tourId) {
		this.tourId = tourId;
	}
	
	public long getStartTime() {
		return startTime;
	}
	public Timestamp getStartTimeSQL() {
		return new Timestamp(startTime);
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public void setStartTimeSQL(Timestamp ts) {
		startTime = ts.getTime();
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
}
