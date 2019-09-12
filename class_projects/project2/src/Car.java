//The public class car
public class Car
{
    private String make; 
    private String model; 
    private int year; 
    private int mileage; 

    
    public Car(String ma, String mo, int ye, int mi)
    {
        this.make = ma;
        this.model = mo;
        this.year = ye;
        this.mileage = mi; 
    }

    //get and set methods for the cars make
    public String getMake()
    {
        return this.make; 
    }
    public void setMake(String ma)
    {
        this.make = ma; 
    }

    //get and set methods for the cars model
    public String getModel()
    {
        return this.model; 
    }
    public void setModel(String mo)
    {
        this.model = mo; 
    }  

    
    //get and set methods for the cars year
    public int getYear()
    {
        return this.year; 
    }
    public void setYear(int ye)
    {
        this.year = ye; 
    }


    //get and set methods for the cars mileage
    public int getMileage()
    {
        return this.mileage;
    }
    public void setMileage(int mi)
    {
        this.mileage = mi; 
    }

    //overidden toString method
    public String toString()
    {
        return this.make + "," + this.model + "," + this.year + "," + this.mileage;
    }
}