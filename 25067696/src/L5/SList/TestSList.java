package L5.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();

        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");

        System.out.println("=== List ===");
        list.display();

        System.out.println("\n\n=== Remove ===");
        String removedValue = list.removeInitial();
        System.out.println("Removed: " + removedValue);

        System.out.println("\n=== Check \"difficult\" ===");
        System.out.println("Is \"difficult\" in the list?");
        System.out.println("Ans: " + list.contains("difficult"));

        System.out.println("\n=== Clear list ===");
        list.clear();
        list.display();
    }
}
