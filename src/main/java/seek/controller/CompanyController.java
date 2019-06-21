package seek.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import seek.domain.entity.Company;
import seek.repository.CompanyRepository;

import javax.inject.Inject;
import java.util.List;

@Controller(value = "/companies")
public class CompanyController {

    @Inject
    protected CompanyRepository companyRepository;

    @Get(value = "/list")
    @SuppressWarnings("unused")
    public List<Company> list() {
        return companyRepository.findAll();
    }
}
