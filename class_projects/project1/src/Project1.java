import java.util.*;
import javax.swing.*; 


public class Project1
{
    public static void main(String args[])
    {
        String myFile = args[0];
        int lineCount = numLines(myFile); 
        
       
        Car[] unsortedCars = new Car[lineCount];
        fillArray(myFile, unsortedCars);

        Car[] sortedCars = new Car[lineCount]; 
        fillArray(myFile, sortedCars);
        
        selectionSort(sortedCars);
        //try{
        CarGUI myGui = new CarGUI();
        myGui.addToGUI(unsortedCars, sortedCars);
        myGui.showGUI();
        //}
        /*catch(NullPointerException e){
            for(int i = 0; i < sortedCars.length; i++){
                System.out.println(sortedCars[i].toString());
            }
        }*/

    }


    //Fills an declared Car Array from an input file 
    private static void fillArray(String myFile, Car[] myArray)
    {
        //Creates new TFI object 
        TextFileInput input = new TextFileInput(myFile);

        //takes the first line of cars.txt and turns it into the String 'line'
        String line = input.readLine(); 

        //keeps track of the index of the array we are currently up to
        int count = 0; 

        while(line != null)
        {
             //Tokenizes the first line using ',' as a delimninator 
            StringTokenizer st = new StringTokenizer(line, ",");

            //If the line has 4 tokens, instantiate a new car object at index 'count'
            if(st.countTokens() == 4)
            {
                //Instantiates a new car and places it in an index of the array
                //calls the next token for each part of the constructor, and turns the strings into ints when necessary
                myArray[count] = new Car(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                count++; 
            }

            //Changes the line variable to the next line of cars.txt
            line = input.readLine();
        }
    }

    //Gets the number of lines in a txt file so the array can be instantiated to a specific size
    public static int numLines(String myFile)
    {
        int count = 0; 
        TextFileInput input = new TextFileInput(myFile);

        String line = input.readLine(); 

        // A while loop to loop through each line of the text while the next line is still full, i.e not null
        while(line != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");

            //this ensures that only valid rows are counted, i.e rows with four tokens
            if(tokenizer.countTokens() == 4)
            {
                count++;
            }
            else System.out.println(line);

            line = input.readLine(); 
        }
        return count;
    }

    //Swaps the location of two objects in an array. Takes in two indexes and the array
    private static void swap(Car[] input, int i, int j)
    {
        Car temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    // Sort an array of Car objects using the selection sort procedure, and the String class compareToIgnoreCase() method
    public static void selectionSort(Car[] input)
    {
        for (int i = 0; i < input.length - 1; i++)
        {
            String min = input[i].getMake();
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++)
            {
                if (min.compareToIgnoreCase(input[j].getMake()) > 0)
                {
                    min = input[j].getMake();
                    minIndex = j;
                }
            }
            swap(input, i, minIndex);
        }
    }
}


//dont hard code size of array
//selection sort is in lab14 and lab06
//make a compareTo function in my Car class so i can do a selection sort 