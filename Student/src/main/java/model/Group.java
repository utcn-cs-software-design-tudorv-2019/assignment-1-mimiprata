package model;

public class Group {
	private int idgroup;
	private String description;
	public Group() {
		
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Group [idgroup=" + idgroup + ", description=" + description + "]";
	}
	
}
