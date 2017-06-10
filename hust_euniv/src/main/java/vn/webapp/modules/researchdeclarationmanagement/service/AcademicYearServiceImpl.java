package vn.webapp.modules.researchdeclarationmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.webapp.modules.researchdeclarationmanagement.dao.AcademicYearDAO;
import vn.webapp.modules.researchdeclarationmanagement.model.AcademicYear;

@Service("academicYearService")
public class AcademicYearServiceImpl implements AcademicYearService {
	@Autowired
    private AcademicYearDAO academicYearDAO;

    /**
     * Get all list of academic year
     * @param null
     * @return List
     */
    @Override
    public List<AcademicYear> list(){
    	return academicYearDAO.getList();
    }
}
