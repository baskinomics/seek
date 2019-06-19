package seek.domain.entity;

import javax.persistence.*;
import java.util.UUID;

/**
 *
 */
@Entity
@Table(name = "POSITION")
public class Position {

    /**
     * todo ID field
     */
    @Id
    @Column(name = "POSITION_ID",
            columnDefinition = "",
            insertable = false,
            updatable = false,
            nullable = false)
    private UUID id = UUID.randomUUID();

    /**
     * A {@link Company} instance.
     */
    @Column(name = "COMPANY_ID", columnDefinition = "")
    private UUID companyId;

    /**
     * The URL of the job position posting.
     */
    @Column(name = "", columnDefinition = "")
    private String positionUrl;

    /**
     * The user-defined ranking of the position.
     */
    @Column(name = "", columnDefinition = "")
    private int rank;

    /**
     * The Glassdoor interview difficulty rating for this position.
     */
    @Column(name = "", columnDefinition = "")
    private float interviewDifficulty;

    /**
     * The {@link Location} of this position.
     */
    @Column(name = "", columnDefinition = "")
    private Location location;

    /**
     * Indicates whether a cover letter has been completed for this position.
     */
    @Column(name = "", columnDefinition = "")
    private boolean isCoverLetterCompleted;

    /**
     * Indicates whether the application for this position has been submitted.
     */
    @Column(name = "", columnDefinition = "")
    private boolean isApplied;

    /**
     * User notes about the position.
     */
    @Column(name = "", columnDefinition = "")
    private String notes;

    /**
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    /**
     * Default constructor.
     */
    public Position() {

    }


}
