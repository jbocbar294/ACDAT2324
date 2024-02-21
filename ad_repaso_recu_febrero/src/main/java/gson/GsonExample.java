package gson;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

    private static Data[] dataArray;
    private static List<Data> dataList;
    private static Data objetData;

    public static void main(String[] args) {
        initData();
        //toJsonExamples();
        fromJsonExamples();
        dateFormatExamples();
    }

    private static void initData() {
        dataArray = new Data[3];
        for (int i = 0; i < dataArray.length; i++) {
            dataArray[i] = new Data("a String " + i, i, new Date());
        }
        dataList = new LinkedList<>();
        for (Data dato : dataArray) {
            dataList.add(dato);
        }
    }

    private static void toJsonExamples() {
        Gson gson = new Gson();

        System.out.println(gson.toJson(new Data("string", 10, new Date())));
        System.out.println("-----------------------------------------------------------");
        System.out.println(gson.toJson(dataArray));
        System.out.println("-----------------------------------------------------------");
        System.out.println(gson.toJson(dataList));
    }

    private static void fromJsonExamples() {
        Gson gson = new Gson();
        String json = "{'aString':'from Parsed String','aInt':33,'aDate':'Feb 26, 2014 7:35:23 PM'}";

        objetData = gson.fromJson(json, Data.class);
        System.out.println("-----------------------------------------------------------");
        System.out.println(objetData.toString());

        String jsonList = gson.toJson(dataList);

        List<Data> parsedDataList = (List<Data>) gson.fromJson(jsonList, List.class);
        for (int i = 0; i < parsedDataList.size(); i++) {
            System.out.println("-----------------------------------------------------------");
            System.out.print(parsedDataList.get(i));
        }
        System.out.println();

        Data[] parsedDataArray = gson.fromJson(jsonList, Data[].class);
        for (Data data : parsedDataArray) {
            System.out.println("-----------------------------------------------------------");
            System.out.print(data);
        }
        System.out.println();
    }

    private static void dateFormatExamples() {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yy HH:mm:ss").create();

        System.out.println(gson.toJson(new Date()));
    }
}
