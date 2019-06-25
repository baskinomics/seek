package seek.controller;

import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import seek.domain.dto.CompanyDto;
import seek.domain.entity.Company;
import seek.service.CompanyService;

import javax.inject.Inject;
import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * todo Documentation
 */
@Controller(value = "/companies")
public class CompanyController {

    /**
     * Eligible bean for our company service.
     */
    @Inject
    protected CompanyService companyService;

    /**
     * Returns a collection of {@link CompanyDto} instances.
     *
     * @return
     */
    @Get(value = "/list")
    @SuppressWarnings("unused")
    public List<CompanyDto> list() {
        return companyService.list();
    }

    /**
     * Returns a {@link Company} instance matching the given {@code id}.
     *
     * @param id
     * @return
     */
    @Get("/{id}")
    @SuppressWarnings("unused")
    public Company get(final String id) {
        return companyService.get(UUID.fromString(id));
    }

    /**
     * todo Add validation
     *
     * @param company
     * @return
     */
    @Post
    @SuppressWarnings("unused")
    public HttpResponse<CompanyDto> save(@Body Company company) {
        final CompanyDto persisted = companyService.save(company);

        return HttpResponse
                .created(persisted)
                .headers(headers -> headers.location(location(company.getId())));
    }

    /**
     * todo Documentation
     *
     * @param company
     * @return
     */
    @Put
    @SuppressWarnings("unused")
    public HttpResponse update(@Body Company company) {
        final CompanyDto updated = companyService.update(company);
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(updated.getId()).getPath());
    }

    /**
     * todo Documentation
     *
     * @param id
     * @return
     */
    @Delete("/{id}")
    @SuppressWarnings("unused")
    public HttpResponse delete(final String id) {
        companyService.delete(UUID.fromString(id));
        return HttpResponse.noContent();
    }

    /**
     * todo Documentation
     *
     * @param id
     * @return
     */
    protected URI location(UUID id) {
        return URI.create("/companies/" + id);
    }

    /**
     * todo Documentation
     * 
     * @param company
     * @return
     */
    protected URI location(Company company) {
        return location(company.getId());
    }
}
