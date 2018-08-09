package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;

public class NumArrShort extends NumArr {

	public NumArrShort(int length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getBitsPerItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeInBytes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int toByteArray(byte[] arr, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int loadFromByteArray(byte[] arr, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(int index, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NumArrType getType() {
		return NumArrType.SHORT;
	}

}
