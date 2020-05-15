package model;
public abstract class Person {
	//Atributos
	private String name;
	private String last_name;
	private String identification;
	
	public Person(String name, String last_name, String identification){
		this.name=name;
		this.last_name=last_name;
		this.identification=identification;
	}
	public Person(){
		name=" ";
		last_name=" ";
		identification=" ";
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getLast_name(){
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name=last_name;
	}
	
	public String getIdentification(){
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification=identification;
	}

}