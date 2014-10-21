import java.util.Iterator;
import java.util.NoSuchElementException;


public class StringListIterator implements Iterator<String>{
 
 private StringList strList;
 private int current;
 private boolean canRemove;
 
 public StringListIterator(StringList sList)
 {
  strList = sList;
  current = -1;
  canRemove = false;
 }

 public boolean hasNext() {
  int next = current +1;
  boolean result = false;
  if (next < strList.size())
   result = true;
  return result;
 }

 
 public String next() {
  if (!hasNext())
   throw new NoSuchElementException();
  
  current++;
  canRemove = true;
  return (strList.get(current));
 }
 
 
 public void remove() {
 if (!canRemove) 
  throw new IllegalStateException();
 
 strList.remove(current);
 canRemove = false;
 current --;
  
 }

}
