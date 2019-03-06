public class Term implements Comparable{
    public String word;
    public int count;

    public Term(String w){
        this.word=w;
        this.count=1;
    }
    public Term(String w, int c){
        this.word=w;
        this.count=c;
    }

    public int getCount(){
        return this.count;
    }

    public boolean equals(Object o){
        Term t = (Term)o;
        return t.word.equals(this.word);
    }

    @Override
    public int compareTo(Object o) {
        Term t = (Term)o;
        return Integer.compare(this.count,t.count);
    }
}
