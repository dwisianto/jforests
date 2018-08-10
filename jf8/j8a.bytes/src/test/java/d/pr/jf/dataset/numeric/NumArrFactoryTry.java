package d.pr.jf.dataset.numeric;

import org.junit.Assert;
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
	public void t1a_types() throws Exception {
		
		//NumArrType.SHORT
		//NumArrType.NULL
		
			
	}
	
	
	@Test
	public void t1a_create() throws Exception {
		
		int iLen=5;
		
		NumArr naNull = NumArrFactory.createNumericArray(NumArrType.NULL, iLen);
		Assert.assertEquals( naNull.getType(), NumArrType.NULL );
		System.out.println( naNull.getBitsPerItem() );		
		
		NumArr naShort = NumArrFactory.createNumericArray(NumArrType.SHORT, iLen);
		Assert.assertEquals( naShort.getType(), NumArrType.SHORT );
		System.out.println( naShort.getBitsPerItem() );
		
		
		
		
	}


}
