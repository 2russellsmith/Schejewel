package excursions.models;

public class CruiseShip {
	private int id;
	private String name;
	private int cruise_line_id;
	
	public void setCruiseShipId(int CruiseShipId){
		this.id = CruiseShipId;
	}
	public int getCruiseShipId(){
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setCruiseLineId(int CruiseLineId){
		this.cruise_line_id = CruiseLineId;
	}
	public int getCruiseLineId(){
		return cruise_line_id;
	}
}
