public abstract class CarList
{
    protected CarNode head, tail; 
    protected int length;  

    public CarList()
    {
        CarNode dummy = new CarNode(new Car("","", 0, 0));
        this.head = dummy;
        this.tail = this.head; 
        this.length = 0; 
    }

    public void append(Car c)
    {
        // Create a new CarNode 'n'
        CarNode n = new CarNode(c);

        // Add the new node to the end of the list by ensuring that tail.next points to n 
        tail.next = n; 

        //Update what the new last node is by setting tail to n
        this.tail = n; 

        // Increment the length after every element is added 
        length++; 
    }

    public int getLength()
    {
        return this.length; 
    }
}