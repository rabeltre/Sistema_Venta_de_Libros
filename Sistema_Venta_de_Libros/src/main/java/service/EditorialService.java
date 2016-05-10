package service;

import model.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.EditorialDao;

import java.util.List;

/**
 * Created by root on 03/05/16.
 */
@Service("editorialService")
public class EditorialService implements EditorialDao{
    @Autowired
    private EditorialDao editorialDao;

            @Override
    public Editorial findById(String s) {
        return editorialDao.findById(s);
    }

    @Override
    public List<Editorial> findAll() {
        return editorialDao.findAll();
    }

    @Override
    public Editorial makePersistent(Editorial entity) {
        return editorialDao.makePersistent(entity);
    }
}
