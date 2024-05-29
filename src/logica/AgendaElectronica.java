package logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AgendaElectronica {
    private JPanel mainPanel;
    private JTextField textdni;
    private JTextField textnombre;
    private JTextField textapellido;
    private JTextField textdireccion;
    private JTextField texttelefono;
    private JTextField textFechanac;
    private JButton guardarButton;
    private JButton btnBack;
    private JButton btnForward;
    private JTextField textIndice;
    private JButton limpiarButton;
    private JButton borrarButton;


    // Variables Lógica

    String [] dni = new String[10];
    String [] nombre = new String[10];
    String [] apellidos = new String[10];
    String [] direcciones = new String[10];
    String [] telefonos = new String[10];
    String [] fechanac = new String[10];




    // Excepcion for empty String

    public int validaInt(String number){
        int result = 0; //Valor default.
        try{
            if(number != null){
                result = Integer.parseInt(number);
            }
        }catch(NumberFormatException nfe){
            //*No es numerico!
        }
        return result;
    }

// Evento botones

    public AgendaElectronica() {
        btnForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               int index = validaInt(textIndice.getText());

               if ( index < 9 ){

                   index = index+1;
                   textIndice.setText(String.valueOf(index));


                   // Mostramos datos :

                   textdni.setText(dni[index]);
                   textnombre.setText(nombre[index]);
                   textapellido.setText(apellidos[index]);
                   textdireccion.setText(direcciones[index]);
                   textFechanac.setText(fechanac[index]);
                   texttelefono.setText(telefonos[index]);


               }

            }
        });


        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int index = validaInt(textIndice.getText());

                if ( index > 0 ){

                    index = index-1;
                    textIndice.setText(String.valueOf(index));



                }
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = validaInt(textIndice.getText());
                dni[index]=textdni.getText();
                nombre[index]=textnombre.getText();
                apellidos[index]= textapellido.getText();
                telefonos[index]= texttelefono.getText();
                fechanac[index]= textFechanac.getText();
                direcciones[index]= textdireccion.getText();


                limpiarCampos();

            }
        });



            limpiarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    limpiarCampos();

                }
            });


        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = validaInt(textIndice.getText());
                dni[index] = "";
                nombre[index] = "";
                apellidos[index] = "";
                direcciones[index] = "";
                telefonos[index] = "";
                fechanac[index] = "";


                limpiarCampos();







            }
        });
    }

    // Métodos


    // Método para limpiar los campos :

    private void limpiarCampos() {

        textdni.setText("");
        textnombre.setText("");
        textdireccion.setText("");
        textapellido.setText("");
        texttelefono.setText("");
        textFechanac.setText("");
        textIndice.setText("");

    }


    // Método Main

    public static void main(String[] args) {
        JFrame frame = new JFrame("AgendaElectronica");
        frame.setContentPane(new AgendaElectronica().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(1200, 400);
        frame.setResizable(false);
        frame.setVisible(true);





    }
}
