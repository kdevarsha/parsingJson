package com.parseJsondata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.apache.avro.Schema;
import org.apache.avro.generic.IndexedRecord;
import org.kitesdk.data.spi.JsonUtil;

public class consumerRecordBackup implements IndexedRecord{
    @JsonProperty(value = "payload", required = true)
    private Object payload;
    public Object getPayload() {
        return payload;
    }
    public consumerRecordBackup(Object payload) {
        this.payload = payload;
    }
    public void setPayload(Object payload) {
        this.payload = payload;
    }
    @JsonIgnore private Map<Integer, Object> objectMap = new HashMap<>();
    @Override
    public void put(int i, Object v) {
        objectMap.put(i, v);
    }
    @Override
    public Object get(int i) {
        return objectMap.get(i);
    }
    @JsonIgnore
    @Override
    public Schema getSchema() {
        JsonNode node = new ObjectMapper().convertValue(this, JsonNode.class);
        return JsonUtil.inferSchema(node, "RecordName");
    }
}
