package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;

public class NumArrNull extends NumArr {
	
	private static NumArrNull instance;

	static {
		instance = new NumArrNull(0);
	}

	public static NumArrNull getInstance() {
		return instance;
	}	

	public NumArrNull(int length) {
		super(length);

	}
	
	@Override
	public int getSizeInBytes() {
		return 0;
	}

	@Override
	public int get(int index) {
		return 0;
	}

	@Override
	public void set(int index, int value) {
		// Do nothing
	}

	@Override
	public int getBitsPerItem() {
		return 0;
	}

	@Override
	public int toByteArray(byte[] arr, int offset) {
		return offset;
	}

	@Override
	public int loadFromByteArray(byte[] arr, int offset) {
		return offset;
	}

	@Override
	public NumArrType getType() {
		return NumArrType.NULL;
	}

	@Override
	public int getSizeInBit() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
