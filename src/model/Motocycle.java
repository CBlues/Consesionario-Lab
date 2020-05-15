package model;
import java.time.LocalDate;
public class Motocycle extends Vehicle{
	//Constantes
	public static final String MOTO_STANDAR="Standar";
	public static final String MOTO_SPORT="Sport";
	public static final String MOTO_SCOOTER="Scooter";
	public static final String MOTO_CROSS="Cross";
	//Atributos
	private String moto_type;
	private double cap_tank;
	private double consume_gaso;
	//Metodos
	public Motocycle(double base_price, String brand, String model, double mileage, double cylinder,String type,String lisence_plate,String moto_type,double cap_tank,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		super(base_price,brand,model,mileage,cylinder,type,lisence_plate,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
		this.moto_type=moto_type;
		this.cap_tank=cap_tank;
		this.consume_gaso=gasolineConsume();
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
		int year=LocalDate.now().getYear();
		String dateSoat=super.getSoat().getYear();
		String dateMecanical=super.getSoat().getYear();
		if(type.equals(Vehicle.VEHICLE_NEW)){
			total=base*0.04;
			total_price=total+base+priceSoat+priceMec;
		}
		else if(dateSoat.equals(year) && dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			total=base*0.04;
			total_price=total+base;
			desc=base*0.02;
			total_price=total+base-desc;
		}
		else if(!dateSoat.equals(year) && !dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			total=base*0.04;
			desc=base*0.02;
			total_price=total+base-desc+priceSoat+priceMec+500000;
		}
		else if(!dateSoat.equals(year) && dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			total=base*0.04;
			desc=base*0.02;
			total_price=total+base-desc+priceSoat+priceMec+250000;
		}
		else if(dateSoat.equals(year) && !dateMecanical.equals(year) && type.equals(Vehicle.VEHICLE_USED)){
			total=base*0.04;
			desc=base*0.02;
			total_price=total+base-desc+priceSoat+priceMec+250000;
		}
		super.setTotal_price(total_price);
	}
	
	@Override
	public String toString(){
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
		double priceSoat=super.getSoat().getPrice();
		String yearSoat=super.getSoat().getYear();
		double coverage_amount=super.getSoat().getCoverage_amount();
		String soat=super.getSoat().getSoatCode();
		double priceMec=super.getMecanical().getPrice();
		String yearMec=super.getMecanical().getYear();
		double level_gas=super.getMecanical().getGas_level();
		String mecanical=super.getMecanical().getMecanicalCode();
		if(client!=null){
			return "Cliente: "+id+"Precio Total: "+total_price+"\n"+"Precio base: "+base_price+"\n"+"Marca: "+brand+"\n"+"Modelo: "+model+"\n"+"millas: "+mileage+"\n"+"desplazamiento: "+displacement+"\n"+"Nuevo o usado: "+type+"\n"+"Lisencia y placa: "+lisence_plate+"\n"+"Tipo de moto: "+moto_type+"\n"+"Capacidad: "+cap_tank+"\n"+"Consumo de gasolina: "+consume_gaso+"\n"+"Codigo Soat: "+soat+"\n"+"Precio Soat: "+priceSoat+"\n"+"Año Soat: "+yearSoat+"\n"+"Covertura: "+coverage_amount+"\n"+"Codigo mecanico: "+mecanical+"\n"+"Precio del mecanico: "+priceMec+"\n";
		}
		return "Cliente: "+id+"Precio Total: "+total_price+"\n"+"Precio base: "+base_price+"\n"+"Marca: "+brand+"\n"+"Modelo: "+model+"\n"+"millas: "+mileage+"\n"+"desplazamiento: "+displacement+"\n"+"Nuevo o usado: "+type+"\n"+"Lisencia y placa: "+lisence_plate+"\n"+"Tipo de moto: "+moto_type+"\n"+"Capacidad: "+cap_tank+"\n"+"Consumo de gasolina: "+consume_gaso+"\n"+"Codigo Soat: "+soat+"\n"+"Precio Soat: "+priceSoat+"\n"+"Año Soat: "+yearSoat+"\n"+"Covertura: "+coverage_amount+"\n"+"Codigo mecanico: "+mecanical+"\n"+"Precio del mecanico: "+priceMec+"\n";
	}
	
	public double gasolineConsume(){
		double displacement=super.getCylinder();
		double consume=cap_tank*(displacement/ 90);
		return consume;
	}
	
	public String getMoto_Type(){
		return moto_type;
	}
	
	public void setMoto_Type(String moto_type){
		this.moto_type=moto_type;
	}
	
	public double getCap_tank(){
		return cap_tank;
	}
	
	public void setCap_tank(double cap_tank){
		this.cap_tank=cap_tank;
	}
	
	public double getConsume_Gasolina(){

            return consume_gasolina;
	}
	
	public void setConsume_Gaso(double consume_gasolina){
		this.consume_gaso=consume_gasolina;
	}
}