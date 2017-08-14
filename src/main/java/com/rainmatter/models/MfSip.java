package com.rainmatter.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A wrapper for Mutualfunds sip.
 */
public class MfSip {
    @SerializedName("dividend_type")
    public String dividendType;
    @SerializedName("pending_instalments")
    public int pendingInstalments;
    @SerializedName("created")
    public String created;
    @SerializedName("last_instalment")
    public String lastInstalment;
    @SerializedName("transaction_type")
    public String transactionType;
    @SerializedName("frequency")
    public String frequency;
    @SerializedName("instalment_date")
    public int instalmentDate;
    @SerializedName("fund")
    public String fund;
    @SerializedName("sip_id")
    public String sipId;
    @SerializedName("tradingsymbol")
    public String tradingsymbol;
    @SerializedName("tag")
    public String tag;
    @SerializedName("instalment_amount")
    public int instalmentAmount;
    @SerializedName("instalments")
    public int instalments;
    @SerializedName("status")
    public String status;
    @SerializedName("order_id")
    public String orderId;

    public List<MfSip> mfSips = new ArrayList<>();

    /** Parse mutualfunds sip list.
     * @param response is the JSONObject response which contains array of sip.
     * @throws JSONException is thrown when there is error while parsing response.
     * */
    public void parseMfSips(JSONObject response) throws JSONException{
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        mfSips = Arrays.asList(gson.fromJson(String.valueOf(response.get("data")), MfSip[].class));
    }

    /** Parse individual sip response.
     * @param response is the JSONObject response which contains one sip.
     * @throws JSONException is thrown when there is error while parsing response.
     * @return MfSip is the details of the individual Sip.
     * */
    public MfSip parseMfSip(JSONObject response) throws JSONException{
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response.get("data").toString(), MfSip.class);
    }

    /** Parse sip place response.
     * @param response is the JSONObject response which contains order id and sip id.
     * @throws JSONException is thrown when there is error while parsing response.
     * */
    public void parseMfSipPlaceResponse(JSONObject response) throws JSONException{
        this.orderId = response.getJSONObject("data").getString("order_id");
        this.sipId = response.getJSONObject("data").getString("sip_id");
    }
}
