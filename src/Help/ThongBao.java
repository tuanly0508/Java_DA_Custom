/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import View_Dialog.ThongBaoDlg;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Starr
 */
public class ThongBao {

    public static void ThongBao(String noiDung, String tieuDe) {
        JOptionPane.showMessageDialog(new JFrame(), noiDung, tieuDe, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void ThongBaoDon(String noiDung, String tieuDe){
        ThongBaoDlg tb = new ThongBaoDlg(null,true);
        tb.setNoiDung(tieuDe, noiDung);
        tb.setVisible(true);
    }
    
    public static int LuaChon(String noiDung, String tieuDe){
        return JOptionPane.showConfirmDialog(new JFrame(), noiDung, tieuDe,JOptionPane.YES_NO_OPTION);
    }
    
}
