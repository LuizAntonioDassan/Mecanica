package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ComprovantePanel {
    JLabel texto;

    public ComprovantePanel() {
        JFrame comprovante = new JFrame();
        comprovante.setVisible(true);
        comprovante.setSize(250, 150);
        comprovante.setTitle("Mecanica UFMS");

        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalGlue());

        texto = new JLabel("<html> Deseja Gerar o  seu comprovante de pagamento? </html>");
        texto.setAlignmentX(JLabel.CENTER_ALIGNMENT); 
        texto.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        texto.setFont(new Font("Arial", Font.PLAIN, 20));
        

        panel.add(texto);
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
                comprovante.dispose();
            }
        });

        bCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                geraRecibo();
                comprovante.dispose();
                JOptionPane optionPane = new JOptionPane();
                optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                optionPane.setMessage("Processo Concluido");       
                JDialog dialog = optionPane.createDialog(null, "Recibo Gerado");
                dialog.setVisible(true);
            }
        });

        comprovante.add(panel, BorderLayout.CENTER);
        comprovante.add(buttons, BorderLayout.SOUTH);
        comprovante.setLocationRelativeTo(null);

    }

    public void geraRecibo(){
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);
        
        try{
            document.save("F:\\PDFBox\\mypdf.pdf");
            document.close();
         }catch (IOException e){
            System.err.println("Erro ao criar o PDF: " + e.getMessage());
         }
    }
}
