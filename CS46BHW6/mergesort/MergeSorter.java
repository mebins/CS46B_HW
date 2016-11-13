package mergesort;

public class MergeSorter {

	private int[] data;

	public MergeSorter(int[] data) {
		this.data = data;
	}

	public int[] mergeSort() {
		if(data.length <= 1) return data;
		
		int[] merge = new int[this.data.length];
		// split
		int[] leftData = new int[data.length / 2];
		int[] rightData = new int[data.length - data.length / 2];
		System.arraycopy(data, 0, leftData, 0, leftData.length);
		System.arraycopy(data, leftData.length, rightData, 0, rightData.length);
		
		MergeSorter leftSplit = new MergeSorter(leftData);
		MergeSorter rightSplit = new MergeSorter(rightData);
		
		leftData = leftSplit.mergeSort();
		rightData = rightSplit.mergeSort();
		
	
		
		// merge
		int leftIndex = 0;
		int index = 0;
		int rightIndex = 0;
		
		while (leftIndex < leftData.length || rightIndex < rightData.length) {
			if (leftIndex < leftData.length && rightIndex < rightData.length) {

				if (leftData[leftIndex] < rightData[rightIndex]) {

					merge[index] = leftData[leftIndex];
					index++;
					leftIndex++;

				} else if (leftData[leftIndex] >= rightData[rightIndex]) {

					merge[index] = rightData[rightIndex];
					index++;
					rightIndex++;
				}
			}
			else
			{
				if(leftIndex >= leftData.length)
				{
					merge[index] = rightData[rightIndex];
					index++;
					rightIndex++;
				}
				else
				{
					merge[index] = leftData[leftIndex];
					index++;
					leftIndex++;
				}
			}
		}
		return merge;
	}

	
}
