package org.jhipster.jbookman.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Currency.
 */
@Entity
@Table(name = "jbm_currency")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "\\b[A-Z]{3}\\b")
    @Column(name = "alphabeticcode", length = 3, nullable = false, unique = true)
    private String alphabeticcode;

    @NotNull
    @Min(value = 100)
    @Max(value = 999)
    @Column(name = "numericcode", nullable = false)
    private Integer numericcode;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "minorunit")
    private Integer minorunit;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Currency id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlphabeticcode() {
        return this.alphabeticcode;
    }

    public Currency alphabeticcode(String alphabeticcode) {
        this.setAlphabeticcode(alphabeticcode);
        return this;
    }

    public void setAlphabeticcode(String alphabeticcode) {
        this.alphabeticcode = alphabeticcode;
    }

    public Integer getNumericcode() {
        return this.numericcode;
    }

    public Currency numericcode(Integer numericcode) {
        this.setNumericcode(numericcode);
        return this;
    }

    public void setNumericcode(Integer numericcode) {
        this.numericcode = numericcode;
    }

    public String getName() {
        return this.name;
    }

    public Currency name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinorunit() {
        return this.minorunit;
    }

    public Currency minorunit(Integer minorunit) {
        this.setMinorunit(minorunit);
        return this;
    }

    public void setMinorunit(Integer minorunit) {
        this.minorunit = minorunit;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Currency)) {
            return false;
        }
        return getId() != null && getId().equals(((Currency) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Currency{" +
            "id=" + getId() +
            ", alphabeticcode='" + getAlphabeticcode() + "'" +
            ", numericcode=" + getNumericcode() +
            ", name='" + getName() + "'" +
            ", minorunit=" + getMinorunit() +
            "}";
    }
}
