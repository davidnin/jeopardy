/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Tablero {
    private Set<Pregunta> preguntas = new LinkedHashSet<>();
    private Set<Pregunta> preguntasRondaFinal = new LinkedHashSet<>();
    private int turno;
    private boolean J1Juega = true;
    /*private ViewJeopardy viewJeopardy; */
    private Jugador jugador1;
    private Jugador jugador2;
    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Set<Pregunta> getPreguntasRondaFinal() {
        return preguntasRondaFinal;
    }

    public void setPreguntasRondaFinal(Set<Pregunta> preguntasRondaFinal) {
        this.preguntasRondaFinal = preguntasRondaFinal;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isJ1Juega() {
        return J1Juega;
    }

    public void setJ1Juega(boolean J1Juega) {
        this.J1Juega = J1Juega;
    }
/*
    public ViewJeopardy getViewJeopardy() {
        return viewJeopardy;
    }

    public void setViewJeopardy(ViewJeopardy viewJeopardy) {
        this.viewJeopardy = viewJeopardy;
    }
*/
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
     
     public Tablero(Jugador J1, Jugador J2) {
        this.turno = 0;
      //  this.viewJeopardy = view;
        this.jugador1 = J1;
        this.jugador2 = J2;
        
        try {
            cargarDatos();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     private void cargarDatos() throws IOException{
        
        FileReader lectura = new FileReader("preguntasJeopardy.txt");
        BufferedReader  escritura = new BufferedReader(lectura); 
        String frase;

        frase = escritura.readLine();
        while (frase != null){
            String[] valores = frase.split(";");
            Pregunta p = new Pregunta(valores[0],Integer.parseInt(valores[1]),Integer.parseInt(valores[2]),valores[3], valores[4], valores[5], valores[6]);
            preguntas.add(p);
            frase = escritura.readLine();
        } 
    }
     
     public void cargarDatosRondaFinal() throws IOException{
        
        FileReader lectura = new FileReader("preguntasRondaFinal.txt");
        BufferedReader escritura = new BufferedReader(lectura); 
        String frase;

        frase = escritura.readLine();
        while (frase != null){
            String[] valores = frase.split(";");
            Pregunta p = new Pregunta(valores[0],Integer.parseInt(valores[1]),Integer.parseInt(valores[2]),valores[3], valores[4], valores[5], valores[6]);
            preguntasRondaFinal.add(p);
            frase = escritura.readLine();
        } 
    }
     
     
     
     
     
}
