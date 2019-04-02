package sr.unasat.holesaler.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.designPatterns.state.Context;
import sr.unasat.holesaler.dto.CompanyDto;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.service.CompanyService;
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

    private ModelMapper modelMapper = new ModelMapper();
    private StatusService statusService = StatusService.getInstance();
    private CompanyService companyService = CompanyService.getInstance();
    private Context userState = Context.getInstance();

    @Path("/all")
    @GET
    public Response getAllCompanies() {
        List<Company> companies;
        try {
            companies = companyService.getAllCompanies();
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Company company : companies) {
            companyDtos.add(modelMapper.map(company, CompanyDto.class));
        }
        companyDtos = userState.companyDtoListByUser(companyDtos);
        return Response.ok(companyDtos).build();
    }

    @Path("/search/{name}")
    @GET
    public Company getCompanyByName(@PathParam("name") String name) {
        return companyService.getCompanyByName(name);
    }

    @Path("/register")
    @POST
    public Response registerNewCompany(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        try {
            companyService.registerNewCompany(company);
            return Response.ok().build();
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/remove")
    @DELETE
    public void deleteCompanyById(CompanyDto companyDto) {
        companyService.removeCompany(companyDto.getId());
    }

    @Path("/new_registrations")
    @GET
    public Response getAllNewRequests() {
        List<Company> newRegistrations;
        List<CompanyDto> newRegistrationsDto = new ArrayList<>();
        try {
            newRegistrations = companyService.getAllNewRequests();
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        for (Company company : newRegistrations) {
            newRegistrationsDto.add(modelMapper.map(company, CompanyDto.class));
        }
        return Response.ok(newRegistrationsDto).build();
    }

    @Path("/approve")
    @PUT
    public Response approveCompany(CompanyDto companyDto) {
        try {
            statusService.updateCompanyRegistrationStatus(companyDto.getId(), "APPROVED");
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/reject")
    @PUT
    public Response rejectCompany(CompanyDto companyDto) {
        try {
            statusService.updateCompanyRegistrationStatus(companyDto.getId(), "REJECTED");
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/deactivate")
    @PUT
    public Response deactivateCompany(CompanyDto companyDto) {
        try {
            statusService.updateCompanyRegistrationStatus(companyDto.getId(), "DEACTIVATED");
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/active")
    @GET
    public Response getAllActiveCompanies(){
        List<CompanyDto> activeCompaniesDto = new ArrayList<>();
        List<Company> activeCompanies;
        try{
            activeCompanies = companyService.getAllActiveCompanies();
        } catch(Exception e){
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        for (Company company : activeCompanies) {
            activeCompaniesDto.add(modelMapper.map(company, CompanyDto.class));
        }
        return Response.ok(activeCompaniesDto).build();
    }

}
