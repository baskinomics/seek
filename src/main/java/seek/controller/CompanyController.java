package seek.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import seek.domain.dto.CompanyDto;
import seek.service.CompanyService;

import javax.inject.Inject;
import java.util.List;

@Controller(value = "/companies")
public class CompanyController {

    @Inject
    protected CompanyService companyService;

    @Get(value = "/list")
    @SuppressWarnings("unused")
    public List<CompanyDto> list() {
        return companyService.list();
    }
}
