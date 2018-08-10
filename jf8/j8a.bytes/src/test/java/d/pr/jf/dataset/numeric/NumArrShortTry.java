package d.pr.jf.dataset.numeric;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;
import d.pr.jf.util.UtilByteArray;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NumArrShortTry {

	

	
	@Test
	public void t1a_size() {
		
		int iLen = 3;
		NumArrShort naShort = new NumArrShort(iLen);
		
		System.out.println( naShort.getSizeInBytes() ); 
		
		
		Assert.assertEquals( NumArrType.SHORT,naShort.getType() );
		Assert.assertEquals( iLen, naShort.length );
		Assert.assertEquals( Short.SIZE, naShort.getBitsPerItem() );
		Assert.assertEquals( iLen*UtilByteArray.LEN_BYTE_SHORT , naShort.getSizeInBytes() );
		Assert.assertEquals( iLen*Short.SIZE , naShort.getSizeInBits() );
		
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
	
	
	/**
	 * toByteArray   - 
	 * fromByteArray -
	 */
	@Test
	public void t3a_byte_array() {
		
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
				
		// [] convert to byte array
		int iOffset=10;
		byte [] naShortBa = new byte[iOffset+iLen* Short.SIZE];
		naShort.toByteArray( naShortBa, iOffset );
		
		// [] 
		NumArrShort naShort2 = new NumArrShort(iLen);
		naShort2.fromByteArray(naShortBa, iOffset);
		for(int iCtr=0; iCtr < iLen; iCtr++) {
			System.out.println( " iCtr "+ iCtr + " " + naShort2.get(iCtr) );
		}		
		
	}	
	
	/**
	 * subSample
	 * 
	 */	
	@Test
	public void t4a_sub_sample() {
		
		
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
		
		int [] idx = {1,3,5,7};
		NumArr naShortIdx = naShort.getSubSample(idx);
		System.out.println( naShortIdx.toString() );
		
	}

}
