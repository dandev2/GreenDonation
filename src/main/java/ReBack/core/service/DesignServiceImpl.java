package ReBack.core.service;

import ReBack.core.data.Design;
import ReBack.core.dto.DesignDTO;
import ReBack.core.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignServiceImpl implements DesignService {

    @Autowired
    DesignRepository designRepository;

    @Override
    public String register(DesignDTO dto) {
        return null;
    }

    @Override
    public void save(Design design) {
        Design save = designRepository.save(design);
        System.out.println("save : "+save);
    }

}
