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

public class JPanelDatosProcesados extends JPanel {
	private JTable tableGrupo1;
	private JTable tableGrupo2;

	private DefaultTableModel modelGrupo1;
	private DefaultTableModel modelGrupo2;
	private JScrollPane scrollPaneTable1;
	private JScrollPane scrollPaneTable2;
	
	private ArrayList<Persona> datos;
	
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
		
		
		
		
	}
	
	public void procesarDatos(ArrayList<Persona> datos) {
		this.datos=datos;
		
		ProcesarDatos datosProcesados = new ProcesarDatos(datos);
		
		actualizarTable1(datosProcesados.getGrupo1());
		actualizarTable2(datosProcesados.getGrupo2());
		
	}
	
	private void actualizarTable1(Set<Integer> grupo1) {
		
		
		for(Integer persona : grupo1) {
			
			Persona personaActual=datos.get(persona);
			
			String nombre = personaActual.getNombre();
			String deporte = String.valueOf(personaActual.getDeporte());
			String musica = String.valueOf(personaActual.getMusica());
			String espectaculo = String.valueOf(personaActual.getEspectaculo());
			String ciencia = String.valueOf(personaActual.getCiencia());
			
	
			modelGrupo1.addRow(new String[] { nombre,deporte, musica,espectaculo,ciencia });
			
		}
		
		
	}
	private void actualizarTable2(Set<Integer> grupo2) {

		if(grupo2==null) {
			return;
		}
		
		for(Integer persona : grupo2) {

			Persona personaActual=datos.get(persona);

			String nombre = personaActual.getNombre();
			String deporte = String.valueOf(personaActual.getDeporte());
			String musica = String.valueOf(personaActual.getMusica());
			String espectaculo = String.valueOf(personaActual.getEspectaculo());
			String ciencia = String.valueOf(personaActual.getCiencia());


			modelGrupo2.addRow(new String[] { nombre,deporte, musica,espectaculo,ciencia });

		}


	}
	 
}
