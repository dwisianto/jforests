

package d.pr.jf.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;



/**
 * 
 * - move
 * - 'arrayInt' and 'arrayDouble' to be after arrayByte
 *
 */
public class UtilByteArray {
		
	
	public static int LEN_BYTE_BIT    = 1;
	public static int LEN_BYTE_BOOL   = 1;
	public static int LEN_BYTE_BYTE   = 1;
	public static int LEN_BYTE_CHAR   = 2;
	public static int LEN_BYTE_SHORT  = Short.BYTES; // 2
	public static int LEN_BYTE_INT    = Integer.BYTES; // 4
	public static int LEN_BYTE_LONG   = Long.BYTES; // 8
	public static int LEN_BYTE_FLOAT  = Float.BYTES; // 4
	public static int LEN_BYTE_DOUBLE = Double.BYTES; // 8
	
	public static ByteOrder BYTE_ORDER_ENDIAN = ByteOrder.nativeOrder(); // ByteOrder.BIG_ENDIAN ByteOrder.LITTLE_ENDIAN;
	
	
	//System.out.printf(" aValShort: %d \n", value);
	//ShortBuffer shortBuffer = ByteBuffer.allocate(LEN_BYTE_SHORT).order(ByteOrder.LITTLE_ENDIAN).putShort(value).asShortBuffer();
	//while(shortBuffer.hasRemaining()){  System.out.println( " shortBuf " + shortBuffer.get()); }						
	public static int setShort(short value, byte[] byteArrDest, int iDestOffset) {
		
		byte []  byteArrSrc  = ByteBuffer.allocate(LEN_BYTE_SHORT).order(BYTE_ORDER_ENDIAN).putShort(value).array();
		//System.out.println( Arrays.toString(byteArrSrc));	
		int iSrcPos=0;
		System.arraycopy( byteArrSrc, iSrcPos, byteArrDest, iDestOffset, LEN_BYTE_SHORT);	
		
		return iDestOffset + LEN_BYTE_SHORT;
	}

	public static short getShort(byte[] byteArr, int offset) {
		return ByteBuffer.wrap(byteArr,offset,LEN_BYTE_SHORT).order(BYTE_ORDER_ENDIAN).getShort();
	}
	
	public static int setInt(int value, byte[] byteArrDest, int iDestOffset) {
		
		
		byte []  byteArrSrc  = ByteBuffer.allocate(LEN_BYTE_INT).order(BYTE_ORDER_ENDIAN).putInt(value).array();	
		int iSrcPos=0;
		System.arraycopy( byteArrSrc, iSrcPos, byteArrDest, iDestOffset, LEN_BYTE_INT);		
		
		return iDestOffset + LEN_BYTE_INT;
	}
	
	public static int getInt(byte[] byteArr, int offset) {
		return ByteBuffer.wrap(byteArr,offset,LEN_BYTE_INT).order(BYTE_ORDER_ENDIAN).getInt();
	}
	
	
	
	

	public static int setLong(long value, byte[] byteArrDest, int iDestOffset) {
		//System.out.printf(" aVal1: %d \n", value);		
		
		byte []  byteArrSrc  = ByteBuffer.allocate(LEN_BYTE_LONG).order(BYTE_ORDER_ENDIAN).putLong(value).array();
		//System.out.println( Arrays.toString(byteArrSrc));
		
		int iSrcPos=0;
		System.arraycopy( byteArrSrc, iSrcPos, byteArrDest, iDestOffset, LEN_BYTE_LONG);	
		
		return iDestOffset + LEN_BYTE_LONG;
	}
	
	public static long getLong(byte[] byteArr, int offset) {
		return ByteBuffer.wrap(byteArr,offset,LEN_BYTE_LONG).order(BYTE_ORDER_ENDIAN).getLong();
	}

	
	public static int setFloat(float f, byte[] array, int offset) {
		int i = Float.floatToIntBits(f);
		return setInt(i, array, offset);
	}
	
	public static float getFloat(byte[] data, int offset) {
		int i = getInt(data, offset);
		return Float.intBitsToFloat(i);
	}

	
	public static int setDouble(double d, byte[] array, int offset) {
		long l = Double.doubleToRawLongBits(d);
		return setLong(l, array, offset);
	}
	
