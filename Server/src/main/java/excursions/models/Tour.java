package excursions.models;

import java.util.Date;

//commented out variables were ones that I couldn't understand even after looking at the database
public class Tour {
    private Date StartDate;
    private Date EndDate;
    private int TourTypes;// from my best understanding of the database
    //groups //tourtypeid + ownerid//from the database
    
    //we can change the granularity of the time we set it with.
    //default is milliseconds, but I don't think we need that kind
    //of accuracy.  If we need minutes, or hours instead, that's just
    //a matter of changing the multiplier in this function
    //btw, the seconds is seconds from "now" as in, when this function
    //was called.  there is probably a better way to handle all of this
    //but until we know more about how we want to do this, I figured this
    //was good enough
    public void setStartDate(int seconds){
        Date today = new Date();
        StartDate = new Date(today.getTime() + seconds * 1000);
    }
    public Date getStartDate(){
        return StartDate;
    }
    
    //This function requires startDate to be set first, that can
    //be changed if it needs to be.  this way forces the end date
    //to be after the start date
    public void setEndDate(int seconds){
        EndDate = new Date(StartDate.getTime() + seconds * 1000);
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
