package d.pr.jf.dataset;

/**
 * @author Yasser Ganjisaffar <ganjisaffar at gmail dot com>
 */
public interface IntByteSerializable {

	public int getSizeInBytes();

	public int toByteArray(byte[] arr, int offset);

	public int loadFromByteArray(byte[] arr, int offset);

}