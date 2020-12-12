package com.bingjunior.myapplication.NCRfragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bingjunior.myapplication.Modal.Skel_MissingPersonForm;
import com.bingjunior.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class misspersonregister3 extends Fragment {

    private View v;
    private Button choosephoto, detailnext;
    private Spinner spinnerstate;
    private Spinner spinnerdistrict, spinnerpolice;

    String date_pattern="^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
    private static int RESULT_LOAD_IMAGE = 1;

    private  String stateAnddistrict_API="https://criminal-alert-d5694.firebaseio.com/.json";
    private RequestQueue requestQueue;

    private ArrayList<String> statelist=new ArrayList<>();
    private ArrayList<String> districtlist=new ArrayList<String>();
    private String spinstate,spindistrict;
    private  static String encodedImage;
    public misspersonregister3() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fir_miss_person_register3, container, false);

        spinnerstate = v.findViewById(R.id.spinnerstate);
        spinnerdistrict = v.findViewById(R.id.spinnerdistrict);
        spinnerpolice = v.findViewById(R.id.spinnerpolice);
        choosephoto = v.findViewById(R.id.choosephoto);
        detailnext = v.findViewById(R.id.detailsnext);

        requestQueue= Volley.newRequestQueue(getContext());

        readdata();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, statelist);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.notifyDataSetChanged();
        spinnerstate.setAdapter(adapter);

        spinnerstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 spinstate = adapterView.getItemAtPosition(i).toString();
                Log.i("Item Selected: ", spinstate);
             // spinstate=spinnerstate.getSelectedItem().toString();
//                Log.e("select_item", " "+spinstate );
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> arraydistrictAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, districtlist);
        arraydistrictAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdistrict.setAdapter(arraydistrictAdapter);

        spinnerdistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spindistrict=spinnerdistrict.getSelectedItem().toString();
                Log.e("select_item", " "+spindistrict );

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        choosephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        detailnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Skel_MissingPersonForm MissingPersonFormInstance = Skel_MissingPersonForm.getInstance();
                MissingPersonFormInstance.setState(String.valueOf(spinnerstate));
                MissingPersonFormInstance.setDistrict(String.valueOf(spindistrict));
                MissingPersonFormInstance.setPhoto(String.valueOf(encodedImage));

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ncrframe, new misspersonregister4());
                ft.commit();
            }
        });
        return v;
    }

    private void readdata() {

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,stateAnddistrict_API,new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("states");
                    JSONObject object ;
                    String resultselected = "Bihar";
                  //  String resultselectdistrict ="";

                    for (int i = 0; i < jsonArray.length(); i++) {
                        object = jsonArray.getJSONObject(i);
                    // =============for selecting state===============
                        String state = object.getString("state");
                        statelist.add(state);
                       // Log.e("statelist",state);
                       // String district=object.getString("districts");
                        //  String policestation=object.getString("police");

                       // =============for selecting district===============
                        if (resultselected.equals(state)) {
                            JSONArray jsonArray1 = object.getJSONArray("districts");
                            String district = null;
                            for(int j=0;j<jsonArray1.length();j++){
                                district=jsonArray1.getString(j);
                                districtlist.add(district);
                            }
                          //  Log.e("districtjsonh1ndnd ",""+districtlist);
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("erroe",error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMAGE){
            Uri imageUri = data.getData();
            final InputStream imageStream;
            try {
                imageStream = getActivity().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                encodedImage = encodeImage(selectedImage);
                // uploadimageapicall(encodedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    private String encodeImage(Bitmap selectedImage) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        selectedImage.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

}
