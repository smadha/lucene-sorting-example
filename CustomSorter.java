package edu.usc.lucene.custom.sorter;

import java.io.IOException;

import org.apache.lucene.search.FieldComparator;
import org.apache.lucene.search.FieldComparatorSource;
import org.apache.lucene.util.BytesRef;

/**
 * Defines custom sort order for your lucene fields<br/>
 * For example if you have a set with {four, eight, one} and you want to order these character like {one, four, eight} you can go ahead edit below function.
 * @author madhav
 */
public class CustomComparatorSource extends FieldComparatorSource {

	@Override
	public FieldComparator<BytesRef> newComparator(final String fieldName, final int numHits, final int sortPos,
			boolean reversed) throws IOException {
			
		return new FieldComparator.TermValComparator(numHits, fieldName, reversed){
		
		    public int compareValues(BytesRef val1, BytesRef val2) {
		    /**
		     * TODO: MODIFY as per your comparison function. Below is a standard String sorting. <br/>
		     * You need to convert bytes to String. <br/>
		     * For Numbers it might make more sense to override FieldComparator.NumericComparator or use already implemented FieldComparator.* classes
		     */
		    	return new String(val1.bytes).compareTo(new String(val2.bytes));

		    }
		};
	}
}
