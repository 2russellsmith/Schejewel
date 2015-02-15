package excursions.models;

//it this a combination of tourtype and groups?
//this is the assumption that was made, and was
//implemented as such
import java.util.ArrayList;

public class TourGroup {
    //Todo: This needs to be implemented
    //from tour type
    private String Name;
    private ArrayList<Resource> ResourceList;
    //from groups
    private String Purchaser;//this might need to be a class based on the schema
    private int PeopleCount;
    //the database also includes settled here
    
    public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public void setResourceList(ArrayList<Resource> ResourceList){
	    this.ResourceList = new ArrayList<Resource>(ResourceList);
	}
	public ArrayList<Resource> getResourceList(){
	    return ResourceList;
	}
	
	public void setPurchaser(String Purchaser){
	    this.Purchaser = Purchaser;
	}
	public String getPurchaser(){
	    return Purchaser;
	}
	
	public void setPeopleCount(int PeopleCount){
	    this.PeopleCount = PeopleCount;
	}
	public int getPeopleCount(){
	    return PeopleCount;
	}
}
