package excursions.models;

public class TourGroup {
	private int TourGroupId;
	private int PortageId;
	private int TourId;
    private int GroupSize;
    private Boolean Settled = null;
    
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
    
    public void setTourId(int TourId){
    	this.TourId = TourId;
    }
    public int getTourId(){
    	return TourId;
    }
    
	public void setGroupSize(int GroupSize){
	    this.GroupSize = GroupSize;
	}
	public int getGroupSize(){
	    return GroupSize;
	}
	
    public Boolean getSettled() {
    	return Settled;
    }
    public void setSettled(Boolean Settled) {
    	this.Settled = Settled;
    }
}
