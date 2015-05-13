package org.jfree.chart.demo;

public class DataParser {
	
	int effectiveX;
	int effectiveY;
	int[] coords = {0,0}; //{x,y}
	double time;
	
	public DataParser(int effX, int effY){
		effectiveX=effX;
		effectiveY=effY;
	}
	
	public boolean parseString(String data){
		String[] input=data.split(" ");
		coords[0]=Integer.parseInt(input[0]);
		coords[1]=Integer.parseInt(input[1]);
		//throw out bad values
		if(coords[0]==0 || coords[0]>effectiveX) return false;
		if(coords[1]==0 || coords[1]>effectiveY) return false;
		
		if(data.length()>2){
		time=Double.parseDouble(input[2]);
		}
		return true;
	}
	public int[] getCoords(){
		return coords;
	}
	public int getX(){
		return coords[0];
	}
	public int getY(){
		return coords[1];
	}
	public double getTime(){
		return time;
	}
	public int getFlippedX(){
		return Math.abs(coords[0]-effectiveX);
	}
	public int getFlippedY(){
		return Math.abs(coords[1]-effectiveY);
	}
}

