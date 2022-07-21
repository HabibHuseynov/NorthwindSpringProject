package coding.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import coding.northwind.business.abstracts.ProductService;
import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.core.utilities.results.SuccessDataResult;
import coding.northwind.core.utilities.results.SuccessResult;
import coding.northwind.dataAccess.abstracts.ProductDao;
import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager  implements ProductService{

	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(),"find all");
	
	}
	@Override
	public Result add(Product product) {
		// TODO Auto-generated method stub
		this.productDao.save(product);
		return new SuccessResult("Product save");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"find all");
	}
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"find all");
	}
	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"find all");
	
	}
	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategory_CategoryIdIn(categories),"find all");
	
	}
	@Override
	public DataResult<List<Product>> getByProductNameContans(String productName) {
	
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"find all");
	
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"find all");
	
	}
	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.GetByNameAndCategory(productName,categoryId),"find all");
	}
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		Pageable pageable =PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort));
	}
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		System.out.println(this.productDao.getProductWithCategoryDetails());
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"find all");
	}

}
