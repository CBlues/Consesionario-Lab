package model;
import java.util.ArrayList;
public class Client extends Person {
	//Atributos
	private String phone_number;
	private String mail;
	//Relaciones
	private ArrayList<Vehicle>interest;
	//Metodos
	public Client(){
		super();
	}
	
	public Client(String name, String last_name, String identification, String phone_number, String mail) {
		super(name,last_name,identification);
		this.phone_number=phone_number;
		this.mail=mail;
		this.interest=new ArrayList<Vehicle>();
	}
	
	public String getPhone_number(){
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number=phone_number;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail=mail;
	}
	
	public ArrayList<Vehicle> getInterest(){
		return interest;
	}
}