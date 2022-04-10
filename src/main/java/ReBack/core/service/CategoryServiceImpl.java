package ReBack.core.service;

import ReBack.core.data.Category;
import ReBack.core.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public Category findCategoryId(Long category) {
        Optional<Category> findCategoryId = categoryRepository.findById(category);
        return findCategoryId.get();
    }
}
