package org.jfree.chart.demo;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Display {

	public JFrame frame;
	public static JTextField txtMass;
	public JTextField txtLength;
	public JTextField txtZenith;
	public int frameW=1280;
	public int frameH=768;
	public static int effectiveX = 15240;
	public static int effectiveY = 9298;
	public DataAnalysis analysis = new DataAnalysis();
	//initial conditions
   
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private static ScatterCanvas panel_1;
	private JPanel panel_2;
	private JTextField RAzimuth;
	private JTextField TAzimuth;
	private static JTextField TimeElapsed;
	private JTextField AzDisp;
	private JTextField Lat;
	private JTextField EffXInput;
	private JTextField EffYInput;
	private static boolean enabled=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				////////////
			}
		});
		
		 try {
		
			  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			    String s;
			    File dataFile = new File("data.txt");
				FileWriter fw = new FileWriter(dataFile);
				BufferedWriter bw = new BufferedWriter(fw);
			    DataParser datIn = new DataParser(effectiveX,effectiveY);
			    
			    //while(!enabled){}//spin until enabled
			    
				while ((s = in.readLine()) != null && s.length() != 0 && enabled){
				 // System.out.println(s);
					if(datIn.parseString(s)){
						bw.write(s);
						bw.write('\n');
						bw.flush();
						panel_1.plotCoords(datIn.getX(),datIn.getFlippedY());
						TimeElapsed.setText(Double.toString(datIn.getTime()));
					}
				}
		 
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, frameW, frameH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 5, 1200, 700);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Parameters", null, panel, null);
		panel.setLayout(null);
		
		txtMass = new JTextField();
		txtMass.setText("0.0");
		txtMass.setBounds(307, 63, 114, 19);
		panel.add(txtMass);
		txtMass.setColumns(10);
		
		txtLength = new JTextField();
		txtLength.setText("0.0");
		txtLength.setBounds(307, 94, 114, 19);
		panel.add(txtLength);
		txtLength.setColumns(10);
		
		txtZenith = new JTextField();
		txtZenith.setText("0.0");
		txtZenith.setBounds(307, 125, 114, 19);
		panel.add(txtZenith);
		txtZenith.setColumns(10);
		
		JLabel lblInitialConditions = new JLabel("Initial Conditions");
		lblInitialConditions.setBounds(307, 36, 120, 15);
		panel.add(lblInitialConditions);
		
		JButton btnSetParam = new JButton("Set Param");
		btnSetParam.setBounds(445, 31, 107, 25);
		panel.add(btnSetParam);
		
		JLabel lblMass = new JLabel("Mass");
		lblMass.setBounds(438, 65, 70, 15);
		panel.add(lblMass);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setBounds(439, 96, 70, 15);
		panel.add(lblLength);
		
		JLabel lblZenithAngle = new JLabel("Zenith Angle");
		lblZenithAngle.setBounds(439, 122, 114, 25);
		panel.add(lblZenithAngle);
		
		RAzimuth = new JTextField();
		RAzimuth.setText("0.0");
		RAzimuth.setBounds(307, 156, 114, 19);
		panel.add(RAzimuth);
		RAzimuth.setColumns(10);
		
		JLabel lblReleaseAzimuth = new JLabel("Release Azimuth");
		lblReleaseAzimuth.setBounds(438, 158, 131, 15);
		panel.add(lblReleaseAzimuth);
		
		TAzimuth = new JTextField();
		TAzimuth.setText("0.0");
		TAzimuth.setBounds(307, 187, 114, 19);
		panel.add(TAzimuth);
		TAzimuth.setColumns(10);
		
		JLabel lblTabletAzimuth = new JLabel("Tablet Azimuth");
		lblTabletAzimuth.setBounds(438, 189, 124, 15);
		panel.add(lblTabletAzimuth);
		
		TimeElapsed = new JTextField();
		TimeElapsed.setBounds(719, 63, 114, 19);
		panel.add(TimeElapsed);
		TimeElapsed.setColumns(10);
		
		JLabel lblTimeElapsed = new JLabel("Time Elapsed");
		lblTimeElapsed.setBounds(863, 65, 147, 15);
		panel.add(lblTimeElapsed);
		
		AzDisp = new JTextField();
		AzDisp.setBounds(719, 125, 114, 19);
		panel.add(AzDisp);
		AzDisp.setColumns(10);
		
		JLabel lblAzimuthalDisplacement = new JLabel("Azimuthal Displacement");
		lblAzimuthalDisplacement.setBounds(863, 127, 182, 15);
		panel.add(lblAzimuthalDisplacement);
		
		Lat = new JTextField();
		Lat.setBounds(719, 187, 114, 19);
		panel.add(Lat);
		Lat.setColumns(10);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setBounds(866, 189, 70, 15);
		panel.add(lblLatitude);
		
		JLabel lblCalculations = new JLabel("Calculations");
		lblCalculations.setBounds(719, 36, 114, 15);
		panel.add(lblCalculations);
		
		EffXInput = new JTextField();
		EffXInput.setText("15240");
		EffXInput.setBounds(307, 303, 114, 19);
		panel.add(EffXInput);
		EffXInput.setColumns(10);
		
		EffYInput = new JTextField();
		EffYInput.setText("9298");
		EffYInput.setBounds(307, 340, 114, 19);
		panel.add(EffYInput);
		EffYInput.setColumns(10);
		
		JLabel lblTabletSettings = new JLabel("Tablet Settings");
		lblTabletSettings.setBounds(326, 270, 114, 15);
		panel.add(lblTabletSettings);
		
		JLabel lblNumberOfEffective = new JLabel("Number of Effective Lines in X Area");
		lblNumberOfEffective.setBounds(438, 305, 270, 15);
		panel.add(lblNumberOfEffective);
		
		JLabel lblNumberOfEffective_1 = new JLabel("Number of Effective Lines in Y Area");
		lblNumberOfEffective_1.setBounds(438, 342, 251, 15);
		panel.add(lblNumberOfEffective_1);
		
		JButton btnApplySettings = new JButton("Apply Settings");
		btnApplySettings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				effectiveX = Integer.parseInt(EffXInput.getText());
				effectiveY = Integer.parseInt(EffYInput.getText());
			}
		});
		btnApplySettings.setBounds(452, 265, 153, 25);
		panel.add(btnApplySettings);
		
		JButton startbtn = new JButton("Begin Data Collection");
		startbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				enabled=true;
			}
		});
		startbtn.setBounds(826, 300, 219, 25);
		panel.add(startbtn);
		
		JButton endbtn = new JButton("End Data Collection");
		endbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enabled=false;
			}
		});
		endbtn.setBounds(826, 352, 219, 25);
		panel.add(endbtn);
		
		btnSetParam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			analysis.setZenith(Double.parseDouble(txtZenith.getText()));
				analysis.setLength(Double.parseDouble(txtLength.getText()));
				analysis.setMass(Double.parseDouble(txtMass.getText()));
				analysis.setRAzimuth(Double.parseDouble(RAzimuth.getText()));
				analysis.setTAzimuth(Double.parseDouble(TAzimuth.getText()));
				
				
			}
		});
		
		panel_1 = new ScatterCanvas(frameW,frameH,effectiveX,effectiveY);
		tabbedPane.addTab("Position", null, panel_1, null);
		
		//panel_2 = new ScatterCanvas();
		tabbedPane.addTab("Angular Displacement", null, panel_2, null);
	}
}
