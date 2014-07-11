package musca2;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public interface IViewMuste {
       public ArrayList<IMusca> getListaMuste();
       public void setListaMuste(ArrayList<IMusca> musteDeDesenat);
       public MouseEvent getLastClick();
       public void cleanLastClick();
       public Dimension getSize();
       public void repaint();
}
