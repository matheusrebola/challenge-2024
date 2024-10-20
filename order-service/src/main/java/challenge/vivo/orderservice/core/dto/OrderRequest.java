package challenge.vivo.orderservice.core.dto;

import java.util.List;

import challenge.vivo.orderservice.core.document.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	private List<Product> products;
}