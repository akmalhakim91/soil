package my.cwm.soil.employeeinfo;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor

public class EmployeeController {
    
    final private EmployeeService svc;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Employee> list = svc.getAllEmployees(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);

    }

    public Page<Employee> findAll(Pageable paging) {
        return null;
    }


    @Transactional
    @PostMapping("")
    public Employee save(@RequestBody Employee employee){
        return this.svc.save(employee);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id){
        this.svc.delete(id);
    }





}
