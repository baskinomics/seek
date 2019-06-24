package seek.service;

import io.micronaut.spring.tx.annotation.Transactional;
import seek.domain.dto.CompanyDto;
import seek.repository.CompanyRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Singleton
public class CompanyService {

    /**
     *
     */
    @Inject
    protected CompanyRepository companyRepository;

    /**
     *
     * @return
     */
    @Transactional
    public List<CompanyDto> list() {
        return companyRepository.findAll().stream()
                .map(company -> new CompanyDto(company))
                .collect(Collectors.toList());
    }
}
