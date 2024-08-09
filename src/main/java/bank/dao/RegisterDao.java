package bank.dao;
import java.util.*;

import bank.model.Register;
public interface RegisterDao {
	
	int createRecord(List<Register> reglst);
	int deleteRecord(int accNo);
	int updateRecord(List<Register> reglst);
	List<Register> retriveRecord(int accNo);
	List<Register> displayAll();

	
	

}
