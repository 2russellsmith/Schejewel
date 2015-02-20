package excursions.models;

import java.util.Calendar;

public class CruiseShip {
	private int CruiseShipId;
	private int CruiseLineId;//or a CruiseLine
	
	public void setCruiseShipId(int CruiseShipId){
		this.CruiseShipId = CruiseShipId;
	}
	public int getCruiseShipId(){
		return CruiseShipId;
	}
	
	public void setCruiseLineId(int CruiseLineId){
		this.CruiseLineId = CruiseLineId;
	}
	public int getCruiseLineId(){
		return CruiseLineId;
	}
}
