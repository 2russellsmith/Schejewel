package excursions.models;

import java.util.Calendar;

public class Portage {
	private int PortageId;
    private int CruiseShipId; //or CruiseShip
    private Calendar ArrivalDate;
    private Calendar DepartureDate;
    private String Name;
    private int PassengerCount;
    private Calendar AllAboard;
    private int Dock;
    private String Voyage;
   
    public void setPortageId(int PortageId){
    	this.PortageId = PortageId;
    }
    public int getPortageId(){
    	return PortageId;
    }
    
    public void setCruiseShipId(int CruiseShipId){
    	this.CruiseShipId = CruiseShipId;
    }
    public int getCruiseShipId(){
    	return CruiseShipId;
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
    
    public long getArrivalDate() {
    	return ArrivalDate.getTimeInMillis();
    }
    public void setArrivalDate(long millis) {
        ArrivalDate = Calendar.getInstance();   
        ArrivalDate.setTimeInMillis(millis);
    }
	
    public long getDepartureDate() {
    	return DepartureDate.getTimeInMillis();
    }
    public void setDepartureDate(long millis) {
        DepartureDate = Calendar.getInstance();
        DepartureDate.setTimeInMillis(millis);
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
	
    public long getAllAboard() {
    	return AllAboard.getTimeInMillis();
    }
    public void setAllAboard(long millis) {
    	AllAboard = Calendar.getInstance();
        AllAboard.setTimeInMillis(millis);
    }
}
