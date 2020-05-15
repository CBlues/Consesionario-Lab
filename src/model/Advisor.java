package model;
public class Advisor extends Person{
	//Constantes
	public static final int CLIENTS=5;
	//Atributos
	private int sales_quantity;
	//Relaciones
	private Client[] clients;
	//Metodos
	public Advisor(){
		super();
	}

	public Advisor(String name, String last_name, String identification) {
		super(name,last_name,identification);
		this.sales_quantity=0;
		this.clients = new Client[CLIENTS];
	}

	public int getSales_quantity(){
		return sales_quantity;
	}
	
	public void setSales_quantity(int sales_quantity){
		this.sales_quantity=sales_quantity;
	}

	public Client[] getClients(){
		return clients;
	}

}