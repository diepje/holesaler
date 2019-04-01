package sr.unasat.holesaler.controller;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Credentials;
import sr.unasat.holesaler.entity.Employee;
import sr.unasat.holesaler.service.AuthService;
import sr.unasat.holesaler.service.CompanyService;
import sr.unasat.holesaler.service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    private CompanyService companyService = CompanyService.getInstance();
    private EmployeeService employeeService = EmployeeService.getInstance();
    private AuthService authService = AuthService.getInstance();

    @Path("/login")
    @POST
    public Response login(Credentials credentials) {
        Company company = companyService.getCompanyByUsername(credentials.getUsername().toLowerCase());
        Employee employee = employeeService.getEmployeeByUsername(credentials.getUsername().toLowerCase());
        try {
            if (company != null) {
                return authService.login(company, credentials) ?
                        Response.ok().entity(company).build() :
                        Response.status(Response.Status.UNAUTHORIZED).build();
            }
            if (employee != null) {
                return authService.login(employee, credentials) ?
                        Response.ok().entity(employee).build() :
                        Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
