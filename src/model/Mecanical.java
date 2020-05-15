package model;
public class Mecanical extends Document {
	//Atributos
	private double gas_level;
	private final String mecanical;
	//Metodos
	public Mecanical(double price,String year,double gas_level){
		super(price,year);
		this.gas_level=gas_level;
		this.mecanical=mecanical();
	}
	
	public String mecanical(){
	int[][] image_code=super.getImage_code();
    String a="";
    String b="";
    String c="";
    String soat="";
    int cont=image_code.length-1;
    for (int s=0;s<image_code.length;s++) {
    		 	 a+=image_code[0][s]+" ";
    }
    for (int w=0;w<image_code.length;w++){
           b+=image_code[w][cont]+" ";
           cont--;
    }
    for (int t=0;t<image_code.length;t++){
           c+=image_code[3][t]+" ";
    }

    soat=a+b+c;
  		return soat;
	}
	
	public double getGas_level() {
		return gas_level;
	}
	
	public void setGas_level(double gas_level) {
		this.gas_level = gas_level;
	}
	
	public String getMecanicalCode() {
		return mecanical;
	}

}