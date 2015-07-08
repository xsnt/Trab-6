/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jean
 */
public class EvtTabControlador {
    
    private JTable tabela;
    private EvtTabGUI view;
    
    public EvtTabControlador(EvtTabGUI v){
        this.view = v;
        this.tabela = v.getTabela();
    }
    
    //Mostra os eventos na tabela
    public void listaEventos(){
        DefaultTableModel dtm = new DefaultTableModel(new Object [] []{ }, new String [] {
                                "Nome", "Dia", "Turno", "Quantidade de Players"} );
        
        
        for (Evento e : Evento.e) {
            Evento t = (Evento) e;
            dtm.addRow(new Object [] {t.getNome(), t.getDia(), t.getTurno(), t.getQuantPers() } );
        }
        this.tabela.setModel(dtm);
    }
    
    public void listaPersonagens(){
        int listar;
        
        listar = this.tabela.getSelectedRow();
        System.out.println(listar);
        if(listar > -1){
            PerTabGUI tab = new PerTabGUI();
            PerTabControlador cont = new PerTabControlador(tab);
            
            ArrayList<Personagem> p = Evento.e.get(listar).getGrupo();
            
            cont.listaPersonagens(p);
            tab.setVisible(true);
            tab.getJogaGrupo().setVisible(false);
            tab.getButtonLimboPer().setVisible(false);
        }  
    }
    public void removeEvt(){
        int remover;
        
        remover = this.tabela.getSelectedRow();
        if(remover > -1){
            Evento.e.remove(remover);
            this.view.setVisible(false);
        }
        
        view.setVisible(false);
    }
    
}
    

