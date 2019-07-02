package seek.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seek.domain.dto.CompanyDto;
import seek.domain.entity.Company;

// @MicronautTest
class CompanyTest {

    @Test
    void testCreateCompany() {
        final Company company = new Company();
        Assertions.assertNotNull(company.getId());
    }

    @Test
    void testCreateCompanyDto() {
        final Company company = new Company();
        final CompanyDto dto = new CompanyDto(company);
        Assertions.assertNotNull(dto.getId());
    }
}
