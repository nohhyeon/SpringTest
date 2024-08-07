package su.spring.dept.dao;

import java.util.List;
import su.spring.dept.dto.DeptDTO;

public interface DeptDAO {
	public List<DeptDTO> selectAll();

	public DeptDTO select(int deptno);

	public void insert(DeptDTO deptDTO);

	public void update(DeptDTO deptDTO);

	public void delete(int deptno);
}
