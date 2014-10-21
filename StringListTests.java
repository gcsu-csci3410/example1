import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StringListTests {
  
  StringList list = new StringList();
  
  @Before
  public void setUp()
  {
    list.add("zero");
    list.add("one");
    list.add("two");
    list.add("three");
  }
  
  @Test
  public void testNegativeIndex() {
    boolean result = false;
    try
    {
      list.remove(-1);
      fail("Negative index value not handled correctly");
    }
    catch (IndexOutOfBoundsException e) 
    {
      result = true;
    }
    assertTrue(result);
  }
  
  @Test
  public void testInvalidIndex(){
    boolean result = false;
    try
    {
      String  message = "Before remove" + list + list.size();
      list.remove(4);
      message += "\nafter remove" + list + list.size();
      
      fail("Invalid index value not handled correctly: " + message);
    }
    catch (IndexOutOfBoundsException e) 
    {
      result = true;
    }
    assertTrue(result);
  }
  
  @Test
  public void testAdd() {
    StringList list = new StringList();
    list.add("1");
    System.out.println("("+list+")");
    assertEquals(list.toString(),"[1]");
    
    //adding past capacity
    for(int i=2; i<=12; i++)
      list.add(""+i);
    assertEquals(list.toString(),"[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]");
  }
  
  @Test
  public void testRemove()
  {
    StringList list = new StringList();
    
    //adding past capacity
    for(int i=0; i<=3; i++)
      list.add(""+i);
    
    list.remove(0);
    assertEquals(list.toString(),"[1, 2, 3]");
    
    list.remove(2);
    assertEquals(list.toString(),"[1, 2]");
    
    list.remove(0);
    list.remove(0);
    assertEquals(list.toString(),"[]");
    
    try
    {
      String message = "before remove " + list;
      list.remove(0);
      message += "\nafter remove(0): " + list; 
      fail("Invalid index value not handled correctly\n" + message);
      
    }
    catch (IndexOutOfBoundsException e)
    {
      assertTrue(true);
    }
    
    
  }
  
  @Test
  public void testSet()
  {
    StringList list = new StringList();
    
    //adding past capacity
    for(int i=0; i<=3; i++)
      list.add(""+i);
    
    list.set(0, "a");
    assertEquals(list.toString(),"[a, 1, 2, 3]");
    list.set(3,"b");
    assertEquals(list.toString(),"[a, 1, 2, b]");
    
    
    try
    {
      String message = "before set(negative index): " + list;
      list.set(-1,"h");
      message += "\nafter set(negative index: " + list;
      fail("Invalid index value not handled correctly\n"+message);
      
    }
    catch (IndexOutOfBoundsException e)
    {
      assertTrue(true);
    }
    try
    {
      String message = "before set (too large index): " + list;
      list.set(8,"h");
      message += "\nafter set(too large index): " + list;
      fail("Invalid index value not handled correctly\n" + message);
      
    }
    catch (IndexOutOfBoundsException e)
    {
      assertTrue(true);
    }
  }
  
}
