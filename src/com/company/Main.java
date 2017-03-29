package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	String nombre;

        nombre = JOptionPane.showInputDialog("cual es tu nombre?");

       System.out.println("hola "+nombre);

        principalFrame launchPrincipalFrame = new principalFrame();
    }
}
