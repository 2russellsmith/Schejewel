package excursions.models;

import java.util.Calendar;

//commented out variables were ones that I couldn't understand even after looking at the database
public class Tour {
    private Calendar StartDate;
    private Calendar EndDate;
    private int TourTypes;// from my best understanding of the database
    //groups //tourtypeid + ownerid//from the database
    
    public void setStartDate(int year, int month, int day, int hour, int minute){
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        StartDate = Calendar.getInstance();
        
        StartDate.set(Calendar.YEAR, year);
	StartDate.set(Calendar.MONTH, month);//0 based.  0 - 11
	StartDate.set(Calendar.DATE, day);
	StartDate.set(Calendar.HOUR_OF_DAY, hour);//24 hour clock. 0 - 23.
	StartDate.set(Calendar.MINUTE, minute);
    }
    public Calendar getStartDate(){//can also return a long representing milliseconds if that's more convienient
        return StartDate;
    }

    public void setEndDate(int year, int month, int day, int hour, int minute){
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        EndDate = Calendar.getInstance();
        
        EndDate.set(Calendar.YEAR, year);
	EndDate.set(Calendar.MONTH, month);//0 based.  0 - 11
	EndDate.set(Calendar.DATE, day);
	EndDate.set(Calendar.HOUR_OF_DAY, hour);//24 hour clock. 0 - 23.
	EndDate.set(Calendar.MINUTE, minute);
		//if(StartDate.compareTo(EndDate) != -1) //then error.  start date should be before end date
    }
    public Calendar getEndDate(){//can also return a long representing milliseconds if that's more convienient
        return EndDate;
    }
    
    public void setTourTypes(int TourTypes){
        this.TourTypes = TourTypes;
    }
    public int getTourTypes(){
        return TourTypes;
    }
}
