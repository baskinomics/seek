package seek.domain.dto;

import lombok.Data;
import seek.domain.entity.Company;
import seek.domain.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * todo documentation
 */
@Data
public class CompanyDto {
    /**
     * todo documentation
     */
    private UUID id;

    /**
     * todo documentation
     */
    private String name;

    /**
     * todo documentation
     */
    private String companyUrl;

    /**
     * todo documentation
     */
    private String careersUrl;

    /**
     * todo documentation
     */
    private float glassdoorRating;

    /**
     * todo documentation
     */
    private List<Position> positions = new ArrayList<>();

    /**
     *
     * @param company
     */
    public CompanyDto(final Company company) {
        this.id              = company.getId();
        this.name            = company.getName();
        this.companyUrl      = company.getCompanyUrl();
        this.careersUrl      = company.getCareersUrl();
        this.glassdoorRating = company.getGlassdoorRating();

        this.positions.addAll(company.getPositions());
    }

}
