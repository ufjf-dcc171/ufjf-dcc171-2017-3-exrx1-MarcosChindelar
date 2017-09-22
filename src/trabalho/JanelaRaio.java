/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author M.Chin
 */
class JanelaRaio extends JFrame {

    private final List<Relampagos> relampagos = new ArrayList<Relampagos>();
    private final List<Relampagos> eventos = new ArrayList<Relampagos>();
    private final JButton btCriaRelampago = new JButton("Cria Relampago");
    private final JButton btExcluiRelampago = new JButton("Exclui Relampago");
    private final JButton btEditaRelampago = new JButton("Edita Relampago");
    private JTextField txLongitude = new JTextField("0.00");
    private JTextField txLatitude = new JTextField("0.00");
    private JTextField txData = new JTextField("dd/MM/yyyy HH:mm");
    private JTextField txDescricao = new JTextField("Descrição");
    private final JList<Relampagos> lstRelampagos = new JList<Relampagos>(new DefaultListModel<>());

    public JanelaRaio() {

        lstRelampagos.setModel(new RelampagoListModel(relampagos));
        lstRelampagos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel botoes = new JPanel(new GridLayout(4, 2));
        JPanel edits = new JPanel(new GridLayout(4, 2));

        add(edits, BorderLayout.CENTER);
        edits.add(txLatitude);
        edits.add(txLongitude);
        edits.add(txData);
        edits.add(txDescricao);
        add(botoes, BorderLayout.SOUTH);
        botoes.add(btCriaRelampago);
        botoes.add(btEditaRelampago);
        botoes.add(btExcluiRelampago);

        add(new JScrollPane(lstRelampagos), BorderLayout.WEST);

        btCriaRelampago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float longitude = Float.parseFloat(txLatitude.getText());
                float latitude = Float.parseFloat(txLatitude.getText());
                String descricao = txLatitude.getText();
                SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date data = new Date();
                s.format(data);
                s.setLenient(false);
                Relampagos r = new Relampagos();
                try {
                    r.setData(data = s.parse(txData.getText()));
                } catch (ParseException ex) {
                    Logger.getLogger(JanelaRaio.class.getName()).log(Level.SEVERE, null, ex);
                }

                r.setDestricao(descricao);
                r.setLatitude(latitude);
                r.setLongitude(longitude);

                relampagos.add(r);
                lstRelampagos.updateUI();
            }
        });

        btExcluiRelampago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstRelampagos.isSelectionEmpty()) {
                    return;
                }
                relampagos.remove(lstRelampagos.getSelectedValue());
                lstRelampagos.clearSelection();
                lstRelampagos.updateUI();
            }
        });
        btEditaRelampago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txLatitude.setText("0.00");
                txLongitude.setText("0.00");
                txDescricao.setText("Descrição");
                txData.setText("dd/MM/yyyy HH:mm");
            }
        });
        lstRelampagos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Relampagos selecionada = lstRelampagos.getSelectedValue();
                if (selecionada != null) {
                    txLatitude.setText(Float.toString(selecionada.getLatitude()));
                    txLongitude.setText(Float.toString(selecionada.getLongitude()));
                    txDescricao.setText(selecionada.getDestricao());
                    SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                
                s.setLenient(false);
                    txData.setText(s.format(selecionada.getData()));
                } else {
                    lstRelampagos.setModel(new DefaultListModel<>());
                }
            }
        });
    }
}
