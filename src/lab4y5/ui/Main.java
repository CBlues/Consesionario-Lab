package ui;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;
import model.*;
public class Main{
	//Atributos
		private Company mainCompany;	
		public static Scanner lector;
	//Constantes
		public static final String MOTO="Motocycle";
		public static final String GASO="Gasoline";
		public static final String ELEC="Electrical";
		public static final String HYB="Hybrid";
		public static void main(String[] args){
			Scanner lector = new Scanner (System.in);
			Main objMain=new Main();
			int option;
			objMain.createCompany();
			do{
				cls();
				System.out.println ("Menú opciones"+
				"\n1.Registrar tutor"+
				"\n2.Registrar cliente"+
				"\n3.Registrar vehículos"+
				"\n4.Muestre la información de parqueo"+
				"\n5.Vender vehículo");
				System.out.println ("Escoja la opción de desee");
				option=Integer.parseInt(lector.nextLine());
				switch (option){
					case 1:
						objMain.enterAdvisor();
						break;
					case 2:
						objMain.enterClient();
						break;
					case 3:
						System.out.println("¿Qué tipo de vehículo desea registrar?. Ingrese 1 para motocicleta, 2 para carros de gasolina, 3 para carros eléctricos o 4 para carros hibridos");
						int o=Integer.parseInt(lector.nextLine());
						if(o==1){
							objMain.enterVehicleMotocycle();
						}
						else if(o==2){
							objMain.enterVehicleGasoline();
						}
						else if(o==3){
							objMain.enterVehicleElectrical();
						}
						else{
							objMain.enterVehicleHybrid();
						}
						break;
					case 4:
						objMain.parkingInformation();
						break;
					case 5:
						objMain.interest();
						break;
				}
				System.out.println("Para regresar al menú escriba 0");
				option=Integer.parseInt(lector.nextLine());
			} while (option==0);
		}
	public static void cls(){
			try{
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}
			catch (Exception E){
				System.out.println (E);
			}
	}
	public void createCompany(){
		Scanner lector = new Scanner (System.in);
		System.out.println("Ingrese nombre del concesionario");
		String name=lector.nextLine();
		System.out.println("Ingrese NIT");
		String nit=lector.nextLine();
		mainCompany=new Company(name.toUpperCase(),nit);
		}
	
	public void enterAdvisor(){
			Scanner lector = new Scanner (System.in);
			System.out.println("Ingrese nombre");
			String name=lector.nextLine();
			System.out.println("Ingrese apellido");
			String last_name=lector.nextLine();
			System.out.println("Ingrese identificación");
			String identification=lector.nextLine();
			String message=mainCompany.addAdvisor(name.toUpperCase(),last_name.toUpperCase(),identification);
			System.out.println(message);
		}
	
	public void enterClient(){
			Scanner lector = new Scanner (System.in);
			System.out.println("Ingrese nombre");
			String name=lector.nextLine();
			System.out.println("Ingrese apellido");
			String last_name=lector.nextLine();
			System.out.println("Ingrese identificación");
			String identification=lector.nextLine();
			System.out.println("Ingrese número telefónico ");
			String phone_number=lector.nextLine();
			System.out.println("Ingrese mail");
			String mail=lector.nextLine();
			String message=mainCompany.addClient(name.toUpperCase(),last_name.toUpperCase(),identification,phone_number,mail);
			System.out.println(message);
		}
	
