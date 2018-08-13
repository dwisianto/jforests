package d.pr.jf.dataset;

/**
 * @author Yasser Ganjisaffar <ganjisaffar at gmail dot com>
 */
public interface ByteSerializableInterface {
	
	public int getSizeInBits();

	public int getSizeInBytes();

	public int toByteArray(byte[] arr, int offset);

	public int fromByteArray(byte[] arr, int offset);

}