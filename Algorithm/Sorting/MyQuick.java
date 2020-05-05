package week6;

public class MyQuick extends SortBase {
	public MyQuick(int[] myData) {
		super(myData.length);
		data = myData;
		title = "Quick Sort";
	}
	
	public int[] sort() {
		result = quickSort(data, 0, size-1);
		return result;
	}
	
	private int[] quickSort(int[] data, int p, int r) {
		numberOfIteration++;
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
		return data;
	}
	
	private int partition(int[] data, int p, int r) {
		int pivot = r;
		
		int left = p;
		int right = r;
		
		while(left<right) {
			while(data[left]<data[pivot] && left<right) left++;
			while(data[right]>=data[pivot] && left<right) right--;
			if(left<right) swapData(data, left, right);
		}
		// 여기서부터는 left, right 모두 상관 없음
		swapData(data, pivot, right);
		
		return right;
	}

	private void swapData(int[] data2, int i, int j) {
		numberOfSwap++;
		int temp = data2[i];
		data2[i] = data[j];
		data2[j] = temp;
	}
}
