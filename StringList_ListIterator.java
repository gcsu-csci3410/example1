import java.util.ListIterator;
import java.util.NoSuchElementException;


public class StringList_ListIterator extends StringListIterator implements ListIterator<String> {

	
	public StringList_ListIterator(StringList sList) {
		super(sList);
		
	}

	@Override
	public boolean hasPrevious() {
		if (super.current < 0)
			return false;
		else
			return true;
					
		
	}

	@Override
	public String previous() {
		int previous = super.current;
	
		
		if (!hasPrevious())
			throw new NoSuchElementException();
		super.current = previous-1;
		super.val = previous;
		return strList.get(previous);
		
		
		
//		
//		returns the previous element in the list.  If there are no
//		previous elements (because the list is at the beginning
//				of the list), this method throws a NoSuchElementException
	}

	@Override
	public int nextIndex() {
	int index = super.strList.size();
	if (hasNext())
		index = super.current+1;
	return index;
		
//		returns the next index of the element that would be returned from a call to the next method. 
//		If the list iterator is already at the end of the list, the method returns the size of the list.
		
	}

	@Override
	public int previousIndex() {
		int previous = super.current-1;
		if (super.current <=0)
			previous = -1;
		return previous;
	}

	@Override
	public void set(String e) {
		
		if (!canSet)
		{
			throw new IllegalStateException();
		}
		else
		{
			super.strList.set(val,e);
		}
		// TODO Auto-generated method stub
		
		
		
//		This method can only be called after you have called either the next or
//		previous method. Calling this method will replace the element that was returned by next or previous with element.
//		This method throws an IllegalStateException under the following 
//		
	}
	

	@Override
	public void add(String e) {
		super.canSet = false;
		super.strList.add(val+1,e);
	}

	
}
