package enums;

public enum HeaderMenuItems {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    private String item;

    HeaderMenuItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
