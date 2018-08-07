package d.pr.jf.dataset.numeric;

import d.pr.jf.dataset.IntByteSerializable;

public abstract class NumArr implements IntByteSerializable {

		protected int length;

		public NumArr(int length) {	this.length = length; } 

		public int getLength() { 	return length; } 

		//public abstract NumericArrayType getType();

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
