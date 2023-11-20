package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Controllers;
import tables.ClienteDB;
import tables.ContaDB;

public class ContaPanel extends JPanel{

    public JTextField valor;
    public JTextField forma;
    public JLabel texto;

    public ContaPanel(String idmanut) {
        JFrame conta = new JFrame();
        conta.setVisible(true);
        conta.setSize(250, 400);
        conta.setTitle("Mecanica UFMS");
        
        
        var panel = new JPanel();

        valor = new JTextField();

        forma = new JTextField();
        texto = new JLabel("Finalizar Manutenção");
        texto.setFont(new Font("Arial", Font.PLAIN, 20));;

        panel.add(texto);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Valor: "));
        panel.add(valor);

        panel.add(new JLabel("Forma de pagamento: "));
        panel.add(forma);

        var buttons = new JPanel();
        var bCancelar = new JButton("Cancelar");
        var bCadastrar = new JButton("Finalizar");

         // bCancelar.setBackground(Color.RED);
        bCancelar.setForeground(Color.RED);
        // bCadastrar.setBackground(Color.GREEN);
        bCadastrar.setForeground(Color.GREEN);

        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(bCancelar);
        buttons.add(bCadastrar);

        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            conta.dispose();
            }
        });

         bCadastrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(!valor.getText().isEmpty() && !forma.getText().isEmpty()){
          criaConta(Integer.parseInt(idmanut), forma.getText(), Double.parseDouble(valor.getText()));
          
          JOptionPane optionPane = new JOptionPane();
          optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
          optionPane.setMessage("Conta Cadastrada");       
          JDialog dialog = optionPane.createDialog(null, "Cadastro Realizado");
          dialog.setVisible(true);
          new ComprovantePanel();
        }else{
          JOptionPane optionPane = new JOptionPane();
          optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
          optionPane.setMessage("Faltam dados a serem preenchidos");       
          JDialog dialog = optionPane.createDialog(null, "Erro");
          dialog.setVisible(true);     
        }
      }
    });
        
        // conta.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        conta.add(panel, BorderLayout.CENTER);   
        conta.add(buttons, BorderLayout.SOUTH);

        conta.setLocationRelativeTo(null);
    }

    private void criaConta(Integer idmanut, String forma, Double valor){
        new Controllers().insereConta(idmanut, forma, valor);
    }
}
