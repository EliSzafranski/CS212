public class SortedCarList extends CarList
{
    public SortedCarList()
    {
        // Call the super constructor
        super();
    }

    public void add(Car c)
    {

        //Create a new CarNode 
        CarNode n = new CarNode(c);

        //Create a new CarNode itterator variable
        CarNode i = head; 

        //Find the correct place to insert the new CarNode in
        while(i.next != null && n.data.getMake().compareToIgnoreCase(i.next.data.getMake()) > 0)
        {
            i = i.next;
        }

        //After finding the correct place for CarNode n, insert it there
        n.next = i.next;
        i.next = n;

        // If n is inserted at the end, then tail is no longer pointing to the correct CarNode, so we update what it points to here
        if(i == this.tail)
        {
            this.tail = n; 
        }

        // Increments the length after any element is added
        length++; 
    }
}






//look up how to store graphs
//use a 2d array for complete graphs //adjecency matrix
//adjacency list 
//dag - type of graph, only positive weights 
//negative weights
//4 shortest path algorithms 
//1 abstract class graph 