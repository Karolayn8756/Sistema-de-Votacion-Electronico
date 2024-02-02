package ec.edu.puce.voto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.puce.voto.dominio.Candidatos;
import ec.edu.puce.voto.dominio.Cursos;
import ec.edu.puce.voto.dominio.Estudiante;
import ec.edu.puce.voto.dominio.Mesas;
import ec.edu.puce.voto.formulario.CrearCandidatos;
import ec.edu.puce.voto.formulario.CrearCursos;
import ec.edu.puce.voto.formulario.CrearEstudiantes;
import ec.edu.puce.voto.formulario.CrearMesas;
import ec.edu.puce.voto.formulario.Reporte;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Menuprincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contenedor;
	private JDesktopPane desktopPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmMesas;
	private JMenuItem mntmBocaDeUrna;

	public List<Candidatos> candidatos = new ArrayList<>();
	public List<Mesas> mesas = new ArrayList<Mesas>();
	public List<Estudiante> estudiantes = new ArrayList<Estudiante>();
	public List<Cursos> cursos = new ArrayList<Cursos>();
	public String[] nombresMesas = {};
	
	public int idCandidato = 1;
	public int idEstudiantes = 1;
	private JMenuItem mntmResultadosBarras;
	private JMenuItem mntmResultadosPastel;
	private JMenuItem mntmPadronElectoral;
	private JMenuItem mntmCandidatos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menuprincipal frame = new Menuprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menuprincipal() {
		
		
		for (String mesa: nombresMesas) {
			Mesas mesaE = new Mesas(mesa);
			mesas.add(mesaE);
		}
		setTitle("SISTEMA DE VOTO ELECTRÓNICO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 64, 128));
		menuBar.setBackground(new Color(192, 191, 188));
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Cambria Math", Font.BOLD, 16));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Cambria Math", Font.BOLD, 16));
		mnArchivo.add(mntmSalir);

		JMenu mnAdministracin = new JMenu("Administración");
		mnAdministracin.setFont(new Font("Cambria Math", Font.BOLD, 16));
		menuBar.add(mnAdministracin);

		mntmMesas = new JMenuItem("Mesas");
		mntmMesas.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon5.png")));
		mntmMesas.setFont(new Font("Cambria Math", Font.BOLD, 16));
		mntmMesas.addActionListener(this);
		mnAdministracin.add(mntmMesas);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mntmCursos.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon4.png")));
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cursoVentana();
			}
		});
		mntmCursos.setFont(new Font("Cambria Math", Font.BOLD, 16));
		mnAdministracin.add(mntmCursos);
		
		JMenuItem mntmEstudiantes = new JMenuItem("Estudiantes");
		mntmEstudiantes.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon3.png")));
		mntmEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estudianteVentana();
			}
		});
		mntmEstudiantes.setFont(new Font("Cambria Math", Font.BOLD, 16));
		mnAdministracin.add(mntmEstudiantes);
		
		mntmCandidatos = new JMenuItem("Candidatos");
		mntmCandidatos.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon3.png")));
		mntmCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidatoVentana();
			}
		});
		mntmCandidatos.setFont(new Font("Cambria Math", Font.BOLD, 16));
		mnAdministracin.add(mntmCandidatos);
		
				JMenu mnReportes = new JMenu("Reportes");
				mnReportes.setFont(new Font("Cambria Math", Font.BOLD, 16));
				menuBar.add(mnReportes);
				
						mntmPadronElectoral = new JMenuItem("Reportes PE");
						mntmPadronElectoral.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon6.png")));
						mntmPadronElectoral.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Reporte rpe = new Reporte(mesas, cursos, estudiantes);
								desktopPane.add(rpe);
								rpe.setVisible(true);
							}
						});
						mntmPadronElectoral.setFont(new Font("Cambria Math", Font.BOLD, 16));
						mnReportes.add(mntmPadronElectoral);
						
								JMenuItem mntmResultadosPorCantn = new JMenuItem("Resultados por cantón o ciudad");
								mntmResultadosPorCantn.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
									}
								});
								mntmResultadosPorCantn.setFont(new Font("Dialog", Font.BOLD, 16));
								

		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setFont(new Font("Dialog", Font.BOLD, 16));
		

		mntmBocaDeUrna = new JMenuItem("Boca de Urna");
		mntmBocaDeUrna.setFont(new Font("Dialog", Font.BOLD, 16));
		mntmBocaDeUrna.addActionListener(this);
		mnProceso.add(mntmBocaDeUrna);

		JMenu mnGrficos = new JMenu("Gráficos");
		mnGrficos.setFont(new Font("Dialog", Font.BOLD, 16));
		

		mntmResultadosBarras = new JMenuItem("Resultados Barras");
		mnGrficos.add(mntmResultadosBarras);
		mntmResultadosBarras.addActionListener(this);
		mntmResultadosBarras.setFont(new Font("Dialog", Font.BOLD, 16));

		mntmResultadosPastel = new JMenuItem("Resultados Pastel");
		mnGrficos.add(mntmResultadosPastel);
		mntmResultadosPastel.addActionListener(this);
		mntmResultadosPastel.setFont(new Font("Dialog", Font.BOLD, 16));
		contenedor = new JPanel();
		contenedor.setBackground(new Color(255, 255, 255));
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contenedor);
		contenedor.setLayout(new CardLayout(0, 0));

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(85, 170, 170));
		contenedor.add(desktopPane, "name_35522358088801");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menuprincipal.class.getResource("/ec/edu/puce/icon/icon.png")));
		lblNewLabel.setBounds(146, 93, 472, 313);
		desktopPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			dispose();
		} else if (e.getSource() == mntmMesas) {
			CrearMesas crearMesa = new CrearMesas(mesas);
			desktopPane.add(crearMesa);
			crearMesa.setVisible(true);

		} else if (e.getSource() == mntmBocaDeUrna) {
			
		}  else if (e.getSource() == mntmResultadosPastel) {
			
		} 

	}
	
	public void candidatoVentana() {
		CrearCandidatos crearCandidato = new CrearCandidatos(candidatos, idCandidato);
		desktopPane.add(crearCandidato);
		crearCandidato.setVisible(true);
	}
	
	public void estudianteVentana() {
		CrearEstudiantes crearEstudiante = new CrearEstudiantes(cursos, estudiantes, idEstudiantes);
		desktopPane.add(crearEstudiante);
		crearEstudiante.setVisible(true);
	}
	
	public void cursoVentana() {
		CrearCursos crearCurso = new CrearCursos(mesas, cursos);
		desktopPane.add(crearCurso);
		crearCurso.setVisible(true);
	}	
}
