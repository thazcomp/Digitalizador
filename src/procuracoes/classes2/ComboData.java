/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuracoes.classes2;

import procuracoes.classes.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;

/**
 *
 * @author Thiago
 */
public class ComboData {

    public Calendar cal = new GregorianCalendar();
    public JComboBox dia;
    public JComboBox mes;
    public JComboBox ano;
    public ItemListener trocaMes;

    public ComboData(int DIA, int MES, int ANO) {

        cal.set(ANO, MES, DIA);
        int i = 1;
        String[] d = new String[31];
        String[] m = new String[12];
        String[] a = new String[401];
        while (i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            d[i - 1] = Integer.toString(i);
            i++;
        }
        dia = new JComboBox(d);
        i = 1;
        while (i <= 12) {
            m[i - 1] = Integer.toString(i);
            i++;
        }
        String z[] = new String[31];
        trocaMes = (ItemEvent e) -> {
            int j = 1;
            cal.set(Calendar.MONTH, mes.getSelectedIndex());
            while (j <= cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                z[j - 1] = Integer.toString(j);
                j++;
            }
            while(j<=31){
                z[j-1] = null;
                j++;
            }
            JComboBox diaux = new JComboBox(z);
            int i1 = cal.get(Calendar.MONTH); //interessante, declaração usada com o objetivo de atrasar a jvm, pois sem ela ele não monta o modelo corretamente não sei o porque
            dia.setModel(diaux.getModel());
        };
        mes = new JComboBox(m);
        mes.addItemListener(trocaMes);
        i = 1800;
        while (i <= 2200) {
            a[i - 1800] = Integer.toString(i);
            i++;
        }
        ano = new JComboBox(a);
        ano.setSelectedIndex(215);
    }
}
