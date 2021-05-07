package my.cwm.soil.employeeinfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class EmployeeService {
    final EmployeeRepository repo;

    public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Employee> pagedResult = repo.findAll(paging);

        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }
        else
        {
            return new ArrayList<Employee>();
        }

    }

    public Employee save(Employee employee){
        return this.repo.save(employee);
    }

    public void delete(Long id){
        this.repo.deleteById(id);
    }




}
