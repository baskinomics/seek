package seek.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

/**
 * Represents a job position and associated metadata.
 * todo: validation
 *
 * @author Sean Baskin
 */
@Data
@Entity
@Table(schema = "SEEK", name = "POSITION")
public class Position {

    /**
     * todo ID field
     */
    @Id
    @Setter(value = AccessLevel.PROTECTED)
    @Column(name = "POSITION_ID", insertable = false, updatable = false, nullable = false)
    @SuppressWarnings("unused")
    private UUID id = UUID.randomUUID();

    /**
     * A {@link Company} instance.
     */
    @Column(name = "COMPANY_ID")
    @SuppressWarnings("unused")
    private UUID companyId;

    /**
     * The URL of the job position posting.
     */
    @Column(name = "POSITION_URL")
    @SuppressWarnings("unused")
    private String positionUrl;

    /**
     * The user-defined ranking of the position.
     */
    @Column(name = "RANK")
    @SuppressWarnings("unused")
    private int rank;

    /**
     * The Glassdoor interview difficulty rating for this position.
     */
    @Column(name = "INTERVIEW_DIFFICUTY")
    @SuppressWarnings("unused")
    private float interviewDifficulty;

    /**
     * The location of this position.
     */
    @Column(name = "LOCATION")
    @SuppressWarnings("unused")
    private String location;

    /**
     * Indicates whether a cover letter has been completed for this position.
     */
    @Column(name = "IS_COVER_LETTER")
    @SuppressWarnings("unused")
    private boolean isCoverLetterCompleted;

    /**
     * Indicates whether the application for this position has been submitted.
     */
    @Column(name = "IS_APPLIED")
    @SuppressWarnings("unused")
    private boolean isApplied;

    /**
     * User notes about the position.
     */
    @Column(name = "NOTES")
    @SuppressWarnings("unused")
    private String notes;

    /**
     * The {@link Company} with which this position is associated.
     */
    @Setter(value = AccessLevel.PROTECTED)
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    @SuppressWarnings("unused")
    private Company company;
}
