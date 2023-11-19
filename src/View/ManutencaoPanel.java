package View;

import java.awt.*;
import java.awt.event.*;
import java.security.Timestamp;

import javax.swing.*;

import Controller.Controllers;
import Controller.ManutecanoController;

import Model.Cliente;

import Model.Veiculo;



public class ManutencaoPanel extends JPanel {
  private Timestamp dataHora;

  private JPanel pCPF;
  private static JTextField tCPF;

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

  private JPanel pData;
  private JTextArea tData;

  public ManutencaoPanel() {
    var panel = new JPanel();
    
    pCPF = new JPanel();
    tCPF = new JTextField();
    pCPF.setLayout(new BoxLayout(pCPF, BoxLayout.Y_AXIS));
    pCPF.add(new JLabel("CPF:"));
    pCPF.add(tCPF);
    JButton bConsultar = new JButton("Consultar");
    pCPF.add(bConsultar);

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

    pData = new JPanel();
    tData = new JTextArea();
    pData.setLayout(new BoxLayout(pData, BoxLayout.Y_AXIS));
    pData.add(new JLabel("Data: ", SwingConstants.LEFT));
    // tData.setText(dataHora.toString());
    pData.add(tData);

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
    panel.add(pData);

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

    bConsultar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        consultarCPF();
      }
    });

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
    validarCPF(tCPF.getText());

    if((tProblema.getText().length() > 0) && (tPlaca.getText().length() > 0) && (tCusto.getText().length() > 0) && (tCPF.getText().length() > 0) && (tModelo.getText().length() > 0) && (tCor.getText().length() > 0) && (tTelefone.getText().length() > 0) && (tEmail.getText().length() > 0)){
      new ManutecanoController().agendarManutencao(tProblema.getText(), Double.parseDouble(custo), cbTipoManutencao.getSelectedItem().toString(), tPlaca.getText());
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
    public void consultarCPF(){
      JOptionPane optionPane = new JOptionPane();
      optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);   
      JDialog dialog = optionPane.createDialog(null, "Cadastro Realizado");
      String cpf = tCPF.getText();
      Controllers cliente = new Controllers();
      Cliente clienteConsultado = cliente.recuperaCliente(cpf);
      Veiculo veiculoConsultado = cliente.recuperaVeiculoCliente(cpf);
      
      if(clienteConsultado != null){
        tEmail.setText(clienteConsultado.getEmail());
        tNome.setText(clienteConsultado.getNome());
        tTelefone.setText(clienteConsultado.getNumero());
        tCor.setText(veiculoConsultado.getCor());
        tModelo.setText(veiculoConsultado.getModelo());
        tPlaca.setText(veiculoConsultado.getPlaca());
      }else{
        optionPane.setMessage("CPF nao encontrado");  
        dialog.setVisible(true);
      }
    }

    public static boolean validarCPF(String cpf) {
      JOptionPane optionPane = new JOptionPane();
      optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);   
      JDialog dialog = optionPane.createDialog(null, "Cadastro Realizado");
      cpf = cpf.replaceAll("[^0-9]", "");
      tCPF.setText(cpf);

      if (cpf.length() != 11) {
          optionPane.setMessage("CPF preenchido errado");  
          dialog.setVisible(true);
          return false;
      }

      boolean todosDigitosIguais = true;
      for (int i = 1; i < cpf.length(); i++) {
          if (cpf.charAt(i) != cpf.charAt(0)) {
              todosDigitosIguais = false;
              break;
          }
      }
      if (todosDigitosIguais) {
          optionPane.setMessage("CPF digitos iguais");  
          dialog.setVisible(true);
          return false;
      }

      int soma = 0;
      for (int i = 0; i < 9; i++) {
          soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
      }
      int digito1 = 11 - (soma % 11);
      if (digito1 > 9) {
          digito1 = 0;
      }

      if (digito1 != Integer.parseInt(cpf.substring(9, 10))) {
          return false;
      }

      soma = 0;
      for (int i = 0; i < 10; i++) {
          soma += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
      }
      int digito2 = 11 - (soma % 11);
      if (digito2 > 9) {
          digito2 = 0;
      }

      return (digito2 == Integer.parseInt(cpf.substring(10)));
  }
}
