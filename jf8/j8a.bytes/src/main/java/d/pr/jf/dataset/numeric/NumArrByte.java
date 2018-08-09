package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;

public class NumArrByte extends NumArr {
	
	private byte[] data;
	
	public NumArrByte(int length) {
		super(length);
		data = new byte[length];		
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
	public int loadFromByteArray(byte[] arr, int offset) {
		for (int i = 0; i < length; i++) {
			data[i] = arr[offset];
			offset++;
		}
		return offset;
	}


	@Override
	public NumArrType getType() {
		return NumArrType.BYTE;
	}
	



}
