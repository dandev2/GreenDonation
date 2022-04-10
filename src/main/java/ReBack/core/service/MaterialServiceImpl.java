package ReBack.core.service;

import ReBack.core.data.Material;
import ReBack.core.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;

    public Material findMaterialId(Long material) {
        Optional<Material> findMaterialId = materialRepository.findById(material);
        return findMaterialId.get();
    }

}
