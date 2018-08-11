package d.pr.jf.util;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilByteArray1Try {
	

	/**
	 * System.out.println( Boolean.BYTES );
	 * System.out.println( String.B);
	 * System.out.println( Bit.SIZE );		
	 */
	@Test
	public void t0a() {
		
		Assert.assertEquals( Byte.BYTES, UtilByteArray.LEN_BYTE_CHAR );		
		Assert.assertEquals( Short.BYTES, UtilByteArray.LEN_BYTE_SHORT );		
		Assert.assertEquals( Integer.BYTES, UtilByteArray.LEN_BYTE_INT );		
		Assert.assertEquals( Long.BYTES, UtilByteArray.LEN_BYTE_LONG );		
		Assert.assertEquals( Float.BYTES, UtilByteArray.LEN_BYTE_FLOAT );		
		Assert.assertEquals( Double.BYTES, UtilByteArray.LEN_BYTE_DOUBLE );
		
	}
	
	@Test
	public void t0b_bits() {
		
		Assert.assertEquals( Byte.SIZE,    Byte.SIZE * UtilByteArray.LEN_BYTE_CHAR );		
		Assert.assertEquals( Short.SIZE,   Byte.SIZE * UtilByteArray.LEN_BYTE_SHORT );		
		Assert.assertEquals( Integer.SIZE, Byte.SIZE * UtilByteArray.LEN_BYTE_INT );		
		Assert.assertEquals( Long.SIZE,    Byte.SIZE * UtilByteArray.LEN_BYTE_LONG );		
		Assert.assertEquals( Float.SIZE,   Byte.SIZE * UtilByteArray.LEN_BYTE_FLOAT );		
		Assert.assertEquals( Double.SIZE,  Byte.SIZE * UtilByteArray.LEN_BYTE_DOUBLE );		
		
	}
	
	
	@Test
	public void t2a_short() {				
		
		int intByteLen = UtilByteArray.LEN_BYTE_SHORT;
		
		int intOffset1 = 3;
		int intOffset2 = intOffset1 + intByteLen;
		int intOffset3 = intOffset2 + intByteLen;
		int intOffset4 = intOffset3 + intByteLen;
		
		short aVal1 = (short) 21;
		short aVal2 = (short) 42; 
		short aVal3 = (short) Short.MIN_VALUE;
		short aVal4 = (short) Short.MAX_VALUE;
		//System.out.printf(" %d:%d %d:%d %d:%d %d:%d \n",intOffset1, aVal1,intOffset2, aVal2, intOffset3, aVal3, intOffset4, aVal4); 				 
				
		int iLen = 4;
		byte [] byteArr = new byte[ intOffset1 + iLen*intByteLen ];
		Assert.assertEquals( intOffset1 + iLen*intByteLen, byteArr.length );
		
		Assert.assertEquals( intOffset2,UtilByteArray.setShort( aVal1, byteArr, intOffset1) ); 
		Assert.assertEquals( aVal1, UtilByteArray.getShort( byteArr, intOffset1) ); 

		Assert.assertEquals( intOffset3,UtilByteArray.setShort( aVal2, byteArr, intOffset2) ); 
		Assert.assertEquals( aVal2, UtilByteArray.getShort( byteArr, intOffset2) );
		
		Assert.assertEquals( intOffset4,UtilByteArray.setShort( aVal3, byteArr, intOffset3) ); 
		Assert.assertEquals( aVal3, UtilByteArray.getShort( byteArr, intOffset3) );

		Assert.assertEquals( byteArr.length,UtilByteArray.setShort( aVal4, byteArr, intOffset4) ); 
		Assert.assertEquals( aVal4, UtilByteArray.getShort( byteArr, intOffset4) ); 
		
	}		
	
	@Test
	public void t2b_int() {				
		
		int intByteLen = UtilByteArray.LEN_BYTE_INT;
		
		int intOffset1 = 3;
		int intOffset2 = intOffset1 + intByteLen;
		int intOffset3 = intOffset2 + intByteLen;
		int intOffset4 = intOffset3 + intByteLen;
		
		int aVal1 = 21;
		int aVal2 = 42; 
		int aVal3 = Integer.MIN_VALUE;
		int aVal4 = Integer.MAX_VALUE;
		//System.out.printf(" %d:%d %d:%d %d:%d %d:%d \n",intOffset1, aVal1,intOffset2, aVal2, intOffset3, aVal3, intOffset4, aVal4); 				 
				
		int intValLen = 4;
		byte [] byteArr = new byte[ intOffset1 + intValLen*intByteLen ];
		Assert.assertEquals( intOffset1+intValLen*intByteLen, byteArr.length );

		Assert.assertEquals( intOffset2,UtilByteArray.setInt( aVal1, byteArr, intOffset1) ); 
		Assert.assertEquals( aVal1, UtilByteArray.getInt( byteArr, intOffset1) ); 

		Assert.assertEquals( intOffset3,UtilByteArray.setInt( aVal2, byteArr, intOffset2) ); 
		Assert.assertEquals( aVal2, UtilByteArray.getInt( byteArr, intOffset2) );
		
		Assert.assertEquals( intOffset4,UtilByteArray.setInt( aVal3, byteArr, intOffset3) ); 
		Assert.assertEquals( aVal3, UtilByteArray.getInt( byteArr, intOffset3) ); 

		Assert.assertEquals( byteArr.length,UtilByteArray.setInt( aVal4, byteArr, intOffset4) ); 
		Assert.assertEquals( aVal4, UtilByteArray.getInt( byteArr, intOffset4) );
		
	}		
	
	
	@Test
	public void t2c_long() {						
		
		int intByteLen = UtilByteArray.LEN_BYTE_LONG;
		
		int intOffset1 = 3;
		int intOffset2 = intOffset1 + intByteLen;
		int intOffset3 = intOffset2 + intByteLen;
		int intOffset4 = intOffset3 + intByteLen;
		
		long aVal1 = (long)21;
		long aVal2 = (long)42; 
		long aVal3 = (long) Long.MIN_VALUE;
		long aVal4 = (long) Long.MAX_VALUE;
		//System.out.printf(" %d:%d %d:%d %d:%d %d:%d \n",intOffset1, aVal1,intOffset2, aVal2, intOffset3, aVal3, intOffset4, aVal4); 				 
				
		int intValLen = 4;
		byte [] byteArr = new byte[ intOffset1 + intValLen*intByteLen ];
		Assert.assertEquals( intOffset1+intValLen*intByteLen, byteArr.length );

		Assert.assertEquals( intOffset2,UtilByteArray.setLong( aVal1, byteArr, intOffset1) ); 
		Assert.assertEquals( aVal1, UtilByteArray.getLong( byteArr, intOffset1) ); 

		Assert.assertEquals( intOffset3,UtilByteArray.setLong( aVal2, byteArr, intOffset2) ); 
		Assert.assertEquals( aVal2, UtilByteArray.getLong( byteArr, intOffset2) );
		
		Assert.assertEquals( intOffset4,UtilByteArray.setLong( aVal3, byteArr, intOffset3) ); 
		Assert.assertEquals( aVal3, UtilByteArray.getLong( byteArr, intOffset3) ); 

		Assert.assertEquals( byteArr.length,UtilByteArray.setLong( aVal4, byteArr, intOffset4) ); 
		Assert.assertEquals( aVal4, UtilByteArray.getLong( byteArr, intOffset4) );
		System.out.println( UtilByteArray.getLong( byteArr, intOffset4) );		
		
	}		
	

	@Test
	public void t3a_float() {				
		
		int intByteLen = UtilByteArray.LEN_BYTE_FLOAT;
		
		int intOffset1 = 3;
		int intOffset2 = intOffset1 + intByteLen;
		int intOffset3 = intOffset2 + intByteLen;
		int intOffset4 = intOffset3 + intByteLen;
		
		float aVal1 = (float) 0.1;
		float aVal2 = (float) 0.9;
		float aVal3 = (float) Float.MAX_VALUE;
		float aVal4 = (float) Float.MIN_VALUE;
		//System.out.printf(" %d:%d %d:%d %d:%d %d:%d \n",intOffset1, aVal1,intOffset2, aVal2, intOffset3, aVal3, intOffset4, aVal4); 				 
				
		int intValLen = 4;
		byte [] byteArr = new byte[ intOffset1 + intValLen*intByteLen ];
		Assert.assertEquals( intOffset1+intValLen*intByteLen, byteArr.length );

		Assert.assertEquals( intOffset2,UtilByteArray.setFloat( aVal1, byteArr, intOffset1) ); 
		Assert.assertEquals( aVal1, UtilByteArray.getFloat( byteArr, intOffset1), 0.1 ); 

		Assert.assertEquals( intOffset3,UtilByteArray.setFloat( aVal2, byteArr, intOffset2) ); 
		Assert.assertEquals( aVal2, UtilByteArray.getFloat( byteArr, intOffset2), 0.1 );
		
		Assert.assertEquals( intOffset4,UtilByteArray.setFloat( aVal3, byteArr, intOffset3) ); 
		Assert.assertEquals( aVal3, UtilByteArray.getFloat( byteArr, intOffset3), 0.1 ); 

		Assert.assertEquals( byteArr.length,UtilByteArray.setFloat( aVal4, byteArr, intOffset4) ); 
		Assert.assertEquals( aVal4, UtilByteArray.getFloat( byteArr, intOffset4), 0.1 );
		System.out.println( UtilByteArray.getFloat( byteArr, intOffset4) );		
				
	}

	
	@Test
	public void t3b_double() {								
		int intByteLen = UtilByteArray.LEN_BYTE_DOUBLE;
		
		
		int intOffset1 = 3;
		int intOffset2 = intOffset1 + intByteLen;
		int intOffset3 = intOffset2 + intByteLen;
		int intOffset4 = intOffset3 + intByteLen;
		
		double aVal1 = (double) 0.1;
		double aVal2 = (double) 0.9;
		double aVal3 = (double) Float.MAX_VALUE;
		double aVal4 = (double) Float.MIN_VALUE;
		//System.out.printf(" %d:%d %d:%d %d:%d %d:%d \n",intOffset1, aVal1,intOffset2, aVal2, intOffset3, aVal3, intOffset4, aVal4); 				 
				
		int intValLen = 4;
		byte [] byteArr = new byte[ intOffset1 + intValLen*intByteLen ];
		Assert.assertEquals( intOffset1+intValLen*intByteLen, byteArr.length );

		Assert.assertEquals( intOffset2,UtilByteArray.setDouble( aVal1, byteArr, intOffset1) ); 
		Assert.assertEquals( aVal1, UtilByteArray.getDouble( byteArr, intOffset1), 0.1 );
		System.out.println( UtilByteArray.getDouble( byteArr, intOffset1) );		

		Assert.assertEquals( intOffset3,UtilByteArray.setDouble( aVal2, byteArr, intOffset2) ); 
		Assert.assertEquals( aVal2, UtilByteArray.getDouble( byteArr, intOffset2), 0.1 );
		System.out.println( UtilByteArray.getDouble( byteArr, intOffset2) );		
		
		Assert.assertEquals( intOffset4,UtilByteArray.setDouble( aVal3, byteArr, intOffset3) ); 
		Assert.assertEquals( aVal3, UtilByteArray.getDouble( byteArr, intOffset3), 0.1 ); 

		Assert.assertEquals( byteArr.length,UtilByteArray.setDouble( aVal4, byteArr, intOffset4) ); 
		Assert.assertEquals( aVal4, UtilByteArray.getDouble( byteArr, intOffset4), 0.1 );
		System.out.println( UtilByteArray.getDouble( byteArr, intOffset4) );		
		
	}

	@Test
	public void t3c_array_int() {								
		int intByteLen = UtilByteArray.LEN_BYTE_LONG;
	}
	
	@Test
	public void t3d_string() {								
		int intByteLen = UtilByteArray.LEN_BYTE_LONG;
	}
	
		
	/**
	 * byteArray 
	 *   setBoolean
	 *   getBoolean
	 */
	@Ignore
	@Test
	public void t4a_boolean() {
		System.out.println("here");
		
	}
	
	@Test
	public void t4b() {
		System.out.println( Byte.SIZE );		
	}
	
	

}
