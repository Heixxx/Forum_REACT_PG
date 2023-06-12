package controllers.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategory")
    private long idCategory;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idCategory")
    private List<Post> posty;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(long idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return idCategory == category.idCategory && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, name);
    }

    @Override
    public String toString() {
        return "Category [idCategory=" + idCategory + ", name=" + name + "]";
    }
}
