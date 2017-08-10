package hbi.core.exam.dto;

import com.hand.hap.system.dto.BaseDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Bale on 2017/8/4.
 */

@Table(name = "hap_om_order_headers")
public class OmOrderHeaders extends BaseDTO {

    @Id
    @GeneratedValue
    private Long headerId; //订单头ID

    private String orderNumber; //订单编号

    private Long companyId; //公司ID

    private Date orderDate; //订单日期

    private String orderStatus; //订单状态

    private Long customerId; //客户ID

    //----------------------页面需要的数据----------------------//


    @Transient
    private String companyName; // 公司名称

    @Transient
    private String customerName;    //客户名称

    @Transient
    private Long orderSum;   //订单金额

    //----------------------查询需要的数据---------------------//

    @Transient
    private Long inventoryItemId;       //产品(物料) id


    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(Long orderSum) {
        this.orderSum = orderSum;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    @Override
    public String toString() {
        return "OmOrderHeaders{" +
                "headerId=" + headerId +
                ", orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerId=" + customerId +
                ", companyName='" + companyName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderSum='" + orderSum + '\'' +
                '}';
    }
}
