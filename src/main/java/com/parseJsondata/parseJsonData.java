package com.parseJsondata;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.avro.Schema;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericData;
import org.apache.hadoop.fs.Path;
import org.kitesdk.data.spi.JsonUtil;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.avro.AvroParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.hadoop.conf.Configuration;
public class parseJsonData {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File( "test.json"));
        List<JSONObject> jsonArray = new ArrayList<JSONObject>();
        while (scanner.hasNext()) {
            JSONObject obj = (JSONObject) new JSONParser().parse(scanner.nextLine());
            jsonArray.add(obj);
        }
        jsonArray.forEach(emp ->{
            JSONObject mainObject = new JSONObject(emp);
            //val posts = mainObject.getJSONObject("posts");
            List<JSONObject> list = new ArrayList<JSONObject>();
            //ArrayList list = new ArrayList<mainObject>();
            HashMap<String,Object> result = new ObjectMapper().readValue(emp, HashMap.class);
            val map = mainObject.keys();
            System.out.println("Mowa bro eee line add chesa")
            while (map.hasNext()) {
                var key = map.next().toString()
                var jsonObject = posts.getJSONObject(key)
                val gson = Gson()
                val kk: Objects = gson.fromJson(jsonObject.toString(), Objects::class.java)
                list.add(kk)
                Log.e("key", key)
            }
        });
//        jsonArray.forEach(emp -> {
//            try {
//                parseEmpObj((JSONObject) emp);
//            } catch (java.text.ParseException | IOException e) {
//                e.printStackTrace();
//            }
//        });
//
//    }
//    private static void parseEmpObj(JSONObject obj) throws java.text.ParseException, IOException {
//        JSONObject jsonObject1 = (JSONObject)obj;
//        String date = (String) jsonObject1.get("local_start_time");
//        //System.out.println("Created Date: " + date);
//        parseJsonData.createFolder(date, obj);
//
//    }
//
//    public static void createFolder(String par1, JSONObject data) throws java.text.ParseException, IOException {
//        String string1 = par1;
//        JSONObject jsonObject2 = (JSONObject)data;
//        String date = string1.substring(0,10);
//        String time = string1.substring(11,13);
//        //System.out.println(time);
////        File theDir = new File(date+"/"+time);
////        if (!theDir.exists()){
////            theDir.mkdirs();
////        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode node = objectMapper.convertValue(jsonObject2, JsonNode.class);
//        consumerRecordBackup record = new consumerRecordBackup(node);
//        Schema jsonSchema = JsonUtil.inferSchema(node, "RecordName");
//        try (ParquetWriter<consumerRecordBackup> writer = AvroParquetWriter
//                .<consumerRecordBackup>builder(new Path(date+"/"+time+"/"+"Hello."+new Random().nextInt()+".snappy"+".parquet"))
//                .withConf(new Configuration())
//                .withCompressionCodec(CompressionCodecName.SNAPPY)
//                .withSchema(jsonSchema)
//                .build()) {
//            writer.write(record);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
       }
//

}




