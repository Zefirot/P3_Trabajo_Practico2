package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class JPanelEstadisticas extends JPanel {

	private JProgressBar progressBarDeporte;
	private JProgressBar progressBarMusica;
	private JProgressBar progressBarEspectaculo;
	private JProgressBar progressBarCiencia;
	
	
	/**
	 * Create the panel.
	 */
	public JPanelEstadisticas() {
		setLayout(null);
		setBounds(0, 0, 581, 316);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Promedios Grupo 1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(32, 11, 257, 223);
		add(panel);
		panel.setLayout(null);
		
		//Labels
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setBounds(22, 16, 46, 14);
		panel.add(lblDeporte);
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMusica = new JLabel("Musica");
		lblMusica.setBounds(22, 68, 46, 14);
		panel.add(lblMusica);
		lblMusica.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEspectaculo = new JLabel("Espectaculo");
		lblEspectaculo.setBounds(6, 126, 67, 14);
		panel.add(lblEspectaculo);
		lblEspectaculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCiencia = new JLabel("Ciencia");
		lblCiencia.setBounds(22, 186, 46, 14);
		panel.add(lblCiencia);
		lblCiencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		//Progress Bars
		
		UIManager.put("ProgressBar.selectionBackground", Color.RED);
				
		progressBarDeporte = new JProgressBar();
		progressBarDeporte.setBounds(78, 16, 146, 14);
		panel.add(progressBarDeporte);
		progressBarDeporte.setForeground(Color.BLACK);
		progressBarDeporte.setMinimum(1);
		progressBarDeporte.setMaximum(5);
		progressBarDeporte.setStringPainted(true);
		
		progressBarMusica = new JProgressBar();
		progressBarMusica.setBounds(78, 68, 146, 14);
		panel.add(progressBarMusica);
		progressBarMusica.setForeground(Color.BLACK);
		progressBarMusica.setMinimum(1);
		progressBarMusica.setMaximum(5);
		progressBarMusica.setStringPainted(true);

		progressBarEspectaculo = new JProgressBar();
		progressBarEspectaculo.setBounds(78, 126, 146, 14);
		panel.add(progressBarEspectaculo);
		progressBarEspectaculo.setForeground(Color.BLACK);
		progressBarEspectaculo.setMinimum(1);
		progressBarEspectaculo.setMaximum(5);
		progressBarEspectaculo.setStringPainted(true);

		progressBarCiencia = new JProgressBar();
		progressBarCiencia.setBounds(78, 186, 146, 14);
		panel.add(progressBarCiencia);
		progressBarCiencia.setForeground(Color.BLACK);
		progressBarCiencia.setMinimum(1);
		progressBarCiencia.setMaximum(5);
		progressBarCiencia.setStringPainted(true);
		
		
		
	}
	
	
	public void setPromediosGrupo1(ArrayList<Integer> promedios) {
		
		int promedioDeporte = promedios.get(0);
		int promedioMusica = promedios.get(1);
		int promedioEspectaculo = promedios.get(2);
		int promedioCiencia = promedios.get(3);
		
		progressBarDeporte.setValue(promedioDeporte);
		progressBarDeporte.setString("Promedio: "+String.valueOf(promedioDeporte));
		
		progressBarMusica.setValue(promedioMusica);
		progressBarMusica.setString("Promedio: "+String.valueOf(promedioMusica));
		
		progressBarEspectaculo.setValue(promedioEspectaculo);
		progressBarEspectaculo.setString("Promedio: "+String.valueOf(promedioEspectaculo));
		
		progressBarCiencia.setValue(promedioCiencia);
		progressBarCiencia.setString("Promedio: "+String.valueOf(promedioCiencia));
		
	}
	
	public void setPromediosGrupo2(ArrayList<Integer> promedios) {
		
	}
	
}
