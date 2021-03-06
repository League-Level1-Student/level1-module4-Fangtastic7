import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinaryConverter implements ActionListener, MouseListener {
	public static void main(String[] args) {
		new BinaryConverter().createUI();
	}

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField input1 = new JTextField(20);
	JLabel output = new JLabel();
	JButton button1 = new JButton();

	private void createUI() {

		frame.add(panel);
		frame.setTitle("Binary Converter");
		frame.setVisible(true);
		input1.getText();
		button1.setText("Convert");
		panel.add(input1);

		panel.add(button1);
		panel.add(output);
		button1.addMouseListener(this);
		frame.pack();
	}

	String convert(String input) {

		if (input.length() != 8) {
			JOptionPane.showMessageDialog(null, "Enter 8 bits, silly!!!");
			return "-";
		}
		String binary = "[0-1]+"; // must contain numbers in the given range
		if (!input.matches(binary)) {
			JOptionPane.showMessageDialog(null, "Binary can only contain 1s or 0s, silly!!!");
			return "-";
		}
		try {
			char value = '1';
			int total = 1;
			int sum = 0;

			for (int i = 0; i < 8; i++) {

				if (value == (input.charAt(i))) {

					sum = sum + exponent(i);
					System.out.println(sum);
				}
			}
			System.out.println(sum);
			return "-";

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a binary, silly!!!");
			return "-";
		}
	}

	private int exponent(int num) {
		// TODO Auto-generated method stub
		int outcome = 1;
		

			for (int i = 0; i < num; i++) {
				outcome = outcome * 2;
			
		}
		
		return outcome;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String letter = convert(input1.getText());
		output.setText(letter);
		frame.pack();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
