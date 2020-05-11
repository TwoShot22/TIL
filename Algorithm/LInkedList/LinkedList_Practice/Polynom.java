package LinkedList_Practice;

import java.util.ArrayList;

public class Polynom {
	MyLinkedList<Term> myP;
	String polyName;
	
	public Polynom(String name) {
		myP = new MyLinkedList<Term>();
		polyName = name;
	}
	
	public void addTerm(int c, int e) {
		Term t = new Term(c,e);
		int index = findDegree(t);
		if(index<0)
			myP.add(t);
		else {
			myP.set(index, myP.get(index).add(t));
			if(myP.get(index)==null)
				deleteIndex(index);
		}
		myP.sort();
	}
	
	private void deleteIndex(int index) {
		myP.remove(index);
	}
	
	private int findDegree(Term t) {
		int index = -1;
		for(int i=0; i<myP.size; i++)
			if(t.equals(myP.get(i))) index = myP.indexOf(myP.get(i));
		return index;
	}
	
	public void deleteTerm(Term t) {
		int index = findDegree(t);
		if(index>=0)
			deleteIndex(index);
	}
	
	public int calculate(int x) {
		int result = 0;
		for(int i=0; i<myP.size; i++)
			result = result + myP.get(i).value(x);
		return result;
	}
	
	public void printPoly() {
		System.out.print("--- Function "+polyName + " = ("+ myP.size()+") ");
		String temp = "";
		for(int i=0; i<myP.size; i++) {
			System.out.print(temp + myP.get(i).toString());
			temp = " + ";
		}
	}
	
	public void deleteTerm(int e) {
		Term t = new Term(1,e);
		deleteTerm(t);
	}
}
