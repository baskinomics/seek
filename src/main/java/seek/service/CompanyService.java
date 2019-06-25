package seek.service;

import io.micronaut.spring.tx.annotation.Transactional;
import seek.domain.dto.CompanyDto;
import seek.domain.entity.Company;
import seek.repository.CompanyRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * todo Documentation
 */
@Singleton
public class CompanyService {

    /**
     * todo Documentation
     */
    @Inject
    protected CompanyRepository companyRepository;

    /**
     * todo Documentation
     *
     * @return
     */
    @Transactional
    public List<CompanyDto> list() {
        return companyRepository.findAll().stream()
                .map(company -> new CompanyDto(company))
                .collect(Collectors.toList());
    }

    /**
     * todo Convert this to DTO.
     *
     * @param id
     * @return
     */
    @Transactional
    public Company get(final UUID id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * todo Documentation
     *
     * @param company
     * @return
     */
    @Transactional
    public CompanyDto save(final Company company) {
        return new CompanyDto(companyRepository.save(company));
    }

    /**
     * todo Documentation
     *
     * @param company
     * @return
     */
    @Transactional
    public CompanyDto update(final Company company) {
        return new CompanyDto(companyRepository.update(company));
    }

    /**
     * todo Documentation
     *
     * @param id
     */
    @Transactional
    public void delete(final UUID id) {
        companyRepository.deleteById(id);
    }
}
