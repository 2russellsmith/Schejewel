package excursions.models;

import java.sql.Timestamp;

public class Portage {
	private int portageId;
    private int cruiseShipId;
    private long arrival;
    private long departure;
    private String Name;
    private Integer passengerCount = null;
    private Long allAboard = null;
    private Integer dock = null;
    private String voyage = null;
   
    public void setPortageId(int PortageId){
    	this.portageId = PortageId;
    }
    public int getPortageId(){
    	return portageId;
    }
    
    public void setCruiseShipId(int CruiseShipId){
    	this.cruiseShipId = CruiseShipId;
    }
    public int getCruiseShipId(){
    	return cruiseShipId;
    }
    
    public void setDock(Integer Dock){
    	this.dock = Dock;
    }
    public Integer getDock(){
    	return dock;
    }
    
    public void setVoyage(String Voyage){
    	this.voyage = Voyage;
    }
    public String getVoyage(){
    	return voyage;
    }
    
    public long getArrival() {
    	return arrival;
    }
	public Timestamp getArrivalSQL() {
		return new Timestamp(arrival);
	}
    public void setArrival(long millis) {
        arrival = millis;
    }
	public void setArrivalSQL(Timestamp ts) {
		arrival = ts.getTime();
	}
	
    public long getDeparture() {
    	return departure;
    }
	public Timestamp getDepartureSQL() {
		return new Timestamp(departure);
	}
    public void setDeparture(long millis) {
        departure = millis;
    }
	public void setDepartureSQL(Timestamp ts) {
		departure = ts.getTime();
	}
    
    public String getName() {
    	return Name;
    }
    public void setName(String Name) {
    	this.Name = Name;
    }
	
    public Integer getPassengerCount() {
    	return passengerCount;
    }
    public void setPassengerCount(Integer PassengerCount) {
    	this.passengerCount = PassengerCount;
    }
	
    public Long getAllAboard() {
    	return allAboard;
    }
	public Timestamp getAllAboardSQL() {
		if (allAboard == null)
			return null;
		return new Timestamp(allAboard);
	}
    public void setAllAboard(Long millis) {
    	allAboard = millis;
    }
	public void setAllAboardSQL(Timestamp ts) {
		if (ts == null)
			allAboard = null;
		else
			allAboard = ts.getTime();
	}
}
