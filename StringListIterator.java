import java.util.Iterator;
import java.util.NoSuchElementException;


public class StringListIterator implements Iterator<String>{
	
	protected StringList strList;
	protected int current;
	protected boolean canRemove;
	protected boolean canSet;
	protected int val;
	
	public StringListIterator(StringList sList)
	{
		strList = sList;
		current = -1;
		canRemove = false;
		canSet = false;
		val = current;
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
		{
			throw new NoSuchElementException();
		}
		
		current++;
		canRemove = true;
		canSet = true;
		val = current;
		return (strList.get(current));
	}
	
	
	public void remove() {
	if (!canRemove)	
		throw new IllegalStateException();
	
	strList.remove(current);
	canRemove = false;
	canSet = false;
	current --;
		
	}

}
