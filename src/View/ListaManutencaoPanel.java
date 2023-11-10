package View;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.Manutencao;

public class ListaManutencaoPanel extends JPanel {
  public ListaManutencaoPanel() {
    String[] colunas = { "ID", "Placa", "Descrição", "Custo", "Tipo", "Hora", "Finalizado" };
    var lista = Manutencao.getAll();
    List<String[]> dados = new ArrayList<>();

    for (Manutencao manutencao : lista) {
      String[] dado = { manutencao.getId().toString(), manutencao.getPlaca(), manutencao.getDescricao(),
          Double.valueOf(manutencao.getCusto()).toString(), manutencao.getTipo(), manutencao.getData().toString(),
          manutencao.getFinalizado().toString() };
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
}
