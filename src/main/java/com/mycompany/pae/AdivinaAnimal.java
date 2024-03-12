/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pae;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author juanh
 */
class AdivinaAnimal {
    private static NodoArbol raiz;
    private Scanner in;

    /**
     * Constructor por omision. Crea el nodo raiz con un elefante
     */
    public AdivinaAnimal (){
	raiz = new NodoArbol("Elefante");
	in = new Scanner(System.in);
    }

    /**
     * Metodo para jugar a adivinar animales
     */
  public void jugar() {
    NodoArbol nodo = raiz;

    while (nodo != null) {
        if (nodo.izquierda != null) {
            // Hay una pregunta
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                nodo.valor,
                "Adivinanza",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                nodo = nodo.izquierda;
            } else {
                nodo = nodo.derecha;
            }
        } else {
            // Se tiene un animal
            int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Tu animal es un " + nodo.valor + "?",
                "Adivinanza",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(
                    null,
                    "¡Gané! siuuuuuuuu :)",
                    "Adivinanza",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                animalNuevo(nodo);
            }

            nodo = null;
            return;
            
        }
    }
}

  /*
   * Mï¿½todo privado para leer una respuesta del usuario sï¿½lo puede ser si o no
   * @return boolean -- true si la respuesta es si y false en otro caso.
   */
  public boolean respuesta() {
    while (true) {
        int opcion = JOptionPane.showOptionDialog(
            null,
            "¿Sí o no?",
            "Respuesta",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"Sí", "No"},
            null
        );

        if (opcion == JOptionPane.YES_OPTION) {
            return true;
        } else if (opcion == JOptionPane.NO_OPTION) {
            return false;
        }
    }
}

public void animalNuevo(NodoArbol nodo) {
    String animalNodo = (String) nodo.valor;

    String nuevoA = JOptionPane.showInputDialog(
        null,
        "¿Cuál es tu animal?",
        "Nuevo animal",
        JOptionPane.QUESTION_MESSAGE
    );

    String pregunta = JOptionPane.showInputDialog(
        null,
        "¿Qué pregunta con respuesta sí/no puedo hacer para poder decir que es un(a) " + nuevoA + "?",
        "Nueva pregunta",
        JOptionPane.QUESTION_MESSAGE
    );

    NodoArbol nodo1 = new NodoArbol(animalNodo);
    NodoArbol nodo2 = new NodoArbol(nuevoA);

    int opcion = JOptionPane.showOptionDialog(
        null,
        "¿Para un(a) " + nuevoA + " la respuesta es sí o no?",
        "Respuesta",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        new String[] {"Sí", "No"},
        null
    );

    if (opcion == JOptionPane.YES_OPTION) {
        nodo.valor = pregunta + "?";
        nodo.izquierda = nodo2;
        nodo.derecha = nodo1;
    } else if (opcion == JOptionPane.NO_OPTION) {
        nodo.valor = pregunta + "?";
        nodo.izquierda = nodo1;
        nodo.derecha = nodo2;
    }
}

public static void main(String[] args) {
    JOptionPane.showMessageDialog(
        null,
        "Juguemos a adivinar animales",
        "AdivinaAnimal",
        JOptionPane.INFORMATION_MESSAGE
    );

    boolean otroJuego = true;
    AdivinaAnimal juego = new AdivinaAnimal();

    do {
        juego.jugar();

        int opcion = JOptionPane.showOptionDialog(
            null,
            "¿Jugamos otra vez?",
            "Nuevo juego",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"Sí", "No"},
            null
        );

        if (opcion == JOptionPane.NO_OPTION) {
            otroJuego = false;
        }
    } while (otroJuego);

    JOptionPane.showMessageDialog(
        null,
        "¡Hasta la próxima!",
        "AdivinaAnimal",
        JOptionPane.INFORMATION_MESSAGE
    );
    
}
}