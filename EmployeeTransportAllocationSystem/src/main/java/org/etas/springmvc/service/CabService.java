package org.etas.springmvc.service;

import java.util.List;

import org.etas.springmvc.bean.Cab;
import org.etas.springmvc.dao.CabDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cabService")
public class CabService {

    @Autowired
    CabDAO cabDao;

    @Transactional
    public List<Cab> getAllCabs() {
        return cabDao.getAllCabs();
    }

    @Transactional
    public Cab getCab(int cabId) {
        return cabDao.getCab(cabId);
    }

    @Transactional
    public void addCab(Cab cab) {
        cabDao.addCab(cab);
    }

    @Transactional
    public void updateCab(Cab cab) {
        cabDao.updateCab(cab);

    }

    @Transactional
    public void deleteCab(int cabId) {
        cabDao.deleteCab(cabId);
    }

    @Transactional
    public void setCabStatusToAvailable(int cabId) {
        cabDao.setCabStatusToAvailable(cabId);
    }

    @Transactional
    public void setCabStatusToUnavailable(int cabId) {
        cabDao.setCabStatusToUnavailable(cabId);
    }

}
