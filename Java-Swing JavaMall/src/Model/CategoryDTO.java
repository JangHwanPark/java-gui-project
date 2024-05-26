package Model;

public class CategoryDTO {
    private int category_no;
    private String category_name;

    public CategoryDTO(int category_no, String category_name) {
        this.category_no = category_no;
        this.category_name = category_name;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public int getCategoryNo() {
        return category_no;
    }

    public void setCategoryNo(int category_no) {
        this.category_no = category_no;
    }
}
