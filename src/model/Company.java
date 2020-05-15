package model;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Company {
	//Constants
	public static final int SELLERS=10;
	public static final int ROW=10;
	public static final int COLUMN=5;
	//Atributes
	private String name;
	private String nit;
	private double total_earnings;
	private double sales_number;
	private Advisor[] sellers;
	private ArrayList<Vehicle>vehicles;
	private ArrayList<Client>waitingClients;
	private Vehicle [][]parkingLot;
	//Methods
	public Company(String name, String nit) {
		this.name=name;
		this.nit=nit;
		this.total_earnings=0;
		this.sales_number=0;
		this.sellers = new Advisor[SELLERS];
		this.vehicles=new ArrayList<Vehicle>();
		this.waitingClients=new ArrayList<Client>();
		this.parkingLot= new Vehicle[COLUMN][ROW];
	}
	/** getName
	     * Method to provide the name of the company
	     * @return String name of the company
	     */
	public String getName(){
		return name;
	}
	/** setName
	     * Method to changes the name of the company
	     * @param numName -name of the company-!= null
	     */
	public void setName(String name) {
		this.name = name;
	}
	/** getNit
	     * Method to provide the nit of the company
	     * @return String nit of the company
	     */
	public String getNit() {
		return nit;
	}
	/** setNit
	     * Method to changes the nit of the company
	     * @param nit -nit of the company-!= null
	     */
	public void setNit(String nit){
		this.nit = nit;
	}
	/** getTotal_earnings
	     * Method to provide the toal earnings of the company
	     * @return double total earnings
	     */
	public double getTotal_earnings(){
		return total_earnings;
	}
	/** setTotal_earnings
	     * Method to changes the total earnings of the company
	     * @param total_earnings -total earnings of the company-!= null
	     */
	public void setTotal_earnings(double total_earnings) {
		this.total_earnings = total_earnings;
	}
	/** getSales_number
	     * Method to provide the sales number
	     * @return double sales number
	     */
	public double getSales_number(){
		return sales_number;
	}
	/** setSales_number
	     * Method to changes the sales number of the company
	     * @param sales_number -sales number of the company-!= null
	     */
	public void setSales_number(double sales_number) {
		this.sales_number = sales_number;
	}
	/** getVehicles
	     * Method to provide the vehicles of the company
	     * @return Arraylist<Vehicle> vehicles of the company
	     */
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	/** searchAdvisor
	     *Method used to search for an advisor in the corresponding array.
	     * post:Advisor object created in the client array.
	     * @param identification -advisor identification-!= null
	     * @return Advisor searchAdvisor null or not if find it.
	     */
	public Advisor searchAdvisor(String identification){
	Advisor searchAdvisor=null;
	boolean find=false;
	for (int s=0;s<SELLERS&&find==false;s++){
		if(sellers[s]!=null){
			if (sellers[s].getIdentification().equals(identification)){
			searchAdvisor=sellers[s];
			find=true;
			}
		}
	}
		return searchAdvisor;
    }
     /** addAdvisor
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param identification - advisor identification-!= null
	     * @param name - advisor name to enter - != null
	     * @param last_name - advisor las name to enter - != null
	     * @return String with the operation message
	     */
    public String addAdvisor(String name, String last_name, String identification)
	{   String message="";
		boolean add=false;
	    Advisor search=searchAdvisor(identification);
	    if (search!=null){
	    	message="Error. Avisor already exists.";
	    }
	    else
	    {
	   		for (int s=0;s<SELLERS&&add==false;s++){
	    		if (sellers[s]==null){
	    			sellers[s]=new Advisor(name,last_name,identification);
	    			add=true;
	    			message="The new advisor was successfully registered.";
	    	}
	    }
	    	if (add==false){
	    	message="Error.Cannot register more advisors";
	    	}
	    }
        return message;
	}
	/** searchClient
	     *Method used to search for a client in the corresponding array.
	     * post:Client object created in the client array.
	     * @param identification -client identification-!= null
	     * @return Client searchClient null or not if find it.
	     */
	public Client searchClient(String identification){
	Client searchClient=null;
	boolean find=false;
	boolean search=false;
	for(int s=0;s<SELLERS&&find==false;s++){
		if(sellers[s]!=null){
			Client []clients=new Client[Advisor.CLIENTS];
			clients=sellers[s].getClients();
			for(int m=0;m<Advisor.CLIENTS&&search==false;m++){
				if(clients[m]!=null){
					if(clients[m].getIdentification().equals(identification)){
						searchClient=clients[m];
						search=true;
						find=true;
					}
				}
			}	
		}
	}
		return searchClient;
    }
    /** addClient
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param identification - client identification-!= null
	     * @param name - client name to enter - != null
	     * @param last_name - client las name to enter - != null
	     * @param phone_number - client number - != null
	     * @param mail - client mail - != null
	     * @return String with the operation message
	     */
    public String addClient(String name, String last_name, String identification, String phone_number, String mail)
	{   String message="";
		boolean add=false;
	    Client search=searchClient(identification);
	    if (search!=null){
	    	message="Error. Client already exists.";
	    }
	    else{
	   		for (int m=0;m<SELLERS&& add==false;m++){
	   			if (sellers[m]!=null){
	   				Client []clients=new Client[Advisor.CLIENTS];
					clients=sellers[m].getClients();
					for(int s=0;s<Advisor.CLIENTS;s++){
						if(clients[s]==null){
	    					clients[s]=new Client(name,last_name,identification,phone_number,mail);
	    					add=true;
	    				}
	    			}
	    		}
	    	}
	    if(add==true){
	    	message="The new client was successfully registered.";
	    }
	    else{
	    	Client clients=new Client(name,last_name,identification,phone_number,mail);
	    	waitingClients.add(clients);
	    	}
	    }
        return message;
	}
	/** searchVehicle
	     *Method used to search for a vehicle existing or not
	     * @param lisence_plate -lisence plate of the vehicle-!= null
	     * @return boolean true if find it, false if not.
	     */
	public boolean searchVehicle(String lisence_plate){
	boolean searchVehicle=false;
	boolean find=false;
	for (int s=0;s<vehicles.size()&&find==false;s++){
		if(vehicles.get(s)!=null){
			if(vehicles.get(s).getLisence_plate().equals(lisence_plate)){
			searchVehicle=true;
			find=true;
			}
		}
	}
		return searchVehicle;
    }
    /** addVehicle
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param base_price - base price of the motocycle -!= null
	     * @param brand - brand of the motocycle - != null
	     * @param model - model of the motocycle- != null
	     * @param mileage - mileage of the motocycle- != null
	     * @param cylinder - cylinder of the motocycle- != null
	     * @param type - type of the motocycle(new or used)-!= null
	     * @param lisence_plate - lisence plate of the motocycle - != null
	     * @param moto_type - type of the motocycle - != null
	     * @param cap_tank - capacity of the tank - != null
	     * @param priceSoat - Soat price of the motocycle- !=null
	     * @param yearSoat - Soat year of the motocycle-!= null
	     * @param coverage_amout - coverage amount of the motocycle - != null
	     * @param priceMec - mechanical techno review price of the motocycle - != null
	     * @param yearMec - mechanical techno review year- != null
	     * @param level_gas - level gas of the motocycle - != null
	     * @return String with the operation message
	     */
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String moto_type,double cap_tank,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		if(add==false || lisence_plate.equals("Not assigned")){
			Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
			this.vehicles.add(vehicles);
			find=true;
			}
		if(find==true){
			message="The vehicle has been successfully registered";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	/** addVehicle
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param base_price - base price of the gasoline car -!= null
	     * @param brand - brand of the gasoline car- != null
	     * @param model - model of the gasoline car- != null
	     * @param mileage - mileage of the gasoline car- != null
	     * @param cylinder - cylinder of the gasoline car- != null
	     * @param type - type of the gasoline car(new or used)-!= null
	     * @param lisence_plate - lisence plate of the gasoline car - != null
	     * @param car_type - type of the gasoline car- != null
	     * @param door_number - door numbers of the gasoline car- != null
	     * @param polarized - if the gasoline car if polarized- != null
	     * @param cap_tank - capacity of tank - != null
	     * @param type_gasoline- gasoline type of the car - !=null
	     * @param priceSoat - Soat price of the gasoline- !=null
	     * @param yearSoat - Soat year of the gasoline car-!= null
	     * @param coverage_amout - coverage amount of the gasoline car - != null
	     * @param priceMec - mechanical techno review price of the gasoline car - != null
	     * @param yearMec - mechanical techno review year- != null
	     * @param level_gas - level gas of the gasoline car - != null
	     * @return String with the operation message
	     */
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,double cap_tank,String type_gasoline,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		Scanner lector = new Scanner (System.in);
		boolean find=false;
		boolean add=false;
		boolean park=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[0][m]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[0][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[1][m]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[1][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[2][m]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[2][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[3][m]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[3][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[4][m]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[4][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
					Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
					this.vehicles.add(vehicles);
					find=true;
			}
		if(add==false && park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	/** addVehicle
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param base_price - base price of the electric car -!= null
	     * @param brand - brand of the electric car- != null
	     * @param model - model of the electric car- != null
	     * @param mileage - mileage of the electric car- != null
	     * @param cylinder - cylinder of the electric car- != null
	     * @param type - type of the electric car(new or used)-!= null
	     * @param lisence_plate - lisence plate of the electric car - != null
	     * @param car_type - type of the electric car- != null
	     * @param door_number - door numbers of the electric car- != null
	     * @param polarized - if the electric car if polarized- != null
	     * @param priceSoat - client mail - !=null
	     * @param charger_type - charger type oh the battery- != null
	     * @param duration- duration of the battery- !=null
	     * @param priceSoat - Soat price of the electric car- !=null
	     * @param yearSoat - Soat year of the electric car-!= null
	     * @param coverage_amout - coverage amount of the electric car - != null
	     * @param priceMec - mechanical techno review price of the electric car - != null
	     * @param yearMec - mechanical techno review year- != null
	     * @param level_gas - level gas of the electric car - != null
	     * @return String with the operation message
	     */
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,String charger_type,double duration,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		boolean park=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[0][m]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[0][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[1][m]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[1][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[2][m]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[2][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[3][m]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[3][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[4][m]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[4][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
				Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
				this.vehicles.add(vehicles);
				find=true;
			}
		if(add==false && park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	/** addVehicle
	     * Method used to create a new client. 
	     * pre: Existing client arrangement. 
	     * @param base_price - base price of the hybrid car -!= null
	     * @param brand - brand of the hybrid car- != null
	     * @param model - model of the hybrid car- != null
	     * @param mileage - mileage of the hybrid car- != null
	     * @param cylinder - cylinder of the hybrid car- != null
	     * @param type - type of the hybrid car(new or used)-!= null
	     * @param lisence_plate - lisence plate of the hybrid car - != null
	     * @param car_type - type of the hybrid car- != null
	     * @param door_number - door numbers of the hybrid car- != null
	     * @param polarized - if the hybrid car if polarized- != null
	     * @param priceSoat - client mail - !=null
	     * @param cap_tank - capacity of tank- != null
	     * @param type_gasoline- gasoline type- !=null
	     * @param charger_type - charger type of the battery- != null
	     * @param duration- duration of the battery- !=null
	     * @param priceSoat - Soat price of the hybrid car- !=null
	     * @param yearSoat - Soat year of the hybrid car-!= null
	     * @param coverage_amout - coverage amount of the hybrid car - != null
	     * @param priceMec - mechanical techno review price of the hybrid car - != null
	     * @param yearMec - mechanical techno review year- != null
	     * @param level_gas - level gas of the hybrid car - != null
	     * @return String with the operation message
	     */
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,double cap_tank,String type_gasoline,String charger_type,double duration,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		String message="";
		boolean park=false;
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[0][m]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[0][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[1][m]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[1][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[2][m]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[2][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[3][m]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[3][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<ROW && park==false;m++){
						if(parkingLot[4][m]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[4][m]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
				Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
				this.vehicles.add(vehicles);
				find=true;
			}
		if(add==false && park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	/** interest
	     *Method used to save each customer's interest vehicles
	     * @param identificationA -advisor identification-!= null
	     * @param identificationC -client identification-!= null
	     * @param vehicle -what type of vehicle-!= null
	     * @param type -if is used or new-!= null
	     * @return string with the respective message.
	     */
	public String interest(String identificationA,String identificationC,String vehicle,String type){
		Scanner lector = new Scanner (System.in);
		Advisor search=searchAdvisor(identificationA);
		String message="";
		boolean add=false;
		ArrayList<Vehicle> interest;
		interest=new ArrayList<Vehicle>();
		if (search==null){
	    	message="Error. Avisor doesnt exists.";
	    	System.out.println("MOTO");
	    }
	    else{
	   		for (int s=0;s<SELLERS && add==false;s++){
	   			if(sellers[s].getIdentification().equals(identificationA)){
	   				add=true;
	   				Client [] clients=sellers[s].getClients();
	   				for(int m=0;m<Advisor.CLIENTS;m++){
	   					if(clients[m].getIdentification().equals(identificationC)){
	   						interest=clients[m].getInterest();
	   						if(type.equals(Vehicle.VEHICLE_NEW)){
								if(vehicle.equals("Motocycle")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_NEW) && vehicles.get(w) instanceof Motocycle){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Gasoline")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_NEW) && vehicles.get(w) instanceof Gasoline){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Electrical")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_NEW) && vehicles.get(w) instanceof Electrical){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Hybrid")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_NEW) && vehicles.get(w) instanceof Hybrid){
											interest.add(vehicles.get(w));
										}
									}
								}
							}
							else if(type.equals(Vehicle.VEHICLE_USED)){
								if(vehicle.equals("Motocycle")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_USED) && vehicles.get(w) instanceof Motocycle){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Gasoline")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_USED) && vehicles.get(w) instanceof Gasoline){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Electrical")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_USED) && vehicles.get(w) instanceof Electrical){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Hybrid")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(Vehicle.VEHICLE_USED) && vehicles.get(w) instanceof Hybrid){
											interest.add(vehicles.get(w));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		message=catalogue(interest,identificationC);
		return message;
	}
	/** catalogue
	     *Method used to show the information of the vehicles of interest
	     * @param arraylist -vehicles of interest-!= null
	     * @param identification -client identification-!= null
	     * @return string of the vehicles information
	     */
	public String catalogue( ArrayList<Vehicle> arraylist,String identification){
		String message="";
		Client objClient=searchClient(identification);
		if(objClient==null){
			message="The client doesn exist";
		}
		else{
			for(int s=0;s<arraylist.size();s++){
				message+=arraylist.get(s).toString()+"\n"+"\n";
			}
		}
		return message;
	}
	/** parkingInformation
	     *Method used to show the information of the vehicles of the parking lot
	     * @param year -model of interest-!= null
	     * @return string of the vehicles information
	     */
	public String parkingInformation(String year){
		String message="";
		int modelVehicle = Integer.parseInt(year);
		if(modelVehicle==2014){
			for(int s=0;s<ROW;s++){
					if(parkingLot[0][s]!=null){
						message+=parkingLot[0][s].toString()+"\n"+"\n";
				}
			}
		}
		else if(modelVehicle==2013){
			for(int s=0;s<ROW;s++){
					if(parkingLot[1][s]!=null){
						message+=parkingLot[1][s].toString()+"\n"+"\n";
				}
			}
		}
		else if(modelVehicle==2012){
			for(int s=0;s<ROW;s++){
					if(parkingLot[2][s]!=null){
						message+=parkingLot[2][s].toString()+"\n"+"\n";
				}
			}
		}
		else if(modelVehicle==2011){
			for(int s=0;s<ROW;s++){
					if(parkingLot[3][s]!=null){
						message+=parkingLot[3][s].toString()+"\n"+"\n";
				}
			}
		}
		else if(modelVehicle<2011){
			for(int s=0;s<ROW;s++){
					if(parkingLot[4][s]!=null){
						message+=parkingLot[4][s].toString()+"\n"+"\n";
				}
			}
		}
		return message;
	}
	/** sellVehicle
	     *Method used to sell a vehicle.
	     * @param identificationA -advisor identification-!= null
	     * @param identificationC -client identification-!= null
	     * @param lisence_plate -lisence plate of the vehicle to sell-!= null
	     * @return string message of the operation
	     */
	public String sellVehicle(String identificationA,String identificationC,String lisence_plate,String type,double base_price){
		String message="";
		boolean add=false;
		String linsence_plateNew="";
		Random rnd = new Random();
		ArrayList<Vehicle> interest;
		interest=new ArrayList<Vehicle>();
		Advisor search=searchAdvisor(identificationA);
		double priceVehicle=0;
		if (search==null){
	    	message="Error. Advisor doesnt exists.";
	    }
	    else{
	    	for (int s=0;s<SELLERS;s++){
	    		if(sellers[s]!=null){
	   				if(sellers[s].getIdentification().equals(identificationA)){
	   					Client [] clients=sellers[s].getClients();
	   					for(int m=0;m<Advisor.CLIENTS;m++){
	   						if(clients[m]!=null){
	   							if(clients[m].getIdentification().equals(identificationC)){
	   								interest=clients[m].getInterest();
	   									for(int w=0;w<interest.size() && add==false;w++){
	   										if(interest.get(w).getClient()==null){
	   											if(type.equals(Vehicle.VEHICLE_USED)){
	   											if(interest.get(w).getType().equals(Vehicle.VEHICLE_USED)){
	   												if(interest.get(w).getLisence_plate().equals(lisence_plate)){
	   													interest.get(w).setClient(clients[m]);
	   													priceVehicle=interest.get(w).getTotal_price();
	   													int advisorSellers=sellers[s].getSales_quantity();
	   													sellers[s].setSales_quantity(advisorSellers+1);
	   													sales_number++;
	   													add=true;
	   													message="The purchase has been successful, we are grateful for choosing us";
														this.total_earnings+=priceVehicle;
	   												}
	   											}
	   										}
	   							else if(type.equals(Vehicle.VEHICLE_NEW)){
	   								if(interest.get(w).getType().equals(Vehicle.VEHICLE_NEW)){
	   									if(interest.get(w).getBase_price()==base_price){
	   										for (int i=0; i<7;i++){
	   											if(i < 4){
	   												 char lisence=(char)(rnd.nextInt(91) + 65);
	   												 String lisence_plateNew = Character.toString(lisence);
	   											}
	   											else{
	   												linsence_plateNew+= rnd.nextInt(10);
	   											}
	   										}
	   										interest.get(w).setLisence_plate(linsence_plateNew);
	   										interest.get(w).setClient(clients[m]);
	   										priceVehicle=interest.get(w).getTotal_price();
	   										int advisorSellers=sellers[s].getSales_quantity();
	   										sellers[s].setSales_quantity(advisorSellers+1);
	   										sales_number++;
	   										add=true;
	   										message="The purchase has been successful, we are grateful for choosing us";
											this.total_earnings+=priceVehicle;
	   										}
	   									}
	   								}
	   							}
	   								else{
	   									message="The vehicle was selled";
	   								}
	   							}
	   						}						
						}
					}
				}
			}
		}
		}
		return message;
	}
}