package excursions.models;

import java.util.Date;
import java.util.Calendar;

//commented out variables were ones that I couldn't understand even after looking at the database
public class Tour {
    private Date StartDate;
    private Date EndDate;
    private int TourTypes;// from my best understanding of the database
    //groups //tourtypeid + ownerid//from the database
    
    public void setStartDate(int year, int month, int day, int hour, int minute){
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        Calendar toSet = Calendar.getInstance();
        
        toSet.set(Calendar.YEAR, year);
	toSet.set(Calendar.MONTH, month);//0 based.  0 - 11
	toSet.set(Calendar.DATE, day);
	toSet.set(Calendar.HOUR_OF_DAY, hour);
	toSet.set(Calendar.MINUTE, minute);
		
	StartDate = toSet.getTime();
    }
    public Date getStartDate(){
        return StartDate;
    }

    public void setEndDate(int year, int month, int day, int hour, int minute){
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        Calendar toSet = Calendar.getInstance();
        
        toSet.set(Calendar.YEAR, year);
	toSet.set(Calendar.MONTH, month);//0 based.  0 - 11
	toSet.set(Calendar.DATE, day);
	toSet.set(Calendar.HOUR_OF_DAY, hour);
	toSet.set(Calendar.MINUTE, minute);
	
	EndDate = toSet.getTime();
		//if(StartDate.compareTo(EndDate) != -1) //then error.  start date should be before end date
    }
    public Date getEndDate(){
        return EndDate;
    }
    
    public void setTourTypes(int TourTypes){
        this.TourTypes = TourTypes;
    }
    public int getTourTypes(){
        return TourTypes;
    }
}
