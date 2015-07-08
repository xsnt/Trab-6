/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;
/*Depois deste trabalho, eu largo java de mão 4 ever*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class ControladorGuild {
    private Guild view;
    private PerTabGUI tab;
    private PerTabControlador tabCont;
    private EvtTabGUI tabEve;
    private EvtTabControlador tabEveCont;
    private ArrayList<Personagem> grupoGerado;
    private boolean gerado;
    
    //Construtor (Santo Alt+Insert)
    public ControladorGuild(Guild v){
        this.view = v;
        Personagem.p = new ArrayList<>();
        Evento.e = new ArrayList<>();
        this.tab = new PerTabGUI();
        this.tabCont = new PerTabControlador(this.tab);
        this.tabEve = new EvtTabGUI();
        this.tabEveCont = new EvtTabControlador(this.tabEve);
        this.grupoGerado = null;
    }
    
    //Joga o boneco pra dentro 
    public void cadastroPersonagem(){
        String personagem = (String) view.getPerN().getText();
        String turno = (String) view.getTurno().getSelectedItem();
        String raca = (String) view.getPerR().getSelectedItem();
        String classe = (String) view.getPerC().getSelectedItem();
        String profissao = (String) view.getPerPrf().getSelectedItem();
        String espec = (String)view.getPerRl().getSelectedItem();
        int lvlPersonagem = (int) view.getPerNv().getValue();
        int lvlProfissao = (int) view.getPerNprf().getValue();
        ArrayList<String> dias = pegaDias();
        
        //Pega a info dos baratos e joga pro outro barato
        if(verificaInfoCadastro(personagem, turno, dias)){//Sem isso ele buga de um jeito inimaginavel
        Personagem ps = new Personagem(personagem, raca, classe, espec, lvlPersonagem, profissao, lvlProfissao, dias, turno);
        Personagem.p.add(ps);
        view.resetCadastro();
        }
    }
    //Transforma os checkbox em um Array de dias
    private ArrayList<String> pegaDias(){
        ArrayList<String> dias = new ArrayList<>();
        
        if(view.getDomingo().isSelected()){
            dias.add("Dom");
        }
        if(view.getSegunda().isSelected()){
            dias.add("Seg");
        }
        if(view.getTerca().isSelected()){
            dias.add("Ter");
        }
        if(view.getQuarta().isSelected()){
            dias.add("Qua");
        }
        if(view.getQuinta().isSelected()){
            dias.add("Qui");
        }
        if(view.getSexta().isSelected()){
            dias.add("Sex");
        }
        if(view.getSabado().isSelected()){
            dias.add("Sab");
        }
        
        if(dias.size() > 0){
            return dias;
        }else{
            return null;
        }
    }
    
    //Cria o grupo de acordo com as especificações do usuário
    public void geraGrupo(){
        int total = Integer.valueOf((String) view.getEvtGenGurizada().getSelectedItem());
        int qntTank = (int) view.getEvtGenTank().getValue();
        int qntHealer = (int) view.getEvtGenHealer().getValue();
        int qntDps = (int) view.getEvtGenDps().getValue();
        int soma = qntTank + qntHealer + qntDps;
        //Arrays auxiliares para salvar índices dos personagens
        ArrayList<Integer> indTank;
        ArrayList<Integer> indHealer;
        ArrayList<Integer> indDps;

        
        
        if(total == soma){
            indTank = new ArrayList<>();
            indHealer = new ArrayList<>();
            indDps = new ArrayList<>();
            
            //Separa os personagens disponíveis entre as especialidades
            for(int i = 0; i < Personagem.p.size(); i++){
                Personagem a = (Personagem) Personagem.p.get(i);
                switch (a.getEspecialidade()) {
                    case "Tank":
                        indTank.add(i);
                        break;
                    case "Healer":
                        indHealer.add(i);
                        break;
                    case "Dps":
                        indDps.add(i);
                        break;
                }
            }
            //Testa se eh possível gerar o grupo nessas configurações
            if(indTank.size() >= qntTank && indHealer.size() >= qntHealer && indDps.size() >= qntDps){
                this.grupoGerado = new ArrayList<>();
                
                for(int hue = 0; hue < qntTank; hue++){
                    int id = (int) indTank.get(hue);
                    Personagem p = (Personagem) Personagem.p.get(id);
                    grupoGerado.add(p);
                }
                for(int hue = 0; hue < qntHealer; hue++){
                    int id = (int) indHealer.get(hue);
                    Personagem p = (Personagem) Personagem.p.get(id);
                    grupoGerado.add(p);
                }
                for(int hue = 0; hue < qntDps; hue++){
                    int id = (int) indDps.get(hue);
                    Personagem p = (Personagem) Personagem.p.get(id);
                    grupoGerado.add(p);
                }

                JOptionPane.showMessageDialog(null, "Grupo gerado! \n Preencha os campos: Nome, dia e hora do Evento");
                this.gerado = true;
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível gerar um grupo nessas configurações!");
            }            
            }else{
            JOptionPane.showMessageDialog(null, "Cofiguração no gerador inválida!");
        }
        
        view.resetGerador();    
    }
    
    //Lista os personagens cadastrados
    public void listaPersonagens(){
        this.tab.setVisible(true);
        this.tabCont.listaPersonagens();
    }
    
    //Lista os eventos cadastrados
    public void listaEventos(){
        this.tabEve.setVisible(true);
        this.tabEveCont.listaEventos();
    }
    
    //Cadastra um evento no sistema
    public void cadastroEvento(){
        String nome = (String) view.getEvtNome().getText();
        String turno = (String) view.getEvtTurno().getSelectedItem();
        String dia = (String) view.getEvtDia().getSelectedItem();
        int qnt = Integer.valueOf((String) view.getEvtTam().getSelectedItem());
        int[] i = this.tabCont.getIndices();
        ArrayList<Personagem> p = new ArrayList<>();
        Evento e;
        
        if(verificaInfoEvento(nome, turno, i, qnt)){    
            if(!this.gerado){
                for(int j = 0; j < i.length; j++){
                    System.out.println(i[j]);
                    p.add((Personagem) Personagem.p.get(i[j]));
                }
                e = new Evento(p, nome, dia, turno, qnt);
            }else{
                e = new Evento(this.grupoGerado, nome, dia, turno, qnt);
                this.gerado = false;
            }
            
            Evento.e.add(e);
            view.resetEvento();
        }
    }

    //Transforma uma String de dias em um ArrayList de dias
    private ArrayList<String> strToArray(String dias){
        ArrayList<String> dispo = new ArrayList<>();
        
        
        if(dias.contains("Dom")){
            dispo.add("Dom");
        }
        if(dias.contains("Seg")){
            dispo.add("Seg");
        }
        if(dias.contains("Ter")){
            dispo.add("Ter");
        }
        if(dias.contains("Qua")){
            dispo.add("Qua");
        }
        if(dias.contains("Qui")){
            dispo.add("Qui");
        }
        if(dias.contains("Sex")){
            dispo.add("Sex");
        }
        if(dias.contains("Sab")){
            dispo.add("Sab");
        }
        
        
        return dispo;
    }
    
    //verifica os dados de cadastro do evento
    private boolean verificaInfoEvento(String nome, String hora, int[] indice, int qnt){
        if(nome.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo 'Nome do evento' vazio!");
            return false;
        }
        
        if(hora.isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo 'Hora do evento' vazio!");
            return false;
        }
            
        if(!this.gerado){
            if(indice.length < qnt){
                JOptionPane.showMessageDialog(null, "Selecione mais personagens!");
                return false;
            }

            if(indice.length > qnt){
                JOptionPane.showMessageDialog(null, "Quantidade de personagens excedida!");
                return false;
            }
        }
        return true;
    }

    private boolean verificaInfoCadastro(String personagem, String turno, ArrayList<String> dias) {

        if(personagem.isEmpty()){
            JOptionPane.showMessageDialog(null, "personagem vazio");
            return false;
        }
        
        if(dias == null){
            JOptionPane.showMessageDialog(null, "dia vazio");
            return false;
        }
        
        if(turno.isEmpty()){
            JOptionPane.showMessageDialog(null, "turno vazio");
            return false;
        }
        return true;
        // se tudo der certo retorna true
    }
}
