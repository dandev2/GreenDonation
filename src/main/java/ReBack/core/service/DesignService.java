package ReBack.core.service;

import ReBack.core.data.Design;
import ReBack.core.dto.DesignDTO;

public interface DesignService {
    String register(DesignDTO dto);

    void save(Design design);
}
