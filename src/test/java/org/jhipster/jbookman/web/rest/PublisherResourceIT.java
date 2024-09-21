package org.jhipster.jbookman.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.jhipster.jbookman.domain.PublisherAsserts.*;
import static org.jhipster.jbookman.web.rest.TestUtil.createUpdateProxyForBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.jhipster.jbookman.IntegrationTest;
import org.jhipster.jbookman.domain.Publisher;
import org.jhipster.jbookman.repository.PublisherRepository;
import org.jhipster.jbookman.service.dto.PublisherDTO;
import org.jhipster.jbookman.service.mapper.PublisherMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link PublisherResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PublisherResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT = "BBBBBBBBBB";

    private static final String DEFAULT_WEBSITE = "AAAAAAAAAA";
    private static final String UPDATED_WEBSITE = "BBBBBBBBBB";

    private static final String DEFAULT_SOCIALMEDIA = "AAAAAAAAAA";
    private static final String UPDATED_SOCIALMEDIA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/publishers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPublisherMockMvc;

    private Publisher publisher;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Publisher createEntity(EntityManager em) {
        Publisher publisher = new Publisher()
            .name(DEFAULT_NAME)
            .contact(DEFAULT_CONTACT)
            .website(DEFAULT_WEBSITE)
            .socialmedia(DEFAULT_SOCIALMEDIA);
        return publisher;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Publisher createUpdatedEntity(EntityManager em) {
        Publisher publisher = new Publisher()
            .name(UPDATED_NAME)
            .contact(UPDATED_CONTACT)
            .website(UPDATED_WEBSITE)
            .socialmedia(UPDATED_SOCIALMEDIA);
        return publisher;
    }

    @BeforeEach
    public void initTest() {
        publisher = createEntity(em);
    }

    @Test
    @Transactional
    void createPublisher() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);
        var returnedPublisherDTO = om.readValue(
            restPublisherMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(publisherDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            PublisherDTO.class
        );

        // Validate the Publisher in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedPublisher = publisherMapper.toEntity(returnedPublisherDTO);
        assertPublisherUpdatableFieldsEquals(returnedPublisher, getPersistedPublisher(returnedPublisher));
    }

    @Test
    @Transactional
    void createPublisherWithExistingId() throws Exception {
        // Create the Publisher with an existing ID
        publisher.setId(1L);
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restPublisherMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(publisherDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkNameIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        publisher.setName(null);

        // Create the Publisher, which fails.
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        restPublisherMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(publisherDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkContactIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        publisher.setContact(null);

        // Create the Publisher, which fails.
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        restPublisherMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(publisherDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllPublishers() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        // Get all the publisherList
        restPublisherMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(publisher.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].contact").value(hasItem(DEFAULT_CONTACT)))
            .andExpect(jsonPath("$.[*].website").value(hasItem(DEFAULT_WEBSITE)))
            .andExpect(jsonPath("$.[*].socialmedia").value(hasItem(DEFAULT_SOCIALMEDIA)));
    }

    @Test
    @Transactional
    void getPublisher() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        // Get the publisher
        restPublisherMockMvc
            .perform(get(ENTITY_API_URL_ID, publisher.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(publisher.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.contact").value(DEFAULT_CONTACT))
            .andExpect(jsonPath("$.website").value(DEFAULT_WEBSITE))
            .andExpect(jsonPath("$.socialmedia").value(DEFAULT_SOCIALMEDIA));
    }

    @Test
    @Transactional
    void getNonExistingPublisher() throws Exception {
        // Get the publisher
        restPublisherMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingPublisher() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the publisher
        Publisher updatedPublisher = publisherRepository.findById(publisher.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedPublisher are not directly saved in db
        em.detach(updatedPublisher);
        updatedPublisher.name(UPDATED_NAME).contact(UPDATED_CONTACT).website(UPDATED_WEBSITE).socialmedia(UPDATED_SOCIALMEDIA);
        PublisherDTO publisherDTO = publisherMapper.toDto(updatedPublisher);

        restPublisherMockMvc
            .perform(
                put(ENTITY_API_URL_ID, publisherDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(publisherDTO))
            )
            .andExpect(status().isOk());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedPublisherToMatchAllProperties(updatedPublisher);
    }

    @Test
    @Transactional
    void putNonExistingPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(
                put(ENTITY_API_URL_ID, publisherDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(publisherDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(publisherDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(publisherDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdatePublisherWithPatch() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the publisher using partial update
        Publisher partialUpdatedPublisher = new Publisher();
        partialUpdatedPublisher.setId(publisher.getId());

        partialUpdatedPublisher.socialmedia(UPDATED_SOCIALMEDIA);

        restPublisherMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPublisher.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPublisher))
            )
            .andExpect(status().isOk());

        // Validate the Publisher in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPublisherUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedPublisher, publisher),
            getPersistedPublisher(publisher)
        );
    }

    @Test
    @Transactional
    void fullUpdatePublisherWithPatch() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the publisher using partial update
        Publisher partialUpdatedPublisher = new Publisher();
        partialUpdatedPublisher.setId(publisher.getId());

        partialUpdatedPublisher.name(UPDATED_NAME).contact(UPDATED_CONTACT).website(UPDATED_WEBSITE).socialmedia(UPDATED_SOCIALMEDIA);

        restPublisherMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedPublisher.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedPublisher))
            )
            .andExpect(status().isOk());

        // Validate the Publisher in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPublisherUpdatableFieldsEquals(partialUpdatedPublisher, getPersistedPublisher(partialUpdatedPublisher));
    }

    @Test
    @Transactional
    void patchNonExistingPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, publisherDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(publisherDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(publisherDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamPublisher() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        publisher.setId(longCount.incrementAndGet());

        // Create the Publisher
        PublisherDTO publisherDTO = publisherMapper.toDto(publisher);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restPublisherMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(publisherDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Publisher in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deletePublisher() throws Exception {
        // Initialize the database
        publisherRepository.saveAndFlush(publisher);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the publisher
        restPublisherMockMvc
            .perform(delete(ENTITY_API_URL_ID, publisher.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return publisherRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Publisher getPersistedPublisher(Publisher publisher) {
        return publisherRepository.findById(publisher.getId()).orElseThrow();
    }

    protected void assertPersistedPublisherToMatchAllProperties(Publisher expectedPublisher) {
        assertPublisherAllPropertiesEquals(expectedPublisher, getPersistedPublisher(expectedPublisher));
    }

    protected void assertPersistedPublisherToMatchUpdatableProperties(Publisher expectedPublisher) {
        assertPublisherAllUpdatablePropertiesEquals(expectedPublisher, getPersistedPublisher(expectedPublisher));
    }
}
