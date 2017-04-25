package main.services;

import main.models.dao.PlanDao;
import main.models.dao.PlanDaoImpl;
import main.models.pojo.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
@Service
public class PlanServiceImpl implements PlanService {

    public PlanDao planDao;

    public PlanDao getPlanDao() {
        return planDao;
    }

    @Autowired
    public void setPlanDao(PlanDao planDao) {
        this.planDao = planDao;
    }

    public List<Plan> getAllPlans() {
        return planDao.getAll(true);
    }

    public boolean deletePlanById(Integer id) {
        return planDao.delete(id);
    }
}
