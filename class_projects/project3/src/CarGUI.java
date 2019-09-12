import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextArea; 
import java.awt.GridLayout; 

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
import java.util.StringTokenizer;

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
        this.setSize(400, 400);
        this.setLocation(400, 450);
        this.setLayout(new GridLayout(1, 2)); // layout is 1 row, 2 columns

        //Adding a menu bar with drop down file button 
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        //Creating buttons to add to 'file' drop down menu  
        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        
        // Adding an action listener to each menu button 
        FileMenuHandler fmh = new FileMenuHandler(this);
        open.addActionListener(fmh);
        quit.addActionListener(fmh);

         // Physically adding the "open" and "quit" buttons to the drop down "file" menu
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        // Add file menu to the menu bar, and set this gui's
        // menu bar to the menuBar we created above
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);


        // Adding two text areas to the GUI which will display both lists
        this.leftTextArea = new JTextArea();
        this.rightTextArea = new JTextArea();
    }


    public void showGUI()
    {
        this.setVisible(true);
    }


    //This method takes an array of type CarList and adds each element in the array to the GUI
    public void addToGUI(CarList[] list)
    {
        //Adds two text areas to the content pane of the GUI
        this.getContentPane().add(this.leftTextArea);
        this.getContentPane().add(this.rightTextArea);
        

        // Create two CarNode reference variables to itterate through the linked lists
        // They each start off pointing to the CarNode after the head/dummy node
        CarNode itteratorA = list[0].head.next;
        CarNode itteratorB = list[1].head.next; 

        for(int i = 0; i < list[0].getLength(); i++)
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

     // method to read every element in the file, and instantiate and add a new Car object to a CarList
     public void readFile(File file)
     {
         Scanner reader = null;

         //Creates an array of CarLists which can be filled
         CarList list[] = new CarList[2]; 

         //Create Two car lists to add the new Car objects to
         SortedCarList sorted = new SortedCarList(); 
         UnsortedCarList unsorted = new UnsortedCarList(); 

         try
         {
             reader = new Scanner(file);

             String line = reader.nextLine(); 

             while (reader.hasNextLine())
             {
                 
                 line = reader.nextLine();
                 //Create a new StringTokenizer object to parse the string returned by
                 //the method nextLine()
                 StringTokenizer st = new StringTokenizer(line, ",");
                
                 // Create new Car reference variable
                 Car n; 

                 if(st.countTokens() == 4)
                 {
                     // Instantsiate each new Car object from the text file and then add it to the Linked Lists 
                     n = new Car(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                     sorted.add(n); 
                     unsorted.add(n);
                 }

                //line = reader.nextLine(); 
                //line = reader.nextLine(); 
             }
         }
         catch (FileNotFoundException e)
         {
             e.printStackTrace();
         }

         // Adds both CarList objects to an array of type CarList 
         list[0] = sorted; 
         list[1] = unsorted; 

         // Calls the addToGUI method to physically add the two linked lists to the CarGUI
         // Passes both CarLists to the method through an array of type CarList 
         addToGUI(list); 
     }
}