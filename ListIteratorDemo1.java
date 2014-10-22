import java.util.*;

/**
   This program demonstrates a ListIterator.
*/

public class ListIteratorDemo1
{
   public static void main(String[] args)
   {
      // Create an ArrayList to hold String objects.
      StringList nameList = new StringList();
      
      // Add some names to the ArrayList.
      nameList.add("Chris");
      nameList.add("David");
      nameList.add("Katherine");
      nameList.add("Kenny");
      
      // Get a list iterator to traverse the list.
      ListIterator<String> it = nameList.listIterator();

      // Use the iterator to display the items in nameList.
      while (it.hasNext())
      {
         System.out.println(it.next());
      }
   }
}