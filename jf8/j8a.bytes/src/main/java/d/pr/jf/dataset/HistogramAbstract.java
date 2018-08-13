package d.pr.jf.dataset;

import java.util.Arrays;


public class HistogramAbstract {

}


/**
public abstract class Histogram {

protected Feature feature;

public int numValues;
public boolean splittable;

public int totalCount;
public double totalWeightedCount;

public int[] perValueCount;
public double[] perValueWeightedCount;

public Histogram(Feature feature) {
	this.feature = feature;
	numValues = feature.getNumberOfValues();
	splittable = true;
	
	totalCount = 0;
	totalWeightedCount = 0;
	perValueCount = new int[numValues];
	perValueWeightedCount = new double[numValues];
}

protected abstract void initCustomData(CandidateSplitsForLeaf leafSplitCandidates, int[] instances);
protected abstract void subtractCustomData(Histogram child);

public void init(CandidateSplitsForLeaf leafSplitCandidates, int[] instances) {
	
	totalCount = leafSplitCandidates.getNumInstancesInLeaf();
	totalWeightedCount = leafSplitCandidates.getTotalWeightedCount();
	Arrays.fill(perValueCount, 0);
	Arrays.fill(perValueWeightedCount, 0);
	
	initCustomData(leafSplitCandidates, instances);
	
}

public void subtractFromMe(Histogram child) throws Exception {
	if (child.numValues != numValues) {
		throw new Exception("inconsistent lengths for Histograms");
	}

	totalCount -= child.totalCount;
	totalWeightedCount -= child.totalWeightedCount;
	
	for (int i = 0; i < numValues; i++) {
		perValueCount[i] -= child.perValueCount[i];
		perValueWeightedCount[i] -= child.perValueWeightedCount[i];
	}
	
	subtractCustomData(child);
}	
}
**/