package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import Model.Manutencao;
import tables.ManutencaoDB;

public class ManutencaoPanel extends JPanel {
  private JPanel pCPF;
  private JTextField tCPF;

  private JPanel pTipoManutencao;
  private JComboBox<String> cbTipoManutencao;

  private JPanel pModelo;
  private JTextField tModelo;
  
  private JPanel pNome;
  private JTextField tNome;

  private JPanel pCor;
  private JTextField tCor;
  
  private JPanel pTelefone;
  private JTextField tTelefone;

  private JPanel pEmail;
  private JTextField tEmail;

  private JPanel pPlaca;
  private JTextField tPlaca;
  
  private JPanel pCusto;
  private JTextField tCusto;

  private JPanel pProblema;
  private JTextArea tProblema;

  public ManutencaoPanel() {
    var panel = new JPanel();
    
    pCPF = new JPanel();
    tCPF = new JTextField();
    pCPF.setLayout(new BoxLayout(pCPF, BoxLayout.Y_AXIS));
    pCPF.add(new JLabel("CPF:"));
    pCPF.add(tCPF);

    pTipoManutencao = new JPanel();
    String[] options = { "Troca de Peça", "Serviço" };
    cbTipoManutencao = new JComboBox(options);
    pTipoManutencao.setLayout(new BoxLayout(pTipoManutencao, BoxLayout.Y_AXIS));
    pTipoManutencao.add(new JLabel("Tipo de Manutenção:", SwingConstants.RIGHT));
    pTipoManutencao.add(cbTipoManutencao);

    pModelo = new JPanel();
    tModelo = new JTextField();
    pModelo.setLayout(new BoxLayout(pModelo, BoxLayout.Y_AXIS));
    pModelo.add(new JLabel("Modelo:", SwingConstants.LEFT));
    pModelo.add(tModelo);

    pNome = new JPanel();
    tNome = new JTextField();
    pNome.setLayout(new BoxLayout(pNome, BoxLayout.Y_AXIS));
    pNome.add(new JLabel("Nome:", SwingConstants.LEFT));
    pNome.add(tNome);

    pCor = new JPanel();
    tCor = new JTextField();
    pCor.setLayout(new BoxLayout(pCor, BoxLayout.Y_AXIS));
    pCor.add(new JLabel("Cor:", SwingConstants.LEFT));
    pCor.add(tCor);

    pTelefone = new JPanel();
    tTelefone = new JTextField();
    pTelefone.setLayout(new BoxLayout(pTelefone, BoxLayout.Y_AXIS));
    pTelefone.add(new JLabel("Telefone:", SwingConstants.LEFT));
    pTelefone.add(tTelefone);

    pEmail = new JPanel();
    tEmail = new JTextField();
    pEmail.setLayout(new BoxLayout(pEmail, BoxLayout.Y_AXIS));
    pEmail.add(new JLabel("Email:", SwingConstants.LEFT));
    pEmail.add(tEmail);

    pPlaca = new JPanel();
    tPlaca = new JTextField();
    pPlaca.setLayout(new BoxLayout(pPlaca, BoxLayout.Y_AXIS));
    pPlaca.add(new JLabel("Placa do Veículo:", SwingConstants.LEFT));
    pPlaca.add(tPlaca);

    pCusto = new JPanel();
    tCusto = new JTextField();
    pCusto.setLayout(new BoxLayout(pCusto, BoxLayout.Y_AXIS));
    pCusto.add(new JLabel("Custo:", SwingConstants.LEFT));
    pCusto.add(tCusto);

    tCusto.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent ke) {
         String value = tCusto.getText();
         int l = value.length();

         var alreadyDecimal = value.contains(",");

         if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || (!alreadyDecimal && ke.getKeyChar() == ',')) {
            tCusto.setEditable(true);
         } else {
            tCusto.setEditable(false);
         }
      }
   });

    pProblema = new JPanel();
    tProblema = new JTextArea();
    tProblema.setMaximumSize(new Dimension(500, 100));
    // tProblema.setMaximumSize(new Dimension(300, 40));
    pProblema.setLayout(new BoxLayout(pProblema, BoxLayout.Y_AXIS));
    pProblema.add(new JLabel("Descrição do Problema:", SwingConstants.LEFT));
    pProblema.add(tProblema);

    // adjust size and set layout
    GridLayout layout = new GridLayout(4, 3, 10, 10);
    panel.setLayout(layout);
    // add components
    panel.add(pCPF);
    panel.add(pTipoManutencao);
    panel.add(pModelo);
    panel.add(pNome);
    panel.add(pCor);
    panel.add(pTelefone);
    panel.add(pEmail);
    panel.add(pPlaca);
    panel.add(pCusto);
    panel.add(pProblema);

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
        CadastrarManutencao();
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

  private void CadastrarManutencao() {
    String custo = tCusto.getText();
    custo = custo.replace(',', '.');
    if(tCPF.getText().length() == 0){
      System.out.println("Ta vazio");
    }

    if((tProblema.getText().length() > 0) && (tPlaca.getText().length() > 0) && (tCusto.getText().length() > 0) && (tCPF.getText().length() > 0) && (tModelo.getText().length() > 0) && (tCor.getText().length() > 0) && (tTelefone.getText().length() > 0) && (tEmail.getText().length() > 0)){
      new ManutencaoDB().criaManutencao(tProblema.getText(), Double.parseDouble(custo), cbTipoManutencao.getSelectedItem().toString(), tPlaca.getText());
      tCPF.setText("");
      tPlaca.setText("");
      tProblema.setText("");
      tCusto.setText("");
      tCor.setText("");
      tEmail.setText("");
      tNome.setText("");
      tTelefone.setText("");
      JOptionPane optionPane = new JOptionPane();
      optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
      optionPane.setMessage("Manutencao Cadastrada");       
      JDialog dialog = optionPane.createDialog(null, "Cadastro Realizado");
      dialog.setVisible(true);
    }
    else{
      JOptionPane optionPane = new JOptionPane();
      if(tCPF.getText().length() == 0){
        optionPane.setMessage("Campo CPF nao foi preenchido");       
      }
      else if(tModelo.getText().length() == 0){
        optionPane.setMessage("Campo Modelo nao foi preenchido");       
      }
      else if(tNome.getText().length() == 0){
        optionPane.setMessage("Campo Nome nao foi preenchido");       
      }
      else if(tCor.getText().length() == 0){
        optionPane.setMessage("Campo Cor nao foi preenchido");       
      }
      else if(tTelefone.getText().length() == 0){
        optionPane.setMessage("Campo Telefone nao foi preenchido");       
      }
      else if(tEmail.getText().length() == 0){
        optionPane.setMessage("Campo Email nao foi preenchido");       
      }
      else if(tPlaca.getText().length() == 0){
        optionPane.setMessage("Campo Placa nao foi preenchido");       
      }
      else if(tCusto.getText().length() == 0){
        optionPane.setMessage("Campo Custo nao foi preenchido");       
      }
      else if(tProblema.getText().length() == 0){
        optionPane.setMessage("Campo Problema nao foi preenchido");       
      }
      optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
      JDialog dialog = optionPane.createDialog(null, "Erro Preenchimento");
      dialog.setVisible(true);
    }
  }
}
