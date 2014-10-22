import java.util.*;

/**
   This program demonstrates a ListIterator.
*/

public class ListIteratorDemo2
{
   public static void main(String[] args)
   {
      // Create an ArrayList to hold String objects.
      StringList nameList = new StringList();
     //ArrayList<String> nameList = new ArrayList<String>();
      
      // Add some names to the ArrayList.
      nameList.add("Chris");
      nameList.add("David");
      nameList.add("Katherine");
      nameList.add("Kenny");
      
      // Get a list iterator to traverse the list.
      ListIterator<String> it = nameList.listIterator();

      // Use the iterator to display the names.
      while (it.hasNext())
      {
         System.out.println(it.next());
      }
      
      System.out.println("\nNow in reverse order.\n");
      
      // Now display the names in reverse order.
      while (it.hasPrevious())
      {
         System.out.println(it.previous());
      }
   }
}