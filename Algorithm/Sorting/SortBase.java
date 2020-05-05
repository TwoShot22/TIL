package week6;

public class SortBase {
	int numberOfIteration; // number of recursive calls
	int numberOfSwap;
	int[] data;
	int[] result;
	int size;
	String title;
	
	public SortBase(int n){
		numberOfIteration = 0;
		numberOfSwap = 0;
		size = n;
		data = new int[size];
		result = new int[size];
		title = "Base";
	}
	
	public int[] createData() {
		for(int i=0; i<size; i++)
			data[i] = (int) (Math.random()*size*10);
		return data;
	}
	
	public int[] sort() {
		result = data;
		return result;
	}
	
	public void showInfo() {
		System.out.println("\n >>> "+title+" <<<");
		System.out.println("-- result : ");
		for(int e:result)
			System.out.print(e+" ");
		System.out.println("\n-- Iteration(RecursiveCalls) = "+numberOfIteration + "\n-- Swap(Merge) = "+numberOfSwap);
	}
}
