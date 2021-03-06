package sr.unasat.holesaler.controller;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.designPatterns.serviceFactory.Service;
import sr.unasat.holesaler.designPatterns.serviceFactory.ServiceFactory;
import sr.unasat.holesaler.designPatterns.state.Context;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Credentials;
import sr.unasat.holesaler.entity.Employee;
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
    private Service authService = ServiceFactory.getInstance("AUTHENTICATION");
    private Context context = Context.getInstance();

    @Path("/login")
    @POST
    public Response login(Credentials credentials) {
        Company company = companyService.getCompanyByUsername(credentials.getUsername().toLowerCase());
        Employee employee = employeeService.getEmployeeByUsername(credentials.getUsername().toLowerCase());
        Response response;
        try {
            if (company != null) {
                response = authService.login(company, credentials) ?
                        Response.ok().entity(company).build() :
                        Response.status(Response.Status.UNAUTHORIZED).build();

                return response;
            }
            if (employee != null) {
                response = authService.login(employee, credentials) ?
                        Response.ok().entity(employee).build() :
                        Response.status(Response.Status.UNAUTHORIZED).build();
                context.setState(employee.getRole());
                return response;
            }
        } catch (Exception e) {
            JPAConfiguration.getEntityManager().getTransaction().rollback();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
