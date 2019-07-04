package seek.repository;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import seek.domain.entity.Position;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
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
 * Implementation of the {@link PositionRepository} interface.
 *
 * @author Sean Baskin
 */
@Singleton
@SuppressWarnings("unused")
public class PositionRepositoryImpl implements PositionRepository {

    /**
     * Class logger.
     */
    private static final Logger log = LogManager.getLogger(PositionRepositoryImpl.class);

    /**
     * todo Documentation.
     */
    // @PersistenceContext
    private EntityManager entityManager;

    public PositionRepositoryImpl(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Position> findById(@NotNull UUID id) {
        log.log(Level.DEBUG, String.format("Querying for Position[id: {}].", id.toString()));

        // 1. Compose our criteria
        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Position> criteria = criteriaBuilder.createQuery(Position.class);

        // 2. Construct our query
        final Root<Position> root = criteria.from(Position.class);
        final Predicate idEqualsPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteria.select(root).where(idEqualsPredicate);

        // todo Create and register an exception handler for these checked exceptions.
        // 3. Execute the query and return the result
        try {
            return Optional.ofNullable(entityManager
                    .createQuery(criteria)
                    .getSingleResult());
        } catch (EntityNotFoundException e) {
            log.log(Level.ERROR, e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<Position> findAll() {
        log.log(Level.DEBUG, "Querying for all positions.");

        // 1. Instantiate a collection for our query result
        final List<Position> results = new ArrayList<>();

        // 2. todo
        final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Position> criteriaQuery = criteriaBuilder.createQuery(Position.class);

        // 3. Construct our query
        final Root<Position> root = criteriaQuery.from(Position.class);
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
    public Position save(@NotNull Position position) {
        entityManager.persist(position);
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Position update(@NotNull Position position) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(@NotNull UUID id) {

    }
}
