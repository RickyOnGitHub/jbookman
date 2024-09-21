package org.jhipster.jbookman.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.jhipster.jbookman.domain.Publisher} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PublisherDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String contact;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        if (!(o instanceof PublisherDTO)) {
            return false;
        }

        PublisherDTO publisherDTO = (PublisherDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, publisherDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PublisherDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", contact='" + getContact() + "'" +
            ", website='" + getWebsite() + "'" +
            ", socialmedia='" + getSocialmedia() + "'" +
            "}";
    }
}
