/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;

import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public class Evento {
    public static ArrayList<Evento> e; //Array principal de Eventos
    
    private ArrayList<Personagem> grupo;
    private String nome;
    private String dia;
    private String turno;
    private int quantPers;
    
    public Evento(ArrayList<Personagem> g, String nome, String dia, String turno, int quant){
        this.grupo = g;
        this.nome = nome;
        this.dia = dia;
        this.turno = turno;
        this.quantPers = quant;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getDia(){
        return this.dia;
    }
    
    public String getTurno(){
        return this.turno;
    }
    
    public int getQuantPers(){
        return this.quantPers;
    }
    
    public ArrayList<Personagem> getGrupo(){
        return this.grupo;
    }
}

