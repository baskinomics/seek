package seek.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * Represents a job position and associated metadata.
 *
 * @author Sean Baskin
 */
@Entity
@Table(schema = "SEEK", name = "POSITION")
public class Position {

    /**
     * todo ID field
     */
    @Id
    @Getter
    @Setter(value = AccessLevel.PROTECTED)
    @Column(name = "POSITION_ID", insertable = false, updatable = false, nullable = false)
    @SuppressWarnings("unused")
    private UUID id = UUID.randomUUID();

    /**
     * A {@link Company} instance.
     */
    @Getter
    @Setter
    @Column(name = "COMPANY_ID")
    @SuppressWarnings("unused")
    private UUID companyId;

    /**
     * The URL of the job position posting.
     */
    @Getter
    @Setter
    @Column(name = "POSITION_URL")
    @SuppressWarnings("unused")
    private String positionUrl;

    /**
     * The user-defined ranking of the position.
     */
    @Getter
    @Setter
    @Column(name = "RANK")
    @SuppressWarnings("unused")
    private int rank;

    /**
     * The Glassdoor interview difficulty rating for this position.
     */
    @Getter
    @Setter
    @Column(name = "INTERVIEW_DIFFICUTY")
    @SuppressWarnings("unused")
    private float interviewDifficulty;

    /**
     * The location of this position.
     */
    @Getter
    @Setter
    @Column(name = "LOCATION")
    @SuppressWarnings("unused")
    private String location;

    /**
     * Indicates whether a cover letter has been completed for this position.
     */
    @Getter
    @Setter
    @Column(name = "IS_COVER_LETTER")
    @SuppressWarnings("unused")
    private boolean isCoverLetterCompleted;

    /**
     * Indicates whether the application for this position has been submitted.
     */
    @Getter
    @Setter
    @Column(name = "IS_APPLIED")
    @SuppressWarnings("unused")
    private boolean isApplied;

    /**
     * User notes about the position.
     */
    @Getter
    @Setter
    @Column(name = "NOTES")
    @SuppressWarnings("unused")
    private String notes;

    /**
     *
     */
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    @SuppressWarnings("unused")
    private Company company;

    /**
     * Default constructor.
     */
    public Position() {

    }
}
