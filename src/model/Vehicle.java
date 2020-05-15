package model;
public abstract class Vehicle{
	//Constantes
	public static final String VEHICLE_NEW="New";
	public static final String VEHICLE_USED="Used";
	//Atributos
	private double total_price;
	private double base_price;
	private String brand;
	private String model;
	private double mileage;
	private double cylinder;
	private String type;
	private String lisence_plate;
	private Client client;
	//Relaciones
	private Soat soat;
	private Mecanical mecanical;
	//Metodos
	public Vehicle(double base_price, String brand, String model, double mileage, double cylinder, String type, String lisence_plate,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		this.total_price=0;
		this.base_price=base_price;
		this.brand=brand;
		this.model=model;
		this.mileage=mileage;
		this.cylinder=cylinder;
		this.type=type;
		this.lisence_plate=lisence_plate;
		this.client=null;
		this.soat=new Soat(priceSoat,yearSoat,coverage_amount);
		this.mecanical=new Mecanical(priceMec,yearMec,gas_level);
	}
	public double getTotal_price(){
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price=total_price;
	}
	public double getBase_price(){
		return base_price;
	}
	public void setBase_price(double base_price) {
		this.base_price=base_price;
	}
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand=brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model){
		this.model=model;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage){
		this.mileage=mileage;
	}
	public double getCylinder(){
		return cylinder;
	}
	public void setCylinder(double cylinder) {
		this.cylinder=cylinder;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getLisence_plate(){
		return lisence_plate;
	}
	public void setLisence_plate(String lisence_plate) {
		this.lisence_plate=lisence_plate;
	}
	public Soat getSoat(){
		return soat;
	}
	public Mecanical getMecanical(){
		return mecanical;
	}
	public Client getClient(){
		return client;
	}
	public void setClient(Client client){
		this.client=client;
	}
}