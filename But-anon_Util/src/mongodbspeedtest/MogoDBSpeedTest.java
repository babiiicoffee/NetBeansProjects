/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodbspeedtest;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author 2ndyrGroupB
 */
public class MogoDBSpeedTest {

    public void insertWithConnection() {
        long start = new Date().getTime() / 1000;
        for (int i = 1; i < 1001; i++) {

            try {
                Logger mongoLogger = Logger.getLogger("org.mongodb.driver"); // Load the driver
                mongoLogger.setLevel(Level.SEVERE); // level of the connection
                MongoClient mongoClient = new MongoClient("localhost", 27017); // create new client
                DB db = mongoClient.getDB("butanon"); // get the database
                DBCollection collection = db.getCollection("myConnection"); // create new colection
                BasicDBObject object = new BasicDBObject("Column_1", i) // create a new object
                        .append("Column_2", i + 1)
                        .append("Column_3", i + 2)
                        .append("Column_4", i + 3)
                        .append("Column_5", i + 4);
                collection.insert(object); // insert the object created into the collection
                System.out.println("Inserted successfully " + object);

            } catch (SecurityException e) {
                System.out.println(e);
            }
        }
        long end = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (end - start));
    }

    public void insertWithOutConnection() {

        long start = new Date().getTime() / 1000;
        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver"); // Load the driver
            mongoLogger.setLevel(Level.SEVERE); // level of the connection
            MongoClient mongoClient = new MongoClient("localhost", 27017); // create new client
            DB db = mongoClient.getDB("butanon"); // get the database
            DBCollection collection = db.getCollection("myConnection"); // create new colection    

            for (int i = 1; i < 1001; i++) {

                BasicDBObject object = new BasicDBObject("Column_1", i) // create a new object
                        .append("Column_2", i + 1)
                        .append("Column_3", i + 2)
                        .append("Column_4", i + 3)
                        .append("Column_5", i + 4);
                collection.insert(object); // insert the object created into the collection
                System.out.println("Inserted successfully " + object);

            }
        } catch (SecurityException e) {
            System.out.println(e);
        }
        long end = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (end - start));
    }

    public void deleteWithConnection() {

        long start = new Date().getTime() / 1000;

        for (int i = 1; i < 1001; i++) {

            try {
                Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
                mongoLogger.setLevel(Level.SEVERE);
                MongoClient mongoClient = new MongoClient("localhost", 27017);
                DB db = mongoClient.getDB("alonzo");
                DBCollection collection = db.getCollection("myConnection");

                BasicDBObject obj = new BasicDBObject("Column_1", i);
                //  Removing data from the collection which has the key of Column_1 with the value equivalent to the value of
                collection.remove(obj);
                System.out.println("Successfully deleted! " + obj);

            } catch (SecurityException e) {
                System.out.println(e);
            }
        }
        long end = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (end - start));
    }

    public void deleteWithOutConnection() {

        long timeStart = new Date().getTime() / 1000;

        try {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("alonzo");
            DBCollection collection = db.getCollection("myConnection");
            for (int i = 1; i < 1001; i++) {
                collection.remove(new BasicDBObject("Column_1", i));
                System.out.println("Successfully deleted! " + i);
            }
        } catch (SecurityException e) {
            System.out.println(e);
        }
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public void getAVGJavaLoop() {

        long timeStart = new Date().getTime() / 1000;
        int avgColumn_1 = 0;
        int avgColumn_2 = 0;
        int avgColumn_3 = 0;
        int avgColumn_4 = 0;
        int avgColumn_5 = 0;
        for (int i = 1; i < 1001; i++) {
            Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
            mongoLogger.setLevel(Level.SEVERE);
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("alonzo");
            DBCollection collection = db.getCollection("myConnection");

            // Creating a database object with the key of Column_1 with the value i
            BasicDBObject query = new BasicDBObject("Column_1", i);
            // Executing the query find() with the value of the object provided above
            DBCursor c = collection.find(query);

            // Iterating through the result of the query
            while (c.hasNext()) {
                avgColumn_1 += Integer.parseInt(c.next().get("Column_1").toString());
            }

            // Creating a database object with the key of Column_2 with the value i + 1
            BasicDBObject query2 = new BasicDBObject("Column_2", i + 1);
            DBCursor c2 = collection.find(query2);

            while (c2.hasNext()) {
                avgColumn_2 += Integer.parseInt(c2.next().get("Column_2").toString());
            }

            // Creating a database object with the key of Column_3 with the value i + 2
            BasicDBObject query3 = new BasicDBObject();
            query3.put("Column_3", i + 2);
            DBCursor c3 = collection.find(query3);

            while (c3.hasNext()) {
                avgColumn_3 += Integer.parseInt(c3.next().get("Column_3").toString());
            }

            // Creating a database object with the key of Column_4 with the value i + 3
            BasicDBObject query4 = new BasicDBObject();
            query4.put("Column_4", i + 3);
            DBCursor c4 = collection.find(query4);

            while (c4.hasNext()) {
                avgColumn_4 += Integer.parseInt(c4.next().get("Column_4").toString());
            }

            // Creating a database object with the key of Column_5 with the value i + 4
            BasicDBObject query5 = new BasicDBObject();
            query5.put("Column_5", i + 4);
            DBCursor c5 = collection.find(query5);

            while (c5.hasNext()) {
                avgColumn_5 += Integer.parseInt(c5.next().get("Column_5").toString());
            }

        }

        System.out.println(avgColumn_1 / 1000);
        System.out.println(avgColumn_2 / 1000);
        System.out.println(avgColumn_3 / 1000);
        System.out.println(avgColumn_4 / 1000);
        System.out.println(avgColumn_5 / 1000);

        long timeFinish = new Date().getTime() / 1000;

        System.out.println("Time interval in milliseconds: " + (timeFinish - timeStart));
    }

    int avgColumn_1 = 0;
    int avgColumn_2 = 0;
    int avgColumn_3 = 0;
    int avgColumn_4 = 0;
    int avgColumn_5 = 0;

    public void getAVGAggregation() {

        long timeStart = new Date().getTime() / 1000;
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("alonzo");
        MongoCollection<Document> collection = database.getCollection("myConnection");

        Block<Document> addCol1Value = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                avgColumn_1 += Integer.parseInt(document.get("_id").toString());
            }
        };
        Block<Document> addCol2Value = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                avgColumn_2 += Integer.parseInt(document.get("_id").toString());
            }
        };
        Block<Document> addCol3Value = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                avgColumn_3 += Integer.parseInt(document.get("_id").toString());
            }
        };
        Block<Document> addCol4Value = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                avgColumn_4 += Integer.parseInt(document.get("_id").toString());
            }
        };
        Block<Document> addCol5Value = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                avgColumn_5 += Integer.parseInt(document.get("_id").toString());
            }
        };
        for (int i = 1; i < 1001; i++) {
            collection.aggregate(
                    Arrays.asList(
                            Aggregates.match(Filters.eq("Column_1", i)),
                            Aggregates.group("$Column_1")
                    )
            ).forEach(addCol1Value);

            collection.aggregate(
                    Arrays.asList(
                            Aggregates.match(Filters.eq("Column_2", i + 1)),
                            Aggregates.group("$Column_2")
                    )
            ).forEach(addCol2Value);

            collection.aggregate(
                    Arrays.asList(
                            Aggregates.match(Filters.eq("Column_3", i + 2)),
                            Aggregates.group("$Column_3")
                    )
            ).forEach(addCol3Value);

            collection.aggregate(
                    Arrays.asList(
                            Aggregates.match(Filters.eq("Column_4", i + 3)),
                            Aggregates.group("$Column_4")
                    )
            ).forEach(addCol4Value);

            collection.aggregate(
                    Arrays.asList(
                            Aggregates.match(Filters.eq("Column_5", i + 4)),
                            Aggregates.group("$Column_5")
                    )
            ).forEach(addCol5Value);
        }
        System.out.println("Column 1 Average: " + avgColumn_1 / 1000);
        System.out.println("Column 2 Average: " + avgColumn_2 / 1000);
        System.out.println("Column 3 Average: " + avgColumn_3 / 1000);
        System.out.println("Column 4 Average: " + avgColumn_4 / 1000);
        System.out.println("Column 5 Average: " + avgColumn_5 / 1000);
        long timeFinish = new Date().getTime() / 1000;
        System.out.println("Time interval in seconds: " + (timeFinish - timeStart));
    }

    public static void main(String[] args) {
        MogoDBSpeedTest db = new MogoDBSpeedTest();

//        db.insertWithConnection();
//            db.deleteWithConnection();
//            db.insertWithOutConnection();
            db.deleteWithOutConnection();

//        db.getAVGAggregation();
//        db.GetAverageUsingJavaLoop();
    }
}
