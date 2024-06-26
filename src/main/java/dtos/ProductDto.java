package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto extends BaseDto{
    private Long id;
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    private String name;
    private String description;
    private String thumbnail;
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Max(value = 10000000, message = "Price must be less than or equal to 10,000,000")
    private double price;
    @Min(value = 0, message = "Price sale must be greater than or equal to 0")
    @JsonProperty("price_sale")
    private double priceSale;
    @Min(value = 1, message = "Quantity must be greater than or equal to 0")
    private int quantity;
    private String material;
    private String size;
    private int color;
    private String codeProduct;
    @JsonProperty("quantity_sold")
    private int quantitySold;
    private int status;
    //private Double rating;
    private Double discount;
    @JsonProperty("category_id")
    private Long categoryId;  // Field to represent Category ID
    @JsonProperty("brand_id")
    private Long brandId;     // Field to represent Brand ID
    @JsonProperty("tags_product_id")
    private Long tagsProductId; // Field to represent TagsProduct ID
    private List<ProductImageDto> productImages;
}
