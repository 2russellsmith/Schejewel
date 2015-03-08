package excursions.models;

public class Resource {
    private int id;
    private String name;
    private Integer capacity = null;
    private int owner_id;
    
	public int getResourceId() {
		return id;
	}
	public void setResourceId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public int getOwnerId() {
		return owner_id;
	}
	public void setOwnerId(int owner_id) {
		this.owner_id = owner_id;
	}
}
