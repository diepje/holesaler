package sr.unasat.holesaler.designPatterns.state;

import sr.unasat.holesaler.dto.CompanyDto;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private static State state = new NonEmployeeState();

    private static Context context;

    private Context(){

    }

    public static Context getInstance(){
        if (context == null){
            context = new Context();
        }
        return context;
    }

    public void setState(String role) {
        if (role.equals("ADMIN")) {
            state = new AdminState();
        } else if (role.equals("EMPLOYEE")){
            state = new EmployeeState();
        } else {
            state = new NonEmployeeState();
        }
    }

    public CompanyDto companyDtoByUser(CompanyDto companyDto) {
        return state.getCompanyDto(companyDto);
    }

    public List<CompanyDto> companyDtoListByUser(List<CompanyDto> companyDtos){
        List<CompanyDto> companyDtoListByUser = new ArrayList<>();
        for (CompanyDto companyDto : companyDtos){
            if (state.getCompanyDto(companyDto) != null) {
                companyDtoListByUser.add(state.getCompanyDto(companyDto));
            }
        }
        return companyDtoListByUser;
    }
}
