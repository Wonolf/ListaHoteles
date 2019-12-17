package com.example.listahoteles

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.widget.EditText
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.boton_item.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerView: RecyclerView =findViewById(R.id.recycler)
        recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val hoteles= ArrayList<Hoteles>()
        hoteles.add(Hoteles("Meliá Granada",4,73,"Calle Angel Ganivet 7, 18009",8.3,R.drawable.melia))
        hoteles.add(Hoteles("Hotel Guadalupe",3,33,"Calle Paseo de la Sabica, 18009",8.2,R.drawable.guadalupe))
        hoteles.add(Hoteles("Eurostars Washington Irving",5,86,"Calle Paseo del Generalife 10",9.3,R.drawable.washington))
        hoteles.add(Hoteles("Abades Recogidas",4,58,"Calle Recogidas 7, 18005",8.5,R.drawable.abades))
        hoteles.add(Hoteles("Marquis Portago",3,34,"Calle San Matías 20, 18009",7.7,R.drawable.marquis))
        hoteles.add(Hoteles("Hotel Párraga Siete",2,45,"Calle Párraga 7 bajo, 18002",8.6,R.drawable.parraga))

        val adaptador=AdaptadorHoteles(hoteles)
        recyclerView.adapter=adaptador

        fab.setOnClickListener {
            val intent = Intent(this, ReservaHotel::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
