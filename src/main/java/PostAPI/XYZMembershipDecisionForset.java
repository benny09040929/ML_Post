package PostAPI;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Benny on 17/3/2.
 */
public class XYZMembershipDecisionForset {

    public static void main(String[] args) throws Exception {

        XYZMembershipDecisionForset http = new XYZMembershipDecisionForset();
        http.sendPost();
    }

    // HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://ussouthcentral.services.azureml.net/workspaces/7991482199fc42709352457b05997aed/services/371789184b41483f813c5bbcdbd58cac/execute?api-version=2.0&details=true";
        String api_key = "UpxW4GXXvmyLZTYUIJF7M6Q4vhFPP+UMmoj8BozBx70CnIEQ1rWf7F+E06d3g4uCfHlyl2+eY03Xjw5kLAG90A==";

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

        String[] ColumData = {"member_id","identifier_explain","member_identifier","membership_active","product_name","bought_where"};
        String[] ValueData = {"0","value","0","0","value","value"};


        for(int i =0 ; i < ColumData.length ; i++){
            ColumnNames.put(ColumData[i]);
            Values.put(ValueData[i]);
        }

        Values2.put(Values);
        Inputs.put("input1",input1);
        input1.put("ColumnNames",ColumnNames);
        input1.put("Values",Values2);
        Data.put("Inputs",Inputs);

        return Data;

    }
}
