import java.util.*;

/**
   This program demonstrates adding with a ListIterator.
*/

public class ListIteratorDemo3
{
   public static void main(String[] args)
   {
      // Create an ArrayList to hold String objects.
     // List<String> nameList = new ArrayList<String>();
      StringList nameList = new StringList();
      
      // Add some names to the ArrayList.
      nameList.add("Chris");
      nameList.add("David");
      nameList.add("Katherine");
      nameList.add("Kenny");
      
      // Display the names in the list
      System.out.println("Here are the original names.");
      for (String element : nameList)
      {
         System.out.println(element);
      }

      // Get a list iterator.
      ListIterator<String> it = nameList.listIterator();
      
      // Create a flag variable to indicate when
      // we've inserted a name into the list.
      boolean done = false;
      
      // Add "Darlene" to the list, right after "Chris".
      while (!done && it.hasNext())
      {
         // Get the next element.
         String str = it.next();
         
         // If the last element retrieved was "Chris"
         // then insert "Darlene".
         if (str.compareToIgnoreCase("Chris") == 0)
         {
            // Insert the name after the element
            // we just retrieved.
            it.add("Darlene");
            
            // Indicate that we're done.
            done = true;            
         }
      }

      // Display the names in the list again.
      System.out.println("\nHere are the names now.");
      for (String element : nameList)
      {
         System.out.println(element);
      }
   }
}

/*Here are the original names.
Chris
David
Katherine
Kenny

Here are the names now.
Chris
Darlene
David
Katherine
Kenny
*/