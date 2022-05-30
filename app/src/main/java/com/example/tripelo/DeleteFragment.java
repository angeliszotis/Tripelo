package com.example.tripelo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripelo.RoomDB.PacketTrip;
import com.example.tripelo.RoomDB.SuggestTrip;
import com.example.tripelo.RoomDB.TravelAgency;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteFragment extends Fragment {
    TextView ta_id,ta_name , ta_street,st_id, st_country, st_city, st_time,pt_id, pt_price,pt_time;
    Button button_create_entry;
    TravelAgency ta = new TravelAgency();
    SuggestTrip st = new SuggestTrip();
    PacketTrip pt = new PacketTrip();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteFragment newInstance(String param1, String param2) {
        DeleteFragment fragment = new DeleteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_delete, container, false);

        ta_id = view.findViewById(R.id.editTextTA_id_delete);
        ta_name =view.findViewById(R.id.editTextTextPersonName_delete);
        ta_street = view.findViewById(R.id.editTextStreeName_delete);
        st_id = view.findViewById(R.id.editTextST_id_delete);
        st_country = view.findViewById(R.id.editTextCountry_delete);
        st_city = view.findViewById(R.id.editTextCity_delete);
        st_time = view.findViewById(R.id.editTextTimePeriod_delete);
        pt_id = view.findViewById(R.id.editTextPT_id_delete);
        pt_price = view.findViewById(R.id.editTextPrice_delete);
        pt_time = view.findViewById(R.id.editTextStartTime_delete);

        button_create_entry = view.findViewById(R.id.button_crete_entry_delete);


        // Listener TA ID ON CHANGE
        ta_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!ta_id.getText().toString().isEmpty()){
                    getDataTA(Integer.parseInt(ta_id.getText().toString()));
                }

                //Integer.parseInt(String.valueOf(ta_id.getText()))
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // Listener st ID ON CHANGE

        st_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!st_id.getText().toString().isEmpty()){
                    getDataST(Integer.parseInt(st_id.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        // LISTENER PT

        pt_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!pt_id.getText().toString().isEmpty()){
                    getDataPT(Integer.parseInt(pt_id.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        button_create_entry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!st_country.getText().toString().isEmpty() & !st_city.getText().toString().isEmpty() & !st_time.getText().toString().isEmpty() & !ta_name.getText().toString().isEmpty() & !ta_street.getText().toString().isEmpty() & !ta_id.getText().toString().isEmpty() & !st_id.getText().toString().isEmpty() & !pt_time.getText().toString().isEmpty() & !pt_price.getText().toString().isEmpty() ){
                    PT();
                }
                else if(!st_country.getText().toString().isEmpty() & !st_city.getText().toString().isEmpty() & !st_time.getText().toString().isEmpty() & !ta_name.getText().toString().isEmpty() & !ta_street.getText().toString().isEmpty()) {
                    TA();
                    ST();
                }
                else if(!st_country.getText().toString().isEmpty() & !st_city.getText().toString().isEmpty() & !st_time.getText().toString().isEmpty()) {

                    ST();
                }
                else if(!ta_name.getText().toString().isEmpty() & !ta_street.getText().toString().isEmpty()){
                    TA();
                }
                else{
                    Toast.makeText(getActivity(), "Fill the TextFields to Crete New Add.",Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }


    public void getIDforCreate(){
        //TA
        String idNum="";
        List<Integer> integers2 = MainActivity.myAppDatabase.mydao().getLastRecordTA();

        for (Integer i: integers2) {
            idNum = idNum +  i ;
        }

        if(!idNum.isEmpty()){
            idNum = ""+(Integer.parseInt(idNum)+1);}
        ta_id.setText(idNum);

        // ST
        for(Integer i : integers2){
            integers2.remove(i);
        }
        idNum="";
        integers2 = MainActivity.myAppDatabase.mydao().getLastRecordST();
        for (Integer i : integers2) {
            idNum = idNum +  i ;
        }

        if(!idNum.isEmpty()){
            idNum = String.valueOf(Integer.parseInt(idNum)+1);}

        st_id.setText(idNum);

        //PT
        for(Integer i : integers2){
            integers2.remove(i);
        }
        idNum="";
        integers2 = MainActivity.myAppDatabase.mydao().getLastRecordPT();
        for (Integer i : integers2) {
            idNum = idNum +  i ;
        }
        if(!idNum.isEmpty()){idNum = String.valueOf(Integer.parseInt(idNum)+1);}

        pt_id.setText(idNum);

    }
    public void TA(){

        String var_ta_name = ta_name.getText().toString();
        String var_ta_street = ta_street.getText().toString();
        String var_ta_id = ta_id.getText().toString();


        ta.setKwdikos(Integer.parseInt(var_ta_id));
        ta.setTravel_agency_name(var_ta_name);
        ta.setTravel_agency_street(var_ta_street);


        try {
            ta.setKwdikos(Integer.parseInt(var_ta_id));
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }

        try {
            ta.setTravel_agency_name(var_ta_name);
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }

        try {
            ta.setKwdikos(Integer.parseInt(var_ta_id));
            ta.setTravel_agency_name(var_ta_name);
            ta.setTravel_agency_street(var_ta_street);
            MainActivity.myAppDatabase.mydao().deleteTA(ta);
            Toast.makeText(getActivity(), "Travel Agency Deleted Succefuly!",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }



    }

    public void ST(){

        String var_st_country = st_country.getText().toString();
        String var_st_city = st_city.getText().toString();
        String var_st_time = st_time.getText().toString();
        String var_st_id = st_id.getText().toString();



        st.setKwdikos(Integer.parseInt(var_st_id));
        st.setCountry(var_st_country);
        st.setCity(var_st_city);
        st.setTime(var_st_time);


        try {
            st.setKwdikos(Integer.parseInt(var_st_id));
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }

        try {
            st.setCountry(var_st_country);
            st.setCity(var_st_city);
            st.setTime(var_st_time);
            MainActivity.myAppDatabase.mydao().deleteST(st);
            Toast.makeText(getActivity(),"Suggest Trip Deleted Succefuly!",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }
        st_country.setText("");
        st_city.setText("");
        st_time.setText("");





    }


    public void PT(){

        String var_pt_price = pt_price.getText().toString();
        String var_pt_time = pt_time.getText().toString();
        String var_ta_id = ta_id.getText().toString();
        String var_st_id = st_id.getText().toString();
        String var_pt_id = pt_id.getText().toString();




        try {
            pt.setKwd_travel_agency(Integer.parseInt(var_ta_id));
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }
        try {
            pt.setKwd_trip(Integer.parseInt(var_st_id));
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }
        try {
            pt.setKwdikos(Integer.parseInt(var_pt_id));
        } catch (NumberFormatException ex) {
            System.out.println("Could not parse " + ex);
        }

        try {
            pt.setPrice(var_pt_price);
            pt.setTime_to_start(var_pt_time);
            MainActivity.myAppDatabase.mydao().deletePT(pt);
            Toast.makeText(getActivity(), "Packet Trip Deleted Succefuly!",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            String message = e.getMessage();
            Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
        }


        pt_price.setText("");
        pt_time.setText("");





    }

    public void getDataTA(int id) {

        List<TravelAgency> var_ta = MainActivity.myAppDatabase.mydao().getDataTA(id);
        for (TravelAgency i : var_ta) {
            int key = i.getKwdikos();
            String name = i.getTravel_agency_name();
            String street = i.getTravel_agency_street();
            ta_name.setText(name);
            ta_street.setText(street);

        }
    }
    public void getDataST(int id) {

        List<SuggestTrip> list_ST = MainActivity.myAppDatabase.mydao().getDataST(id);

        for (SuggestTrip i : list_ST) {

            String country = i.getCountry();
            String city = i.getCity();
            String time = i.getTime();

            st_country.setText(country);
            st_city.setText(city);
            st_time.setText(time);

        }
    }
    public void getDataPT(int id) {
/*
        ta_street.setText("");
        ta_name.setText("");
        st_country.setText("");
        st_time.setText("");
        st_city.setText("");
*/
        List<PacketTrip> var_ta = MainActivity.myAppDatabase.mydao().getDataPT(id);

        //getDataTA(Integer.parseInt(ta_id.getText().toString()));
        //getDataST(Integer.parseInt(st_id.getText().toString()));

        for (PacketTrip i : var_ta) {


            if(!String.valueOf(i.getKwd_travel_agency()).isEmpty()&!String.valueOf(i.getKwd_trip()).isEmpty()) {
                ta_id.setText(String.valueOf(i.getKwd_travel_agency()));
                st_id.setText(String.valueOf(i.getKwd_trip()));
                Toast.makeText(getActivity(), "Travel agent and Packet Trip Entry exist!",Toast.LENGTH_LONG).show();

            }else if (String.valueOf(i.getKwd_travel_agency()).isEmpty() & String.valueOf(i.getKwd_trip()).isEmpty()){
                ta_id.setText("");
                st_id.setText("");
                Toast.makeText(getActivity(), "Travel agent and Packet Trip Entry Dose not exist!",Toast.LENGTH_LONG).show();
            }
            else if(String.valueOf(i.getKwd_travel_agency()).isEmpty()){
                ta_id.setText("");
                st_id.setText(String.valueOf(i.getKwd_trip()));
                Toast.makeText(getActivity(), "Travel agent Entry Dose not exist!",Toast.LENGTH_LONG).show();

            }else if(String.valueOf(i.getKwd_trip()).isEmpty()){
                ta_id.setText(String.valueOf(i.getKwd_travel_agency()));
                st_id.setText("");
                Toast.makeText(getActivity(), "Suggest Trip Entry Dose not exist!",Toast.LENGTH_LONG).show();

            }

            pt_price.setText(i.getPrice());
            pt_time.setText(i.getTime_to_start());

        }

    }
}