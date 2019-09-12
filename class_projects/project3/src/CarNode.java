public class CarNode
{
    // 'data' holds the car object of the node
    protected Car data; 

    // 'next' points to the next element of the array 
    protected CarNode next; 

    // Constructor for the CarNode class 
    // takes one Car object as a parameter and sets 'data' to that variable 
    public CarNode(Car c)
    {
        this.data = c; 
    }  
}