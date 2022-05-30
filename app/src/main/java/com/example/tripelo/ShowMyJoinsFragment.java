package com.example.tripelo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowMyJoinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowMyJoinsFragment extends Fragment {

    TextView text;
    DocumentReference documentReference;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShowMyJoinsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowMyJoinsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowMyJoinsFragment newInstance(String param1, String param2) {
        ShowMyJoinsFragment fragment = new ShowMyJoinsFragment();
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
        View view = inflater.inflate(R.layout.fragment_show_my_joins, container, false);

        text = view.findViewById(R.id.textView_ShowMyJoins);

        CollectionReference collectionReference = MainActivity.dbf.
                collection("join");
        collectionReference.
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result = "";
                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                    JoinFire join = documentSnapshot.toObject(JoinFire.class);
                    Integer id = join.getId();
                    String name = join.getName();
                    String surname = join.getSurname();
                    String hotel = join.getHotel();
                    Integer ptid = join.getPtid();
                    String start_time = join.getTime();
                    String price = join.getPrice();
                    String country = join.getCountry();

                    result+= "Id: " + id + "\nFull name: " + name +" "+ surname + "\n" +
                            "Hotel: " + hotel+ "\n"+
                            "Packet Id: "+ptid + "\n"+
                            "Country: "+country +" Start Time: "+start_time+"\n"+
                             "price: "+price+"\n\n";
                }
                text.setText(result);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"query operation failed.", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}