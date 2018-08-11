package d.pr.jf.dataset.numeric;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;
import d.pr.jf.util.UtilByteArray;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumArrIntTry {

	
	
	/**
	 * Initialization using a constructor
	 */
	@Test
	public void t1a_create_constructor() {
		
		int iLen = 3;
		NumArrShort naShort = new NumArrShort(iLen);
		
		System.out.println( naShort.getSizeInBytes() ); 		
		
		Assert.assertEquals( NumArrType.SHORT,naShort.getType() );
		Assert.assertEquals( iLen, naShort.length );
		Assert.assertEquals( Short.SIZE, naShort.getBitsPerItem() );
		Assert.assertEquals( iLen*UtilByteArray.LEN_BYTE_SHORT , naShort.getSizeInBytes() );
		Assert.assertEquals( iLen*Short.SIZE , naShort.getSizeInBits() );
		
	}
	

	/**
	 * Initialization using a factory method
	 */	
	@Test
	public void t1a_create_factory() throws Exception {	
		
		int iLen = 3;
		NumArr naTmp = NumArrFactory.createNumericArray(NumArrFactory.NumArrType.INT, iLen);		
		NumArrInt na = (NumArrInt) naTmp; 
		System.out.println( na );
		
		Assert.assertEquals( NumArrType.INT, na.getType() );
		Assert.assertEquals( iLen, na.length );
		Assert.assertEquals( Integer.SIZE, na.getBitsPerItem() );
		Assert.assertEquals( iLen*Integer.BYTES , na.getSizeInBytes() );
		Assert.assertEquals( iLen*Integer.SIZE , na.getSizeInBits() );
				
		//System.out.println( na.getLength() );
		//System.out.println( na.getSizeInBits() ); 
		//System.out.println( na.getSizeInBytes() ); 
		//System.out.println( na.getSizeInBits() );
		
	}

	
	@Test
	public void t2a_get_set() {
		
		int iLen = 10;
		NumArrInt na = new NumArrInt(iLen);
		
		int iIdx1=3;
		int iIdx2=5;
		int iIdx3=7;
		short iVal1=30;
		short iVal2=40;
		short iVal3=50;
		na.set(iIdx1, iVal1);
		na.set(iIdx2, iVal2);
		na.set(iIdx3, iVal3);
		
		Assert.assertEquals( iVal1, na.get(iIdx1) ); 
		Assert.assertEquals( iVal2, na.get(iIdx2) ); 
		Assert.assertEquals( iVal3, na.get(iIdx3) ); 			
		
	}
	
	
	/**
	 * toByteArray   - 
	 * fromByteArray -
	 */
	@Test
	public void t3a_byte_array() {
		
		int iLen = 10;
		NumArrInt na = new NumArrInt(iLen);
		
		int iIdx1=3;
		int iIdx2=5;
		int iIdx3=7;
		int iVal1=30;
		int iVal2=40;
		int iVal3=50;
		na.set(iIdx1, iVal1);
		na.set(iIdx2, iVal2);
		na.set(iIdx3, iVal3);
				
		// [] convert to byte array
		int iOffset=10;
		byte [] naBa1 = new byte[iOffset+iLen* Short.SIZE];
		na.toByteArray( naBa1, iOffset );
		
		// [] 
		NumArrInt naBa2 = new NumArrInt(iLen);
		naBa2.fromByteArray(naBa1, iOffset);
		System.out.println(naBa2);
		
	}	
	
	
	/**
	 * subSample
	 * 
	 */	
	@Test
	public void t4a_sub_sample() {
		
		
		int iLen = 10;
		NumArrInt naShort = new NumArrInt(iLen);
		
		int iIdx1=3;
		int iIdx2=5;
		int iIdx3=7;
		int iVal1=30;
		int iVal2=40;
		int iVal3=50;
		naShort.set(iIdx1, iVal1);
		naShort.set(iIdx2, iVal2);
		naShort.set(iIdx3, iVal3);
		
		int [] idx = {1,3,5,7};
		NumArr naShortIdx = naShort.getSubSample(idx);
		System.out.println( naShortIdx.toString() );
		
	}
	
	
	
	
}
