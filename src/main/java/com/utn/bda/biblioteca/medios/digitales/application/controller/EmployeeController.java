package com.utn.bda.biblioteca.medios.digitales.application.controller;

import com.utn.bda.biblioteca.medios.digitales.application.ResponseHandler;
import com.utn.bda.biblioteca.medios.digitales.application.request.CreateEmployeeRequest;
import com.utn.bda.biblioteca.medios.digitales.model.dto.EmployeeDto;
import com.utn.bda.biblioteca.medios.digitales.service.contract.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<EmployeeDto> employeeDtos = this.employeeService.getAll();
        return ResponseHandler.success( employeeDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        EmployeeDto employeeDto = this.employeeService.getById(id);
        return ResponseHandler.success( employeeDto);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateEmployeeRequest employeeRequest){
        EmployeeDto employeeDto = EmployeeDto.from(employeeRequest);
        try {
           employeeDto = this.employeeService.save(employeeDto);
        }
        catch (Exception exception){
            exception.printStackTrace();
            return ResponseHandler.badRequest("No se pudo crear el employee");
        }
        return ResponseHandler.created(employeeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable long id ,@RequestBody EmployeeDto employeeRequest){
        if (id!= employeeRequest.getId()){
            return  ResponseHandler.badRequest("Peticion incorrecta");
        }
        try {
            this.employeeService.save(employeeRequest);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseHandler.badRequest("No se pudo modificar");
        }
        return ResponseHandler.noContent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id){
        try{
            this.employeeService.delete(id);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseHandler.badRequest("No se pudo eliminar el elemento");
        }
        return ResponseHandler.noContent();

    }

}
