import javax.swing.JOptionPane;

public class Project0
{
    public static void main(String[] args)
    {

        String inputWord = null; 
        
        // This allows for the user to input as many sentences as they wish
        while(true)
        {
            int lowerCase = 0, upperCase = 0; 
            

            inputWord = JOptionPane.showInputDialog("Please enter a sentence.");

            // ensures the user will be able to exit the program when they type "done"
            if(inputWord.equalsIgnoreCase("stop"))
            {
                System.exit(0);
            }

            //Itterates through the entire string to find the "e's"
            for(int i = 0; i < inputWord.length(); i++)
            {
                if(inputWord.charAt(i) == 'e')
                {
                    //increments when finds a lower case 'e'
                    lowerCase++; 
                }
                if(inputWord.charAt(i) == 'E')
                {
                    //increments when finds an upper case 'E'
                    upperCase++; 
                }
            }
            //Writes the total number of both upper and lower case E's so the user can see them
            JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowerCase + "\nNumber of upper case e's: " + upperCase);
        }
    }
}