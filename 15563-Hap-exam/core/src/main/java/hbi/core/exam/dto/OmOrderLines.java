package hbi.core.exam.dto;

import com.hand.hap.system.dto.BaseDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by Bale on 2017/8/5.
 */

@Table(name = "hap_om_order_lines")
public class OmOrderLines extends BaseDTO {

    //---------------------------------table 信息-----------------------------------//
    @Id
    @GeneratedValue
    private Long lineId; //订单行ID

    private Long headerId; //订单头ID

    private Long lineNumber; //行号

    private Long inventoryItemId; //产品ID

    private Long orderdQuantity; //数量

    private String orderQuantityUom; //产品单位

    private Long unitSellingPrice; //销售单价

    private String description; //备注

    private Long companyId; //公司ID

    //---------------------------------附加信息---------------------------------//
    @Length(max = 150)
    private String addition1; //附加信息1

    @Length(max = 150)
    private String addition2; //附加信息2

    @Length(max = 150)
    private String addition3; //附加信息3

    @Length(max = 150)
    private String addition4; //附加信息4

    @Length(max = 150)
    private String addition5; //附加信息5

    //-----------------------------------页面需求信息-----------------------------------//

    @Transient
    private String itemCode;    //物料编码

    @Transient
    private String itemDescription;       //物料描述

    @Transient
    private Long amount;        //金额

    //---------------------------------------geter seter--------------------------------------//

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public Long getOrderdQuantity() {
        return orderdQuantity;
    }

    public void setOrderdQuantity(Long orderdQuantity) {
        this.orderdQuantity = orderdQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public Long getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Long unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OmOrderLines{" +
                "lineId=" + lineId +
                ", headerId=" + headerId +
                ", lineNumber=" + lineNumber +
                ", inventoryItemId=" + inventoryItemId +
                ", orderdQuantity=" + orderdQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", description='" + description + '\'' +
                ", companyId=" + companyId +
                ", addition1='" + addition1 + '\'' +
                ", addition2='" + addition2 + '\'' +
                ", addition3='" + addition3 + '\'' +
                ", addition4='" + addition4 + '\'' +
                ", addition5='" + addition5 + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", amount=" + amount +
                '}';
    }
}
