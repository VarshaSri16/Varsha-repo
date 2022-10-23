import java.io.*;
import java.util.Scanner;

class LeftRight 
{
    public void create()		//this function will create a new file 
    {
        boolean s=false;		
	  try
	  {	
      	File f=new File("C:/Users/Nitin Srivastava/Varsha/lrm.txt");		//new file will be created at this location
        	if(f.createNewFile())
            	System.out.println("Successfully created new File");			//this will print if the file is successfully created and condition returns true
        	else
        		System.out.println("File not created");					//this will run if the file is not created 
	 }											   //it will not create a file if the file with the same name already exists at that location
	 catch(Exception e)
	 {
		e.printStackTrace();
	 }
	
    }
    public void read(String loc) throws IOException
    {
		String input;
		Scanner sc = new Scanner(new File(loc));		//This will take a file as input
	      StringBuffer sb = new StringBuffer();		
	      while (sc.hasNextLine()) 				//it will return false when we reach end of file
		{
	         input = sc.nextLine();			
	         sb.append(" "+input);				//append data to print
      	}
      	System.out.println("Contents of the file are: "+sb.toString());        //changing the string buffer to string to print the data 
    }
    public void append(String loc, String data) throws IOException
    {
 
		FileWriter fw = new FileWriter(loc, true);			//true will state that the file is in append mode
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw); 
		pw.println(data);								
 		System.out.println("Data Successfully appended into file"); 
		pw.flush(); 
		fw.close();
		bw.close();
		pw.close();
    }
    public void replacedata(String loc, String data)
    {
	  File file = new File(loc);
	  FileWriter fr=null;
	  BufferedWriter br=null;
        String newdata=data+System.getProperty("line.separator"); 		//it will return /r/n in case of windows 
        try
        {
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(newdata);							//it will overwrite the old data 
           
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                br.close();
                fr.close();
            } 
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }	
    }

    public void search(String loc,String data) throws IOException
    {
	      File f1=new File(loc); 
	      String[] words=null;   
	      FileReader fr = new FileReader(f1);    
	      BufferedReader br = new BufferedReader(fr);  
      	String s;
		boolean flag=false;
      	while((s=br.readLine())!=null)						//loop will run till end of file
      	{
		 
      	      words=s.split(" "); 							//split the parah into words wy using space as a delimeter
			for(String w : words) 							//loop will run for each word
			{
				
				 if (w.equalsIgnoreCase(data)) 				//it will search by ignoring the case
				 {
                			System.out.println("Found: " +w);
					flag=true;      			                 //it will print the word if found in the file and flag will change to true
					break;
				 }
			}
		
      	}
		if(flag==false)
		{
			System.out.println("Not Found");					// It will print not found if the flag remains false 
		}
      	fr.close();
    }

    public void replacewords(String loc,String oldword,String newword) throws IOException   //function to replace a word with another word
    {
        	String or = "";
        	BufferedReader br = null;
        	BufferedWriter bw = null;
		try 
		{
			br = new BufferedReader(new FileReader(loc));
            	String cu = br.readLine();
            	while (cu != null) 						//loop will run till the end of current file
			{
                		or += cu + System.lineSeparator();
                		cu = br.readLine();
           		}
			String mo = or.replaceAll(oldword, newword);		//it will replace all occurences of the old word with the new word
			bw= new BufferedWriter(new FileWriter(loc));		
			bw.write(mo);							//it will write the modified data into the file

        	} 
		catch (IOException e) 
		{
 
        	} 
		finally 
		{
            	try 
			{
                		if (br != null) 
                    		br.close();
               		if (bw != null) 
                    		bw.close();
               	}
			catch (IOException e) 
			{
                
            	}
        	}	
    }
    public void count(String loc) throws IOException 		//this function will count the number of words in the file
    {										//loc contains the location of the file whose words we want to count
		File f1=new File(loc);                          //file object is created
	      String[] words=null; 					//String array is declared and initialized as null
	      int wc=0;    						//counter flag
	      FileReader fr = new FileReader(f1);    
	      BufferedReader br = new BufferedReader(fr);  
      	String s;
      	while((s=br.readLine())!=null)			//this will run untill the file contains data
      	{
      	   words=s.split(" ");   				//this will split the parah and store each word on each index of the array 
      	   wc=wc+words.length;   				//this will store the length of the words array
      	}
      	fr.close();
      	System.out.println("Number of words in the file:" +wc);    //it will print the number of words
    }
    public static void main(String[] args) throws IOException
    {
        LeftRight lr= new LeftRight();
	  String loc="C:/Users/Nitin Srivastava/Varsha/Varsha.txt";                   //Location of the file on which operation is performed
	  System.out.println("Enter 1 to create a file");
	  System.out.println("Enter 2 to read content of the file");
        System.out.println("Enter 3 to append data to existing file");
        System.out.println("Enter 4 to replace complete data with another data ");
        System.out.println("Enter 5 to search word in a file");
        System.out.println("Enter 6 to replace a word with another word");
        System.out.println("Enter 7 to count number of words");
	  System.out.println("Enter your choice :");						//Enter your choice depending on what operation you have to perform			
	  InputStreamReader isr=new InputStreamReader(System.in);
	  BufferedReader br=new BufferedReader(isr);		
        int ch=Integer.parseInt(br.readLine());
        switch(ch)
	  {
		case 1:
		{
			lr.create();					//Create file function will be called when user gives choice as 1 and it go similar with other choices
			break;
		}
		case 2: 
		{
			lr.read(loc);
			break;
			  
		}
		case 3:
		{
			System.out.println("Enter Data to append");			//Takes data to append from the user	
			String data=br.readLine();
			lr.append(loc,data);
			break;
		}
		case 4:
		{
			System.out.println("Enter data to replace");			//Takes data from the user to replace
			String data=br.readLine();
			lr.replacedata(loc,data);
			break;
		} 
		case 5:
		{
			System.out.println("Enter word to search");			//Takes data fromt he user to search a word in the file
			String data=br.readLine();
			lr.search(loc,data);
			break;
		}
		case 6:
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter word you want to replace");			//Takes data from the user to replace existing word with new word
			String oldword=sc.next();
			System.out.println("Enter word to replace the existing word");	//Note: Data entered should be case sensitive 
		      String newword=sc.next();
			lr.replacewords(loc,oldword,newword);
			break;
		}
		case 7:
		{
			lr.count(loc);																
			break;
		}
		default :
		{
			System.out.println("Invalid Choice");				//This block will run in case user enters anything apart from the choices mentioned
		}
	  }		
    }
}