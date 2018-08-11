package d.pr.jf.dataset.numeric;

import java.util.Arrays;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;
import d.pr.jf.util.UtilByteArray;


public class NumArrInt extends NumArr {
	
	private int[] data;	

	public NumArrInt(int iLength) {
		super(iLength);
		data = new int[iLength];
	}
	
	public String toString() {
		return Arrays.toString(data);
	}
	
	
	@Override
	public NumArrType getType() {
		return NumArrType.INT;
	}	

	@Override
	public int getBitsPerItem() {
		return Integer.SIZE;
	}

	@Override
	public int getSizeInBits() {
		return length * Integer.SIZE;
	}
	
	@Override
	public int getSizeInBytes() {
		return length * Integer.BYTES;
	}
	
	@Override
	public int get(int index) {
		return data[index];
	}

	@Override
	public void set(int index, int value) {
		data[index] = value;
	}
	
	
	@Override
	public int toByteArray(byte[] arr, int offset) {
		
		for (int i = 0; i<length; i++) {
			UtilByteArray.setInt(data[i], arr, offset);
			offset += UtilByteArray.LEN_BYTE_INT;
		}
		
		return offset;
	}

	@Override
	public int fromByteArray(byte[] arr, int offset) {
		
		for (int i = 0; i<length; i++) {
			data[i] = UtilByteArray.getInt(arr, offset);
			offset += UtilByteArray.LEN_BYTE_INT;
		}
		
		return offset;
		
	}

	@Override
	public NumArr getSubSample(int[] indices) {
		
		NumArrInt subsampleArray = new NumArrInt(indices.length);
		for (int i = 0 ; i < indices.length; i++) {
			subsampleArray.data[i] = data[indices[i]];
		}
		return subsampleArray;
		
	}

}


/**
public class IntNumericArray extends NumericArray {
	
	private int[] data;
	
	public IntNumericArray(int length) {
		super(length);
		data = new int[length];
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
		data[index] = value;
	}

	@Override
	public int getBitsPerItem() {
		return Integer.SIZE;
	}
	
	@Override
	public int toByteArray(byte[] arr, int offset) {
		for (int i = 0; i<length; i++) {
			Util.putIntInByteArray(data[i], arr, offset);
			offset += 2;
		}
		return offset;
	}

	@Override
	public int loadFromByteArray(byte[] arr, int offset) {
		for (int i = 0; i<length; i++) {
			data[i] = Util.toInt(arr, offset);
			offset += 2;
		}
		return offset;
	}

	@Override
	public NumericArrayType getType() {		
		return NumericArrayType.INT;
	}

	@Override
	public NumericArray getSubSampleNumericArray(int[] indices) {
		IntNumericArray subsampleArray = new IntNumericArray(indices.length);
		for (int i = 0 ; i < indices.length; i++) {
			subsampleArray.data[i] = data[indices[i]];
		}
		return subsampleArray;
	}
}

*/