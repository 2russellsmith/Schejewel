package excursions.models;

public class Resource {
    private int ResourceId;
    private String Name;
    private int Capacity;
    private int OwnerId;
    
    public void setResourceId(int ResourceId){
        this.ResourceId = ResourceId;
    }
    public int getResourceId(){
        return ResourceId;
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
    
    public void setOwnerId(int OwnerId){
        this.OwnerId = OwnerId;
    }
    public int getOwnerId(){
        return OwnerId;
    }
}