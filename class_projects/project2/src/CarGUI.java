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
    public void addToGUI(CarList unsorted, CarList sorted)
    {
        //Adds two text areas to the content pane
        this.getContentPane().add(this.leftTextArea);
        this.getContentPane().add(this.rightTextArea);
        

        // Create two CarNode reference variables to itterate through the linked lists
        // They each start off pointing to the CarNode after the head/dummy node
        CarNode itteratorA = unsorted.head.next;
        CarNode itteratorB = sorted.head.next; 

        for(int i = 0; i < unsorted.getLength(); i++)
        {
            //Appends each element of the Car arrays to the two text-areas
            //Also turns the Car object into a string
            leftTextArea.append(itteratorA.data.toString() + "\n");
            rightTextArea.append(itteratorB.data.toString() + "\n");

            // points the two reference itterator variables to the CarNode following their current CarNode
            itteratorA = itteratorA.next; 
            itteratorB = itteratorB.next; 
        }
    }
}