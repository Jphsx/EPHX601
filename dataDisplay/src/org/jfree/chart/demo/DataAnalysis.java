package org.jfree.chart.demo;
//stub class that holds important data and can analyze data

public class DataAnalysis {
	private double mass;
	private double length;
	private double zenith;
	private double RAzimuth;
	private double TAzimuth;
	
	public DataAnalysis(){
		
	}
	public void setMass(double M){
		mass=M;
	}
	public void setLength(double L){
		length=L;
	}
	public void setZenith(double theta){
		zenith=theta;
	}
	public void setRAzimuth(double theta){
		RAzimuth=theta;
	}
	public void setTAzimuth(double theta){
		TAzimuth=theta;
	}
}
