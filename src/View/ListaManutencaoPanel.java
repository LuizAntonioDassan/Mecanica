package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Manutencao;

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
        return false;
      };
    };
    

    setLayout(new BorderLayout());

    add(new JScrollPane(table), BorderLayout.CENTER);
    add(table.getTableHeader(), BorderLayout.NORTH);
  }

  protected JButton finalizarManutencao(Long id) {
    JButton botaoFinalizar = new JButton("Finalizar");
    botaoFinalizar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lógica para finalizar a manutenção com o ID idManutencao
        System.out.println("Finalizando manutenção com ID: ");
      }
    });
    return botaoFinalizar;
  }
}
