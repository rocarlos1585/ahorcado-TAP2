package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by robert on 3/28/17.
 */
public class principalFrame implements ActionListener {



    JButton botonPrueba1;
    JButton botonPrueba2;
    JButton botonPrueba3;
    JButton botonPrueba4;
    JButton botonPrueba5;

    JPanel JPImagen;
    JPanel JPPalabra;

    public principalFrame(){

        JFrame frame = new JFrame("Ahorcado");
        frame.setLayout(null);

        JPanelImagen();
        JPanelPalabra();

        JPImagen.setBounds(0, 0, 800, 400);
        JPPalabra.setBounds(0, 400, 800, 200);

        JPImagen.setBorder(BorderFactory.createBevelBorder(1));
        JPPalabra.setBorder(BorderFactory.createBevelBorder(1));

        frame.add(JPImagen);
        frame.add(JPPalabra);

        frame.setLocation(300, 50);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        botonPrueba3 = new JButton();
        botonPrueba3.setText("boton 3");

        botonPrueba4 = new JButton();
        botonPrueba4.setText("boton 4");

        botonPrueba5 = new JButton();
        botonPrueba5.setText("boton 5");

        JPPalabra.add(botonPrueba3);
        JPPalabra.add(botonPrueba4);
        JPPalabra.add(botonPrueba5);

        JPPalabra.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
