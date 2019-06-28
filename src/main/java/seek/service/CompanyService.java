package seek.service;

import io.micronaut.spring.tx.annotation.Transactional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import seek.domain.dto.CompanyDto;
import seek.domain.entity.Company;
import seek.repository.CompanyRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * todo Documentation
 */
@Singleton
public class CompanyService {

    /**
     * Class logger.
     */
    private static final Logger log = LogManager.getLogger(CompanyService.class);


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
    public Optional<CompanyDto> get(final String id) {
        log.log(Level.DEBUG, String.format("Verifying the provided UUID[value: %s] is valid.", id));
        try {
            final UUID verified = UUID.fromString(id);
            log.log(Level.DEBUG, String.format("%s is valid.", verified.toString()));
            final Optional<Company> result = companyRepository.findById(verified);
            return result.map(CompanyDto::new);
        } catch (IllegalArgumentException e) {
            log.log(Level.ERROR, e.getMessage());
            return Optional.empty();
        }
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
