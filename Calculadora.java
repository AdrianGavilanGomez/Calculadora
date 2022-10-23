package DAM2.MP13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculadora extends JFrame implements ActionListener {
    JTextField textarea1 = new JTextField();//Creamos el area de texto
    String op = "";
    double result = 0;
    double a = 0;
    double b = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textarea1.getText().contains(".") && e.getActionCommand().equals(".")) {
        //el if serveix per no poder afegir mes d'un punt
        } else {
            textarea1.setText(textarea1.getText() + e.getActionCommand());
        }
    }
    public Calculadora() {
        setSize(275, 425); //Establecemos el tamaño de la ventana
        setTitle("Calculadora"); //Establecemos el titulo de la ventana
        //setLocation(100,200); //Establecemos la posicion inicial de la ventana
        //setBounds(100,200,500,500);//Establecemos la posicion inicial y el tamaño de la ventana
        setLocationRelativeTo(null);//Establecemos la ventana en el centro

        //setResizable(false);//Establecemos si la ventana puede cambiar de tamaño o no
        setMinimumSize(new Dimension(200,200));//Establecemos el tamaño minimo

        //this.getContentPane().setBackground(Color.BLUE);//Establecemos el color de la ventana

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        JPanel panel = new JPanel();//Creacion de un panel (de momento el panel no esta agregado a la ventana)
        //panel.setBackground(Color.GREEN);//Establecemos el color del panel
        panel.setLayout(null);//Desactivando el layout/diseño por defecto
        this.getContentPane().add(panel);//Agregamos el panel a la ventana

        //TextArea1 - area de texto

        textarea1.setBounds(7,15,250,50);//Establecemos el tamaño y posicion del area de texto
        textarea1.setHorizontalAlignment(SwingConstants.RIGHT);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        textarea1.setForeground(Color.BLACK);//Establecemos el color de la letra
        textarea1.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        panel.add(textarea1);//Agregamos el area de texto al panel
        textarea1.addKeyListener(new KeyAdapter() {
                                     public void keyPressed(KeyEvent ke) {
                                         String value = textarea1.getText();
                                         int l = value.length();
                                         if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                                             textarea1.setEditable(true);
                                         }
                                         else if (ke.getKeyChar() == '.'){
                                             textarea1.setEditable(true);
                                         }
                                         else if (ke.getKeyCode() == 8){
                                             textarea1.setEditable(true);
                                         }
                                         else {
                                             textarea1.setEditable(false);
                                         }
                                     }
                                 });

        //Boton1 - boton
        JButton boton1 = new JButton(".");//Creamos un boton y le añadimos el texto
        boton1.setBounds(15,85,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton1.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton1.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton1.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton1.addActionListener (this);
        panel.add(boton1);//Agregamos el boton al panel
        boton1.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton2 = new JButton("AC");//Creamos un boton y le añadimos el texto
        boton2.setBounds(75,85,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton2.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton2.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton2.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto

        ActionListener ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textarea1.setText(null);
            }
        };
        boton2.addActionListener (ac);

        panel.add(boton2);//Agregamos el boton al panel
        boton2.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton3 = new JButton("<-");//Creamos un boton y le añadimos el texto
        boton3.setBounds(135,85,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton3.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton3.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton3.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto

        ActionListener borrarDigito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textarea1.getText().length() != 0) {
                    textarea1.setText(textarea1.getText().substring(0,textarea1.getText().length() - 1));
                }
            }
        };
        boton3.addActionListener (borrarDigito);

        panel.add(boton3);//Agregamos el boton al panel
        boton3.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton4 = new JButton("+");//Creamos un boton y le añadimos el texto
        boton4.setBounds(195,85,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton4.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton4.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton4.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(textarea1.getText());
                op = "+";
                textarea1.setText("");
            }
        });
        panel.add(boton4);//Agregamos el boton al panel
        boton4.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton5 = new JButton("7");//Creamos un boton y le añadimos el texto
        boton5.setBounds(15,145,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton5.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton5.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton5.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton5.addActionListener (this);
        panel.add(boton5);//Agregamos el boton al panel
        boton5.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton6 = new JButton("8");//Creamos un boton y le añadimos el texto
        boton6.setBounds(75,145,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton6.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton6.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton6.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton6.addActionListener (this);
        panel.add(boton6);//Agregamos el boton al panel
        boton6.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton7 = new JButton("9");//Creamos un boton y le añadimos el texto
        boton7.setBounds(135,145,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton7.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton7.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton7.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton7.addActionListener (this);
        panel.add(boton7);//Agregamos el boton al panel
        boton7.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton8 = new JButton("-");//Creamos un boton y le añadimos el texto
        boton8.setBounds(195,145,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton8.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton8.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton8.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(textarea1.getText());
                op = "-";
                textarea1.setText("");
            }
        });
        panel.add(boton8);//Agregamos el boton al panel
        boton8.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton9 = new JButton("4");//Creamos un boton y le añadimos el texto
        boton9.setBounds(15,205,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton9.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton9.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton9.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton9.addActionListener (this);
        panel.add(boton9);//Agregamos el boton al panel
        boton9.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton10 = new JButton("5");//Creamos un boton y le añadimos el texto
        boton10.setBounds(75,205,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton10.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton10.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton10.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton10.addActionListener (this);
        panel.add(boton10);//Agregamos el boton al panel
        boton10.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton11 = new JButton("6");//Creamos un boton y le añadimos el texto
        boton11.setBounds(135,205,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton11.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton11.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton11.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton11.addActionListener (this);
        panel.add(boton11);//Agregamos el boton al panel
        boton11.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton12 = new JButton("*");//Creamos un boton y le añadimos el texto
        boton12.setBounds(195,205,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton12.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton12.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton12.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(textarea1.getText());
                op = "*";
                textarea1.setText("");
            }
        });
        panel.add(boton12);//Agregamos el boton al panel
        boton12.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton13 = new JButton("1");//Creamos un boton y le añadimos el texto
        boton13.setBounds(15,265,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton13.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton13.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton13.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton13.addActionListener (this);
        panel.add(boton13);//Agregamos el boton al panel
        boton13.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton14 = new JButton("2");//Creamos un boton y le añadimos el texto
        boton14.setBounds(75,265,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton14.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton14.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton14.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton14.addActionListener (this);
        panel.add(boton14);//Agregamos el boton al panel
        boton14.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton15 = new JButton("3");//Creamos un boton y le añadimos el texto
        boton15.setBounds(135,265,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton15.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton15.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton15.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton15.addActionListener (this);
        panel.add(boton15);//Agregamos el boton al panel
        boton15.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton16 = new JButton("/");//Creamos un boton y le añadimos el texto
        boton16.setBounds(195,265,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton16.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton16.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton16.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(textarea1.getText());
                op = "/";
                textarea1.setText("");
            }
        });
        panel.add(boton16);//Agregamos el boton al panel
        boton16.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton17 = new JButton("00");//Creamos un boton y le añadimos el texto
        boton17.setBounds(15,325,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton17.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton17.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton17.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton17.addActionListener (this);
        panel.add(boton17);//Agregamos el boton al panel
        boton17.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton18 = new JButton("0");//Creamos un boton y le añadimos el texto
        boton18.setBounds(75,325,50,50);//Establecemos el tamaño y posicion de la etiqueta
        boton18.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton18.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton18.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        boton18.addActionListener (this);
        panel.add(boton18);//Agregamos el boton al panel
        boton18.setBackground(Color.lightGray); //Establecemos el color de fondo del boton

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////

        JButton boton19 = new JButton("=");//Creamos un boton y le añadimos el texto
        boton19.setBounds(135,325,110,50);//Establecemos el tamaño y posicion de la etiqueta
        boton19.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos la alineacion horizontal del texto dentro de la etiqueta
        boton19.setForeground(Color.BLACK);//Establecemos el color de la letra
        boton19.setFont(new Font("calibri",2,14));//Establecemos la fuente del texto
        panel.add(boton19);//Agregamos el boton al panel
        boton19.setBackground(Color.lightGray); //Establecemos el color de fondo del boton
        boton19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = Double.parseDouble(textarea1.getText());

                if (op == "+") {
                    result = a + b;
                    textarea1.setText(String.valueOf(result));
                } else if (op == "-") {
                    result = a - b;
                    textarea1.setText(String.valueOf(result));
                } else if (op == "*") {
                    result = a * b;
                    textarea1.setText(String.valueOf(result));
                } else if (op == "/") {
                    result = a / b;
                    textarea1.setText(String.valueOf(result));
                }
            }
        });
    }
}
