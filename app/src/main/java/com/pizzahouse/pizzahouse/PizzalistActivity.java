package com.pizzahouse.pizzahouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PizzalistActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView img;
    TextView nametext, pricetext,billtext;
    Button addcart, submitorder;
    Spinner spinner;
    ArrayList arrayList;
    pizzaprice pizzaPrice;
    RadioButton size_small,size_medium,size_large;
    int radiobuttondata;

    String quantityselected;
     int data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pizzaPrice =new pizzaprice();
        setContentView(R.layout.activity_pizzalist);
        billtext=findViewById(R.id.totalbill);
        img=findViewById(R.id.ImageIcon);
        nametext=findViewById(R.id.NameText);
        pricetext=findViewById(R.id.PriceText);
        size_small=findViewById(R.id.small);
        size_medium=findViewById(R.id.medium);
        size_large=findViewById(R.id.large);
        submitorder=findViewById(R.id.order);
        img.setImageResource(getIntent().getIntExtra("Imagename",0));
        nametext.setText(getIntent().getStringExtra("name"));
        pricetext.setText((getIntent().getStringExtra("price")));

        spinner=findViewById(R.id.quantity);
        arrayList=new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(this);
        submitorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(size_small.isChecked())
                {
                    radiobuttondata=199;
                }
                else if(size_medium.isChecked())
                {
                    radiobuttondata=299;
                }
                else
                if(size_large.isChecked())
                {
                    radiobuttondata=399;
                }

                    int total=(radiobuttondata*data);

                billtext.setText("total amount "+total);

                }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        quantityselected=(String)arrayList.get(i).toString();
        data=Integer.parseInt(quantityselected);
        Toast.makeText(this, ""+data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}