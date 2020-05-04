package week6;

public class MyBubble extends SortBase {
	public MyBubble(int[] myData) {
		super(myData.length);
		data = myData;
		title = "Bubble Sort";
	}
	
	public int[] sort() {
		for(int i=size-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				numberOfIteration++;
				if(data[j]>data[j+1]) swapData(data, j, j+1);
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
