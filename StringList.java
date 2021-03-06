public class StringList
{
  private final int DEFAULT_CAPACITY = 10;
  private final int RESIZE_FACTOR = 2;
  private String[] list;
  private int elements;
  
  public StringList()
  {
    list = new String[DEFAULT_CAPACITY];
    elements = 0;  
  }
  
  private void resize()
  {
    String [] newList =  new String[ list.length *RESIZE_FACTOR];
    
    for (int i=0; i<elements; i++)
    {
      newList[i] = list[i];
    }
    
    list = newList;
  }
  
  public int size()
  {
    return elements;
  }
  public void add(String s)
  {
    if (elements == list.length)
      resize();
    list[elements] = s;
    elements++;
  }
  public String get (int index)
  {
    if (index < 0 || index > elements)
      throw new IndexOutOfBoundsException();
    
    String s = list[index];
    return s;
  }
  public String remove (int index)
  {
    if (index< 0 || index >= elements)
      throw new IndexOutOfBoundsException();
    
    String s = list[index];
    
    for (int i=index+1; i< elements; i++)
      list[i-1] = list[i];
    
    elements--;
    
    return s;
  }
  public String set(int index, String str)
  {
    if (index<0 || index > elements)
    {
      throw new IndexOutOfBoundsException();
    }
    String s = list[index];
    list[index] = str;
    return s;
    
  }
  public String toString()
  {
    String s = "[";
    
    for (int i=0; i< elements; i++)
    {
      s = s + list[i];
      if (i!=( elements -1))
        s += ", ";
    }
    s = s+"]";
    return s;  
  }
  
}