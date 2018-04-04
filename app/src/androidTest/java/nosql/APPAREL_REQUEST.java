package nosql;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@DynamoDBTable(tableName = "supplydrop-mobilehub-503652753-APPAREL_REQUEST")

public class APPAREL_REQUEST {

    private Double _requestID;
    private Boolean _coat;
    private Boolean _sleepingEquipment;
    private Boolean _socks;
    private Boolean _underwear;

    @DynamoDBHashKey(attributeName = "requestID")
    @DynamoDBAttribute(attributeName = "requestID")
    public Double getRequestID() {
        return _requestID;
    }

    public void setRequestID(final Double _requestID) {
        this._requestID = _requestID;
    }
    @DynamoDBAttribute(attributeName = "coat")
    public Boolean getCoat() {
        return _coat;
    }

    public void setCoat(final Boolean _coat) {
        this._coat = _coat;
    }
    @DynamoDBAttribute(attributeName = "sleepingEquipment")
    public Boolean getSleepingEquipment() {
        return _sleepingEquipment;
    }

    public void setSleepingEquipment(final Boolean _sleepingEquipment) {
        this._sleepingEquipment = _sleepingEquipment;
    }
    @DynamoDBAttribute(attributeName = "socks")
    public Boolean getSocks() {
        return _socks;
    }

    public void setSocks(final Boolean _socks) {
        this._socks = _socks;
    }
    @DynamoDBAttribute(attributeName = "underwear")
    public Boolean getUnderwear() {
        return _underwear;
    }

    public void setUnderwear(final Boolean _underwear) {
        this._underwear = _underwear;
    }

}