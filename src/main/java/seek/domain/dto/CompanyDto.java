package seek.domain.dto;

import lombok.Data;
import seek.domain.entity.Company;
import seek.domain.entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CompanyDto {
    private UUID id;
    private String name;
    private String companyUrl;
    private String careersUrl;
    private float glassdoorRating;
    private List<Position> positions = new ArrayList<>();

    public CompanyDto(final Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.companyUrl = company.getCompanyUrl();
        this.careersUrl = company.getCareersUrl();
        this.glassdoorRating = company.getGlassdoorRating();
        this.positions.addAll(company.getPositions());
    }

}
