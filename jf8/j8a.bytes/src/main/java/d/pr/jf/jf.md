


- dataset package handle _byte array_, _Feature_ and _Dataset_
- one byte is essentially a character and byte array is a string  
- One may convert from a byte to string and vice versa using Charset.UTF_8  
- Saving byte array into [File](https://www.mkyong.com/java/how-to-convert-array-of-bytes-into-file/)
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
		

- util/
- input
- config
- util


