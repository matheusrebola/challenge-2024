package challenge.vivo.searchservice.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import challenge.vivo.searchservice.core.document.SearchProduct;

public interface SearchProductRepository extends MongoRepository<SearchProduct,String>{
}
