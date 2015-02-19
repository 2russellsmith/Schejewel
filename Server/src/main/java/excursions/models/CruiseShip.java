package excursions.models;

import java.util.Date;
import java.util.Calendar;

public class CruiseShip {
    private int CruiseLine; // from my best understanding of the database
    private Date ArrivalDate;
    private Date DepartureDate;
    private String Name;
    private int PassengerCount;
    private Date AllAboard;
    private int Dock;// from my best understanding of the database
    private String Voyage;// from my best understanding of the database
    private boolean Settled;
    
    public void setCruiseLine(int CruiseLine){
    	this.CruiseLine = CruiseLine;
    }
    public int getCruiseLine(){
    	return CruiseLine;
    }
    
    public void setDock(int Dock){
    	this.Dock = Dock;
    }
    public int getDock(){
    	return Dock;
    }
    
    public void setVoyage(String Voyage){
    	this.Voyage = Voyage;
    }
    public String getVoyage(){
    	return Voyage;
    }
    
    public Date getArrivalDate() {
	return ArrivalDate;
    }
    public void setArrivalDate(int year, int month, int day, int hour, int minute) {
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        Calendar toSet = Calendar.getInstance();
        
        toSet.set(Calendar.YEAR, year);
	toSet.set(Calendar.MONTH, month);//0 based.  0 - 11
	toSet.set(Calendar.DATE, day);
	toSet.set(Calendar.HOUR_OF_DAY, hour);
	toSet.set(Calendar.MINUTE, minute);
	
	ArrivalDate = toSet.getTime();
    }
	
    public Date getDepartureDate() {
	return DepartureDate;
    }
    public void setDepartureDate(int year, int month, int day, int hour, int minute) {
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        Calendar toSet = Calendar.getInstance();
        
        toSet.set(Calendar.YEAR, year);
	toSet.set(Calendar.MONTH, month);//0 based.  0 - 11
	toSet.set(Calendar.DATE, day);
	toSet.set(Calendar.HOUR_OF_DAY, hour);
	toSet.set(Calendar.MINUTE, minute);
	
	DepartureDate = toSet.getTime();
		//if(ArrivalDate.compareTo(DepartureDate) != -1) //then error.  start date should be before end date    
    }
    public String getName() {
	return Name;
    }
    public void setName(String Name) {
	this.Name = Name;
    }
	
    public int getPassengerCount() {
	return PassengerCount;
    }
    public void setPassengerCount(int PassengerCount) {
	this.PassengerCount = PassengerCount;
    }
	
    public Date getAllAboard() {
	return AllAboard;
    }
    public void setAllAboard(int seconds) {
	this.AllAboard = new Date(seconds);//from departure?  from arrival? database unclear
	//holding off switching to calendar for now
    }
	
    public boolean getSettled() {
	return Settled;
    }
    public void setSettled(boolean settled) {
	Settled = settled;
    }
}
