package seek.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import seek.domain.entity.Company;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Exposes an implementation of {@link CompanyRepository}.
 *
 * @author Sean Baskin
 */
@Singleton
@SuppressWarnings("unused")
public class CompanyRepositoryImpl implements CompanyRepository {

    /**
     * Class logger.
     */
    private static final Logger log = LoggerFactory.getLogger(CompanyRepositoryImpl.class);

    /**
     * todo documentation
     */
    // @PersistenceContext
    private EntityManager entityManager;

    /**
     * todo Do we need the application configuration?
     *
     * @param entityManager
     */
    public CompanyRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findById(@NotNull final UUID id) {
        // 1. todo
        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Company> criteria = criteriaBuilder.createQuery(Company.class);

        // 2. Construct our query
        final Root<Company> root = criteria.from(Company.class);
        final Predicate idEqualsPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteria.select(root).where(idEqualsPredicate);

        // 3. Execute the query and return the result
        return Optional.ofNullable(entityManager.createQuery(criteria).getSingleResult());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        // 1. Instantiate a collection for our query result
        final List<Company> results = new ArrayList<>();

        // 2. todo
        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);

        // 3. Construct our query
        final Root<Company> root = criteriaQuery.from(Company.class);
        criteriaQuery.select(root);

        // 4. Execute the query and return the result
        // todo potentially wrap this in an Optional
        results.addAll(entityManager.createQuery(criteriaQuery).getResultList());
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Company save(@NotNull final Company company) {
        entityManager.persist(company);
        return company;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(@NotNull final UUID id) {
        findById(id).ifPresent(company -> entityManager.remove(company));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Company update(@NotNull final Company company) {
        return entityManager.merge(company);
    }
}
