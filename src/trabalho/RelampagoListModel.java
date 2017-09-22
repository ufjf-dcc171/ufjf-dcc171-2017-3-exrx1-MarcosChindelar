/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author M.Chin
 */
public class RelampagoListModel implements ListModel {
    private final List<Relampagos> relampagos;
    private final List<ListDataListener> dataLinisters;

    public RelampagoListModel(List<Relampagos> relampagos) {
        this.relampagos = relampagos;
        this.dataLinisters = new ArrayList();
    }

    public int getSize() {
        return relampagos.size();
    }

    public Relampagos getElementAt(int index) {
        return relampagos.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        this.dataLinisters.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        this.dataLinisters.remove(l);
    }
}
