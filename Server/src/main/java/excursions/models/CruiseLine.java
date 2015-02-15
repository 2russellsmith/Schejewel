package excursions.models;

//this wasn't in the schema, and looking at the data base,
//this seems to just be a name

public class CruiseLine {
    private String Name;
    
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
}
