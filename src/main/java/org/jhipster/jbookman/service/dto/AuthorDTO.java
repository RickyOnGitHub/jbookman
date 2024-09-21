package org.jhipster.jbookman.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import org.jhipster.jbookman.domain.enumeration.WritingStyle;

/**
 * A DTO for the {@link org.jhipster.jbookman.domain.Author} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AuthorDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private WritingStyle writingstyle;

    @NotNull
    private LocalDate birthday;

    private String website;

    private String socialmedia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WritingStyle getWritingstyle() {
        return writingstyle;
    }

    public void setWritingstyle(WritingStyle writingstyle) {
        this.writingstyle = writingstyle;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSocialmedia() {
        return socialmedia;
    }

    public void setSocialmedia(String socialmedia) {
        this.socialmedia = socialmedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AuthorDTO)) {
            return false;
        }

        AuthorDTO authorDTO = (AuthorDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AuthorDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", writingstyle='" + getWritingstyle() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", website='" + getWebsite() + "'" +
            ", socialmedia='" + getSocialmedia() + "'" +
            "}";
    }
}
