package model;
public class Hybrid extends Car implements GasolineConsumable, BatteryConsumable {
	//Atributos
	private double cap_gasol;
	private String type_gaso;
	private double gaso_consume;
	private String charger_type;
	private double duration;
	private double consume_battery;

    public Hybrid(double base_price, String brand, String model, double mileage, double cylinder, String type, String lisence_plate, String car_type, int door_number, boolean polarized, double priceSoat, String yearSoat, double coverage_amount, double priceMec, String yearMec, double gas_level) {
        super(base_price, brand, model, mileage, cylinder, type, lisence_plate, car_type, door_number, polarized, priceSoat, yearSoat, coverage_amount, priceMec, yearMec, gas_level);
    }
	//Metodos
	public Hybrid(String car_type, int door_number, boolean polarized, double cap_gasol, String type_gasol, double gaso_consume, String charger_type, int duration,double consume_battery) {
		super(base_price,brand,model,mileage,cylinder_capacity,type,lisence_plate,car_type,door_number,polarized);
		this.cap_gasol=cap_gasol;
		this.type_gaso=type_gaso;
		this.gaso_consume=gaso_consume;
		this.charger_type=charger_type;
		this.duration=duration;
		this.consume_battery=consume_battery;
	}
	public double getCap_gasol() {
		return cap_gasol;
	}
	public void setCap_gasol(double cap_gasol) {
		this.cap_gasol = cap_gasol;
	}
	public String getType_gaso() {
		return type_gaso;
	}
	public void setType_gaso(String type_gaso) {
		this.type_gaso = type_gaso;
	}

	public double getGaso_consume() {
		return gaso_consume;
	}
	public void setGaso_consume(double gaso_consume) {
		this.gaso_consume = gaso_consume;
	}

	public string getCharger_type() {
		return this.charger_type;
	}
	public void setCharger_type(String charger_type) {
		this.charger_type = charger_type;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getConsume_Battery(){
		return consume_battery;
	}
	public void setConsume_Battery(double consume_battery) {
		this.consume_battery=consume_battery;
	}

    @Override
    public double gasolineConsume() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double batteryConsume() {
        throw new UnsupportedOperationException(); 
    }
}