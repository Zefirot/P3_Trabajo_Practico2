package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import codigoBusiness.Persona;
import codigoBusiness.PersonasJSON;

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
import javax.swing.SwingConstants;

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

	/**
	 * Create the panel.
	 */
	public JPanelTomarDatos() {
		datos = new ArrayList<Persona>();
		setLayout(null);
		setBounds(0, 0, 581, 316);
		
		//Labels
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 16, 61, 14);
		add(lblNombre);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeporte.setBounds(163, 16, 46, 14);
		add(lblDeporte);
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMusica.setBounds(264, 16, 46, 14);
		add(lblMusica);
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		lblEspectaculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspectaculo.setBounds(357, 16, 67, 14);
		add(lblEspectaculo);
		
		JLabel lblCiencia = new JLabel("Ciencia");
		lblCiencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiencia.setBounds(484, 16, 46, 14);
		add(lblCiencia);
		
		//Campos del formulario
		textNombre = new JTextField();
		textNombre.setBounds(67, 14, 86, 20);
		add(textNombre);
		
		//Se crean los spinners
		SpinnerModel modelo = new SpinnerNumberModel(1, 1, 5, 1);  
		
		spinnerDeporte = new JSpinner(modelo);
		spinnerDeporte.setBounds(214, 14, 40, 20);
		add(spinnerDeporte);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerMusica = new JSpinner(modelo);
		spinnerMusica.setBounds(307, 14, 40, 20);
		add(spinnerMusica);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerEspectaculo = new JSpinner(modelo);
		spinnerEspectaculo.setBounds(434, 14, 40, 20);
		add(spinnerEspectaculo);
		
		modelo = new SpinnerNumberModel(1, 1, 5, 1); 
		spinnerCiencia = new JSpinner(modelo);
		spinnerCiencia.setBounds(531, 14, 40, 20);
		add(spinnerCiencia);
		
		//Botones
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
		btnAgregar.setBounds(242, 57, 89, 23);
		add(btnAgregar);
		
		JButton btnProcesar = new JButton("Procesar!");
		btnProcesar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(datos.size()==0) {
					JOptionPane.showMessageDialog(null, "No se pueden procesar los datos, porque no se encuentran datos ingresados");
				}else {
					UIMain.cambiarADatosProcesados();
				}
				
			}
		});
		btnProcesar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnProcesar.setBounds(228, 259, 120, 36);
		add(btnProcesar);
		
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
		
		
		//CAMBIAR FUNCIONALIDAD DE BOTON
		//EL BOTON TIENE QUE LLEVAR A ALGUN LADO PARA ELEGIR CUANTAS PERSONAS CARGAR
		JButton btnNewButton = new JButton("Cargar Datos Default");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarDatosDefault();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 259, 151, 46);
		add(btnNewButton);
		
		
		
		
		
		
	}
	
	private void cargarDatosDefault() {
		PersonasJSON personas = new PersonasJSON();
		personas = personas.leerJSON("src/datosJSON/Personas.JSON");
		
		for(int i=0 ; i<personas.getCantidadPersonas(); i++) {
			
			String nombre = personas.getPersona(i).getNombre();
			int deporte = personas.getPersona(i).getDeporte();
			int musica = personas.getPersona(i).getMusica();
			int espectaculo = personas.getPersona(i).getEspectaculo();
			int ciencia = personas.getPersona(i).getCiencia();
			
			model.addRow(new String[]{ nombre, String.valueOf(deporte), String.valueOf(musica),
					String.valueOf(espectaculo), String.valueOf(ciencia) });
		}
		
		datos.addAll(personas.getTodasLasPersonas());
		
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
	
	public ArrayList<Persona> getDatos(){
		return datos;
	}
}
