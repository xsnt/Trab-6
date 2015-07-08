/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guild;

/**
 *
 * @author Jean
 */
public class Prof {
    private String prof;
    private int level;

    public Prof(String profissao, int level) {
        this.prof = profissao;
        this.level = level;
    }

    public String getProf() {
        return prof;
    }

    public int getLevel() {
        return level;
    }
    
}
