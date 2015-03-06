package excursions.models;

import java.util.List;

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
    public long getStartTime(){
        return start_time;
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
}
