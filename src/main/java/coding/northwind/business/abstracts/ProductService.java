package coding.northwind.business.abstracts;

import java.util.List;



import coding.northwind.core.utilities.results.DataResult;
import coding.northwind.core.utilities.results.Result;
import coding.northwind.entities.concretes.Product;
import coding.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	Result add(Product product);
	DataResult<List<Product>> getAllSorted();
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName
			,int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName
			,int categoryId);
	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContans(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	

	DataResult<List<Product>> GetByNameAndCategory(String productName
			,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
	
	
}