	public static double getDouble(byte[] data, int offset) {
		long l = getLong(data, offset);
		return Double.longBitsToDouble(l);
	}
	
	

	


	
	
	
	public static int setString(String src, byte[] dest, int offset) {
		
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
	
	public static String getString(byte[] data, int offset) {
		
		int length = getShort(data, offset);
		offset += LEN_BYTE_SHORT;
		char[] chars = new char[length];
		for (int i = 0; i < length; i++) {
			chars[i] = (char) data[offset];
			offset++;
		}
		
		return new String(chars);
	}
	

	
	public static int setBoolean(boolean value, byte[] array, int offset) {
		array[offset] = (byte) (value ? 1 : 0);
		return offset + 1;
	}
	
	public static boolean getBoolean(byte[] data, int offset) {
		return (data[offset] == 1);
	}	
	
	
	/**
	 * Given an integer value
	 * create a byte array of size 4
	 * using setInt method to fill in the created byte array
	 * return a byte array representation of the integer value
	 * @param value
	 * @return a byte array
	 */
	public static byte[] getArrayByte(int value) {
		byte[] array = new byte[LEN_BYTE_INT];
		setInt(value, array, 0);
		return array;
	}
	
	
	/**
	 * To save an integer array to a byte array,
	 * one need to reserve a space for the length of the array 
	 * in addition to the space for the array itself
	 * 
	 * @param src - 
	 * @param dest - target byte array 
	 * @param offset - offset 
	 * @return
	 */
	public static int setArrayInt(int[] src, byte[] dest, int offset) {
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setInt(src[i], dest, offset);
		}
		return offset;
	}
	
	public static int[] getArrayInt(byte[] data, int offset) {
		int length = getInt(data, offset);
		offset += LEN_BYTE_INT;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = getInt(data, offset);
			offset += LEN_BYTE_INT;
		}
		return arr;
	}
	
	
	
	public static int setArrayDouble(double[] src, byte[] dest,int offset) {
		
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setDouble(src[i], dest, offset);
		}
		return offset;
	}
	
	public static double[] getArrayDouble(byte[] data, int offset) {
		int length = getInt(data, offset);
		offset += LEN_BYTE_DOUBLE;
		double[] arr = new double[length];
		for (int i = 0; i < length; i++) {
			arr[i] = getDouble(data, offset);
			offset += LEN_BYTE_DOUBLE;
		}
		return arr;
	}
	

}

/**
 * jforests: util/util 
 */
class UtilByteArray101a {
	
		
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
	
	public static int setLong(long l, byte[] array, int offset) {
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
		return setLong(l, array, offset);
	}

