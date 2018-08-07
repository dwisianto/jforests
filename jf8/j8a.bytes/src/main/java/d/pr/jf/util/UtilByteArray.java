

package d.pr.jf.util;



public class ByteArrayConverter {
	
	
	/**
	 * Given an integer value
	 * create a byte array of size 4
	 * using setInt method to fill in the created byte array
	 * return a byte array representation of the integer value
	 * @param value
	 * @return a byte array
	 */
	public static byte[] getByteArray(int value) {
		byte[] array = new byte[4];
		setInt(value, array, 0);
		return array;
	}
	
	
	
	
	public static int setBoolean(boolean value, byte[] array, int offset) {
		array[offset] = (byte) (value ? 1 : 0);
		return offset + 1;
	}
	
	public static int setShort(short value, byte[] array, int offset) {
		array[offset] = (byte) ((value >>> 8) & 0xFF);
		array[offset + 1] = (byte) (value & 0xFF);
		return offset + 2;
	}
	
	public static int setInt(int value, byte[] array, int offset) {
		for (int i = 0; i < 4; i++) {
			int off = (3 - i) * 8;
			array[offset] = (byte) ((value >>> off) & 0xFF);
			offset++;
		}
		return offset;
	}
	
	public static int setByteArrLong(long l, byte[] array, int offset) {
		int i, shift;
		for (i = 0, shift = 56; i < 8; i++, shift -= 8) {
			array[offset] = (byte) (0xFF & (l >> shift));
			offset++;
		}
		return offset;
	}
	
	


	public static int setFloat(float f, byte[] array, int offset) {
		int i = Float.floatToIntBits(f);
		return setInt(i, array, offset);
	}

	public static int setDouble(double d, byte[] array, int offset) {
		long l = Double.doubleToRawLongBits(d);
		return setByteArrLong(l, array, offset);
	}

	public static int setIntArray(int[] src, byte[] dest, int offset) {
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setInt(src[i], dest, offset);
		}
		return offset;
	}

	public static int setByteArrDoubleArray(double[] src, byte[] dest,int offset) {
			
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setDouble(src[i], dest, offset);
		}
		return offset;
	}

	
	public static int setByteArrString(String src, byte[] dest, int offset) {
		
		if (src == null) {
			offset = setShort((short) 0, dest, offset);
		} else {
			char[] chars = src.toCharArray();
			offset = setShort((short) chars.length, dest,offset);
					
			for (int i = 0; i < chars.length; i++) {
				dest[offset] = (byte) chars[i];
				offset++;
			}
		}
		
		return offset;
	}
	
	
	public static boolean getBoolean(byte[] data, int offset) {
		return (data[offset] == 1);
	}	
	
	public static short getShort(byte[] b, int offset) {
		return (short) (((b[offset] & 0x000000FF) << 8) + ((b[offset + 1] & 0x000000FF)));
	}
	
	public static int getInt(byte[] b, int offset) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (b[i + offset] & 0x000000FF) << shift;
		}
		return value;
	}

	public static long getLong(byte[] bytearray, int offset) {
		long result = 0;
		for (int i = offset; i < offset + 8 /* Bytes in long */; i++) {
			result = (result << 8 /* Bits in byte */)
					| (0xff & (byte) (bytearray[i] & 0xff));
		}
		return result;
	}

	public static float getFloat(byte[] data, int offset) {
		int i = getInt(data, offset);
		return Float.intBitsToFloat(i);
	}

	public static double getDouble(byte[] data, int offset) {
		long l = getLong(data, offset);
		return Double.longBitsToDouble(l);
	}

	public static int[] getIntArray(byte[] data, int offset) {
		int length = getInt(data, offset);
		offset += 4;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = getInt(data, offset);
			offset += 4;
		}
		return arr;
	}

	public static String getString(byte[] data, int offset) {
		
		int length = getShort(data, offset);
		offset += 2;
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = (char) data[offset];
			offset++;
		}
		
		return new String(chars);
	}
	
	

}
