package seek.domain.dto;

import lombok.Data;
import seek.domain.entity.Position;

import java.util.UUID;

/**
 * todo documentation
 */
@Data
public class PositionDto {

    /**
     * todo documentation
     */
    private UUID id;

    /**
     * todo documentation
     */
    private UUID companyId;

    /**
     * todo documentation
     */
    private String positionUrl;

    /**
     * todo documentation
     */
    private int rank;

    /**
     * todo documentation
     */
    private float interviewDifficulty;

    /**
     * todo documentation
     */
    private String location;

    /**
     * todo documentation
     */
    private boolean isCoverLetterCompleted;

    /**
     * todo documentation
     */
    private boolean isApplied;

    /**
     * todo documentation
     */
    private String notes;

    /**
     *
     * @param position
     */
    public PositionDto(final Position position) {
        this.id                     = position.getId();
        this.companyId              = position.getCompanyId();
        this.positionUrl            = position.getPositionUrl();
        this.rank                   = position.getRank();
        this.interviewDifficulty    = position.getInterviewDifficulty();
        this.location               = position.getLocation();
        this.isCoverLetterCompleted = position.isCoverLetterCompleted();
        this.isApplied              = position.isApplied();
        this.notes                  = position.getNotes();
    }
}
