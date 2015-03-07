package excursions.models;

public class CruiseShip {
	private int id;
	private String name;
	private int capacity;
	private int cruise_line_id;
	
	public void setId(int CruiseShipId){
		this.id = CruiseShipId;
	}
	public int getId(){
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}
	
	public void setCruiseLineId(int CruiseLineId){
		this.cruise_line_id = CruiseLineId;
	}
	public int getCruiseLineId(){
		return cruise_line_id;
	}
}
