package PostAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Benny on 17/3/2.
 */
public class MLPostEcample {

    public static void main(String[] args) throws Exception {

        MLPostEcample http = new MLPostEcample();
        http.sendPost();
    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://ussouthcentral.services.azureml.net/workspaces/7991482199fc42709352457b05997aed/services/d80577b40c3a4ec49948ddfcb73d0ef9/execute?api-version=2.0&details=true";
        String api_key = "tQxHbm0dN3M2PMGPBn7/fO5C9tglzBdOf4FzJgS2k+/cvd8wXxGoTN8IEvNhJak/LYvfjw+Wij4pr90NrI7Log==";

        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost(url);
        StringEntity urlParameters = new StringEntity(JsonData().toString());
        post.setEntity(urlParameters);

        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer "+api_key);

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        System.out.println(result.toString());

    }

    public static JSONObject JsonData()throws Exception{

        JSONObject Inputs = new JSONObject();
        JSONObject input1 = new JSONObject();
        JSONArray ColumnNames = new JSONArray();
        JSONArray Values = new JSONArray();
        JSONObject Data = new JSONObject();
        JSONArray Values2 = new JSONArray();

        ColumnNames.put("symboling");
        ColumnNames.put("normalized-losses");
        ColumnNames.put("make");
        ColumnNames.put("fuel-type");
        ColumnNames.put("aspiration");
        ColumnNames.put("num-of-doors");
        ColumnNames.put("body-style");
        ColumnNames.put("drive-wheels");
        ColumnNames.put("engine-location");
        ColumnNames.put("wheel-base");
        ColumnNames.put("length");
        ColumnNames.put("width");
        ColumnNames.put("height");
        ColumnNames.put("curb-weight");
        ColumnNames.put("engine-type");
        ColumnNames.put("num-of-cylinders");
        ColumnNames.put("engine-size");
        ColumnNames.put("fuel-system");
        ColumnNames.put("bore");
        ColumnNames.put("stroke");
        ColumnNames.put("compression-ratio");
        ColumnNames.put("horsepower");
        ColumnNames.put("peak-rpm");
        ColumnNames.put("city-mpg");
        ColumnNames.put("highway-mpg");
        ColumnNames.put("price");

        Values.put("0");
        Values.put("0");
        Values.put("value");
        Values.put("value");
        Values.put("value");
        Values.put("value");
        Values.put("value");
        Values.put("value");
        Values.put("value");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("value");
        Values.put("value");
        Values.put("0");
        Values.put("value");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");
        Values.put("0");

        Values2.put(Values);
        Inputs.put("input1",input1);
        input1.put("ColumnNames",ColumnNames);
        input1.put("Values",Values2);
        Data.put("Inputs",Inputs);

        return Data;

    }
}
