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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelEstadisticas extends JPanel {

	//ProgressBars Grupo1
	private JProgressBar progressBarDeporteG1;
	private JProgressBar progressBarMusicaG1;
	private JProgressBar progressBarEspectaculoG1;
	private JProgressBar progressBarCienciaG1;
	
	//ProgressBars Grupo2
	private JProgressBar progressBarDeporteG2;
	private JProgressBar progressBarMusicaG2;
	private JProgressBar progressBarEspectaculoG2;
	private JProgressBar progressBarCienciaG2;
	
	
	
	public JPanelEstadisticas() {
		setLayout(null);
		setBounds(0, 0, 581, 316);
		
		
		//Agrupacion de labels y progressBars de Grupo 1
		
		JPanel panelGrupo1 = new JPanel();
		panelGrupo1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Promedios Grupo 1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGrupo1.setBounds(24, 11, 257, 223);
		add(panelGrupo1);
		panelGrupo1.setLayout(null);
		
		//Labels
		JLabel lblDeporteG1 = new JLabel("Deporte");
		lblDeporteG1.setBounds(22, 16, 46, 14);
		panelGrupo1.add(lblDeporteG1);
		lblDeporteG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblMusicaG1 = new JLabel("Musica");
		lblMusicaG1.setBounds(22, 68, 46, 14);
		panelGrupo1.add(lblMusicaG1);
		lblMusicaG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblEspectaculoG1 = new JLabel("Espectaculo");
		lblEspectaculoG1.setBounds(6, 126, 67, 14);
		panelGrupo1.add(lblEspectaculoG1);
		lblEspectaculoG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCienciaG1 = new JLabel("Ciencia");
		lblCienciaG1.setBounds(22, 186, 46, 14);
		panelGrupo1.add(lblCienciaG1);
		lblCienciaG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		//Progress Bars
		
		UIManager.put("ProgressBar.selectionBackground", Color.RED);
				
		progressBarDeporteG1 = new JProgressBar();
		progressBarDeporteG1.setBounds(78, 16, 146, 14);
		panelGrupo1.add(progressBarDeporteG1);
		progressBarDeporteG1.setForeground(Color.BLACK);
		progressBarDeporteG1.setMinimum(0);
		progressBarDeporteG1.setMaximum(5);
		progressBarDeporteG1.setStringPainted(true);
		
		progressBarMusicaG1 = new JProgressBar();
		progressBarMusicaG1.setBounds(78, 68, 146, 14);
		panelGrupo1.add(progressBarMusicaG1);
		progressBarMusicaG1.setForeground(Color.BLACK);
		progressBarMusicaG1.setMinimum(0);
		progressBarMusicaG1.setMaximum(5);
		progressBarMusicaG1.setStringPainted(true);

		progressBarEspectaculoG1 = new JProgressBar();
		progressBarEspectaculoG1.setBounds(78, 126, 146, 14);
		panelGrupo1.add(progressBarEspectaculoG1);
		progressBarEspectaculoG1.setForeground(Color.BLACK);
		progressBarEspectaculoG1.setMinimum(0);
		progressBarEspectaculoG1.setMaximum(5);
		progressBarEspectaculoG1.setStringPainted(true);

		progressBarCienciaG1 = new JProgressBar();
		progressBarCienciaG1.setBounds(78, 186, 146, 14);
		panelGrupo1.add(progressBarCienciaG1);
		progressBarCienciaG1.setForeground(Color.BLACK);
		progressBarCienciaG1.setMinimum(0);
		progressBarCienciaG1.setMaximum(5);
		progressBarCienciaG1.setStringPainted(true);
		
		
		//Agrupacion de labels y progressBars de Grupo 2
		
		JPanel panelGrupo2 = new JPanel();
		panelGrupo2.setLayout(null);
		panelGrupo2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Promedios Grupo 2", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGrupo2.setBounds(299, 11, 257, 223);
		add(panelGrupo2);
		
		//Labels
		JLabel lblDeporteG2 = new JLabel("Deporte");
		lblDeporteG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeporteG2.setBounds(22, 16, 46, 14);
		panelGrupo2.add(lblDeporteG2);
		
		JLabel lblMusicaG2 = new JLabel("Musica");
		lblMusicaG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMusicaG2.setBounds(22, 68, 46, 14);
		panelGrupo2.add(lblMusicaG2);
		
		JLabel lblEspectaculoG2 = new JLabel("Espectaculo");
		lblEspectaculoG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspectaculoG2.setBounds(6, 126, 67, 14);
		panelGrupo2.add(lblEspectaculoG2);
		
		JLabel lblCienciaG2 = new JLabel("Ciencia");
		lblCienciaG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCienciaG2.setBounds(22, 186, 46, 14);
		panelGrupo2.add(lblCienciaG2);
		
		//Progress Bars
		progressBarDeporteG2 = new JProgressBar();
		progressBarDeporteG2.setStringPainted(true);
		progressBarDeporteG2.setString("Promedio: 0");
		progressBarDeporteG2.setMinimum(0);
		progressBarDeporteG2.setMaximum(5);
		progressBarDeporteG2.setForeground(Color.BLACK);
		progressBarDeporteG2.setBounds(78, 16, 146, 14);
		panelGrupo2.add(progressBarDeporteG2);
		
		progressBarMusicaG2 = new JProgressBar();
		progressBarMusicaG2.setStringPainted(true);
		progressBarMusicaG2.setString("Promedio: 0");
		progressBarMusicaG2.setMinimum(0);
		progressBarMusicaG2.setMaximum(5);
		progressBarMusicaG2.setForeground(Color.BLACK);
		progressBarMusicaG2.setBounds(78, 68, 146, 14);
		panelGrupo2.add(progressBarMusicaG2);
		
		progressBarEspectaculoG2 = new JProgressBar();
		progressBarEspectaculoG2.setStringPainted(true);
		progressBarEspectaculoG2.setString("Promedio: 0");
		progressBarEspectaculoG2.setMinimum(0);
		progressBarEspectaculoG2.setMaximum(5);
		progressBarEspectaculoG2.setForeground(Color.BLACK);
		progressBarEspectaculoG2.setBounds(78, 126, 146, 14);
		panelGrupo2.add(progressBarEspectaculoG2);
		
		progressBarCienciaG2 = new JProgressBar();
		progressBarCienciaG2.setStringPainted(true);
		progressBarCienciaG2.setString("Promedio: 0");
		progressBarCienciaG2.setMinimum(0);
		progressBarCienciaG2.setMaximum(5);
		progressBarCienciaG2.setForeground(Color.BLACK);
		progressBarCienciaG2.setBounds(78, 186, 146, 14);
		panelGrupo2.add(progressBarCienciaG2);
		

		JButton btnVolver = new JButton("Volver ");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				UIMain.volverADatosProcesados();
				
			}
		});
		btnVolver.setBounds(246, 263, 89, 23);
		add(btnVolver);
		
	}
	
	//Esta funcion actualiza todos los promedios
	public void setPromediosDeGrupos(ArrayList<Integer> promediosGrupo1, ArrayList<Integer> promediosGrupo2) {
		
		//Obtener valores para el grupo 1 y actualizar sus progressBars.
		int promedioDeporteG1 = promediosGrupo1.get(0);
		int promedioMusicaG1 = promediosGrupo1.get(1);
		int promedioEspectaculoG1 = promediosGrupo1.get(2);
		int promedioCienciaG1 = promediosGrupo1.get(3);
		
		actualizarBarsG1(promedioDeporteG1, promedioMusicaG1, promedioEspectaculoG1, promedioCienciaG1);
		
		//Si existe un posible grupo 2 se obtienen los valores para el grupo 2 y se actualizan sus progressBars.
		if(promediosGrupo2!=null) {
			
			int promedioDeporteG2 = promediosGrupo2.get(0);
			int promedioMusicaG2 = promediosGrupo2.get(1);
			int promedioEspectaculoG2 = promediosGrupo2.get(2);
			int promedioCienciaG2 = promediosGrupo2.get(3);
			
			actualizarBarsG2(promedioDeporteG2, promedioMusicaG2, promedioEspectaculoG2, promedioCienciaG2);
			
		}
		
	}
	
	//Actualiza los promedios del grupo 1
	private void actualizarBarsG1(int promedioDeporte, int promedioMusica, int promedioEspectaculo, int promedioCiencia ) {
		
		progressBarDeporteG1.setValue(promedioDeporte);
		progressBarDeporteG1.setString("Promedio: "+String.valueOf(promedioDeporte));
		
		progressBarMusicaG1.setValue(promedioMusica);
		progressBarMusicaG1.setString("Promedio: "+String.valueOf(promedioMusica));
		
		progressBarEspectaculoG1.setValue(promedioEspectaculo);
		progressBarEspectaculoG1.setString("Promedio: "+String.valueOf(promedioEspectaculo));
		
		progressBarCienciaG1.setValue(promedioCiencia);
		progressBarCienciaG1.setString("Promedio: "+String.valueOf(promedioCiencia));
		
	}
	
	//Actualiza los promedios del grupo 2
	private void actualizarBarsG2(int promedioDeporte, int promedioMusica, int promedioEspectaculo, int promedioCiencia ) {
		
		progressBarDeporteG2.setValue(promedioDeporte);
		progressBarDeporteG2.setString("Promedio: "+String.valueOf(promedioDeporte));
		
		progressBarMusicaG2.setValue(promedioMusica);
		progressBarMusicaG2.setString("Promedio: "+String.valueOf(promedioMusica));
		
		progressBarEspectaculoG2.setValue(promedioEspectaculo);
		progressBarEspectaculoG2.setString("Promedio: "+String.valueOf(promedioEspectaculo));
		
		progressBarCienciaG2.setValue(promedioCiencia);
		progressBarCienciaG2.setString("Promedio: "+String.valueOf(promedioCiencia));
		
	}
}
