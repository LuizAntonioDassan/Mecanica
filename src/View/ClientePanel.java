package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tables.ClienteDB;

public class ClientePanel extends JPanel {
  public JTextField nome;
  public JTextField numero;
  public JTextField cpf;
  public JTextField endereco;
  public JTextField email;

  public ClientePanel() {
    var panel = new JPanel();
    
    nome = new JTextField();
    numero = new JTextField();
    cpf = new JTextField();
    endereco = new JTextField();
    email = new JTextField();
    
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(new JLabel("Nome: "));
    panel.add(nome);
    panel.add(new JLabel("Numero: "));
    panel.add(numero);
    panel.add(new JLabel("CPF: "));
    panel.add(cpf);
    panel.add(new JLabel("Endereco: "));
    panel.add(endereco);
    panel.add(new JLabel("Email"));
    panel.add(email);

    var buttons = new JPanel();
    var bCancelar = new JButton("Cancelar");
    var bCadastrar = new JButton("Cadastrar");

    // bCancelar.setBackground(Color.RED);
    bCancelar.setForeground(Color.RED);
    // bCadastrar.setBackground(Color.GREEN);
    bCadastrar.setForeground(Color.GREEN);
    
    buttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
    buttons.add(bCancelar);
    buttons.add(bCadastrar);

    bCancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        RemoverPanel();
      }
    });

    bCadastrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new ClienteDB().InsereCliente(nome.getText(), numero.getText(), cpf.getText(), endereco.getText(), email.getText());
      }
    });

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(panel);
    add(buttons);
  }

  private void RemoverPanel() {
    InicialPanel parent = (InicialPanel) getParent();
    parent.RemoverDestaque();
  }
}
