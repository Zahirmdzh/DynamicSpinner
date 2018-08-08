package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> aLNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);
// initialise arrayList
        aLNumbers = new ArrayList<>();
      // create an array adapter using ddefault spinner layout and arraylist
        aaNumbers = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, aLNumbers);
      // bind the arrayadapter to the spinner
        spn2.setAdapter(aaNumbers);

       // aLNumbers.add("2");
        //aLNumbers.add("4");
        aLNumbers.add("6");


////Get the string-array and store as an Array
//        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//
////Convert Array to List and add to the ArrayList
//        aLNumbers.addAll(Arrays.asList(strNumbers));

//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int pos = spn1.getSelectedItemPosition();
//                aLNumbers.clear();
//
//                //Apply either one of the two approaches
//                if (pos == 0) {
//                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//                    aLNumbers.addAll(Arrays.asList(strNumbers));
//                } else {
//                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
//                    aLNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                aaNumbers.notifyDataSetChanged();
//            }
//
//        });
      spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
              aLNumbers.clear();
//
//                //Apply either one of the two approaches
               if (position == 0) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    aLNumbers.addAll(Arrays.asList(strNumbers));
                    // based on array index of even_numbers
                   spn2.setSelection(2);
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    aLNumbers.addAll(Arrays.asList(strNumbers));
                    //based on array index of odd_numbers
                    spn2.setSelection(1);
             }
               aaNumbers.notifyDataSetChanged();
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });
    }
}
