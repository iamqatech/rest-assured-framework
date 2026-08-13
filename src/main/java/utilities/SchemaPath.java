package utilities;

public enum SchemaPath {

    PRODUCT_SCHEMA("schemas/product-schema.json"),
    PRODUCTS_SCHEMA("schemas/products-schema.json"),
    USER_SCHEMA("schemas/user-schema.json"),
    USERS_SCHEMA("schemas/users-schema.json");

    private final String path;

    SchemaPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
