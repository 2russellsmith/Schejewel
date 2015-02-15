package excursions.models;

import java.util.Date;

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
    public void setArrivalDate(int seconds) {
	Date today = new Date();
	this.ArrivalDate = new Date(today.getTime() + seconds * 1000);
    }
	
    public Date getDepartureDate() {
	return DepartureDate;
    }
    public void setDepartureDate(int seconds) {
	this.DepartureDate = new Date(ArrivalDate.getTime() + seconds * 1000);
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
    }
	
    public boolean getSettled() {
	return Settled;
    }
    public void setSettled(boolean settled) {
	Settled = settled;
    }
}
