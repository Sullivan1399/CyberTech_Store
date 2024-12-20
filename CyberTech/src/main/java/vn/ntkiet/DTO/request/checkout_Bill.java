package vn.ntkiet.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class checkout_Bill
{
    private List<checkout_BillDetail> billDetails;
    @NotNull(message = "Hãy chọn phương thức thanh toán")
    private Integer status = 1;
    private BigDecimal total;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private String formatted_price;
    public checkout_Bill()
    {
        
    }
    public checkout_Bill(List<checkout_BillDetail> billDetails)
    {
        this.total=new BigDecimal(0);
        if(billDetails==null)
        {
            this.billDetails = new ArrayList<>();
        }
        else
        {
            this.billDetails = billDetails;
            for(checkout_BillDetail billDetail : billDetails)
            {
                this.total=this.total.add(billDetail.getProductNewPrice());
            }
        }
        this.formatted_price = decimalFormat.format(total);
    }
}
