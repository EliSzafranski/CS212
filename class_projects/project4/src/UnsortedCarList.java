public class UnsortedCarList extends CarList
{
    public UnsortedCarList()
    {
        //Call the super constructor
        super();
    }

    public void add(Car n)
    {
        // Call the append method from the super class to add a new CarNode to the end 
        append(n);
    }
}