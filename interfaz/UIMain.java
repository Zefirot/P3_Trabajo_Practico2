package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLayeredPane;

public class UIMain {

	private JFrame frame;
	private final JLayeredPane layeredPane = new JLayeredPane();
	
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		layeredPane.setBounds(0, 0, 581, 316);
		frame.getContentPane().add(layeredPane);
		
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
	
	
	public static void cambiarADatosProcesados() {
		
		panelDatosProcesados.procesarDatos(panelDatos.getDatos());
		
		panelDatos.setVisible(false);
		panelDatosProcesados.setVisible(true);
		
	}
	
	public static void cambiarAEstadisticas() {
		
		panelDatosProcesados.setVisible(false);
		
		panelEstadisticas.setPromediosGrupo1(panelDatosProcesados.getPromediosGrupo1());
		panelEstadisticas.setPromediosGrupo2(panelDatosProcesados.getPromediosGrupo2());
	
		panelEstadisticas.setVisible(true);
		
	}
	
}
