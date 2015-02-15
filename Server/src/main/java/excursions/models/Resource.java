package excursions.models;

public class Resource {
    private String ID;
    private String Name;
    private int Capacity;
    private String Owner;
    
    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
    
    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }
    public int getCapacity(){
        return Capacity;
    }
    
    public void setOwner(String Owner){
        this.Owner = Owner;
    }
    public String getOwner(){
        return Owner;
    }
}
