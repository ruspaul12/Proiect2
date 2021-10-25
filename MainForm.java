import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Masina{ //CLASA MASINA
    private String nume;
    private String marca;
    private String Motorizare;
    private int pret;

    public Masina (String nume, String marca, String Motorizare, int pret){ //CONSTRUCTOR
        this.nume = nume;
        this.marca = marca;
        this.Motorizare = Motorizare;
        this.pret=pret;
    }
    public Masina(){
        this.nume="nedefinit";
        this.marca="nedefinit";
        this.Motorizare="nedefinit";
        this.pret=-1;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Masina este: ");
        sb.append(nume);
        sb.append(" marca: ");
        sb.append(marca);
        sb.append(" pret ");
        sb.append(pret);
        sb.append(" motorizare: ");
        sb.append(Motorizare);
        return sb.toString();
    }
    public String getnume(){
        return nume;
    }
    public void setnume(String nume1){
        nume=nume1;
    }
}


public class MainForm {
    private JPanel rootPanel;
    private JButton cautareButton;
    private JTextField textField1;
    private JButton listaMasiniButton;
    private JTextArea textArea1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton adaugaButton;
    private JRadioButton benzinaRadioButton;
    private JRadioButton dieselRadioButton;
    private JButton stergereButton;
    private JButton stergeTotButton;
    private JCheckBox gasitCheckBox;


    ArrayList<Masina> m = new ArrayList<>();
    String nume; String marca; String Motorizare; int pret;
    public MainForm() {
        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField2.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Eroare", "Eroare", JOptionPane.ERROR_MESSAGE);
                else
                    nume = textField2.getText();
                if (textField3.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Eroare", "Eroare", JOptionPane.ERROR_MESSAGE);
                else
                    marca = textField3.getText();
                if (textField4.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "Eroare", "Eroare", JOptionPane.ERROR_MESSAGE);
                else
                    pret = Integer.parseInt(textField4.getText());
                if (benzinaRadioButton.isSelected()) {
                    if (dieselRadioButton.isSelected())
                        JOptionPane.showMessageDialog(null, "Eroare", "Eroare", JOptionPane.ERROR_MESSAGE);
                    else
                        Motorizare = "benzina";
                } else {
                    if (dieselRadioButton.isSelected())
                        Motorizare = "diesel";
                    else
                        JOptionPane.showMessageDialog(null, "Eroare", "Eroare", JOptionPane.ERROR_MESSAGE);
                }
                m.add(new Masina(nume,marca,Motorizare,pret));
                textArea1.append(m.get(m.size()-1).toString());
                textArea1.append("\n");


        }




        });
        stergereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(textArea1.getText().replace(textArea1.getSelectedText(),""));
            }
        });
        stergeTotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });

        listaMasiniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("Masina este: Astrah marca: Opel pret 3000 Motorizare diesel");
                textArea1.append("\n");
                textArea1.append("Masina este: Logan marca: Dacia pret 3000 Motorizare benzina");
                textArea1.append("\n");
                textArea1.append("Masina este: Focus marca: Ford pret 1500 Motorizare diesel");
                textArea1.append("\n");
                m.add(new Masina("Astrah","Opel","diesel",3000));
                m.add(new Masina("Logan","Dacia","benzina",3000));
                m.add(new Masina("Focus","Ford","diesel", 1500));
            }
        });
        cautareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean gasit=false;
                for(Masina masina : m)
                    if(masina.getnume().equals(textField1.getText()))
                        gasitCheckBox.setSelected(true);
                    else
                        gasitCheckBox.setSelected(false);
            }
        });
    }

    public static void main(String[] args){
    JFrame frame=new JFrame("Reprezentanta masini");
    frame.setContentPane(new MainForm().rootPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);



    }

}
