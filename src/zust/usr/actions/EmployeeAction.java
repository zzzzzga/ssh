package zust.usr.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

import zust.usr.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware {

	private EmployeeService employeeService;
	private Integer id;

	private InputStream inputStream;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String list() {
		request.put("employees", employeeService.getAll());
		return "list";
	}

	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			inputStream = new ByteArrayInputStream("0".getBytes());
		}
		return "delete";
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

}
