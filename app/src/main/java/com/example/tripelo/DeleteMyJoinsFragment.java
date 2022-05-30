package com.example.tripelo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteMyJoinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteMyJoinsFragment extends Fragment {
    EditText name , surname ,ptid , id ,hotel ,price , country , start_time;
    Button button ;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteMyJoinsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeleteMyJoinsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeleteMyJoinsFragment newInstance(String param1, String param2) {
        DeleteMyJoinsFragment fragment = new DeleteMyJoinsFragment();
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
       View view = inflater.inflate(R.layout.fragment_delete_my_joins, container, false);
        name = view.findViewById(R.id.editTextjoin_name_delete);
        surname = view.findViewById(R.id.editTextjoin_surname_delete);
        ptid= view.findViewById(R.id.editTextjoin_ptid_delete);
        hotel = view.findViewById(R.id.editTextjoin_hotel_delete);
        id = view.findViewById(R.id.editTextjoin_id_delete);
        price = view.findViewById(R.id.editTextPrice_join_delete);
        start_time = view.findViewById(R.id.editTextStartTime_join_delete);
        country = view.findViewById(R.id.editTextCountry_join_delete);

        button = view.findViewById(R.id.button_join_delete);

       // text = view.findViewById(R.id.textView_ShowMyJoins);
    id.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           // if(Integer.parseInt(id.getText().toString()) ==0){ Toast.makeText(getActivity(),"ID must be 1 and up",Toast.LENGTH_LONG);}

                if (!id.getText().toString().isEmpty()) {
                    fillData(Integer.parseInt(id.getText().toString()));
                }
            }


        @Override
        public void afterTextChanged(Editable editable) {

        }
    });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            deleteMethod(Integer.parseInt(id.getText().toString()));
        }
    });

        return view;
    }

    private void deleteMethod(int ida) {

       // MainActivity.dbf.collection("join").document("ida").removeValue();

        MainActivity.dbf.collection("join").document(String.valueOf(ida))
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getActivity(), "Join Deleted Succefuly!",Toast.LENGTH_LONG).show();
                        clearText();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Join Deleted Fail!",Toast.LENGTH_LONG).show();
                    }
                });


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
 public void clearText(){

     name.setText("");
     surname.setText("");
     hotel.setText("");
     price.setText( "");
     start_time.setText("");
     country.setText("");
 }
}