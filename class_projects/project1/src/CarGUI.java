import javax.swing.*; 
import java.awt.*;
class CarGUI extends JFrame
{
    private JTextArea leftTextArea;
    private JTextArea rightTextArea; 
    
    public CarGUI()
    {
        this("No Title");
    }

    public CarGUI(String title)
    {
        super(title); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocation(200, 200);
        this.setLayout(new GridLayout(1, 2)); // layout is 1 row, 2 columns

        this.leftTextArea = new JTextArea();
        this.rightTextArea = new JTextArea();
    }

    public void showGUI()
    {
        this.pack();
        this.setVisible(true);
    }

    //This adds two Car arrays to the GUI
    public void addToGUI(Car[] a, Car[] b)
    {
        //Adds two text areas to the content pane
        this.getContentPane().add(this.leftTextArea);
        this.getContentPane().add(this.rightTextArea);
        
        for(int i = 0; i < a.length; i++)
        {
            //Appends each element of the Car arrays to the two text-areas
            //Also turns the Car object into a string
            leftTextArea.append(a[i].toString() + "\n");
            rightTextArea.append(b[i].toString() + "\n");
        }
    }
}