package sr.unasat.holesaler.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.dto.CompanyDto;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.service.StatusService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyController {

    private CompanyDao companyDao = CompanyDaoImpl.getInstance();
    private ModelMapper modelMapper = new ModelMapper();
    private StatusService statusService = StatusService.getInstance();

    @Path("/all")
    @GET
    public Response getAllCompanies() {
        List<Company> companies = null;
        try {
            companies = companyDao.getAllCompanies();
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Company company : companies) {
            companyDtos.add(modelMapper.map(company, CompanyDto.class));
        }
        return Response.ok(companyDtos).build();
    }

    @Path("/search/{name}")
    @GET
    public Company getCompanyByName(@PathParam("name") String name) {
        return companyDao.getCompanyByName(name);
    }

    @Path("/register")
    @POST
    public Response registerNewCompany(Company company) {
        System.out.println(company);
        return Response.ok().build();
//            company.setName(company.getName().toLowerCase());
//            company.setUsername(company.getUsername().toLowerCase());
//        try {
//            companyDao.addCompany(company);
//            return Response.ok().build();
//        } catch (Exception e) {
//            JPAConfiguration.getEntityManager().getTransaction().rollback();
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
    }

    @Path("/remove/{id}")
    @DELETE
    public void deleteCompanyById(@PathParam("id") Long id) {
        companyDao.removeCompany(id);
    }

    @Path("/new_registrations")
    @GET
    public Response getAllNewRequests() {
        List<Company> newRegistrations;
        try {
            newRegistrations = companyDao.getAllNewCompanyRegistrations();
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(newRegistrations).build();
    }

    @Path("/approve")
    @POST
    public Response approveCompany(CompanyDto companyDto) {
        try {
            statusService.approveCompanyRegistration(companyDto.getId());
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

}
