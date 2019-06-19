package seek.domain.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Entity
@Table(schema = "", name = "COMPANY")
public class Company {

    // todo required

    /**
     * todo ID field
     */
    @Id
    @Column(name = "ID", columnDefinition = "", insertable = false, updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    /**
     *
     */
    @Column(name = "NAME", columnDefinition = "")
    private String name;

    /**
     *
     */
    @Column(name = "COMPANY_URL", columnDefinition = "")
    private String companyUrl;

    /**
     *
     */
    @Column(name = "CAREERS_URL", columnDefinition = "")
    private String careersUrl;

    /**
     *
     */
    @Column(name = "GLASSDOOR_RATING", columnDefinition = "")
    private float glassdoorRating;

    /**
     *
     */
    @OneToMany(mappedBy = "company")
    private List<Position> positions = new ArrayList<>();

    /**
     * Default constructor.
     */
    public Company() {

    }
}
