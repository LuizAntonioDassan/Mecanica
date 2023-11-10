package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class InicialPanel extends JPanel {
  private JButton cliente;
  private JButton funcionario;
  private JButton manutencao;
  private JButton listaManutencao;


  public InicialPanel() {
    // construct components
    cliente = new JButton("Cliente");
    cliente.setPreferredSize(new Dimension(100, 30));
    funcionario = new JButton("Funcionário");
    funcionario.setPreferredSize(new Dimension(100, 30));
    manutencao = new JButton("Manutenção");
    manutencao.setPreferredSize(new Dimension(100, 30));
    listaManutencao = new JButton("Lista de Manutenções");
    listaManutencao.setPreferredSize(new Dimension(100, 30));
    cliente.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MostrarCliente();
      }
    });
    manutencao.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MostrarManutencao();
      }
    });
    listaManutencao.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        MostrarListaManutencao();
      }
    });

    var panel = new JPanel();
    panel.setBackground(Color.BLUE);
    BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(box);
    panel.add(cliente);
    panel.add(funcionario);
    panel.add(manutencao);
    panel.add(listaManutencao);

    // adjust size and set layout
    setPreferredSize(new Dimension(681, 384));
    BorderLayout layout = new BorderLayout(0, 0);
    setLayout(layout);

    // add components
    add(panel, BorderLayout.WEST);
  }

  private void MostrarManutencao() {
    RemoverDestaque();
    add(new ManutencaoPanel(), BorderLayout.CENTER);
    getParent().revalidate();
  }
  
  private void MostrarListaManutencao() {
    RemoverDestaque();
    add(new ListaManutencaoPanel(), BorderLayout.CENTER);
    getParent().revalidate();
  }

  private void MostrarCliente() {
    RemoverDestaque();
    add(new ClientePanel(), BorderLayout.CENTER);
    getParent().revalidate();
  }

  public void RemoverDestaque() {
    BorderLayout layout = (BorderLayout)getLayout();
    var component = layout.getLayoutComponent(BorderLayout.CENTER);

    if (component != null)
      remove(component);
  }
}
