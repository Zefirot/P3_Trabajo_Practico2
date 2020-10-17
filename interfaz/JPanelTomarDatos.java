package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import codigoBusiness.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JSpinner;

public class JPanelTomarDatos extends JPanel {
	private JTextField textNombre;
	private JSpinner spinnerDeporte;
	private JSpinner spinnerMusica;
	private JSpinner spinnerEspectaculo;
	private JSpinner spinnerCiencia;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private ArrayList<Persona> datos;
	private JSpinner spinner;

	/**
	 * Create the panel.
	 */
	public JPanelTomarDatos() {
		datos = new ArrayList<Persona>();
		setLayout(null);
		setBounds(0, 0, 581, 316);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 46, 61, 14);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(67, 44, 86, 20);
		add(textNombre);
		
		//Se crean los spinners
		SpinnerModel modelo = new SpinnerNumberModel(1, 1, 5, 1);  
		
		spinnerDeporte = new JSpinner(modelo);
		spinnerDeporte.setBounds(183, 44, 40, 20);
		add(spinnerDeporte);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerMusica = new JSpinner(modelo);
		spinnerMusica.setBounds(234, 44, 40, 20);
		add(spinnerMusica);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerEspectaculo = new JSpinner(modelo);
		spinnerEspectaculo.setBounds(285, 44, 40, 20);
		add(spinnerEspectaculo);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerCiencia = new JSpinner(modelo);
		spinnerCiencia.setBounds(336, 44, 40, 20);
		add(spinnerCiencia);
		
		//Se crean los botones
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controlarDatos()) {
					agregarDatoATable();
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAgregar.setBounds(424, 43, 89, 23);
		add(btnAgregar);
		
		//Creo la JTable
		model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Deporte");
		model.addColumn("Musica");
		model.addColumn("Espectaculos");
		model.addColumn("Ciencia");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 98, 446, 150);
		scrollPane.setBackground(null);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setModel(model);
		
		
	}
	
	private boolean controlarDatos() {
		
		if(textNombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "El nombre no debe estar vacio");
			return false;
		}
		return true;
		
	}
	
	private void agregarDatoATable() {
		//Obtengo todos los datos
		String nombre = textNombre.getText();
		int deporte = (int)spinnerDeporte.getValue();
		int musica = (int)spinnerMusica.getValue();
		int espectaculo = (int)spinnerEspectaculo.getValue();
		int ciencia = (int)spinnerCiencia.getValue();
		
		//Reseteo los inputs para los proximos datos
		textNombre.setText("");
		spinnerDeporte.setValue(1);
		spinnerMusica.setValue(1);
		spinnerEspectaculo.setValue(1);
		spinnerCiencia.setValue(1);
		
		//Agrego todos los datos al array
		datos.add(new Persona(nombre,deporte,musica,espectaculo,ciencia));
		
		//Agrego los datos a la JTable
		model.addRow(new String[]{ nombre, String.valueOf(deporte), String.valueOf(musica),
				String.valueOf(espectaculo), String.valueOf(ciencia) });
		table.setModel(model);
	}
}
