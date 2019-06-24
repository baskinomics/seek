package seek.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Represents a job position and associated metadata.
 * todo: validation
 *
 * @author Sean Baskin
 */
@Data
@Entity
@Table(schema = "core", name = "position")
public class Position {

    /**
     * todo ID field
     */
    @Id
    @Setter(value = AccessLevel.PROTECTED)
    @Column(name = "position_id", columnDefinition = "uuid", insertable = false, updatable = false, nullable = false)
    @SuppressWarnings("unused")
    private UUID id = UUID.randomUUID();

    /**
     * A {@link Company} instance.
     */
    @NotNull(message = "Company ID cannot be null.")
    @Column(name = "company_id", columnDefinition = "uuid")
    @SuppressWarnings("unused")
    private UUID companyId;

    /**
     * The URL of the job position posting.
     */
    @Column(name = "position_url", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String positionUrl;

    /**
     * The user-defined ranking of the position.
     */
    @Column(name = "rank", columnDefinition = "integer")
    @SuppressWarnings("unused")
    private int rank;

    /**
     * The Glassdoor interview difficulty rating for this position.
     */
    @Column(name = "interview_difficulty", columnDefinition = "real")
    @SuppressWarnings("unused")
    private float interviewDifficulty;

    /**
     * The location of this position.
     */
    @Column(name = "location", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String location;

    /**
     * Indicates whether a cover letter has been completed for this position.
     */
    @Column(name = "is_cover_letter", columnDefinition = "boolean")
    @SuppressWarnings("unused")
    private boolean isCoverLetterCompleted = false;

    /**
     * Indicates whether the application for this position has been submitted.
     */
    @Column(name = "is_applied", columnDefinition = "boolean")
    @SuppressWarnings("unused")
    private boolean isApplied = false;

    /**
     * User notes about the position.
     */
    @Column(name = "notes", columnDefinition = "varchar")
    @SuppressWarnings("unused")
    private String notes;

    /**
     * The {@link Company} with which this position is associated.
     */
    @Setter(value = AccessLevel.PROTECTED)
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @SuppressWarnings("unused")
    private Company company;
}
