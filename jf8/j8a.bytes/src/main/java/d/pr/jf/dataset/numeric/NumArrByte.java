package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;

public class NumArrByte extends NumArr {
	
	private byte[] data;
	
	public NumArrByte(int length) {
		super(length);
		data = new byte[length];		
	}
	
	
	
	@Override
	public NumArrType getType() {
		return NumArrType.BYTE;
	}


	@Override
	public int getSizeInBits() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public int getSizeInBytes() {
		return data.length;
	}

	@Override
	public int get(int index) {
		return data[index];
	}

	@Override
	public void set(int index, int value) {
		data[index] = (byte) value;
	}

	@Override
	public int getBitsPerItem() {
		return Byte.SIZE;
	}
	


	@Override
	public int toByteArray(byte[] arr, int offset) {
		for (int i = 0; i < length; i++) {
			arr[offset] = data[i];
			offset++;
		}
		return offset;
	}

	@Override
	public int fromByteArray(byte[] arr, int offset) {
		for (int i = 0; i < length; i++) {
			data[i] = arr[offset];
			offset++;
		}
		return offset;
	}


	@Override
	public NumArr getSubSample(int[] indices) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
