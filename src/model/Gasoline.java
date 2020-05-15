package model;
import java.time.LocalDate;
public class Gasoline extends Car implements GasolineConsumable {
	//Constantes
	public static final String EXTRA="Extra";
	public static final String CORRIENT="Corriente";
	public static final String DIESEL="Diesel";
	//Atributos
	private double cap_tank;
	private String type_gasoline;
	private double gaso_consume;
	//Metodos
	
	public Gasoline(double base_price, String brand, String model, double mileage, double cylinder, String type, String lisence_plate,String car_type, int door_number, boolean polarized, double cap_tank, String type_gasoline,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level) {
		super(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
		this.cap_tank=cap_tank;
		this.type_gasoline=type_gasoline;
		this.gaso_consume=gasolineConsume();
		total_price();
	}
	
	public void total_price(){
		double total_price=0;
		double total=0;
		double desc=0;
		double base=super.getBase_price();
		String type=super.getType();
		double priceSoat=super.getSoat().getPrice();
		double priceMec=super.getMecanical().getPrice();
		int yearDate=LocalDate.now().getYear();
		String year= String.valueOf(yearDate);
		String dateSoat=super.getSoat().getYear();
		String dateMecanical=super.getSoat().getYear();
		if(type.equals(Vehicle.VEHICLE_NEW)){
			total_price=base+priceSoat+priceMec;
		}
		else if(dateSoat.equals(year) && dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			desc=base*0.1;
			total_price=base-desc;
		}
		else if(!dateSoat.equals(year) && !dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			desc=base*0.1;
			total_price=base-desc+500000;
		}
		else if(!dateSoat.equals(year) && dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			desc=base*0.1;
			total_price=base-desc+250000;
		}
		else if(dateSoat.equals(year) && !dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			desc=base*0.1;
			total_price=base-desc+250000;
		}
		super.setTotal_price(total_price);
	}
	
	@Override
	public double gasolineConsume(){
		double displacement=super.getCylinder();
		double consume=cap_tank*(displacement/ 100);
		return consume;
	}
	
	public double getCap_tank(){
		return cap_tank;
	}
	
	public void setCap_tank(double cap_tank){
		this.cap_tank=cap_tank;
	}
	
	public String getType_gasoline(){
		return type_gasoline;
	}
	
	public void setType_gasoline(String type_gasoline) {
		this.type_gasoline=type_gasoline;
	}
	
	public double getGaso_consume(){
		return gaso_consume;
	}
	
	public void setGaso_consume(double gaso_consume){
		this.gaso_consume=gaso_consume;
	}
	
	@Override
	public String toString(){
		String polarized="";
		String id="";
		Client client=super.getClient();
		if(client!=null){
			id=super.getClient().getIdentification();
		}
		double total_price=super.getTotal_price();
		double base_price=super.getBase_price();
		double displacement=super.getCylinder();
		String brand=super.getBrand();
		String model=super.getModel();
		double mileage=super.getMileage();
		String type=super.getType();
		String lisence_plate=super.getLisence_plate();
		String car_type=super.getCar_type();
		int door_number=super.getDoor_number();
		boolean polarizedCar=super.getPolarized();
		double priceSoat=super.getSoat().getPrice();
		String yearSoat=super.getSoat().getYear();
		double coverage_amount=super.getSoat().getCoverage_amount();
		String soat=super.getSoat().getSoatCode();
		double priceMec=super.getMecanical().getPrice();
		String yearMec=super.getMecanical().getYear();
		double level_gas=super.getMecanical().getGas_level();
		String mecanical=super.getMecanical().getMecanicalCode();
		if(polarizedCar==true){
			polarized="Si";
		}
		else{
			polarized="No";
		}
		if (client!=null){
			return "Cliente: "+id+"Precio Total: "+total_price+"\n"+"Precio base: "+base_price+"\n"+"Marca: "+brand+"\n"+"Modelo: "+model+"\n"+"millas: "+mileage+"\n"+"desplazamiento: "+displacement+"\n"+"Nuevo o usado: "+type+"\n"+"Lisencia y placa: "+lisence_plate+"\n"+"Tipo de moto: "+moto_type+"\n"+"Capacidad: "+cap_tank+"\n"+"Consumo de gasolina: "+consume_gaso+"\n"+"Codigo Soat: "+soat+"\n"+"Precio Soat: "+priceSoat+"\n"+"Año Soat: "+yearSoat+"\n"+"Covertura: "+coverage_amount+"\n"+"Codigo mecanico: "+mecanical+"\n"+"Precio del mecanico: "+priceMec+"\n";}
		 return "Cliente: "+id+"Precio Total: "+total_price+"\n"+"Precio base: "+base_price+"\n"+"Marca: "+brand+"\n"+"Modelo: "+model+"\n"+"millas: "+mileage+"\n"+"desplazamiento: "+displacement+"\n"+"Nuevo o usado: "+type+"\n"+"Lisencia y placa: "+lisence_plate+"\n"+"Tipo de moto: "+moto_type+"\n"+"Capacidad: "+cap_tank+"\n"+"Consumo de gasolina: "+consume_gaso+"\n"+"Codigo Soat: "+soat+"\n"+"Precio Soat: "+priceSoat+"\n"+"Año Soat: "+yearSoat+"\n"+"Covertura: "+coverage_amount+"\n"+"Codigo mecanico: "+mecanical+"\n"+"Precio del mecanico: "+priceMec+"\n";}
}