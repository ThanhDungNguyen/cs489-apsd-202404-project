package edu.miu.cs489.project.thanhdungnguyen.tasks_manager.dto.employee;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Employee;

public class EmployeeAdapter {
    public static Employee getEmployeeFromEmployeeRequest(EmployeeRequest employeeRequest) {
        return new Employee(null, employeeRequest.firstName(), employeeRequest.lastName(), employeeRequest.position(),
                null);
    }

    public static EmployeeResponse getEmployeeResponseFromEmployee(Employee employee) {
        var managerResponse = EmployeeAdapter.getManagerResponseFromManager(employee.getManager());
        return new EmployeeResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                employee.getPosition(), managerResponse);
    }

    public static EmployeeResponse getManagerResponseFromManager(Employee employee) {
        return new EmployeeResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(),
                employee.getPosition(), null);
    }
}
