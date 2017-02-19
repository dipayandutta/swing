import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExampleApplication {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public ExampleApplication(){
		prepareGUI();
	}

	public static void main(String args[]){
		ExampleApplication exampleapplication = new ExampleApplication();
		exampleapplication.showTextField();
		exampleapplication.showLoginList();
		exampleapplication.showMenu();
	}

	private void prepareGUI(){
		mainFrame = new JFrame("Example Application");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3,1));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});

		headerLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(350,165);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}
	private void showTextField(){
		headerLabel.setText("Example Application");

		JLabel nameLabel = new JLabel("User ID:",JLabel.RIGHT);
		JLabel password  = new JLabel("Password : ",JLabel.CENTER);

		final JTextField userText = new JTextField(6);
		final JPasswordField  passwordText = new JPasswordField(6);

		JButton loginButton = new JButton("login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String data = "Username "+userText.getText();
				data += ": Password: "+new String(passwordText.getPassword());
			}
		});

		controlPanel.add(nameLabel);
		controlPanel.add(userText);
		controlPanel.add(password);
		controlPanel.add(passwordText);
		controlPanel.add(loginButton);
		mainFrame.setVisible(true);
	}
	private void showLoginList(){
		
		final DefaultComboBoxModel loginas = new DefaultComboBoxModel();
		loginas.addElement("Admin");
		loginas.addElement("User");
		loginas.addElement("Guest");

		final JComboBox loginCombo = new JComboBox(loginas);
		loginCombo.setSelectedIndex(0);
		
		JScrollPane loginScrollPane = new JScrollPane(loginCombo);

		JButton show = new JButton("Show");

		show.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e ){
				String data = "";
				if (loginCombo.getSelectedIndex() != -1){
					data = "login as "+loginCombo.getItemAt(loginCombo.getSelectedIndex());
				}
				System.out.println(data);
			}
		});
		controlPanel.add(loginScrollPane);
		controlPanel.add(show);
		mainFrame.setVisible(true);
	}		
		
	private void showMenu(){
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
			
		JMenuItem fileClose = new JMenuItem("Close");
		fileClose.setMnemonic(KeyEvent.VK_C);
		fileClose.setToolTipText("Exit Application");
		fileClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		JMenu about = new JMenu();
		about.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem showAbout = new JMenuItem("ShowAbout");
		showAbout.setMnemonic(KeyEvent.VK_S);
		showAbout.setToolTipText("ABOUT");

		showAbout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		file.add(fileClose);
		about.add(showAbout);

		menubar.add(file);
		menubar.add(about);
		
		mainFrame.setJMenuBar(menubar);
		mainFrame.setVisible(true);
	}
}


