package org.jhipster.jbookman.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Book.
 */
@Entity
@Table(name = "jbm_book")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Min(value = 1)
    @Column(name = "edition", nullable = false)
    private Integer edition;

    @NotNull
    @Pattern(regexp = "^(97[89])?\\d{9}(\\d|X)$")
    @Column(name = "isbn_13", nullable = false, unique = true)
    private String isbn13;

    @NotNull
    @Min(value = 0)
    @Column(name = "publishingyear", nullable = false)
    private Integer publishingyear;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "listprice", precision = 21, scale = 2, nullable = false)
    private BigDecimal listprice;

    @ManyToOne(optional = false)
    @NotNull
    private Currency currency;

    @ManyToOne(optional = false)
    @NotNull
    private Author author;

    @ManyToOne(optional = false)
    @NotNull
    private Genre genre;

    @ManyToOne(optional = false)
    @NotNull
    private Publisher publisher;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Book id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Book title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEdition() {
        return this.edition;
    }

    public Book edition(Integer edition) {
        this.setEdition(edition);
        return this;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getIsbn13() {
        return this.isbn13;
    }

    public Book isbn13(String isbn13) {
        this.setIsbn13(isbn13);
        return this;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Integer getPublishingyear() {
        return this.publishingyear;
    }

    public Book publishingyear(Integer publishingyear) {
        this.setPublishingyear(publishingyear);
        return this;
    }

    public void setPublishingyear(Integer publishingyear) {
        this.publishingyear = publishingyear;
    }

    public BigDecimal getListprice() {
        return this.listprice;
    }

    public Book listprice(BigDecimal listprice) {
        this.setListprice(listprice);
        return this;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Book currency(Currency currency) {
        this.setCurrency(currency);
        return this;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book author(Author author) {
        this.setAuthor(author);
        return this;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book genre(Genre genre) {
        this.setGenre(genre);
        return this;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book publisher(Publisher publisher) {
        this.setPublisher(publisher);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        return getId() != null && getId().equals(((Book) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Book{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", edition=" + getEdition() +
            ", isbn13='" + getIsbn13() + "'" +
            ", publishingyear=" + getPublishingyear() +
            ", listprice=" + getListprice() +
            "}";
    }
}
