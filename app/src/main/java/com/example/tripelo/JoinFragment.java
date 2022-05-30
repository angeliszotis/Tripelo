package com.example.tripelo;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripelo.RoomDB.PacketTrip;
import com.example.tripelo.RoomDB.ResultStringInt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JoinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JoinFragment extends Fragment {
    EditText name , surname ,ptid , id ,hotel ,price , country , start_time;
    Button button ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public JoinFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JoinFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JoinFragment newInstance(String param1, String param2) {
        JoinFragment fragment = new JoinFragment();
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
           View view =inflater.inflate(R.layout.fragment_join, container, false);

           name = view.findViewById(R.id.editTextjoin_name);
           surname = view.findViewById(R.id.editTextjoin_surname);
           ptid= view.findViewById(R.id.editTextjoin_ptid);
           hotel = view.findViewById(R.id.editTextjoin_hotel);
           id = view.findViewById(R.id.editTextjoin_id);
           price = view.findViewById(R.id.editTextPrice_join);
           start_time = view.findViewById(R.id.editTextStartTime_join);
           country = view.findViewById(R.id.editTextCountry_join);


           button = view.findViewById(R.id.button_join);

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!id.getText().toString().isEmpty()){
                    fillData(Integer.parseInt(id.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
          //  Map<String, Object> join = new HashMap<>();
        ptid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!ptid.getText().toString().isEmpty()){
                    fillRecyclehome_join(Integer.parseInt(ptid.getText().toString()));
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Var_name = name.getText().toString();
                    //DocumentReference Var_sailorid = MainActivity.db.document("/Sailors/" + Var_sid);
                    String Var_surname = surname.getText().toString();
                  //  DocumentReference Var_boatid = MainActivity.db.document("/Boats/" + Var_bid);
                    int Var_ptid = Integer.parseInt(ptid.getText().toString());
                    int var_id = Integer.parseInt(id.getText().toString());
                    String var_hotel = hotel.getText().toString();


                    JoinFire list = new JoinFire();
                    try{
                        list.setId(var_id);
                        list.setPtid(Var_ptid);
                        list.setName(Var_name);
                        list.setSurname(Var_surname);
                        list.setHotel(var_hotel);
                        list.setTime(start_time.getText().toString());
                        list.setCountry(country.getText().toString());
                        list.setPrice(price.getText().toString());

                    MainActivity.dbf.
                            collection("join").
                            document(""+var_id).
                            set(list).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getActivity(),"Your Join added.",Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(),"add operation failed.",Toast.LENGTH_LONG).show();

                        }
                    });
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                }
            });







           return view;
    }

    public void fillRecyclehome_join(int id){


        List<ResultStringInt> recycleList = MainActivity.myAppDatabase.mydao().bringjoin(id);


        for (ResultStringInt i: recycleList) {

            country.setText(i.getTitle());
            price.setText(i.getPrice());
            start_time.setText(i.getTime());

        }

    }
    public void fillData(int ida){

        DocumentReference collectionReference = MainActivity.dbf.
                collection("join").document(String.valueOf(ida));
        collectionReference.
                get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>(){
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {


                if(documentSnapshot.exists()){
                    JoinFire join = documentSnapshot.toObject(JoinFire.class);


                    try {

                        ptid.setText(String.valueOf(join.getPtid()));
                    } catch (NumberFormatException ex){
                        System.out.println("Could not parse " + ex);

                    }

                    try {
                        name.setText(join.getName());
                        surname.setText(join.getSurname());
                        hotel.setText(join.getHotel());
                        price.setText( join.getPrice());
                        start_time.setText(join.getTime());
                        country.setText(join.getCountry());
                        Toast.makeText(getActivity(), "Travel Agency Deleted Succefuly!",Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                    }


                }else {


                    try {

                        ptid.setText("");
                    } catch (NumberFormatException ex){
                        System.out.println("Could not parse " + ex);

                    }

                    try {
                        name.setText("");
                        surname.setText("");
                        hotel.setText("");
                        price.setText( "");
                        start_time.setText("");
                        country.setText("");
                        Toast.makeText(getActivity(), "Travel Agency Deleted Succefuly!",Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                    }
                    Toast.makeText(getActivity(),"document does not exist.",Toast.LENGTH_LONG).show();
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"query operation failed.", Toast.LENGTH_LONG).show();
            }
        });


    }
}

