package org.jfree.chart.demo;


import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ScatterCanvas extends JPanel {
	
	  /** The time series data. */
   // private TimeSeries series;
	private XYSeries series;

    /** The most recent value added. */
   
    private int padding = 100;
    private int xEffectiveArea;
    private int yEffectiveArea;
	
	
    public ScatterCanvas(int width, int height, int xArea, int yArea){
      
    	xEffectiveArea=xArea;
    	yEffectiveArea=yArea;
    	this.series = new XYSeries("series");
   
    	final XYSeriesCollection dataset = new XYSeriesCollection(this.series);
    
    	final JFreeChart chart = createChart(dataset);
    	
        final ChartPanel chartPanel = new ChartPanel(chart);
      
        this.add(chartPanel);
     
        chartPanel.setPreferredSize(new java.awt.Dimension(width-padding,height-padding));
  

    }
	private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createScatterPlot(
            "XYPosition", 
            "X", 
            "Y",
            dataset 
  
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
     
        axis.setRange(0,xEffectiveArea);
        axis = plot.getRangeAxis();
        axis.setRange(0,yEffectiveArea); 
        return result;
    }
	public void plotCoords(int X, int Y){
		this.series.add(X, Y);
    }
	
}


	

