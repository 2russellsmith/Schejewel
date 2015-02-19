package excursions.models;

import java.util.Calendar;

public class CruiseShip {
    private int CruiseLine; // from my best understanding of the database
    private Calendar ArrivalDate;
    private Calendar DepartureDate;
    private String Name;
    private int PassengerCount;
    private Calendar AllAboard;
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
    
    public Calendar getArrivalDate() {
	return ArrivalDate;
    }
    public void setArrivalDate(int year, int month, int day, int hour, int minute) {
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        ArrivalDate = Calendar.getInstance();
        
        ArrivalDate.set(Calendar.YEAR, year);
	ArrivalDate.set(Calendar.MONTH, month);//0 based.  0 - 11
	ArrivalDate.set(Calendar.DATE, day);
	ArrivalDate.set(Calendar.HOUR_OF_DAY, hour);//24 hour clock. 0 - 23.
	ArrivalDate.set(Calendar.MINUTE, minute);
    }
	
    public Calendar getDepartureDate() {
	return DepartureDate;//.getTimeInMillis(); if you'd rather get just a number, also for storing in the db
	//there is a corresponding .setTimeInMillis(long); for setting the time pulled from the db stored in such a manner
    }
    public void setDepartureDate(int year, int month, int day, int hour, int minute) {
        //numbers roll over, they don't throw errors.  i.e. 74 minutes will be 
        //translated to 1 more hour and 14 minutes
        DepartureDate = Calendar.getInstance();
        
        DepartureDate.set(Calendar.YEAR, year);
	DepartureDate.set(Calendar.MONTH, month);//0 based.  0 - 11
	DepartureDate.set(Calendar.DATE, day);
	DepartureDate.set(Calendar.HOUR_OF_DAY, hour);//24 hour clock. 0 - 23.
	DepartureDate.set(Calendar.MINUTE, minute);
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
	
    public Calendar getAllAboard() {
	return AllAboard;
    }
    public void setAllAboard(int year, int month, int day, int hour, int minute) {
	AllAboard = Calendar.getInstance();//what does AllAboard mean? database unclear
	
        AllAboard.set(Calendar.YEAR, year);
	AllAboard.set(Calendar.MONTH, month);//0 based.  0 - 11
	AllAboard.set(Calendar.DATE, day);
	AllAboard.set(Calendar.HOUR_OF_DAY, hour);//24 hour clock. 0 - 23.
	AllAboard.set(Calendar.MINUTE, minute);
    }
	
    public boolean getSettled() {
	return Settled;
    }
    public void setSettled(boolean settled) {
	Settled = settled;
    }
}
