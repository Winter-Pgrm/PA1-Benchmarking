/*
Name: Alexander Phillips
CptS 233: PA1 -- Benchmarking 
Date: 9/16/2020
gitRepo url: https://github.com/Winter-Pgrm/PA1-Benchmarking.git

*/
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Benchmarking
{

  
  public static void main(String[] args) 
  {
    
    Boolean newFileName = false;
    String fileName = null;
    
    //Checking to see if the user supplies a document to open.
    //by checking the length of args
    if(args.length > 0 )
    {
      fileName = args[0];
      newFileName = startProgram(fileName);
    }
    
    //This is to find a new file name if needed, either by user failure
    // to add to compling (args) or misspelled.
    if(newFileName || args.length == 0)
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter a file name in the following format(" 
                          + "input.txt ) followed by enter::");
      fileName = input.nextLine();
       startProgram(fileName);
    }
  }
  
  //This function will return a boolean incause I need a new filename
  private static Boolean startProgram(String fileName)
  {
    LinkedList<Integer> intList = new LinkedList<Integer>();
    long startTimer = 0;
    long endTimer = 0;
    long totalTime = 0; 
    
    try
    {
        
      File freader = new File(fileName);
      Scanner inputFile = new Scanner(freader);
     
      while( inputFile.hasNextLine() )
      { 
        int ye =  inputFile.nextInt();

        totalTime += time_Insert(intList, ye, startTimer, endTimer);

      }
      //I wanted the print function in insert, but it's probably best here
      System.out.println("\n\nThe time to place all integers into the"
                + " Linked list was " + TimeUnit.MICROSECONDS.convert
                    (totalTime, TimeUnit.NANOSECONDS) + " MicroSeconds");
      //Finds med, min and max fir linked list       
      time_Med(intList,startTimer, endTimer);
      time_Min(intList,startTimer, endTimer);
      time_Max(intList,startTimer, endTimer);
       
    }
    catch(IOException exp)
    {
      //If there is a problem with the file, get a new file name 
      return true;  

    }
    //End of file, no need for a new file name 
    return false;
    
  }

  // This function returns a long for printing the total time it takes to 
  // put all the ints into the linked lsit 
  public static long time_Insert(LinkedList<Integer> intList, Integer value, 
                                                  long startTime, long endTime )
  {
    startTime = System.nanoTime();
    //Start timer
		
		
    //insert integers
    insert(intList, value);
		
    //end timer
		
     endTime = System.nanoTime();
	
            
     return(endTime - startTime);
		
  }
  //I did not find a insertsort function for Linkedlist so I made a modified one

  public static void insert(LinkedList<Integer> intList, Integer value)
  {
    //add value at front if empty    
    if(intList.isEmpty()) 
    {
      intList.add(value);
    }
    //redundant 
    else if(intList.size() > 0)
    { 
      //if the value belongs at the front 
      if(value <= Integer.parseInt(Objects.toString(intList.get(0))))
      {
        intList.addFirst(value);
      }
      //if the value belongs at the back of the list
      else if ( value >= Integer.parseInt(Objects.toString(intList.getLast())))
      {
           
        intList.add(value);
      }
      //got to find where it goes
      else
      {
        //Split size in half to get to the center of the list, probably worse
        // but I like how it works 
        Integer index = (intList.size() /2) ;
        //if the value is the same at the middle place it there 
        if(value == Integer.parseInt(Objects.toString(intList.get(index))))
        {         
          intList.add(index, value);
        }
        //if the vaue is on the upper half of the list
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
        //if the vaue is on the lower half of the list
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


  public static  void time_Max(LinkedList<Integer> intList, long startTime,
                                                                   long endTime)
  {
    //Start timer
    int max = 0 ;
    startTime = System.nanoTime();
    //If the list is sorted the max value should be at the end of the list
    int size = intList.size() -1;
    max = Integer.parseInt(Objects.toString(intList.get(size)));

    //end timer
    endTime = System.nanoTime();
    //display time
    System.out.println("\nThe time it took to get the max:" + max
        + " for the Linked list was " + TimeUnit.MICROSECONDS.convert
         ((endTime - startTime), TimeUnit.NANOSECONDS) + " MicroSeconds");
	
  }
  
  public static void time_Min(LinkedList<Integer> intList, long startTime,
                                                                   long endTime)
  {
    //Start timer
    int min = 0;
    startTime = System.nanoTime();
		
    //insert inegers
		
    min = Integer.parseInt(Objects.toString(intList.get(0)));

    endTime = System.nanoTime();
    //display time
 
    System.out.println("\nThe time it took to get the min:" + min
      + " for the Linked list was " + TimeUnit.MICROSECONDS.convert
        ((endTime - startTime), TimeUnit.NANOSECONDS) + " MicroSeconds");	
		
  }
  
  public static void time_Med(LinkedList<Integer> intList, long startTime, 
                                                                   long endTime)
  {

    int median = 0; 
    float medianResult = 0.0f;
    //Start timer
    startTime = System.nanoTime();
		
		
                
    int valueToTest;
    for(int i = 0; i < intList.size() ; i++)
    {
      valueToTest = Integer.parseInt(Objects.toString(intList.get(i)));
      median += valueToTest;
          
    }
    medianResult = median/ (intList.size() +1);
    endTime = System.nanoTime();
    //display time
    
    System.out.println("\nThe time it took to get the median:" + medianResult
      + " for the Linked list was " + TimeUnit.MICROSECONDS.convert
       ((endTime - startTime), TimeUnit.NANOSECONDS) + " MicroSeconds");
  }
}