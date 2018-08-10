package d.pr.jf.dataset;

/**
 * @author Yasser Ganjisaffar <ganjisaffar at gmail dot com>
 */
public interface IntrByteSerializable {
	
	public int getSizeInBits();

	public int getSizeInBytes();

	public int toByteArray(byte[] arr, int offset);

	public int fromByteArray(byte[] arr, int offset);

}