	public void enterVehicleMotocycle(){
			Scanner lector = new Scanner (System.in);
			String message="";
			String moto_type="";
			String type="";
			String lisence_plate;
			double mileage;
				System.out.println("Ingrese el precio base");
				double base_price=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese la marca");
				String brand=lector.nextLine();
				System.out.println("Ingrese el modelo");
				String model=lector.nextLine();
				System.out.println("Ingrese el cilindraje");
				double cylinder=Double.parseDouble(lector.nextLine());
				System.out.println("Si la motocicleta es nueva digite 1, si es usada digite 2");
				int choice=Integer.parseInt(lector.nextLine());
				if(choice==1){
					type=Vehicle.VEHICLE_NEW;
					lisence_plate="No asignada";
					mileage=0;
				}
				else{
					type=Vehicle.VEHICLE_USED;
					System.out.println("Ingrese la matrícula");
					lisence_plate=lector.nextLine();
					System.out.println("Ingrese el kilometraje");
					mileage=Double.parseDouble(lector.nextLine());
				}
				System.out.println("Cuaĺ es el tipo de motocicleta. Ingrese 1 para Standard, 2 para deportiva, 3 para Scooter y 4 para Cross");
				int choi=Integer.parseInt(lector.nextLine());
				if(choi==1){
					moto_type=Motocycle.MOTO_STANDAR;
				}
				else if(choi==2){
					moto_type=Motocycle.MOTO_SPORT;
				}
				else if(choice==3){
					moto_type=Motocycle.MOTO_SCOOTER;
				}
				else{
					moto_type=Motocycle.MOTO_CROSS;
				}
				System.out.println("Ingrese la capacidad de gasolina");
				double cap_tank=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional sobre el SOAT--");
				System.out.println("Escriba el precio del documento");
				double priceSoat=Double.parseDouble(lector.nextLine());
				System.out.println("Escriba el año del documento");
				String yearSoat=lector.nextLine();
				System.out.println("¿Cuál es la cantidad de cobertura de accidentes de el vehículo a registrar?");
				double coverage_amount=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional acerca de la revisión técnico mecánica--");
				System.out.println("Ingrese el precio del documento");
				double priceMec=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese el año del documento");
				String yearMec=lector.nextLine();
				System.out.println("Cuáles son los niveles de gasolina");
				double gas_level=Double.parseDouble(lector.nextLine());
				message=mainCompany.addVehicle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
				System.out.println(message);
	}
	
