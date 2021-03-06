package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLayeredPane;

public class UIMain {

	private JFrame frmTrabajoPractico;
	private static final JLayeredPane layeredPane = new JLayeredPane();
	
	private static JPanelTomarDatos panelDatos;
	private static JPanelDatosProcesados panelDatosProcesados;
	private static JPanelEstadisticas panelEstadisticas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMain window = new UIMain();
					window.frmTrabajoPractico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrabajoPractico = new JFrame();
		frmTrabajoPractico.setTitle("Trabajo Practico 2");
		frmTrabajoPractico.setBounds(100, 100, 597, 355);
		frmTrabajoPractico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrabajoPractico.getContentPane().setLayout(null);
		layeredPane.setBounds(0, 0, 581, 316);
		frmTrabajoPractico.getContentPane().add(layeredPane);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		panelDatos = new JPanelTomarDatos();
		
		panelDatosProcesados = new JPanelDatosProcesados();
		panelDatosProcesados.setVisible(false);
		
		panelEstadisticas = new JPanelEstadisticas();
		panelEstadisticas.setVisible(false);
		
		layeredPane.add(panelDatos);
		layeredPane.add(panelDatosProcesados);
		layeredPane.add(panelEstadisticas);
		
		
	}
	
	//Este metodo "reinicia" todo por default
	public static void volverACargarDatos() {
		panelDatosProcesados.setVisible(false);  //Primero quito el panelDatosProcesados de la vision del usuario
		
		//Se vuelve a declarar todos los paneles
		panelEstadisticas = new JPanelEstadisticas();
		panelDatosProcesados = new JPanelDatosProcesados();
		panelDatos = new JPanelTomarDatos(); 
		
		//Se actualiza el layeredPane quitando los componentes anteriores y metiendo los nuevos.
		layeredPane.remove(panelDatos);
		layeredPane.add(panelDatos);
		
		layeredPane.remove(panelDatosProcesados);
		layeredPane.add(panelDatosProcesados);
		
		layeredPane.remove(panelEstadisticas);
		layeredPane.add(panelEstadisticas);
		
		//Se ajusta la visibilidad de los paneles
		panelDatosProcesados.setVisible(false);
		panelEstadisticas.setVisible(false);
		panelDatos.setVisible(true);
		
	}
	
	//Se realiza la transicion del panel de datos al panel de datos procesados
	public static void cambiarADatosProcesados() {
		
		panelDatosProcesados.procesarDatos(panelDatos.getDatos());
		
		panelDatos.setVisible(false);
		panelDatosProcesados.setVisible(true);
		
	}
	
	//Se realiza la transicion del panel de datos procesados hacia el panel en donde se muestran las estadisticas
	public static void cambiarAEstadisticas() {
		
		panelDatosProcesados.setVisible(false);
		
		panelEstadisticas.setPromediosDeGrupos(panelDatosProcesados.getPromediosGrupo1(), panelDatosProcesados.getPromediosGrupo2());
		panelEstadisticas.setVisible(true);
		
	}
	
	//Se realiza la transicion del panel de estadisticas al panel de datos procesados
	public static void volverADatosProcesados() {
		
		panelEstadisticas.setVisible(false);
		panelDatosProcesados.setVisible(true);
		
	}
	
}
