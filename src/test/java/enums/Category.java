package enums;

public enum Category {
    PHONES("Phones"),
    LAPTOPS("Laptops"),
    MONITORS("Monitors");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
