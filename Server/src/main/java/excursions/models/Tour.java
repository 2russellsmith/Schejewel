package excursions.models;

import java.util.Calendar;

public class Tour {
    private Calendar StartDate;
    private Calendar EndDate;
    private int TourTypes;//or could be a TourType
    private int OwnerId;
    private int TourId;
    
    public void setStartDate(long millis){
        StartDate = Calendar.getInstance();
        StartDate.setTimeInMillis(millis);
    }
    public long getStartDate(){
        return StartDate.getTimeInMillis();
    }

    public void setEndDate(long millis){
        EndDate = Calendar.getInstance();
        EndDate.setTimeInMillis(millis);;
		//if(StartDate.compareTo(EndDate) != -1) //then error.  start date should be before end date
    }
    public long getEndDate(){//can also return a long representing milliseconds if that's more convienient
        return EndDate.getTimeInMillis();
    }
    
    public void setTourTypes(int TourTypes){
        this.TourTypes = TourTypes;
    }
    public int getTourTypes(){
        return TourTypes;
    }
    
    public void setOwnerId(int OwnerId){
    	this.OwnerId = OwnerId;
    }
    public int getOwnerId(){
    	return OwnerId;
    }
    
    public void setTourId(int TourId){
    	this.TourId = TourId;
    }
    public int getTourId(){
    	return TourId;
    }
}
