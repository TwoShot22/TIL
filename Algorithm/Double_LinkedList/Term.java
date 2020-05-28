
public class Term implements Comparable<Term>{
	int coef;
	int exp;
	Object s;
	
	public Term(int c, int e) {
		coef = c;
		exp = e;
	}
	
	public String toString() {
		if(coef==0) return "";
		else
			return coef+"X^"+exp;
	}
	
	public boolean equals(Term t) {
		return (this.exp == t.exp);
	}

	public Term add(Term t) {
		this.coef += t.coef;
		if(coef==0) return null;
		else
			return this;
	}

	public int value(int x) {
		return (int) (coef * Math.pow(x, this.exp));
	}

	public int compareTo(Term o){
		if(this.exp < o.exp)
			return -1;
		else if(this.exp==o.exp)
			return 0;
		else
			return 1;
	}
}
