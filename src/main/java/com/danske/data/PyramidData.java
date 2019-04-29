package com.danske.data;

import com.danske.util.PyramidUtils;

/**
 * Router Data class for finding pyramid sum.
 *
 * @author Abhinav
 */
public class PyramidData implements Comparable<PyramidData> {
	private int sum;
	private int index;
	private String evenOrOdd;

	public PyramidData(int sum, int index, int num) {
		this.sum = sum;
		this.index = index;
		this.evenOrOdd = PyramidUtils.getEvenOrOdd(num);
	}
	
	public PyramidData(int sum, int index, String evenOrOdd) {
		this.sum = sum;
		this.index = index;
		this.evenOrOdd = evenOrOdd;
	}

	public int getSum() {
		return sum;
	}

	public int getIndex() {
		return index;
	}

	public String getEvenOrOdd() {
		return evenOrOdd;
	}
    
    public PyramidData clone() {
        return new PyramidData(sum, index, evenOrOdd);
    }
    
    @Override
    public int compareTo(PyramidData data) {
        long diff = (data.getSum() - this.getSum());
        return diff == 0 ? 0 : (diff < 0 ? -1 : 1);
    }

}
