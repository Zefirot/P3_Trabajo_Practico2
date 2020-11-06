package interfaz;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import codigoBusiness.Persona;
import codigoBusiness.ProcesarDatos;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelDatosProcesados extends JPanel {
	private JTable tableGrupo1;
	private JTable tableGrupo2;

	private DefaultTableModel modelGrupo1;
	private DefaultTableModel modelGrupo2;
	private JScrollPane scrollPaneTable1;
	private JScrollPane scrollPaneTable2;
	
	private ArrayList<Persona> todasLasPersonas;
	
	private ArrayList<Integer> promediosGrupo1;
	private ArrayList<Integer> promediosGrupo2;
	
	/**
	 * Create the panel.
	 */
	public JPanelDatosProcesados() {
		setLayout(null);
		setBounds(0, 0, 581, 316);
		
		//Labels
		JLabel lblGrupo1 = new JLabel("Grupo 1");
		lblGrupo1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrupo1.setBounds(95, 24, 54, 14);
		add(lblGrupo1);
		
		JLabel lblGrupo2 = new JLabel("Grupo 2");
		lblGrupo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGrupo2.setBounds(411, 24, 46, 14);
		add(lblGrupo2);
		
		//Se crea el modelado de las tables
		modelGrupo1 = new DefaultTableModel();
		modelGrupo1.addColumn("Nombre");
		modelGrupo1.addColumn("Deporte");
		modelGrupo1.addColumn("Musica");
		modelGrupo1.addColumn("Espectaculos");
		modelGrupo1.addColumn("Ciencia");
		
		modelGrupo2 = new DefaultTableModel();
		modelGrupo2.addColumn("Nombre");
		modelGrupo2.addColumn("Deporte");
		modelGrupo2.addColumn("Musica");
		modelGrupo2.addColumn("Espectaculos");
		modelGrupo2.addColumn("Ciencia");
		
		//Se cran las tables como tal
		scrollPaneTable1 = new JScrollPane();
		scrollPaneTable1.setBounds(10, 49, 269, 194);
		add(scrollPaneTable1);
		
		tableGrupo1 = new JTable(modelGrupo1);
		scrollPaneTable1.setViewportView(tableGrupo1);
		
		scrollPaneTable2 = new JScrollPane();
		scrollPaneTable2.setBounds(302, 49, 269, 194);
		add(scrollPaneTable2);
		
		tableGrupo2 = new JTable(modelGrupo2);
		scrollPaneTable2.setViewportView(tableGrupo2);
		
		
		//Botones
		JButton btnVerEstadisticas = new JButton("Ver Estadisticas");
		btnVerEstadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UIMain.cambiarAEstadisticas();
				
			}
		});
		btnVerEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVerEstadisticas.setBounds(75, 282, 123, 23);
		add(btnVerEstadisticas);
		
		JButton btnVolverACargarDatos = new JButton("Volver a cargar los datos");
		btnVolverACargarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UIMain.volverACargarDatos();
				
			}
		});
		btnVolverACargarDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVolverACargarDatos.setBounds(356, 282, 190, 24);
		add(btnVolverACargarDatos);
			
		
	}
	
	public void procesarDatos(ArrayList<Persona> personas) {
		this.todasLasPersonas=personas;
		
		ProcesarDatos datosProcesados = new ProcesarDatos(todasLasPersonas);
		
		ArrayList<Persona> grupo1 = datosProcesados.getGrupo1();
		ArrayList<Persona> grupo2 = datosProcesados.getGrupo2();
		
		actualizarTable1(grupo1);
		actualizarTable2(grupo2);
		
		promediosGrupo1 = ProcesarDatos.getPromedio(grupo1);
		promediosGrupo2 = ProcesarDatos.getPromedio(grupo2);
		
	}
	
	private void actualizarTable1(ArrayList<Persona> grupo1) {
		
		
		for(Persona persona : grupo1) {
		
			String nombre = persona.getNombre();
			String deporte = String.valueOf(persona.getDeporte());
			String musica = String.valueOf(persona.getMusica());
			String espectaculo = String.valueOf(persona.getEspectaculo());
			String ciencia = String.valueOf(persona.getCiencia());
			
	
			modelGrupo1.addRow(new String[] { nombre,deporte, musica,espectaculo,ciencia });
			
		}
		
		
	}
	private void actualizarTable2(ArrayList<Persona> grupo2) {

		if(grupo2==null) {
			return;
		}
		
		for(Persona persona : grupo2) {

			String nombre = persona.getNombre();
			String deporte = String.valueOf(persona.getDeporte());
			String musica = String.valueOf(persona.getMusica());
			String espectaculo = String.valueOf(persona.getEspectaculo());
			String ciencia = String.valueOf(persona.getCiencia());


			modelGrupo2.addRow(new String[] { nombre,deporte, musica,espectaculo,ciencia });

		}


	}
	
	public ArrayList<Integer> getPromediosGrupo1(){
		return promediosGrupo1;
	}
	
	public ArrayList<Integer> getPromediosGrupo2(){
		return promediosGrupo2;
	}
}
