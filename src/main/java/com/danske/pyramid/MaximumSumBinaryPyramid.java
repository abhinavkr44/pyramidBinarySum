package com.danske.pyramid;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.danske.data.PyramidData;
import com.danske.exception.PyramidException;
import com.danske.util.PyramidUtils;


/**
 * This class is to find the maximum sum for the below rules.
 * You will have a triangle (which is a binary tree) input below and you need to find the maximum sum of the numbers per the given rules below:
 * You will start from the top and move downwards to an adjacent number as in below.
 * You are only allowed to walk downwards and diagonally.
 * You should walk over the numbers as evens and odds subsequently. Suppose that you are on an even number the next number you walk must be odd, or if you are stepping over an odd number the next number must be even. In other words, the final path would be like
 * Odd -> even -> odd -> even …
 * You must reach to the bottom of the pyramid.
 * Your goal is to find the maximum sum if you walk the path. Assume that there is at least 1 valid path to the bottom. If there are multiple paths giving the same sum, you can choose any of them.
 *
 * @author Abhinav
 *
 */
public class MaximumSumBinaryPyramid {

    /**
     * find the maximum sum if you walk the path. There is at least 1 valid path to the bottom. 
     * If there are multiple paths giving the same sum, we can choose any of them.
     *
     * @return Sum of longest path over binary tree or -1 if there is no such path.
     * @throws PyramidException for invalidinput.
     */
	public int findMaximumSumBinaryPyramid(URI uri) {
		Path path = Paths.get(uri);

		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String line = reader.readLine();

			if (line == null)
				throw new PyramidException("Given file is empty : " + uri.getPath());

			int number = Integer.parseInt(line);
			PyramidData pyramidData = new PyramidData(number, 0, number);
			List<PyramidData> paths = new ArrayList<PyramidData>();
			paths.add(pyramidData);

			int depth = 2;
			int nodesInDepth = 2;
			while ((line = reader.readLine()) != null) {
				List<PyramidData> currentTreeDepth = new ArrayList<PyramidData>();
				String[] numberArr = line.split(" ");
				//validation to check number of nodes has to be equal to depth of the pyramid
				if (numberArr.length != nodesInDepth) {
					throw new PyramidException("Binary pyramid is invalid at line No " + depth + ", expected Nodes is "
							+ nodesInDepth + ", but contains nodes : " + numberArr.length);
				}

				currentTreeDepth
						.addAll(paths.stream().map(pyramidPath -> PyramidUtils.getAdjecentNode(pyramidPath, numberArr))
								.flatMap(pyramidPathList -> pyramidPathList.stream()).collect(Collectors.toList()));

				paths = currentTreeDepth;
				depth++;
				nodesInDepth++;
			}
			
			return paths.stream().sorted().findFirst().orElse(new PyramidData(-1,0,-1)).getSum();

		} catch (IOException | NumberFormatException ex) {
			throw new PyramidException("Failed while reading file: " + uri.getPath(), ex);
		}
	}
}
