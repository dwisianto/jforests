package d.pr.jf.dataset.numeric;

import java.util.Arrays;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;
import d.pr.jf.util.UtilByteArray;


public class NumArrShort extends NumArr {
	
	private short[] data;

	public NumArrShort(int iLength) {
		super(iLength);
		data = new short[iLength];
	}
	
	@Override
	public NumArrType getType() {
		return NumArrType.SHORT;
	}	

	@Override
	public int getBitsPerItem() {
		return Short.SIZE;
	}
	
	@Override
	public int getSizeInBits() {
		return getBitsPerItem()*length;
	}
	
	@Override
	public int getSizeInBytes() {
		return UtilByteArray.LEN_BYTE_SHORT*length;
	}
	
	@Override
	public int get(int index) {
		return data[index];	
	}

	@Override
	public void set(int index, int value) {
		data[index] = (short)value;		
	}
	

	@Override
	public int toByteArray(byte[] arr, int offset) {
		
		for (int i = 0; i<length; i++) {
			UtilByteArray.setShort(data[i], arr, offset);
			offset += UtilByteArray.LEN_BYTE_SHORT;
		}
		
		return offset;

	}

	@Override
	public int fromByteArray(byte[] arr, int offset) {
		
		for (int i = 0; i<length; i++) {			
			data[i] = UtilByteArray.getShort(arr, offset); 
			offset += UtilByteArray.LEN_BYTE_SHORT;
		}
		
		return offset;
	}
	
	/**
	 * get subsample of the "data" using the listed indices 
	 */
	@Override
	public NumArr getSubSample(int[] indices) {
		
		NumArrShort subSampleArray = new NumArrShort(indices.length);
		for (int i = 0 ; i < indices.length; i++) {
			subSampleArray.data[i] = data[indices[i]];
		}
		
		return subSampleArray;
	}
	
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	

}


/**
 * public class ShortNumericArray extends NumericArray {
	
	private short[] data;
	
	public ShortNumericArray(int length) {
		super(length);
		data = new short[length];
	}

	@Override
	public int getSizeInBytes() {
		return 2 * length;
	}

	@Override
	public int get(int index) {
		return data[index];	
	}

	@Override
	public void set(int index, int value) {
		data[index] = (short)value;
	}

	@Override
	public int getBitsPerItem() {
		return Short.SIZE;
	}
	
	@Override
	public int toByteArray(byte[] arr, int offset) {
		for (int i = 0; i<length; i++) {
			Util.putShortInByteArray(data[i], arr, offset);
			offset += 2;
		}
		return offset;
	}

	@Override
	public int loadFromByteArray(byte[] arr, int offset) {
		for (int i = 0; i<length; i++) {
			data[i] = Util.toShort(arr, offset);
			offset += 2;
		}
		return offset;
	}

	@Override
	public NumericArrayType getType() {		
		return NumericArrayType.SHORT;
	}

	@Override
	public NumericArray getSubSampleNumericArray(int[] indices) {
		ShortNumericArray subsampleArray = new ShortNumericArray(indices.length);
		for (int i = 0 ; i < indices.length; i++) {
			subsampleArray.data[i] = data[indices[i]];
		}
		return subsampleArray;
	}
}
*/
