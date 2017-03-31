package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by robert on 3/28/17.
 */
public class principalFrame{


    public String[] categorias = {"frutas", "animales", "carrera"};
    public String[] frutas = {"mango", "platano", "fresa", "manzana"};
    public String[] animales = {"perro", "kanguro", "huron", "gato"};
    public String[] carrera = {"debugger", "oracle", "arduino", "swift"};


    public int numeroPistas=3;
    String Palabra;
    String palabraOculta;

    JLabel labelNombre, labelCategoria, labelPuntos, labelPalabra, labelImagen;

    JButton botonPrueba1;
    JButton botonPrueba2;
    JButton botonPrueba3;
    JButton botonPrueba4;
    JButton botonPrueba5;
    JButton botonPista;

    JPanel JPDatos;
    JPanel JPImagen;
    JPanel JPPalabra;

    Random rand = new Random(System.currentTimeMillis());
    int numRand = rand.nextInt(4);


    String nombre = (String)JOptionPane.showInputDialog("cual es tu nombre?");

    String eleccionCategoria = (String) JOptionPane.showInputDialog(null,
            "que categoria quiere?",
            "categoria",
            JOptionPane.QUESTION_MESSAGE,
            null,
            categorias,
            categorias[0]);

    public principalFrame(){

        if(eleccionCategoria == "frutas"){

            Palabra = frutas[numRand];
            System.out.println(numRand);
        }

        else if(eleccionCategoria == "animales"){
            Palabra = animales[numRand];
            System.out.println(numRand);
        }

        else if(eleccionCategoria == "carrera"){
            Palabra = carrera [numRand];
            System.out.println(numRand);
        }


        JFrame frame = new JFrame("Ahorcado");
        frame.setLayout(null);

       System.out.println(nombre);
       System.out.println(eleccionCategoria);

        JPanelDatos();
        JPanelImagen();
        JPanelPalabra();

        JPDatos.setBounds(0,0,800,100);
        JPImagen.setBounds(0, 100, 800, 300);
        JPPalabra.setBounds(0, 400, 800, 200);


        JPDatos.setBorder(BorderFactory.createBevelBorder(1));
        JPImagen.setBorder(BorderFactory.createBevelBorder(1));
        JPPalabra.setBorder(BorderFactory.createBevelBorder(1));

        frame.add(JPDatos);
        frame.add(JPImagen);
        frame.add(JPPalabra);

        frame.addKeyListener(new KeyListener(){


            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Pressed " + e.getKeyChar());
            }
        });
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setLocation(300, 50);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void JPanelDatos(){
        JPDatos = new JPanel(new GridLayout(2,2));

        labelCategoria = new JLabel("categoria: "+eleccionCategoria);
        labelCategoria.setBounds(0,50,100,60);

        botonPista = new JButton();
        botonPista.setText("Pistas: "+numeroPistas);
        botonPista.addActionListener(new listenerBotones());

        labelNombre = new JLabel("nombre: "+nombre);

        JPDatos.add(labelNombre);
        JPDatos.add(botonPista);
        JPDatos.add(labelCategoria);

        JPDatos.setVisible(true);
    }

    public void JPanelImagen() {

        JPImagen = new JPanel(new FlowLayout());

        labelImagen = new JLabel();

        ImageIcon imagen = new ImageIcon("/home/roberto/IdeaProjects/ahorcado-TAP2/doge.jpg");

        labelImagen.setIcon(imagen);
        labelImagen.setSize(100,100);
        labelImagen.setLocation(0,0);
        labelImagen.setVisible(true);

        JPImagen.add(labelImagen);

        JPImagen.setVisible(true);
    }

    public void JPanelPalabra() {

        JPPalabra = new JPanel(new FlowLayout());

        palabraOculta = "";
        for (int i = 0; i < Palabra.length(); i++) {
            palabraOculta += " _ ";
        }

        Font fuente = new Font("Arial", Font.BOLD, 36);
        labelPalabra = new JLabel(palabraOculta);
        labelPalabra.setFont(fuente);

        JPPalabra.add(labelPalabra);

        JPPalabra.setFocusable(true);
        JPPalabra.requestFocusInWindow();
        JPPalabra.setVisible(true);

    }


    /**public class listenerTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }**/

    public class listenerBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(botonPista)){
                numeroPistas--;

                botonPista.setText("Pistas: "+numeroPistas);
                if(numeroPistas==0){

                    JOptionPane.showMessageDialog(null,"se teminaron tus pistas");
                    botonPista.setEnabled(false);
                }


                JPPalabra.setFocusable(true);
                JPPalabra.requestFocusInWindow();
                JPPalabra.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {}

                    @Override
                    public void keyPressed(KeyEvent e) {
                        System.out.println(e.getKeyChar());
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {}
                });
            }
        }
    }
}
