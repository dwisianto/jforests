


- dataset package handle _byte array_, _Feature_ and _Dataset_
- one byte is essentially a character and byte array is a string  
- One may convert from a byte to string and vice versa using Charset.UTF_8  
- Saving byte array into a [File](https://www.mkyong.com/java/how-to-convert-array-of-bytes-into-file/)
- dataset/ByteSerializable interface 
	- is being used by NumericArr and Dataset
	- contains **getSizeInBytes**,
		- loadFromByteArray( byte[] inArr,int offset) : init the NumArr from byte [] inArr  
		- toByteArray(byte [] outArr, int offset) : copy from the NumArr into byte [] outArr
- dataset/NumArr has a field of name length along with the associated get and set methods
	- The class also inherits from ByteSerializable, so it has the method loadFromByteArray, getSizeInBytes, and toByteArray
	- The class also additional method of get and set value with the argument of index
- dataset/NumArrByte extends NumArr, which is an abstract class, Thus, NumArrByte has to implement a bunch of methods	
	- The constructor is  public NumArrByte(int length)
	- It has a data field with the type of byte
	- It implements 
		- loadFromByteArray, getSizeInBytes, and toByteArray
		- get and set values 
		- sizeOfItems in byte
- dataset/Dataset contains
	- Feature array
	- target array
	- numInstances
	- numFeatures
	- uri : This uri helps preventing reloading of the same dataset
	- needsInitialization boolean
- dataset/Feature 
	- it implements ByteSerializable interface
	- it has a bin field of type NumericArray; which also implement ByteSerializable
- dataset/Dataset has methods
	- getFeatureValue
	- getOriginalFeatureValue	
- dataset/Feature implement ByteSerializable
	- getSizeInBytes
		- int size = bins.getSizeInBytes();
		- size += 4 + upperBounds.length * 4;
			- 4 bytes for keeping the size of the upperBounds array and 
			- then 4 bytes for each array element
		- size += 2 + (name != null ? name.length() : 0); 
		// 1 byte for name length and then the number of characters
		- size += 8 + 8 + 8 + 1; 		
			// min, max, factor, onLogScale
	- toByteArray(byte[] arr, int offset)
		- offset = bins.toByteArray(arr, offset);
		- offset = Util.putIntArrayInByteArray(upperBounds, arr, offset);
		- offset = Util.putStringInByteArray(name, arr, offset);
		- offset = Util.putDoubleInByteArray(min, arr, offset);
		- offset = Util.putDoubleInByteArray(max, arr, offset);
		- offset = Util.putDoubleInByteArray(factor, arr, offset);
		- offset = Util.putBooleanInByteArray(onLogScale, arr, offset);
		- return offset;
- util/Util
	- short 2 byte, integer 4 bytes, long 8 bytes
	- https://www.tutorialspoint.com/java/lang/float_floattointbits.html
	- https://stackoverflow.com/questions/4485128/how-do-i-convert-long-to-byte-and-back-in-java
	- https://stackoverflow.com/questions/2183240/java-integer-to-byte-array
	- https://javadeveloperzone.com/java-basic/java-convert-long-to-byte-array/
- putInByteBufferInt
	- putInByteBufferBoolean
	- putInByteBufferInt
	- putInByteBufferLong	
	- putInByteBufferShort
	- putInByteBufferDouble
	- putInByteBufferFloat
	- to
- util/UtilByte is introduce to replace util/Util. It specializes in byte manipulation	
		


- util/
- input
- config
- util


