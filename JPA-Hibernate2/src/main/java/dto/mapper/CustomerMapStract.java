package dto.mapper;
/*
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dto.CustomerDto;
import model.Customer;

@Mapper
public interface CustomerMapper {
	// public static final 
	CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
	
	//MapStruct 會自動對應欄位名稱相同的屬性；忽略 Customer order這個欄位
	@Mapping(target = "order", ignore = true)
	CustomerDto customerToDto(Customer customer);
	
	// 如果要支援反向轉換，也可以加這個：
    @InheritInverseConfiguration
    Customer dtoToCustomer(CustomerDto dto);
    
	// 除了 maven dependencies  還有很設定要做
}
*/