	public void enterVehicleGasoline(){
			Scanner lector = new Scanner (System.in);
			String message="";
			String car_type="";
			String type="";
			String type_gasoline="";
			String lisence_plate="";
			boolean polarized;
			double mileage=0;;
				System.out.println("Ingrese el precio base");
				double base_price=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese la marca");
				String brand=lector.nextLine();
				System.out.println("Ingrese el modelo");
				String model=lector.nextLine();
				System.out.println("Ingrese el cilindraje");
				double cylinder=Double.parseDouble(lector.nextLine());
				System.out.println("Si el carro es nuevo digite 1, si es usado, digite 2");
				int opt=Integer.parseInt(lector.nextLine());
				if(opt==1){
					type=Vehicle.VEHICLE_NEW;
					lisence_plate="No asignado";
					mileage=0;
				}
				else{
					type=Vehicle.VEHICLE_USED;
					System.out.println("Escriba la matrícula");
					lisence_plate=lector.nextLine();
					System.out.println("Escriba el kilometraje");
					mileage=Double.parseDouble(lector.nextLine());
				}
				System.out.println("Cuál es el tipo de carro. Escriba 1 para sedan o 2 para Van");
				int op=Integer.parseInt(lector.nextLine());
				if(op==1){
					car_type=Car.CAR_SEDAN;
				}
				else{
					car_type=Car.CAR_VAN;
				}
				System.out.println("Escriba el número de puertas");
				int door_number=Integer.parseInt(lector.nextLine());
				System.out.println("Escriba 1 si el carro es polarizado, y 2 si no");
				int opti=Integer.parseInt(lector.nextLine());
				if(opti==1){
					polarized=true;
				}
				else{
					polarized=false;
				}
				System.out.println("Ingrese la capacidad del tanque");
				double cap_tank=Double.parseDouble(lector.nextLine());
				System.out.println("¿Cuál es el tipo de gasolina. Ingrese 1 para extra, 2 para corriente o 3 para diesel");
				int gaso=Integer.parseInt(lector.nextLine());
				if(gaso==1){
					type_gasoline=Gasoline.EXTRA;
				}
				else if(gaso==2){
					type_gasoline=Gasoline.CORRIENT;
				}
				else{
					type_gasoline=Gasoline.DIESEL;
				}
				System.out.println("--Información adicional sobre el SOAT--");
				System.out.println("Escriba el precio del documento");
				double priceSoat=Double.parseDouble(lector.nextLine());
				System.out.println("Escriba el año del documento");
				String yearSoat=lector.nextLine();
				System.out.println("¿Cuál es la cantidad de cobertura de accidentes de el vehículo a registrar?");
				double coverage_amount=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional acerca de la revisión técnico mecánica--");
				System.out.println("Ingrese el precio del documento");
				double priceMec=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese el año del documento");
				String yearMec=lector.nextLine();
				System.out.println("Cuáles son los niveles de gasolina");
				double gas_level=Double.parseDouble(lector.nextLine());
		 		message=mainCompany.addVehicle(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
		 		System.out.println(message);
	}
	
	public void enterVehicleElectrical(){
			Scanner lector = new Scanner (System.in);
			String message="";
			String car_type="";
			String type="";
			String charger_type="";
			String lisence_plate="";
			boolean polarized;
			double mileage=0;
				System.out.println("Ingrese el precio base");
				double base_price=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese la marca");
				String brand=lector.nextLine();
				System.out.println("Ingrese el modelo");
				String model=lector.nextLine();
				System.out.println("Ingrese el cilindraje");
				double cylinder=Double.parseDouble(lector.nextLine());
				System.out.println("Si el carro es nuevo digite 1, si es usado, digite 2");
				int opt=Integer.parseInt(lector.nextLine());
				if(opt==1){
					type=Vehicle.VEHICLE_NEW;
					lisence_plate="No asignado";
					mileage=0;
				}
				else{
					type=Vehicle.VEHICLE_USED;
					System.out.println("Escriba la matrícula");
					lisence_plate=lector.nextLine();
					System.out.println("Escriba el kilometraje");
					mileage=Double.parseDouble(lector.nextLine());
				}
				System.out.println("Cuál es el tipo de carro. Escriba 1 para sedan o 2 para Van");
				int op=Integer.parseInt(lector.nextLine());
				if(op==1){
					car_type=Car.CAR_SEDAN;
				}
				else{
					car_type=Car.CAR_VAN;
				}
				System.out.println("Escriba el número de puertas");
				int door_number=Integer.parseInt(lector.nextLine());
				System.out.println("Escriba 1 si el carro es polarizado, y 2 si no");
				int opti=Integer.parseInt(lector.nextLine());
				if(opti==1){
					polarized=true;
				}
				else{
					polarized=false;
				}
				System.out.println("Cuál es el tipo de cargador. Escriba 1 para normal, o 2 para rápido");
				int charg=Integer.parseInt(lector.nextLine());
				if(charg==1){
					charger_type=Electrical.NORMAL;
				}
				else{
					charger_type=Electrical.QUICK;
				}
				System.out.println("Escriba la duración del cargador");
				double duration=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional sobre el SOAT--");
				System.out.println("Escriba el precio del documento");
				double priceSoat=Double.parseDouble(lector.nextLine());
				System.out.println("Escriba el año del documento");
				String yearSoat=lector.nextLine();
				System.out.println("¿Cuál es la cantidad de cobertura de accidentes de el vehículo a registrar?");
				double coverage_amount=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional acerca de la revisión técnico mecánica--");
				System.out.println("Ingrese el precio del documento");
				double priceMec=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese el año del documento");
				String yearMec=lector.nextLine();
				System.out.println("Cuáles son los niveles de gasolina");
				double gas_level=Double.parseDouble(lector.nextLine());
		 		message=mainCompany.addVehicle(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
		 		System.out.println(message);
	}
	
	public void enterVehicleHybrid(){
			Scanner lector = new Scanner (System.in);
			String message="";
			String car_type="";
			String type="";
			String type_gasoline="";
			String charger_type="";
			String lisence_plate="";
			boolean polarized;
			double mileage=0;
				System.out.println("Escriba el precio base");
				double base_price=Double.parseDouble(lector.nextLine());
				System.out.println("Escriba la marca");
				String brand=lector.nextLine();
				System.out.println("Escriba el modelo");
				String model=lector.nextLine();
				System.out.println("Escriba el cilindro");
				double cylinder=Double.parseDouble(lector.nextLine());
				System.out.println("Si el carro es nuevo, digite 1, si es usado digite 2");
				int opt=Integer.parseInt(lector.nextLine());
				if(opt==1){
					type=Vehicle.VEHICLE_NEW;
					lisence_plate="No asignada";
					mileage=0;
				}
				else{
					type=Vehicle.VEHICLE_USED;
					System.out.println("Escriba la matrícula");
					lisence_plate=lector.nextLine();
					System.out.println("Escriba el kilometraje");
					mileage=Double.parseDouble(lector.nextLine());
				}
				System.out.println("Cuál es el tipo de carro.Escriba 1 para sedan o 2 para Van");
				int op=Integer.parseInt(lector.nextLine());
				if(op==1){
					car_type=Car.CAR_SEDAN;
				}
				else{
					car_type=Car.CAR_VAN;
				}
				System.out.println("Escriba el número de puertas");
				int door_number=Integer.parseInt(lector.nextLine());
				System.out.println("Escriba 1 si el carro es polarizado, o 2 si no lo es");
				int opti=Integer.parseInt(lector.nextLine());
				if(opti==1){
					polarized=true;
				}
				else{
					polarized=false;
				}
				System.out.println("Ingrese la capacidad del tanque");
				double cap_tank=Double.parseDouble(lector.nextLine());
				System.out.println("¿Cuál es el tipo de gasolina?. Escriba 1 para extra, 2 para corriente o 3 para diesel");
				int gaso=Integer.parseInt(lector.nextLine());
				if(gaso==1){
					type_gasoline=Gasoline.EXTRA;
				}
				else if(gaso==2){
					type_gasoline=Gasoline.CORRIENT;
				}
				else{
					type_gasoline=Gasoline.DIESEL;
				}
				System.out.println("¿Cuál es el tipo de cargador? .1 Es normal, y 2 es rápido");
				int charg=Integer.parseInt(lector.nextLine());
				if(charg==1){
					charger_type=Electrical.NORMAL;
				}
				else{
					charger_type=Electrical.QUICK;
				}
				System.out.println("Ingrese la duración de la bateria");
				double duration=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional acerca del SOAT--");
				System.out.println("Ingrese el precio del documento");
				double priceSoat=Double.parseDouble(lector.nextLine());
				System.out.println("Ingrese el año del documento");
				String yearSoat=lector.nextLine();
				System.out.println("¿Cuál es la cantidad de cobertura de accidentes de el vehículo a registrar?");
				double coverage_amount=Double.parseDouble(lector.nextLine());
				System.out.println("--Información adicional acerca de la revisión técnico mecánica--");
				System.out.println("Escriba el precio del documento");
				double priceMec=Double.parseDouble(lector.nextLine());
				System.out.println("Escriba el año del documento");
				String yearMec=lector.nextLine();
				System.out.println("¿Cuáles son los niveles de gasolina?");
				double gas_level=Double.parseDouble(lector.nextLine());
		 		message=mainCompany.addVehicle(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
		 		System.out.println(message);
	}
	
	public void interest(){
		Scanner lector = new Scanner (System.in);
		String message="";
		String lisence_plate="";
		int buy=0;
		double base_price=0;
		System.out.println("Escriba la identificación del vendedor a cargo");
		String identificationA=lector.nextLine();
		System.out.println("Ingrese la identificación del cliente");
		String identificationC=lector.nextLine();
		System.out.println("¿En qué tipo de vehículo está interesado?");
		System.out.println("Ingrese 1 para motocicletas, 2 para carros a gasolina, 3 para carros eléctricos o 4 para carros hibridos");
		int opt=Integer.parseInt(lector.nextLine());
		String vehicle="";
		String type="";
		if(opt==1){
			vehicle=MOTO;
		}
		if(opt==2){
			vehicle=GASO;
		}
		if(opt==3){
			vehicle=ELEC;
		}
		else if(opt==4){
			vehicle=HYB;
		}
		System.out.println("¿Quiere vehículos nuevos o usados? Ingrese 1 para la primera opción, y 2 para la segunda");
			int op=Integer.parseInt(lector.nextLine());
			if(op==1){
				type=Vehicle.VEHICLE_NEW;
			}
			else{
				type=Vehicle.VEHICLE_USED;
			}
		message=mainCompany.interest(identificationA,identificationC,vehicle,type);
		System.out.println(message);
		System.out.println("¿Quieres comprar un vehículo? ingresa 1 como respuesta afirmativa, y 2 como negativa");
		buy=Integer.parseInt(lector.nextLine());
		if(buy==1){
			if(type.equals(Vehicle.VEHICLE_USED)){
				System.out.println("Ingrese la placa del vehículo que desea comprar");
				lisence_plate=lector.nextLine();
			}
			else{
				System.out.println("Ingrese el precio base de el vehículo que desea comprar");
				base_price=Double.parseDouble(lector.nextLine());
			}
				message=mainCompany.sellVehicle(identificationA,identificationC,lisence_plate,type,base_price);
				System.out.println(message);
			}
		}
	
	public void parkingInformation(){
		Scanner lector = new Scanner(System.in);
		String message="";
		System.out.println("¿Que año desea consultar?");
		String year=lector.nextLine();
		message=mainCompany.parkingInformation(year);
		System.out.println(message);
	}
}	


