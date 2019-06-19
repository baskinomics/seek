package seek.domain.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a company that may or may not have job positions available.
 *
 * @see {@link Position}
 * @author Sean Baskin
 */
@Entity
@Table(schema = "SEEK", name = "COMPANY")
@EqualsAndHashCode
public class Company {

    /**
     * todo ID field
     */
    @Id
    @Getter
    @Setter(value = AccessLevel.PROTECTED)
    @Column(name = "ID", insertable = false, updatable = false, nullable = false)
    @SuppressWarnings("unused")
    private UUID id = UUID.randomUUID();

    /**
     * The company name.
     */
    @Column(name = "NAME")
    @SuppressWarnings("unused")
    private String name;

    /**
     * The company URL.
     */
    @Column(name = "COMPANY_URL")
    @SuppressWarnings("unused")
    private String companyUrl;

    /**
     * The company careers URL.
     */
    @Column(name = "CAREERS_URL")
    @SuppressWarnings("unused")
    private String careersUrl;

    /**
     * The Glassdoor company rating.
     */
    @Column(name = "GLASSDOOR_RATING")
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
