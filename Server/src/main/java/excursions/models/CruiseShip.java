package excursions.models;

import java.util.Date;


//variables that I was unsure about in the schema are "included" as comments
public class CruiseShip {
    //cruiseLine
    private Date ArrivalDate;
    private Date DepartureDate;
    private String Name;
    private int PassengerCount;
    private boolean AllAboard;
    //Dock
    //Voyage
    private boolean Settled;
    
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
	
	public boolean getAllAboard() {
		return AllAboard;
	}
	public void setAllAboard(boolean AllAboard) {
		this.AllAboard = AllAboard;
	}
	
	public boolean getSettled() {
		return Settled;
	}
	public void setSettled(boolean settled) {
		Settled = settled;
	}
}
