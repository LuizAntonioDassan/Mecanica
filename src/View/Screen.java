package View;

import javax.swing.JFrame;

public class Screen {

    public Screen(){
        JFrame tela = new JFrame();
        tela.add(new InicialPanel());
        tela.pack();

        tela.setVisible(true);
        tela.setSize(800, 500);
        tela.setTitle("Mecanica UFMS");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
