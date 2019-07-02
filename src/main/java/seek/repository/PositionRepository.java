package seek.repository;

import seek.domain.entity.Position;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Exposes contract for data access operations on @{link {@link seek.domain.entity.Position} instances.
 */
public interface PositionRepository {

    /**
     * Returns a {@link Position} instance for the given {@code id}.
     *
     * @param id The Position ID to query for.
     * @return The {@link Position} matching the given {@code id} if present.
     */
    Optional<Position> findById(@NotNull UUID id);

    /**
     * Returns a collection of {@link Position} instances.
     * todo Add pagination and sorting.
     *
     * @return The collection of {@link Position} instances.
     */
    List<Position> findAll();

    /**
     * Persists the given {@code Position}.
     *
     * @param position The {@link Position} to persist.
     * @return The persisted {@link Position}.
     */
    Position save(@NotNull Position position);

    /**
     * Update an existing {@link Position} instance.
     *
     * @param position The updated {@link Position} instance.
     * @return The updated {@link Position}.
     */
    Position update(@NotNull Position position);

    /**
     * Deletes the {@link Position} for the given {@code id}.
     *
     * @param id The position ID to delete.
     */
    void deleteById(@NotNull UUID id);
}
