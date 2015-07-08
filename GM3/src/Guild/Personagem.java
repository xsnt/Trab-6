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
public class Personagem {

    public static ArrayList<Personagem> p; //Array principal de personagens
    
    private String personagem;
    private String raca;
    private String classe;
    private String especialidade;
    private String turno;
    private int level;
    private Prof prof; // Comum a todos os personagens
    private ArrayList<String> diasDisp;
    
    public Personagem(String pers, String raca, String classe, String espec, int lvl, String profi, int lvlProf, ArrayList d, String t){
        this.personagem = pers;
        this.raca = raca;
        this.classe = classe;
        this.especialidade = espec;
        this.level = lvl;
        this.prof = new Prof(profi, lvlProf);
        this.diasDisp = d;
        this.turno = t;
    }
    
    public String getPersonagem(){
        return this.personagem;
    }
    
    public String getRaca(){
        return this.raca;
    }
    
    public String getClasse(){
        return this.classe;
    }
    
    public String getEspecialidade(){
        return this.especialidade;
    }
    
    public int getLvlPersonagem(){
        return this.level;
    }
    
    public Prof getProf(){
        return this.prof;
    }
    
    public ArrayList<String> getDiasDisp(){
        return this.diasDisp;
    }
    
    public String getTurno(){
        return this.turno;
    }
}  

