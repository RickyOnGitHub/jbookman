package org.jhipster.jbookman.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.jbookman.domain.Currency} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CurrencyDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 3, max = 3)
    @Pattern(regexp = "\\b[A-Z]{3}\\b")
    private String alphabeticcode;

    @NotNull
    @Min(value = 100)
    @Max(value = 999)
    private Integer numericcode;

    @NotNull
    private String name;

    private Integer minorunit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlphabeticcode() {
        return alphabeticcode;
    }

    public void setAlphabeticcode(String alphabeticcode) {
        this.alphabeticcode = alphabeticcode;
    }

    public Integer getNumericcode() {
        return numericcode;
    }

    public void setNumericcode(Integer numericcode) {
        this.numericcode = numericcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinorunit() {
        return minorunit;
    }

    public void setMinorunit(Integer minorunit) {
        this.minorunit = minorunit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CurrencyDTO)) {
            return false;
        }

        CurrencyDTO currencyDTO = (CurrencyDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, currencyDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CurrencyDTO{" +
            "id=" + getId() +
            ", alphabeticcode='" + getAlphabeticcode() + "'" +
            ", numericcode=" + getNumericcode() +
            ", name='" + getName() + "'" +
            ", minorunit=" + getMinorunit() +
            "}";
    }
}
