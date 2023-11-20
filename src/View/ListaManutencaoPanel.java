package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Model.Manutencao;
import scripts.ButtonColumn;

public class ListaManutencaoPanel extends JPanel {

  private JButton finalizar;

  public ListaManutencaoPanel() {
    finalizar = new JButton("finalizar");
    finalizar.setPreferredSize(new Dimension(20, 30));
    
    String[] colunas = { "ID", "Placa", "Descrição", "Custo", "Tipo", "Hora", "Finalizado","Concluir"};
    var lista = Manutencao.getAll();
    List<Object[]> dados = new ArrayList<>();

    for (Manutencao manutencao : lista) {
      Object[] dado = { 
        manutencao.getId().toString(), 
        manutencao.getPlaca(), 
        manutencao.getDescricao(),
        Double.valueOf(manutencao.getCusto()).toString(), manutencao.getTipo(), 
        manutencao.getData().toString(),
        manutencao.getFinalizado().toString(), 
        "Finalizar"
        };
      dados.add(dado);
    }
    var table = new JTable(dados.toArray(new Object[][] {}), colunas) {
      public boolean isCellEditable(int row, int column) {
        if(column == 7){
          return true;
        }
        else{
          return false;
        }
      };
    };
    
    ButtonColumn button = new ButtonColumn(table, finalizarAction, 7);
    button.setMnemonic(KeyEvent.VK_D);
    
    setLayout(new BorderLayout());
    add(new JScrollPane(table), BorderLayout.CENTER);
    add(table.getTableHeader(), BorderLayout.NORTH);

  }

  Action finalizarAction = new AbstractAction() {
    public void actionPerformed(ActionEvent e){
      JTable table = (JTable)e.getSource();
      int row = Integer.valueOf( e.getActionCommand() );
      Object manut = table.getModel().getValueAt(row, 0);
      Window window = SwingUtilities.windowForComponent(table);

      // new ContaPanel(manut.toString());
      new ComprovantePanel();

      // int result = JOptionPane.showConfirmDialog(
			// 		window,
			// 		"Selecione o valor e a forma de pagamento" + manut,
			// 		"Finalizar Manutenção",
			// 		JOptionPane.YES_NO_OPTION);


      System.out.println("Finalizando manutenção com ID: " + manut.toString());
    }
  };

}
