package ec.edu.puce.voto.formulario;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.voto.dominio.Candidatos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.Font;

public class CrearCandidatos extends JInternalFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	private Candidatos candidato;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnCancelar;
	private List<Candidatos> candidatos;
	private int idCandidato;
	
	public CrearCandidatos(List<Candidatos> candidatos, int idCandidato) {
		getContentPane().setBackground(new Color(74, 149, 149));
		this.idCandidato=idCandidato;
		this.candidatos=candidatos;
		setTitle("CREAR CANDIDATOS");
		setBounds(100, 100, 443, 385);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Cambria Math", Font.BOLD, 13));
		lblNombres.setBounds(14, 50, 70, 15);
		getContentPane().add(lblNombres);

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarCandidato();
			}
		});
		txtNombre.setBounds(85, 48, 166, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(295, 66, 117, 25);
		getContentPane().add(btnNuevo);

		btnGuardar = new JButton("Agregar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(294, 22, 117, 25);
		getContentPane().add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(151, 308, 117, 25);
		getContentPane().add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 390, 176);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }));
		scrollPane.setViewportView(table);

		model = (DefaultTableModel) table.getModel();
		agregarFila();
	}

	private void nuevo() {
		candidato = new Candidatos();
		txtNombre.setText(candidato.getNombre());
	}
	
	

	private void agregarCandidato() {
		candidato = new Candidatos();
		candidato.setId(idCandidato);
		candidato.setNombre(txtNombre.getText());
		candidatos.add(candidato);
		agregarFila();
		txtNombre.setText("");
		idCandidato++;
		
	}

	private void agregarFila() {
		model.setRowCount(0);
		for (Candidatos candidato : candidatos) {
			Object[] fila = new Object[1];
			fila[0] = candidato.getNombre();
			model.addRow(fila);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			nuevo();
		} else if (e.getSource() == btnGuardar) {
			agregarCandidato();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
		else if (e.getSource() == txtNombre) {
			agregarCandidato();
		}
	}	

}

