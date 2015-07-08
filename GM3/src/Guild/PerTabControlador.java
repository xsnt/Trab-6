/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */
public class PerTabControlador {

    private JTable tabela;
    private PerTabGUI view;
    private static int[] jogaIndice;
    
    public PerTabControlador(PerTabGUI v){
        this.tabela = v.getTabela();
        jogaIndice = new int[0];
        this.view = v;
    }
    
    //Era pra dar display nos personagens
    public void listaPersonagens(){
        DefaultTableModel dtm = new DefaultTableModel(new Object [] []{ }, new String [] {
                                "Personagem", "Raça", "Classe", "Especialidade", "Level", "Profissão", 
                                "Level Profissão", "Dias Disponível", "Turno"} );
        
        for (Personagem p : Personagem.p) {
            Personagem t = (Personagem) p;
            dtm.addRow(new Object [] {t.getPersonagem(), t.getRaca(), t.getClasse(), t.getEspecialidade(), t.getLvlPersonagem(),
                t.getProf().getProf(), t.getProf().getLevel(),arrayToStr(t), t.getTurno()});
        }
        
        this.tabela.setModel(dtm);
    }
    
    private String arrayToStr(Personagem p){
        String dias;
        
        dias = p.getDiasDisp().get(0);
        for(int i = 1; i < p.getDiasDisp().size(); i++){
            dias += ", " + p.getDiasDisp().get(i);
        }
        
        return dias;
    }
    //Responsável por listar o Array de personagens de um grupo
    public void listaPersonagens(ArrayList<Personagem> p){
        DefaultTableModel dtm = new DefaultTableModel(new Object [] []{ }, new String [] {
                                "Personagem", "Raça", "Classe", "Especialidade", "Level", "Profissão", 
                                "Level Profissão", "Dias Disponível", "Turno"} );
        
        for (Personagem p1 : p) {
            Personagem t = (Personagem) p1;
            dtm.addRow(new Object [] {t.getPersonagem(), t.getRaca(), t.getClasse(), t.getEspecialidade(), t.getLvlPersonagem(),
                t.getProf().getProf(), t.getProf().getLevel(), t.getTurno()});
        }
        
        this.tabela.setModel(dtm);
    }
    
    //Pega os personagens selecionadas para o grupo
    public void jogaIndice(){
        PerTabControlador.jogaIndice = this.tabela.getSelectedRows();
        view.setVisible(false);
        
    }
    
    //Retorna os indices para o método de cadastras
    public int[] getIndices(){
        return PerTabControlador.jogaIndice;
    }
    
    public void limboPer(){
        int limbo;
        
        limbo = this.tabela.getSelectedRow();
        if(limbo > -1){
            Personagem.p.remove(limbo);
            this.view.setVisible(false);
        }
        
        view.setVisible(false);
    }
   }
