package Ej3;

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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Encuesta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encuesta frame = new Encuesta();
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
	public Encuesta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("100dlu"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("100dlu"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JRadioButton radio1 = new JRadioButton("Windows");
		contentPane.add(radio1, "4, 2");

		JRadioButton radio4 = new JRadioButton("Programacion");
		contentPane.add(radio4, "16, 2");

		JRadioButton radio2 = new JRadioButton("Linux");
		contentPane.add(radio2, "4, 4");

		JRadioButton radio5 = new JRadioButton("Diseño grafico");
		contentPane.add(radio5, "16, 4");

		JRadioButton radio3 = new JRadioButton("Mac");
		contentPane.add(radio3, "4, 6");

		JRadioButton radio6 = new JRadioButton("Administracion");
		contentPane.add(radio6, "16, 6");

		JLabel lblCuantasHoras = new JLabel("Cuantas horas?");
		contentPane.add(lblCuantasHoras, "4, 8");

		textField = new JTextField();
		contentPane.add(textField, "4, 10, fill, default");
		textField.setColumns(10);

		JButton result = new JButton("Impreimir");
		contentPane.add(result, "4, 14");

		ButtonGroup group1 = new ButtonGroup();
		group1.add(radio1);
		group1.add(radio2);
		group1.add(radio3);
		
		radio1.setActionCommand("Windows");
		radio2.setActionCommand("Linux");
		radio3.setActionCommand("Mac");

		ButtonGroup group2 = new ButtonGroup();
		group2.add(radio4);
		group2.add(radio5);
		group2.add(radio6);
		
		radio4.setActionCommand("Programacion");
		radio5.setActionCommand("Diseño Grafico");
		radio6.setActionCommand("Administracion");
		
		final ActionListener enter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, group1.getSelection().getActionCommand() + " " + 
			group2.getSelection().getActionCommand() + " Por estas horas: "+
			textField.getText());
			}
		};
		
		result.addActionListener(enter);

	}

}
