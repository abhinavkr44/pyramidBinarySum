package com.danske.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.danske.constants.PyramidConstants;
import com.danske.data.PyramidData;
/**
 * Util class to find the maximum sum along the path of a binary Pyramid
 * 
 * @author AB320571
 *
 */
public class PyramidUtils {

	/**
	 * Util method to find even/odd
	 * 
	 * @param num
	 * @return
	 */
	public static String getEvenOrOdd(int num) {
		return num % 2 == 0 ? PyramidConstants.EVEN : PyramidConstants.ODD;
	}

	/**
	 * Util method to find the downward adjecent Node for the last indexed node
	 * 
	 * @param path
	 * @param numbers
	 * @return
	 */
	public static Collection<PyramidData> getAdjecentNode(PyramidData path, String[] numbers) {
		List<PyramidData> newPaths = new ArrayList<PyramidData>();
		PyramidData clonedPath = path.clone();
		getRoute(path, Integer.parseInt(numbers[path.getIndex()]), path.getIndex())
				.ifPresent(newPath -> newPaths.add(newPath));
		getRoute(clonedPath, Integer.parseInt(numbers[clonedPath.getIndex() + 1]), clonedPath.getIndex() + 1)
				.ifPresent(newPath -> newPaths.add(newPath));
		return newPaths;
	}
	
	/**
	 * Util method to find the route for maximum path of pyramid
	 * 
	 * @param path
	 * @param number
	 * @param newIndex
	 * @return
	 */

	private static Optional<PyramidData> getRoute(PyramidData path, int number, int newIndex) {
		String isEven = getEvenOrOdd(number);
		if (isEven.equals(path.getEvenOrOdd())) {
			return Optional.empty();
		}
		return Optional.of(new PyramidData(path.getSum() + number, newIndex, number));
	}
}
