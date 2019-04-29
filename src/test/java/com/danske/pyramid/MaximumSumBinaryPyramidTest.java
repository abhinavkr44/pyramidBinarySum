package com.danske.pyramid;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import com.danske.exception.PyramidException;

public class MaximumSumBinaryPyramidTest {

	private MaximumSumBinaryPyramid maximumSumBinaryPyramid;

	@Before
	public void setup() {
		maximumSumBinaryPyramid = new MaximumSumBinaryPyramid();
	}

	@Test
	public void findMaximumSumBinaryPyramidSimpleInput() {
		URI path = getResource("simplePyramid.txt");
		long result = maximumSumBinaryPyramid.findMaximumSumBinaryPyramid(path);
		assertThat(result,equalTo(16L));
	}

	@Test
	public void findMaximumSumBinaryPyramidComplexInput() {
		URI path = getResource("complexPyramid.txt");
		long result = maximumSumBinaryPyramid.findMaximumSumBinaryPyramid(path);
		assertThat(result, equalTo(8186L));
	}

	@Test(expected = PyramidException.class)
	public void findMaximumSumBinaryPyramidInvalidInput() {
		URI path = getResource("incorrectPyramid.txt");
		maximumSumBinaryPyramid.findMaximumSumBinaryPyramid(path);
	}

	private URI getResource(String filePath) {
		try {
			URI uri = this.getClass().getClassLoader().getResource(filePath).toURI();
			return uri;
		} catch (URISyntaxException e) {
			fail("Error while reading file: " + filePath);
			return null;
		}
	}

}
