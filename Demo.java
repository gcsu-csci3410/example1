import java.util.Iterator;

public class Demo 
{
	public static void main(String [] args)
	{
		StringList myList = new StringList();
		myList.add("apple");
		myList.add("pear");
		myList.add("grapes");
		
		//enhanced for loop -- implicitly uses iterator
		for (String s: myList)
			System.out.print( s + " - ");
		System.out.println();
		
		//explicitly uses the iterator
		Iterator <String> it = myList.iterator();
		while (it.hasNext())
		{
			System.out.println("IT: "+ it.next());
		}
		
	}//main
}
/* 
apple - pear - grapes - 
IT: apple
IT: pear
IT: grapes
*/
