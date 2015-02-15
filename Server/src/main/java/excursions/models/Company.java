package excursions.models;

//does this need to import Resources and Tours?
//I think it's fine because they are in the same
//package.  Projects that I run on my environment
//don't need imports if it's referencing things from
//the same package
import java.util.ArrayList;

public class Company {
    private ArrayList<Resource> Resources;
    private ArrayList<Tour> Tours;
    
    //I suspect that JSON doesn't know how to do this, so this
    //will probably need to be changed
    public void setResources(ArrayList<Resource> Resources){
        this.Resources = new ArrayList<Resource>(Resources);
    }
    public ArrayList<Resource> getResources(){
        return Resources;
    }
    
    public void setTours(ArrayList<Tour> Tours){
        this.Tours = new ArrayList<Tour>(Tours);
    }
    public ArrayList<Tour> getTours(){
        return Tours;
    }
}
