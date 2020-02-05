
package RootElement.ROBOSEARCH;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import simbad.gui.Simbad;

public class UserInterface {
	public CentralStation centralstation;
	
	int chosenID; // the id of the chosen robot // 
	private String chosenColor;
	private JFrame frame;
	private JComboBox<String> robotID;
	private JComboBox<String> boxColors;
	private JButton forward;
	private JButton back;
	private JButton right;
	private JButton startControl;
	private JButton left;
	private JButton stopControl;
	private JButton printInfo;
	private JButton stopMission;
	private JButton startMission;

	public UserInterface() {
		chosenID = 0;
		frame = new JFrame("Control Panel");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(800, 100);
      	
		// easy way to create ComboBox using array
		String[] theIDs = { "1", "2", "3", "4" };
		String[] availableColors = {"", "Blue", "Cyan", "Magenta", "Green", "Red", "Yellow"};
		
		robotID = new JComboBox<String>(theIDs);

		robotID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String s = (String) robotID.getSelectedItem();// get the selected item

				switch (s) {
				case "1":
					chosenID = 0;
					break;
				case "2":
					chosenID = 1;
					break;
				case "3":
					chosenID = 2;
					break;
				default:
					chosenID = 3;
					break;

				}
			}
		});
		
		boxColors = new JComboBox<String>(availableColors);

		boxColors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String s = (String) boxColors.getSelectedItem();// get the selected item

				switch (s) {
				case "":
					chosenColor = null;
					break;
				case "Blue":
					chosenColor = "Blue";
					break;
				case "Cyan":
					chosenColor = "Cyan";
					break;
				case "Yellow":
					chosenColor = "Yellow";
					break;
				case "Red":
					chosenColor = "Red";
					break;
				case "Magenta":
					chosenColor = "Magenta";
					break;
				case "Green":
					chosenColor = "Green";
					break;
				}
			}
		});

		// create labels and add to the frame
		JLabel label = new JLabel("Select the robot ID ");
		JLabel label2 = new JLabel("Select Box Color ");
		JPanel panel = new JPanel();

		panel.add(label);
		panel.add(robotID);
		panel.add(label2);
		panel.add(boxColors);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		// arrow keys
		forward = new JButton("UP");
		back = new JButton("DOWN");
		right = new JButton("RIGHT");
		left = new JButton("LEFT");
		startControl = new JButton("START CONTROL");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setPreferredSize(new Dimension(20, 20));
		buttonPanel.add(new JPanel());
		buttonPanel.add(forward);
		buttonPanel.add(new JPanel());
		buttonPanel.add(left);
		buttonPanel.add(new JPanel());
		buttonPanel.add(right);
		buttonPanel.add(new JPanel());
		buttonPanel.add(back);
		buttonPanel.add(new JPanel());
		
		


		// we have to understand which button is pressed, that's why we need action
		// listener
		forward.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveForward();

			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveBackward();

			}
		});

		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
			}
		});

		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
			}
		});

		frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

		// buttons
		stopControl = new JButton("Stop Control");
		printInfo = new JButton("Retrieve Info");
		stopMission = new JButton("Stop Mission");
		startMission = new JButton("Start Mission");
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(stopControl, BorderLayout.EAST);
		panel1.add(startControl, BorderLayout.CENTER);
		panel1.add(printInfo, BorderLayout.WEST);
		panel1.add(stopMission, BorderLayout.SOUTH);
		panel1.add(startMission, BorderLayout.NORTH);
		frame.getContentPane().add(panel1, BorderLayout.SOUTH);
		
		///Initializes the buttons as not clickable until mission is started
    	forward.setEnabled(false);
    	back.setEnabled(false);
    	right.setEnabled(false);
    	startControl.setEnabled(false);
    	stopControl.setEnabled(false);
    	left.setEnabled(false);
    	right.setEnabled(false);
    	printInfo.setEnabled(false);
    	stopMission.setEnabled(false);
    	robotID.setEnabled(false);

		stopControl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopControl();
			}
		});
		
		stopMission.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopMission();
			}
		});

		startMission.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startMission();
			}
		});
		
		printInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printInfo();

			}
		});
		
		startControl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startControl();
			}
		});

		frame.setVisible(true);
	}
	public void printInfo() {
		Set<String> set = this.centralstation.getObstacleCoordinates();
		if (set.isEmpty())
		{
			JOptionPane.showMessageDialog(frame, "No boxes found.");
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Boxes found at: " + set);
		}
	}

	public void moveRight() {
		Command temp = new Command(AvailableCommands.GO_RIGHT);
		this.centralstation.sendCommand(temp, chosenID);
	}

	public void moveLeft() {
		Command temp = new Command(AvailableCommands.GO_LEFT);
		this.centralstation.sendCommand(temp, chosenID);
	}

	public void moveForward() {
		Command temp = new Command(AvailableCommands.GO_UP);
		this.centralstation.sendCommand(temp, chosenID);
	}

	public void moveBackward() {
		Command temp = new Command(AvailableCommands.GO_DOWN);
		this.centralstation.sendCommand(temp, chosenID);
	}

	public void stopControl() {
		//disables buttons that are not supposed to be used when manual control is relinquished. 
		startControl.setEnabled(true);
		forward.setEnabled(false);
		back.setEnabled(false);
		left.setEnabled(false);
		right.setEnabled(false);
      	robotID.setEnabled(true);
		stopControl.setEnabled(false);
		Command temp = new Command(AvailableCommands.STOP_CONTROL);
		this.centralstation.sendCommand(temp, chosenID);
	}
	public void startControl() {
		//enables buttons that can be be used when manual control is enabled. 
		stopControl.setEnabled(true);
		forward.setEnabled(true);
		back.setEnabled(true);
		left.setEnabled(true);
		right.setEnabled(true);
      	robotID.setEnabled(false);
		startControl.setEnabled(false);
		Command temp = new Command(AvailableCommands.START_CONTROL);
		this.centralstation.sendCommand(temp, chosenID);
	}
	
	public void stopMission() {
		this.centralstation.stopMission();
	}
	
	public void startMission() {
		//checks if the operator picked a color or not.
		if(this.chosenColor == null)
		{
			this.printMessage("Please choose a box color.");
		}
		else
		{
			this.centralstation = CentralStation.getInstance();
			this.centralstation.setUI(this);
			this.centralstation.setColor(chosenColor); 
			//creates the simbad frame and starts the mission
	        Environment environment = new Environment();
	      	Simbad frame = new Simbad(environment, false);
	      	//enables the buttons that can be used when mission starts.
	      	stopMission.setEnabled(true);
	    	startControl.setEnabled(true);
	    	printInfo.setEnabled(true);
	      	robotID.setEnabled(true);
	      	startMission.setEnabled(false);
	      	boxColors.setEnabled(false);
		}
	}
	
	//disables all of the buttons except retrieve information when mission is over. this is used both by the central station and the operator.
    public void disableButtons()
    {
        forward.setEnabled(false);
        back.setEnabled(false);
        left.setEnabled(false);
        right.setEnabled(false);
        stopControl.setEnabled(false);
        startControl.setEnabled(false);
        robotID.setEnabled(false);
        stopMission.setEnabled(false);
    }
	
	public void printMessage(String message)
	{
		JOptionPane.showMessageDialog(frame, message);
	}

}
