package sr.unasat.holesaler.controller;

import sr.unasat.holesaler.config.JPAConfiguration;
import sr.unasat.holesaler.dao.CompanyDao;
import sr.unasat.holesaler.dao.CompanyDaoImpl;
import sr.unasat.holesaler.dao.EmployeeDao;
import sr.unasat.holesaler.dao.EmployeeDaoImpl;
import sr.unasat.holesaler.entity.Company;
import sr.unasat.holesaler.entity.Credentials;
import sr.unasat.holesaler.entity.Employee;

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

    private CompanyDao companyDao = CompanyDaoImpl.getInstance();
    private EmployeeDao employeeDao = EmployeeDaoImpl.getInstance();

    @Path("/login")
    @POST
    public Response login(Credentials credentials) {
        Company company = companyDao.getCompanyByUsername(credentials.getUsername().toLowerCase());
        Employee employee = employeeDao.getEmplopyeeByUsername(credentials.getUsername().toLowerCase());
        try {
            if (company != null) {
                return company.getPassword().equals(credentials.getPassword()) ?
                        Response.ok().entity(company).build() :
                        Response.status(Response.Status.UNAUTHORIZED).build();
            }
            if (employee != null) {
                return employee.getPassword().equals(credentials.getPassword()) ?
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
