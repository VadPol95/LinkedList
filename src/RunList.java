

public class RunList {
    public static void main(String[] args) {
        CustomCollectionImpl customCollection = new CustomCollectionImpl();
        customCollection.add("Vadym");
        customCollection.add("Vasiliy");
        customCollection.add("Petr");
        customCollection.add("Arnold");
        System.out.println(customCollection.contains("Vadym"));
        customCollection.delete("Vasiliy");
        customCollection.delete(0);
        System.out.println(customCollection.contains("Vadym"));
        customCollection.clear();


    }
}
