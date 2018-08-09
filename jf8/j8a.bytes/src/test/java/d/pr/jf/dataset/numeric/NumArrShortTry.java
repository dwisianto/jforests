package d.pr.jf.dataset.numeric;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumArrShortTry {

	
	@Test
	public void t0a() {
		
		Assert.assertEquals(Byte.SIZE,  );		
		//System.out.println( Bit.SIZE );		
		System.out.println( 
		System.out.println( Short.SIZE );		
	}

	
	@Test
	public void t1a_size() {
		
		int iLen = 3;
		NumArrShort naShort = new NumArrShort(3);
		
		Assert.assertEquals( iLen, naShort.length );
		Assert.assertEquals( Short.SIZE, naShort.getBitsPerItem() );
		Assert.assertEquals( iLen * Short.SIZE, naShort.getSizeInBytes() );
		
	}
	
	@Test
	public void t2a_get_set() {
		
		int iLen = 10;
		NumArrShort naShort = new NumArrShort(iLen);
		
		int iIdx1=3;
		int iIdx2=5;
		int iIdx3=7;
		short iVal1=30;
		short iVal2=40;
		short iVal3=50;
		naShort.set(iIdx1, iVal1);
		naShort.set(iIdx2, iVal2);
		naShort.set(iIdx3, iVal3);
		
		Assert.assertEquals( iVal1, naShort.get(iIdx1) ); 
		Assert.assertEquals( iVal2, naShort.get(iIdx2) ); 
		Assert.assertEquals( iVal3, naShort.get(iIdx3) ); 			
		
	}
	
	@Test
	public void t2a_byte_array() {
		
	}	

}
