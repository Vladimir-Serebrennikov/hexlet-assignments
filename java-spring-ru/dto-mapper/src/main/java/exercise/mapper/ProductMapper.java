package exercise.mapper;

// BEGIN
import exercise.dto.ProductUpdateDTO;
import org.mapstruct.*;

import exercise.model.Product;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(target = "name", source = "title")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "title", source = "name")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "vendorCode", source = "barcode")
    public abstract ProductDTO map(Product model);
}
// END
