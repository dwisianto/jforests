package d.pr.jf.dataset.numeric;

public class NumArrFactory {  

	public enum NumArrType {
		NULL, BIT, BYTE, SHORT, INT;

		public static NumArrType getFromOrdinal(int ordinal) {
			for (NumArrType type : values()) {
				if (type.ordinal() == ordinal) {
					return type;
				}
			}
			return null;
		}
	}

	public static NumArr createNumericArray(NumArrType type, int length) throws Exception {
		switch (type) {
		case NULL:
			return NumArrNull.getInstance();
		case BIT:
			return new NumArrBit(length);
		case BYTE:
			return new NumArrByte(length);
		case SHORT:
			return new NumArrShort(length);
		case INT:
			return new NumArrInt(length);
		default:
			throw new Exception(type + " is not implemented yet.");
		}
	}
}
