import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.io.File;

public class EditMenuHandler implements ActionListener 
{
    private CarGUI gui; 
    String make;  
    UnsortedCarList searchResult = new UnsortedCarList(); 

    // Constructor 
    public EditMenuHandler(CarGUI gui)
    {
        this.gui = gui; 
    }

    //@overriden actionPerformed
    public void actionPerformed(ActionEvent event)
    {
        String menuName = event.getActionCommand();

        if (menuName.equals("Search")) 
        {
            // JOptionPane to store the make 
            make = JOptionPane.showInputDialog("Type in a make: "); 

            CarNode i = gui.sorted.head.next; 

            while(i != null)
            {
                if(i.data.getMake().equals(make))
                {
                    searchResult.add(i.data);
                }
                i = i.next; 
            }

            //clearCarGUI();
            gui.addSearchGUI(searchResult); 
        }
    }
}