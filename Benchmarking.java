/*
Name: Alexander Phillips
CptS 233: MicroAssignment #1
Date: 9/1/2020
gitRepo url: https://github.com/Winter-Pgrm/HW1.git

*/
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Benchmarking
{

  
  public static void main(String[] args) 
  {
    
    
    
    String fileName;
    Boolean repeat = true;
    
    if(args.length > 0)
    {
    fileName = args[0];
    
    }
    
    repeat = startProgram(args[0]);
    System.out.println(args.length);
    
    
    	
	// Get input from user!
	
	//Scanner input = new Scanner(System.in);
		
    
	
	//End of all user input for this session

    //Creates dimension and carpet to send infromation to. 
    
    // output
   
  }
  
    private static Boolean startProgram( String fileName)
    {
        LinkedList<Integer> intList = new LinkedList<Integer>();
        long startTimer = 0;
        long endTimer =0;
      try
    {
        
      File freader = new File(fileName);
      Scanner inputFile = new Scanner(freader);
      
      Scanner input = new Scanner(System.in);
      while( inputFile.hasNextLine() )
      { 
          int ye =  inputFile.nextInt();

       // intList.add(inputFile.nextInt());
       time_Insert(intList, ye, startTimer, endTimer);

       
      }
      time_Med(intList,  startTimer, endTimer);
      time_Min(intList,  startTimer, endTimer);
       time_Max(intList,  startTimer, endTimer);
       
    }
    
    catch(IOException exp)
    {
   
      System.out.println("The file cannot be found or it was unable to be" 
                          + "opened," + "\n would you like a differnet file?"
                              + "\n Please enter Y or N");
      return true;               
    }
/*
               System.out.print( intList.size() + ":"  + ":::");
       for(int i = 0; i < intList.size() ; i++)
      {
         
        System.out.print(Objects.toString(intList.get(i)) + " ");
      }
       System.out.println();
 */      
 //     Scanner input = new Scanner(System.in);
 //   System.out.print("whatever bro lets me see this  ");
 //   double width = input.nextDouble();
    
    return false;
    
    }

  
    public static void time_Insert(LinkedList<Integer> intList, Integer value, long startTime, long endTime)
	{
            startTime = System.nanoTime();
		//Start timer
		//startTimer = System.nanoTime();
		
		//insert inegers
		insert(intList, value);
		
		//ern timer
		//endTimer = System.nanoTime();
	    endTime = System.nanoTime();
		//display time
      long durationInMs = TimeUnit.MICROSECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);
            System.out.println("The time it took to place " + value +" into the"
                    + " Linked list was " + (durationInMs) );
		
		
	}
    public static void insert(LinkedList<Integer> intList, Integer value)
    {
        

        if(intList.isEmpty()) 
        {
        intList.add(value);
        }
        else if(intList.size() > 0)
        {
          if(value <= Integer.parseInt(Objects.toString(intList.get(0))))
          {
          intList.addFirst(value);
          }
          else if ( value >= Integer.parseInt(Objects.toString(intList.getLast())))
          {
           
          intList.add(value);
          }
          else
          {
          Integer index = (intList.size() /2) ;
          
          if(value == Integer.parseInt(Objects.toString(intList.get(index))))
          {
                       
          intList.add(index, value);
          }
          else if(value >Integer.parseInt(Objects.toString(intList.get(index))))
          {
              
            for(int i = index; i < intList.size() ; i++ )
            {
               if(value <= Integer.parseInt(Objects.toString(intList.get(i))))
               {
               intList.add(i, value);
               break;
               }
            }
          }
          else if(value < Integer.parseInt(Objects.toString(intList.get(index))))
          {
          
            for(int i = index; i > 0 ; i-- )
            {
                       
               if(value >= Integer.parseInt(Objects.toString(intList.get(i))))
               {
               intList.add(i, value);
               break;
               }
            }
          }

          }
        }
    
    }


    public static  void time_Min(LinkedList<Integer> intList, long startTime, long endTime)
	{
		//Start timer
                int max = 0 ;
		startTime = System.nanoTime();
		
		//insert inegers
		int size = intList.size() -1;
	        max = Integer.parseInt(Objects.toString(intList.get(size)));
		//ern timer
		//endTimer = System.nanoTime();
		
		//display time
				//display time
		   endTime = System.nanoTime();
		//display time
          System.out.println("The time it took to get the min: " + max
                    + " for the Linked list was " + (endTime - startTime) );
		
		
	}
	public static void time_Max(LinkedList<Integer> intList, long startTime, long endTime)
	{
		//Start timer
                int min = 0;
		startTime = System.nanoTime();
		
		//insert inegers
		
		min = Integer.parseInt(Objects.toString(intList.get(0)));
		//ern timer
	
		
		//display time
				//display time
		   endTime = System.nanoTime();
		//display time
           System.out.println("The time it took to get the min: " + min
                    + " for the Linked list was " + (endTime - startTime) );
		
		
	}
	public static void time_Med(LinkedList<Integer> intList, long startTime, long endTime)
	{
		//Start timer
                int median = 0; 
                float medianResult = 0.0f;
		startTime = System.nanoTime();
		
		
                
                    int valueToTest;
		  for(int i = 0; i < intList.size() ; i++)
                 {
                     valueToTest = Integer.parseInt(Objects.toString(intList.get(i)));
                     median += valueToTest;
          
                 }
                  medianResult = median/ (intList.size() +1);
                
                
		//display time
		   endTime = System.nanoTime();
		//display time
            System.out.println("The time it took to get the median: " + medianResult 
                    + " for the Linked list was " + (endTime - startTime) );
		
	}

    


}