package mu.ronaldo.lienquan.Asm.Service;

import lombok.RequiredArgsConstructor;
import mu.ronaldo.lienquan.Asm.Repository.CategoryRepository;
import mu.ronaldo.lienquan.Asm.Repository.CourseRepository;
import mu.ronaldo.lienquan.Asm.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
    }
}
