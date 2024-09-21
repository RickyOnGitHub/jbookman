package org.jhipster.jbookman.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jhipster.jbookman.domain.enumeration.WritingStyle;

/**
 * A Author.
 */
@Entity
@Table(name = "jbm_author")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "writingstyle", nullable = false)
    private WritingStyle writingstyle;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "website")
    private String website;

    @Column(name = "socialmedia")
    private String socialmedia;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Author id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Author name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WritingStyle getWritingstyle() {
        return this.writingstyle;
    }

    public Author writingstyle(WritingStyle writingstyle) {
        this.setWritingstyle(writingstyle);
        return this;
    }

    public void setWritingstyle(WritingStyle writingstyle) {
        this.writingstyle = writingstyle;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public Author birthday(LocalDate birthday) {
        this.setBirthday(birthday);
        return this;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getWebsite() {
        return this.website;
    }

    public Author website(String website) {
        this.setWebsite(website);
        return this;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSocialmedia() {
        return this.socialmedia;
    }

    public Author socialmedia(String socialmedia) {
        this.setSocialmedia(socialmedia);
        return this;
    }

    public void setSocialmedia(String socialmedia) {
        this.socialmedia = socialmedia;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Author)) {
            return false;
        }
        return getId() != null && getId().equals(((Author) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Author{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", writingstyle='" + getWritingstyle() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", website='" + getWebsite() + "'" +
            ", socialmedia='" + getSocialmedia() + "'" +
            "}";
    }
}
