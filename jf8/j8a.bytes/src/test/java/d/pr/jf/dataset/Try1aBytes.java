/**
 * 
 * https://www.journaldev.com/770/string-byte-array-java
 * 
 * 
 */
package d.pr.jf.dataset;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Try1aBytes {
	
	@Test
	public void t0a() {
		System.out.println( Byte.SIZE );		
	}
	

	
	/**
	 * Convert a string to byte array
	 * Print a byte array using Arrays.toString 
	 */
	@Test
	public void t1a() {
		System.out.println("t1a");
		
		String s1a = "car";
		byte[] byteArr = s1a.getBytes(StandardCharsets.UTF_8);
		// print the byte[] elements
		System.out.println("String to byte array: " + Arrays.toString(byteArr));		
	}

	/**
	 * 
	 */
	@Test
	public void t1b() {
		System.out.println("t1b");
		
		byte[] byteArray2 = { 'P', 'A', 'N', 'K', 'A', 'J' };
		byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };
		
		String str1 = new String(byteArray1);
		String str2 = new String(byteArray2);
		
		System.out.println(str1);
		System.out.println(str2);
		
	}

	/**
	 * Saving ByteArray to file 
	 */
	@Test
	public void t1c() {
		System.out.println("t1c");
		
		String sDest = "target/bArr";
		byte[] bArr = "car".getBytes(StandardCharsets.UTF_8);
		try {
            Path path = Paths.get(sDest);
            Files.write(path, bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	

	


}