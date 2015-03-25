package excursions.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Tour {
	private int id;
	private int owner_id;
	private long start_time;
    private int tour_type_id;
	private int status_id;
    private List<Resource> resources;
    
    public void setStartTime(long millis){
        start_time = millis;
    }
	public void setStartTime(Date date, Time time) {
		start_time = date.getTime() + timeToMillis(time);
	}
    public long getStartTimeInMillis(){
        return start_time;
    }
	public String getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(start_time);
        return sdf.format(calendar.getTime());
    }
    public String getStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSSSSS");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(start_time);
        return sdf.format(calendar.getTime());
    }
    
    public void setTourTypeId(int id){
        tour_type_id = id;
    }
    public int getTourTypeId(){
        return tour_type_id;
    }
    
    public void setOwnerId(int id){
    	owner_id = id;
    }
    public int getOwnerId(){
    	return owner_id;
    }
    
    public void setTourId(int TourId){
    	this.id = TourId;
    }
    public int getTourId(){
    	return id;
    }

	public int getStatusId() {
		return status_id;
	}
	
	public void setStatusId(int id) {
		status_id = id;
	}
	
    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
	
	private long timeToMillis(Time time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (long)(hour * 3600 + min * 60 + sec) * 1000;
	}
}
