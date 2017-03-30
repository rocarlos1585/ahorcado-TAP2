package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    JLabel labelNombre, labelCategoria, labelPuntos, labelPalabra;

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


        botonPrueba1 = new JButton();
        botonPrueba1.setText("boton 1");

        botonPrueba2 = new JButton();
        botonPrueba2.setText("boton 2");

        JPImagen.add(botonPrueba1);
        JPImagen.add(botonPrueba2);



        JPImagen.setVisible(true);
    }

    public void JPanelPalabra(){

        JPPalabra = new JPanel(new FlowLayout());

        labelPalabra = new JLabel(Palabra);

        botonPrueba3 = new JButton();
        botonPrueba3.setText("boton 3");

        botonPrueba4 = new JButton();
        botonPrueba4.setText("boton 4");

        botonPrueba5 = new JButton();
        botonPrueba5.setText("boton 5");

        JPPalabra.add(botonPrueba3);
        JPPalabra.add(botonPrueba4);
        JPPalabra.add(botonPrueba5);
        JPPalabra.add(labelPalabra);

        JPPalabra.setVisible(true);



    }

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


            }

        }


    }

}
