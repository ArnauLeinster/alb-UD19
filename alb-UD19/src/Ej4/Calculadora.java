package Ej4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField n1;
	private JTextField n2;
	private JRadioButton suma;
	private JRadioButton resta;
	private JRadioButton multi;
	private JRadioButton divi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("100dlu"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50dlu"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("25dlu"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		n1 = new JTextField();
		contentPane.add(n1, "2, 2, fill, default");
		n1.setColumns(10);

		suma = new JRadioButton("+");
		contentPane.add(suma, "6, 2");

		n2 = new JTextField();
		contentPane.add(n2, "2, 4, fill, default");
		n2.setColumns(10);

		resta = new JRadioButton("-");
		contentPane.add(resta, "6, 4");

		JButton equals = new JButton("=");
		contentPane.add(equals, "2, 6");

		multi = new JRadioButton("X");
		contentPane.add(multi, "6, 6");

		divi = new JRadioButton("/");
		contentPane.add(divi, "6, 8");

		suma.setActionCommand("suma");
		resta.setActionCommand("resta");
		multi.setActionCommand("multi");
		divi.setActionCommand("divi");

		ButtonGroup gp = new ButtonGroup();
		gp.add(suma);
		gp.add(resta);
		gp.add(multi);
		gp.add(divi);

		JLabel result = new JLabel("Resultado");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(result, "2, 10");

		JButton exit = new JButton("Exit");
		contentPane.add(exit, "2, 12");

		final ActionListener enter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double num1 = Double.parseDouble(n1.getText());
				double num2 = Double.parseDouble(n2.getText());

				switch (gp.getSelection().getActionCommand()) {
				case "suma":
					result.setText(String.valueOf(num1 + num2));
					break;
				case "resta":
					result.setText(String.valueOf(num1 - num2));
					break;
				case "multi":
					result.setText(String.valueOf(num1 * num2));
					break;
				case "divi":
					if (num2 != 0) {
						result.setText(String.valueOf(num1 / num2));
					} else {
						result.setText("Error");
					}
					break;
				default:
					result.setText("Error");
					break;
				}
			}
		};

		equals.addActionListener(enter);

	}

}
