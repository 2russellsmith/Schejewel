package excursions.models;

public class Company {
    private int CompanyId;
    private String Name;
    
    public void setCompaynId(int CompanyId){
        this.CompanyId = CompanyId;
    }
    public int getCompanyId(){
        return CompanyId;
    }
    
    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return Name;
    }
}
