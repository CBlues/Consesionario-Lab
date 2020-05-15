package model;
import java.util.Random;
public abstract class Document{
	//Constantes
	public static final int DIMENSION=4;
	//Atributos
	private double price;
	private String year;
	private int[][] image_code;
	//Metodos
	public Document(double price,String year){
		this.price=price;
		this.year=year;
		this.image_code= initialize();
	}
	public int[][] initialize(){
		int [][]code = new int[DIMENSION][DIMENSION];
		for (int s=0;s< code.length; s++) {
  			for(int m=0;m< code[s].length;m++) {
    		 	code[s][m] = (int)(Math.random()*10);
  			}
  		}
  		return code;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year=year;
	}
	public int[][] getImage_code() {
		return image_code;
	}
}