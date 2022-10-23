import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class LeftRight 
{
    public void create() throws IOException
    {
        boolean s=false;
        String dir ="D:\\FileDemo";
System.out.println("4");
        File f=new File(dir);
System.out.println("3");
        s=f.mkdir();
	System.out.println("2");
        if(s)
        {
            System.out.printf("Successfully created new directory :  %s%n",dir);
		System.out.println("1");
        }
        else
        {
            System.out.println("Directory not created");
        }
    }
    public static void main(String[] args) throws IOException
    {
        LeftRight lr= new LeftRight();
		System.out.println("6");
        lr.create();
		System.out.println("5");
    }
}