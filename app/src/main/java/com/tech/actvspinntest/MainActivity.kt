package com.tech.actvspinntest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {

    var actv: AutoCompleteTextView? = null
    var list: ListView? = null
    var spin: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

//        var listOfNames = mutableListOf<String>("prashant", "prachi", "rajjeshree", "archana", "neha", "gaurav", "debashish", "jagruti", "anjali", "rajesh")
//        var nameAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, listOfNames)
//        spin?.adapter = nameAdapter
//        list?.adapter = nameAdapter//


        var state_names = resources.getStringArray(R.array.states)//got the list into kotlin file

        var var_adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, state_names)
        actv?.setAdapter(var_adapter)//we r setting the adpater to actv
        actv?.threshold = 1
        list?.adapter = var_adapter//we r setting adapter to list

        actv?.setOnItemClickListener({ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            Toast.makeText(this, "actv item clicked  ", Toast.LENGTH_SHORT).show()
        })



//      spin?.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
//          override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//             Toast.makeText(this@MainActivity,"Spin item :${spin?.getItemAtPosition(position)}  clicked",Toast.LENGTH_SHORT).show()
//          }
//
//          override fun onNothingSelected(parent: AdapterView<*>?) {
//              TODO("Not yet implemented")
//          }
//
//      }
        spin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Spin item :${spin?.getItemAtPosition(position)}  clicked", Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        list?.setOnItemClickListener({ adapterView: AdapterView<*>, view1: View, position: Int, l: Long ->
//       Toast.makeText(this@MainActivity, "${list?.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
            Toasty.success(this, "${list?.getItemAtPosition(position)}", Toast.LENGTH_SHORT, true).show();
        })
    }


    private fun init() {
        actv = findViewById(R.id.actv)
        list = findViewById(R.id.listview)
        spin = findViewById(R.id.spinner)
    }
}