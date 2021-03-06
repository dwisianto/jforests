package d.pr.jf.dataset;

import org.apache.log4j.Logger;

import d.pr.jf.dataset.numeric.NumArr;
import d.pr.jf.dataset.numeric.NumArrFactory.NumArrType;
import d.pr.jf.util.UtilByteArray;


/**
 * - This class implements one feature in a machine learning problem
 * 
 * - the Feature() constructor
 *  * - Feature can be constructed directly from a numeric array; which is the bin
 *  
 * - getType
 *   The type of the feature is similar to the type of the bins;
 *   which could be one of the type of the NumArrType.Short
 *   
 * - ByteSerializableInterface Implementation
 *     getSizeInBytes
 *     getSizeInBits
 *     toByteArray
 *     fromByteArray
 * 
 * - getNumberOfValues
 * - getOriginalValues
 * 
 * 
 * 
 *
 */
public class Feature implements ByteSerializableInterface {
	
	final static Logger logger = Logger.getLogger( Feature.class );	
	
	private String name;
	private double min;
	private double max;
	private double factor;
	private boolean onLogScale;
	
	final public NumArr bins;
	public int[] upperBounds;
	
	
	public Feature(NumArr _bins) { 
		this.bins = _bins;
	}
	
	public NumArrType getType() {
		return bins.getType();
	}
	
	

	@Override
	public int getSizeInBits() { 		// TODO Auto-generated method stub
		int size = bins.getSizeInBits();
		return 0;
	}

	@Override
	public int getSizeInBytes() {
		
		int size = bins.getSizeInBytes();

		// 4 bytes for keeping the size of the upperBounds array 
		// and then 4 bytes for each array element
		size += Integer.BYTES + upperBounds.length * Integer.BYTES;
		

		// Short (2 byte) for name length and then the number of characters
		size += Short.BYTES + (name != null ? name.length() : 0);
		
		// min(8), max(8), factor(8), onLogScale(1)
		size += Double.BYTES + Double.BYTES + Double.BYTES + Byte.BYTES;

		return size;
	}

	@Override
	public int toByteArray(byte[] arr, int offset) {
		
		offset = bins.toByteArray(arr, offset);
		offset = UtilByteArray.setArrayInt(upperBounds, arr, offset);
		offset = UtilByteArray.setString(name, arr, offset);
		offset = UtilByteArray.setDouble(min, arr, offset);
		offset = UtilByteArray.setDouble(max, arr, offset);
		offset = UtilByteArray.setDouble(factor, arr, offset);
		offset = UtilByteArray.setBoolean(onLogScale, arr, offset);
		return offset;

	}

	@Override
	public int fromByteArray(byte[] arr, int offset) {
		
		offset = bins.fromByteArray(arr, offset);
		
		upperBounds = UtilByteArray.getArrayInt(arr, offset);
		offset += Integer.BYTES + upperBounds.length * Integer.BYTES;
		
		name = UtilByteArray.getString(arr, offset);
		offset += Short.BYTES + name.length();
		
		min = UtilByteArray.getDouble(arr, offset);
		offset += Double.BYTES;
		
		max = UtilByteArray.getDouble(arr, offset);
		offset += Double.BYTES;
		
		factor = UtilByteArray.getDouble(arr, offset);
		offset += Double.BYTES;
		
		onLogScale = UtilByteArray.getBoolean(arr, offset);
		offset += Byte.BYTES;
		
		return offset;
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			if (name.length() > Byte.MAX_VALUE) {
				this.name = name.substring(0, Byte.MAX_VALUE);
			} else {
				this.name = name;
			}
		}
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public boolean isOnLogScale() {
		return onLogScale;
	}

	public void setOnLogScale(boolean onLogScale) {
		this.onLogScale = onLogScale;
	}

	public Feature getSubSampleFeature(int[] indices) {
		Feature subSampleFeature = new Feature(bins.getSubSample(indices));
		subSampleFeature.upperBounds = upperBounds;
		subSampleFeature.name = name;
		subSampleFeature.min = min;
		subSampleFeature.max = max;
		subSampleFeature.factor = factor;
		subSampleFeature.onLogScale = onLogScale;
		return subSampleFeature;
	}
	
	
	
	public int getNumberOfValues() {
		return upperBounds.length;
	}
	
	public double getOriginalValue(int scaledValue) {
		double value = scaledValue / factor;
		if (onLogScale) {
			value = Math.exp(value);
			value = value + min - 1;
		} else {
			value += min;
		}
		return value;
	}
	
	
}


/**
 * public class Feature implements ByteSerializable {

	final public NumericArray bins;
	public int[] upperBounds;

	private String name;
	private double min;
	private double max;
	private double factor;
	private boolean onLogScale;

	public Feature(NumericArray _bins)
	{
		this.bins = _bins;
	}
	
	public NumericArrayType getType() {
		return bins.getType();
	}

	public int getNumberOfValues() {
		return upperBounds.length;
	}
	
	public double getOriginalValue(int scaledValue) {
		double value = scaledValue / factor;
		if (onLogScale) {
			value = Math.exp(value);
			value = value + min - 1;
		} else {
			value += min;
		}
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null) {
			if (name.length() > Byte.MAX_VALUE) {
				this.name = name.substring(0, Byte.MAX_VALUE);
			} else {
				this.name = name;
			}
		}
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public boolean isOnLogScale() {
		return onLogScale;
	}

	public void setOnLogScale(boolean onLogScale) {
		this.onLogScale = onLogScale;
	}

	public Feature getSubSampleFeature(int[] indices) {
		Feature subSampleFeature = new Feature(bins.getSubSampleNumericArray(indices));
		subSampleFeature.upperBounds = upperBounds;
		subSampleFeature.name = name;
		subSampleFeature.min = min;
		subSampleFeature.max = max;
		subSampleFeature.factor = factor;
		subSampleFeature.onLogScale = onLogScale;
		return subSampleFeature;
	}

	@Override
	public int getSizeInBytes() {
		int size = bins.getSizeInBytes();

		// 4 bytes for keeping the size of the upperBounds array and then 4
		// bytes for each array element
		size += 4 + upperBounds.length * 4;

		// 1 byte for name length and then the number of characters
		size += 2 + (name != null ? name.length() : 0);
		
		// min, max, factor, onLogScale
		size += 8 + 8 + 8 + 1;

		return size;
	}

	@Override
	public int toByteArray(byte[] arr, int offset) {
		offset = bins.toByteArray(arr, offset);
		offset = Util.putIntArrayInByteArray(upperBounds, arr, offset);
		offset = Util.putStringInByteArray(name, arr, offset);
		offset = Util.putDoubleInByteArray(min, arr, offset);
		offset = Util.putDoubleInByteArray(max, arr, offset);
		offset = Util.putDoubleInByteArray(factor, arr, offset);
		offset = Util.putBooleanInByteArray(onLogScale, arr, offset);
		return offset;
	}

	@Override
	public int loadFromByteArray(byte[] arr, int offset) {
		offset = bins.loadFromByteArray(arr, offset);
		
		upperBounds = Util.toIntArray(arr, offset);
		offset += 4 + upperBounds.length * 4;
		
		name = Util.toString(arr, offset);
		offset += 2 + name.length();
		
		min = Util.toDouble(arr, offset);
		offset += 8;
		
		max = Util.toDouble(arr, offset);
		offset += 8;
		
		factor = Util.toDouble(arr, offset);
		offset += 8;
		
		onLogScale = Util.toBoolean(arr, offset);
		offset += 1;
		
		return offset;
	}
}

**/