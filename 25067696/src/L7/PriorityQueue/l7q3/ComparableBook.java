package L7.PriorityQueue.l7q3;

public class ComparableBook implements Comparable<ComparableBook> {
    private int id;
    private String title;
    
    public ComparableBook(int i, String t) {
        this.id = i;
        this.title = t;
    }

    public int compareTo(ComparableBook otherBook) {
        return this.id - otherBook.id;

        // return Integer.compare(this.id, otherBook.id);
    }

    public String toString() {
        return "ID: " + id + " | Title: " + title;
    }
}   
