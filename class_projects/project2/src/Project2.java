import java.util.*; 

public class Project2
{
    public static void main (String args[])
    {
        String myFile = args[0]; 

        // Create new linked-list object of type car
        SortedCarList sorted = new SortedCarList();
        UnsortedCarList unsorted = new UnsortedCarList(); 

        //Call method to add 
        addToList(myFile, sorted, unsorted);

        CarGUI myGUI = new CarGUI("Cars and such");
        myGUI.addToGUI(sorted, unsorted);
        myGUI.showGUI(); 
    }


    // Method to read an input file, and create new Car objects, and add them to two Linked Lists
    private static void addToList(String myFile, SortedCarList sorted, UnsortedCarList unsorted)
    {
        TextFileInput input = new TextFileInput(myFile); 

        String line = input.readLine(); 

        while(line != null)
        {
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

            // Go to the next line of the text file 
            line = input.readLine(); 
        }
    }
}