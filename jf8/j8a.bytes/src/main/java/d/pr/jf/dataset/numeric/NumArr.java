package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.IntrByteSerializable;
import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;


public abstract class NumArr implements IntrByteSerializable {

	
		protected int length;

		public NumArr(int length) {	this.length = length; } 

		public int getLength() { 	return length; } 
		
		
		public abstract NumArrType getType();
		
		
		/**
		 * 
		 */		
		@Override
		public abstract int getSizeInBytes();
		
		@Override 
		public abstract int getSizeInBits();

		public abstract int getBitsPerItem();


		/**
		 * 
		 */		
		public abstract int get(int index);

		public abstract void set(int index, int value);
		
		

		@Override
		public abstract int toByteArray(byte[] arr, int offset);

		@Override
		public abstract int fromByteArray(byte[] arr, int offset);	
		
		/**
		 * 
		 */
		public abstract NumArr getSubSample(int[] indices);

}

/*
abstract class NumericArray implements ByteSerializable {

	protected int length;

	public NumericArray(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public abstract NumericArrayType getType();

	public abstract int getBitsPerItem();

	@Override
	public abstract int getSizeInBytes();

	@Override
	public abstract int toByteArray(byte[] arr, int offset);

	@Override
	public abstract int loadFromByteArray(byte[] arr, int offset);

	public abstract int get(int index);

	public abstract void set(int index, int value);
}
*/


/**
 * NumArr implements IntrByteSerializable; which has
 * - getSizeInBytes
 * - getSizeInBits
 * - toByteArray
 * - fromByteArray
 *  
 *
 * - getSizeInBit   - length*UtilByteArray.LEN_BYTE_SHORT
 * - getSizeInByte  - length*Short.Bit
 * - getBitsPerItem - Short
 * 
 * - toByteArray
 * - fromByteArray 
 * 
 * 
 */