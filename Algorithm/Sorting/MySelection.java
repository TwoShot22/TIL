package week6;

public class MySelection extends SortBase {
	public MySelection(int[] myData) {
		super(myData.length);
		data = myData;
		title = "Selection Sort";
	}
	
	public int[] sort() {
		for (int i=0; i<size; i++) {
			for(int j=i+1; j<size; j++) {
				numberOfIteration++;
				if(data[i]>data[j]) swapData(data, i, j);
			}
		}
		result = data;
		return result;
	}
	
	private void swapData(int[] data, int i, int j) {
		numberOfSwap++;
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
