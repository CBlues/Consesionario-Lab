package model;
public final class Soat extends Document {
	//Atributos
	private double coverage_amount;
	private final String soat;
	//Metodos
	public Soat(double price,String year,double coverage_amount){
		super(price,year);
		this.coverage_amount=coverage_amount;
		this.soat=soat();
	}
	
	public String soat(){
	int[][] image_code=super.getImage_code();
    String a="";
    String b="";
    String soat1="";
            for (int[] image_code1 : image_code) {
                a += image_code1[0] + " ";
            }
    for (int m=0;m<image_code.length;m++) {
           b+=image_code[3][m]+" ";
    }
    soat1=a+b;
  		return soat1;
	}
	
	public double getCoverage_amount() {
		return coverage_amount;
	}
	
	public void setCoverage_amount(double coverage_amount) {
		this.coverage_amount=coverage_amount;
	}
	
	public String getSoatCode() {
		return soat;
	}
}