package excursions.models;

import java.util.ArrayList;

public class TourGroup {
	private int TourGroupId;
	private int PortageId;//or Portage
	private int TourId;//or Tour
    private int GroupSize;
    private boolean Settled;
    
    public void setTourGroupId(int TourGroupId){
    	this.TourGroupId = TourGroupId;
    }
    public int getTourGroupId(){
    	return TourGroupId;
    }
	
    public void setPortageId(int PortageId){
    	this.PortageId = PortageId;
    }
    public int getPortageId(){
    	return PortageId;
    }
    
    public setTourId(int TourId){
    	this.TourId = TourId;
    }
    public getTourId(){
    	return TourId;
    }
    
	public void setGroupSize(int GroupSize){
	    this.GroupSize = GroupSize;
	}
	public int getGroupSize(){
	    return GroupSize;
	}
	
    public boolean getSettled() {
    	return Settled;
    }
    public void setSettled(boolean Settled) {
    	this.Settled = Settled;
    }
}
