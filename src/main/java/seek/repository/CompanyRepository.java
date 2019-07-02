package seek.repository;

import seek.domain.entity.Company;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Exposes contract for data access operations on {@link Company} instances.
 */
public interface CompanyRepository {

    /**
     * Returns a {@link Company} instance for the given {@code id}.
     *
     * @param id The company ID to query for.
     * @return The {@link Company} matching the given {@code id} if present.
     */
    Optional<Company> findById(@NotNull UUID id);

    /**
     * Returns a collection of {@link Company} instances.
     * todo Add pagination and sorting.
     *
     * @return The collection of {@link Company} instances.
     */
    List<Company> findAll();

    /**
     * Persists the given {@code company}.
     *
     * @param company The {@link Company} to persist.
     * @return The persisted {@link Company}.
     */
    Company save(@NotNull Company company);

    /**
     * Update an existing {@link Company} instance.
     *
     * @param company The updated {@link Company} instance.
     * @return The updated {@link Company}.
     */
    Company update(@NotNull Company company);

    /**
     * Deletes the {@link Company} for the given {@code id}.
     *
     * @param id The company ID to delete.
     */
    void deleteById(@NotNull UUID id);

}
