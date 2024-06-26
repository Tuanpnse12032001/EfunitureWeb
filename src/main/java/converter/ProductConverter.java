package converter;


import com.example.securityl.Responses.ProductResponse;
import com.example.securityl.dtos.ProductDto;
import com.example.securityl.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public static ProductDto toDto(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setThumbnail(entity.getThumbnail());
        dto.setPrice(entity.getPrice());
        dto.setPriceSale(entity.getPriceSale());
        //dto.setRating(entity.getRating());
        dto.setSize(entity.getSize());
        dto.setColor(entity.getColor());
        dto.setCodeProduct(entity.getCodeProduct());
        dto.setStatus(entity.getStatus());
        dto.setDiscount(entity.getDiscount());
        return dto;
    }


    public static Product toEntity(ProductDto dto) {
        Product entity = new Product();
        //entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setThumbnail(dto.getThumbnail());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setPriceSale(dto.getPriceSale());
        //entity.setRating(dto.getRating());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        entity.setCodeProduct(dto.getCodeProduct());
        entity.setStatus(dto.getStatus());
        entity.setDiscount(dto.getDiscount());
//        entity.setCreatedAt(dto.getCreatedAt());
//        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }

    public static Product toEntity(ProductDto dto, Product entity) {
        //Product entity = new Product();
        //entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setThumbnail(dto.getThumbnail());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setPriceSale(dto.getPriceSale());
        //entity.setRating(dto.getRating());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        entity.setCodeProduct(dto.getCodeProduct());
        entity.setStatus(dto.getStatus());
        entity.setDiscount(dto.getDiscount());
        return entity;
    }

    public static ProductResponse toResponse(Product product){
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .thumbnail(product.getThumbnail())
                .description(product.getDescription())
                .priceSale(product.getPriceSale())
                .quantity(product.getQuantity())
                .size(product.getSize())
                .color(product.getColor())
                .codeProduct(product.getCodeProduct())
                //.rating(product.getRating())
                .status(product.getStatus())
                .discount(product.getDiscount())
                .brandId(product.getBrand())
                .tagsProductId(product.getTagsProduct())
                .categoryId(product.getCategory())
                .productImages(product.getProductImages())
                .build();
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());
        return productResponse;
    }
}
