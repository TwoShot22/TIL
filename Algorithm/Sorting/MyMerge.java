package week6;

public class MyMerge extends SortBase{
	public MyMerge(int[] myData) {
		super(myData.length);
		data = myData;
		title = "Merge Sort";
	}
	
	public int[] sort() {
		result = mergeSort(data, 0, size-1);
		return result;
	}
	
	private int[] mergeSort(int[] data, int p, int r) {
		numberOfIteration++;
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
		return data;
	}

	private int[] merge(int[] data, int p, int q, int r) {
		numberOfSwap++;
		
		int[] sorted = new int[data.length];
		
		int i = p;
		int j = q+1;
		int k = p;
		
		while(i<=q && j<=r) {
			if(data[i]<data[j])
				sorted[k++]=data[i++];
			else
				sorted[k++]=data[j++];
		}
		
		while(i<=q)
			sorted[k++]=data[i++];
		while(j<=r)
			sorted[k++]=data[j++];
		
		for(int l=p; l<=r; l++)
			data[l]=sorted[l];
		
		return data;
	}
	
	public int arrayLength() {
		return data.length;
	}
}
