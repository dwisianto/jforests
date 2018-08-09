package d.pr.jf.dataset.numeric;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumArrFactoryTry {

	
	@Test
	public void t0a() throws Exception {
		
		System.out.println( Byte.SIZE );		
		System.out.println( Short.SIZE );		
		System.out.println( Integer.SIZE );		
		
		
	}
	
	@Test
	public void t1a() throws Exception {
		
		NumArr naShort = NumArrFactory.createNumericArray(NumArrType.SHORT, 5);
		System.out.println( naShort.getBitsPerItem() );
		
		
		
	}


}