	public static int setArrayInt(int[] src, byte[] dest, int offset) {
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setInt(src[i], dest, offset);
		}
		return offset;
	}

	public static int setArrayDouble(double[] src, byte[] dest,int offset) {
			
		offset = setInt(src.length, dest, offset);

		for (int i = 0; i < src.length; i++) {
			offset = setDouble(src[i], dest, offset);
		}
		return offset;
	}
	
	
	public static int setString(String src, byte[] dest, int offset) {
		
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
	
	public static int setBoolean(boolean value, byte[] array, int offset) {
		array[offset] = (byte) (value ? 1 : 0);
		return offset + 1;
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

	public static boolean getBoolean(byte[] data, int offset) {
		return (data[offset] == 1);
	}	
	

	
	
	

}



/**
 * 
 * @author dwyk
 *
 */
class UtilByteBuffer101a {
	
	
	//public static int LEN_BIT=1;
	public static int LEN_BOOL=1;
	public static int LEN_CHAR=2;
	public static int LEN_SHORT=2;
	public static int LEN_INT=4;
	public static int LEN_LONG=8;
	public static int LEN_FLOAT=4;
	public static int LEN_DOUBLE=8;
	
	
	public static byte[] set(Object object) throws Exception {

		Class clz = object.getClass();
		//if (clz.equals(Byte.class)) { return setShort( ((Byte)object).byteValue() ); 		
		if (clz.equals(Short.class)) { return setShort( ((Short)object).shortValue() ); 
		} else if (clz.equals(Integer.class)) { return setInt( ( (Integer)object ).intValue() );		
		} else if (clz.equals(Long.class)) { return setLong( ((Long)object).longValue() );			
		} else if (clz.equals(Float.class)) { return setFloat( ((Float)object ).floatValue() );			
		} else if (clz.equals(Double.class)) { return setDouble( ((Double)object).doubleValue() );
		} else if (clz.equals(Boolean.class)) { return setBoolean( ((Boolean)object).booleanValue() );
		} else if (clz.equals(Character.class)) { return setChar( ((Character)object).charValue() ); 
		} else if (clz.equals(String.class)) { return setString( (String)object );		
		} else { throw new Exception( "Cannot convert object of type " + object.getClass().getName() );			
		}
		
	}	
	
	public static byte[] setShort(short value) {
		byte[] bytes = new byte[LEN_SHORT];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putShort(value);
		return buffer.array();
	}	
	
	public static byte[] setInt(int value) {
		byte[] bytes = new byte[LEN_INT];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putInt(value);
		return buffer.array();
	}

	public static byte[] setLong(long value) {

		byte[] bytes = new byte[LEN_LONG];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putLong(value);
		return buffer.array();
	}

	public static byte[] setFloat(float value) {
		byte[] bytes = new byte[LEN_FLOAT];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putFloat(value);
		return buffer.array();
	}

	public static byte[] setDouble(double value) {
		byte[] bytes = new byte[LEN_DOUBLE];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putDouble(value);
		return buffer.array();
	}
	
	
	public static byte[] setChar(char value) {
		byte[] bytes = new byte[LEN_CHAR];
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.putChar(value);
		return buffer.array();
	}	

	public static byte[] setString(String value) {
		return value.getBytes();
	}
	
	public static byte[] setBoolean(boolean value) {
		byte[] array = new byte[LEN_BOOL];
		array[0] = (byte)(value == true ? 1 : 0);
		return array;
	}
	

	
	
	public static Object get(Class aClass, byte[] inputArray) throws Exception {
        
        String className = aClass.getName();	
        if (className.equals(Byte.class.getName())) { return new Byte( getByte(inputArray) );
        } else if (className.equals(Boolean.class.getName())) { return new Boolean( getBoolean(inputArray));
        } else if (className.equals(String.class.getName())) { return getString(inputArray);                             
        } else if (className.equals(Short.class.getName())) { return new Short(getShort(inputArray));
        } else if (className.equals(Integer.class.getName())) { return new Integer(getInt(inputArray));        	        
        } else if (className.equals(Long.class.getName())) { return new Long(getLong(inputArray));
        } else if (className.equals(Float.class.getName())) { return new Float(getLong(inputArray));
        } else if (className.equals(Double.class.getName())) { return new Double(getLong(inputArray));        
        } else { throw new Exception("Cannot convert object of type " + className);            
        }
     
    }	

	public static byte getByte(byte[] array) {
		return array[0];
	}
	
	public static boolean getBoolean(byte[] array) {
		return (array[0] > 0 ? true : false );
	}
	
	public static char getChar(byte[] array) {
		return ByteBuffer.wrap(array).getChar();
	}	

	public static String getString(byte[] array) {
		return new String(array);
	}
	
	public static short getShort(byte[] array) {
		return ByteBuffer.wrap(array).getShort();
	}
	
	public static int getInt(byte[] array) {
		return ByteBuffer.wrap(array).getInt();
	}
	
	public static long getLong(byte[] array) {
		return ByteBuffer.wrap(array).getLong();
	}	
			
	public static float getFloat(byte[] array) {		
		return ByteBuffer.wrap(array).getFloat();
	}	

	public static double getDouble(byte[] array) {
		return ByteBuffer.wrap(array).getDouble();
	}


}




class UtilByteBuffer20 {


    public static byte[] convertToByteArray(char value) {
        byte[] bytes = new byte[2];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putChar(value);
        return buffer.array();
    }
    public static byte[] convertToByteArray(int value) {
        byte[] bytes = new byte[4];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putInt(value);
        return buffer.array();
    }

    public static byte[] convertToByteArray(long value) {

        byte[] bytes = new byte[8];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putLong(value);
        return buffer.array();
    }

    public static byte[] convertToByteArray(short value) {

        byte[] bytes = new byte[2];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putShort(value);
        return buffer.array();
    }

    public static byte[] convertToByteArray(float value) {
        byte[] bytes = new byte[4];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putFloat(value);
        return buffer.array();
    }

    public static byte[] convertToByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.putDouble(value);
        return buffer.array();
    }

    public static byte[] convertToByteArray(String value) {

        return value.getBytes();

    }

    public static byte[] convertToByteArray(boolean value) {
        byte[] array = new byte[1];
        array[0] = (byte)(value == true ? 1 : 0);
        return array;
    }

    public static byte convertToByte(byte[] array) {

        return array[0];

    }

    public static int convertToInt(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getInt();
    }

    public static long convertToLong(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getLong();
    }

    public static short convertToShort(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getShort();
    }

    public static String convertToString(byte[] array) {
        String value = new String(array);
        return value;
    }

    public static Object convertToValue(Class aClass, byte[] inputArray) throws Exception {

        Object returnValue = null;
        String className = aClass.getName();
        if (className.equals(Integer.class.getName())) {
            returnValue = new Integer(convertToInt(inputArray));
        } else if (className.equals(String.class.getName()))    {
            returnValue = convertToString(inputArray);
        } else if (className.equals(Byte.class.getName())) {
            returnValue = new Byte(convertToByte(inputArray));
        } else if (className.equals(Long.class.getName())) {
            returnValue = new Long(convertToLong(inputArray));
        } else if (className.equals(Short.class.getName())) {
            returnValue = new Short(convertToShort(inputArray));
        } else if (className.equals(Boolean.class.getName())) {
            returnValue = new Boolean(convertToBoolean(inputArray));
        }else {
            throw new Exception("Cannot convert object of type " + className);
        }
        return returnValue;
    }

    public static byte[] convertToByteArray(Object object) throws Exception {

        byte[] returnArray = null;
        Class clazz = object.getClass();
        String clazzName = clazz.getName();

        if (clazz.equals(Integer.class)) {
            Integer aValue = (Integer)object;
            int intValue = aValue.intValue();
            returnArray = convertToByteArray(intValue);
        } else if (clazz.equals(String.class)) {
            String aValue = (String)object;
            returnArray = convertToByteArray(aValue);
        } else if (clazz.equals(Byte.class)) {
            Byte aValue = (Byte)object;
            byte byteValue = aValue.byteValue();
            returnArray = convertToByteArray(byteValue);
        } else if (clazz.equals(Long.class)) {
            Long aValue = (Long)object;
            long longValue = aValue.longValue();
            returnArray = convertToByteArray(longValue);
        } else if (clazz.equals(Short.class)) {
            Short aValue = (Short)object;
            short shortValue = aValue.shortValue();
            returnArray = convertToByteArray(shortValue);
        } else if (clazz.equals(Boolean.class)) {
            Boolean aValue = (Boolean)object;
            boolean booleanValue = aValue.booleanValue();
            returnArray = convertToByteArray(booleanValue);
        } else if (clazz.equals(Character.class)) {
            Character aValue = (Character)object;
            char charValue = aValue.charValue();
            returnArray = convertToByteArray(charValue);
        } else if (clazz.equals(Float.class)) {
            Float aValue = (Float)object;
            float floatValue = aValue.floatValue();
            returnArray = convertToByteArray(floatValue);
        } else if (clazz.equals(Double.class)) {
            Double aValue = (Double)object;
            double doubleValue = aValue.doubleValue();
            returnArray = convertToByteArray(doubleValue);
        } else {

            throw new Exception("Cannot convert object of type " + clazzName);
        }

        return returnArray;
    }

    public static boolean convertToBoolean(byte[] array) {
        return (array[0] > 0 ? true : false );
    }

    public static char convertToCharacter(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getChar();
    }

    public static double convertToDouble(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getDouble();
    }

    public static float convertToFloat(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer.getFloat();
    }
}
