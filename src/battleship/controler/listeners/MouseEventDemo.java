
package battleship.controler.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import battleship.model.Tir;
import battleship.view.custom_views.VueCase;


/**
 * Classe qui implement le MouseListener.
 */
public class MouseEventDemo implements MouseListener {

    private VueCase vc;

    /**
     * Construit un instance de MouseEventDemo.
     * @param vc la case.  
     */
    public MouseEventDemo(VueCase vc) {
        this.vc = vc;
    }

    /**
     * Place un tir dans la case.
     * @param e MouseEvent.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        this.vc.getCase().getMer().placer(new Tir(this.vc.getCase().getPosition()));
        System.out.println(this.vc.getCase().getPosition().toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
