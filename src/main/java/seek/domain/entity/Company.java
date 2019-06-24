package seek.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a company that may or may not have job positions available.
 * todo: validation
 *
 * @see {@link Position}
 * @author Sean Baskin
 */
@Data
@Entity
@Table(name = "company")
public class Company {

    /**
     * todo ID field
     */
    @Id
    @Setter(value = AccessLevel.PROTECTED)
    @Column(name = "company_id", columnDefinition = "uuid", insertable = false, updatable = false, nullable = false)
    @SuppressWarnings("unused")
    private UUID id = UUID.randomUUID();

    /**
     * The company name.
     */
    @Column(name = "name", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String name;

    /**
     * The company URL.
     */
    @Column(name = "company_url", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String companyUrl;

    /**
     * The company careers URL.
     */
    @Column(name = "careers_url", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String careersUrl;

    /**
     * The Glassdoor company rating.
     */
    @Column(name = "glassdoor_rating", columnDefinition = "real")
    @SuppressWarnings("unused")
    private float glassdoorRating;

    /**
     * The company's available job positions.
     */
    @OneToMany(mappedBy = "company")
    @EqualsAndHashCode.Exclude
    @SuppressWarnings("unused")
    private List<Position> positions = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Company() {

    }
}
