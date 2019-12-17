package com.example.listahoteles

import android.app.Activity
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.*
import android.view.View
import android.widget.TextView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import kotlinx.android.synthetic.main.boton_item.*

class ReservaHotel : AppCompatActivity() {

   override
   fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.boton_item)

      var option: Spinner
      var result: TextView

      var diasint : Int
      var precioint : Int

      var total: Int

      option = findViewById(R.id.spinner) as Spinner
      result = findViewById(R.id.eleccion) as TextView

      val listado = arrayListOf(
         "Meliá Granada", "Hotel Guadalupe", "Eurostars Washington Irving"
         , "Abades Recogidas", "Marquis Portago", "Hotel Párraga Siete"
      )

      option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado)

      option.onItemSelectedListener = object : OnItemSelectedListener {
         override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            result.text = listado.get(p2)

            when(result.text){
               "Meliá Granada" -> precio2.text = "73"
               "Hotel Guadalupe" -> precio2.text = "33"
               "Eurostars Washington Irving" -> precio2.text = "86"
               "Abades Recogidas" -> precio2.text = "58"
               "Marquis Portago" -> precio2.text = "34"
               "Hotel Párraga Siete" -> precio2.text = "45"
            }
         }

         override fun onNothingSelected(p0: AdapterView<*>?) {
            result.text = "Selecciona una opción"
         }
      }

      val reserva:Button = findViewById(R.id.reserva)

      reserva.setOnClickListener{
         diasint = dias.text.toString().toInt()
         precioint = precio2.text.toString().toInt()

         total = diasint * precioint

         val builder = AlertDialog.Builder(reserva.context)
         builder.setTitle(Html.fromHtml("<font color='#00574b'>Info de la Reserva</font>"))
         builder.setCancelable(false)
         builder.setMessage("Alojarse ${dias.text} días en el hotel '${result.text}' cuesta $total€. " +
                 "¿Quiere continuar?")
         builder.setNegativeButton("Cancelar") { dialog, which ->
            builder.setCancelable(true)
         }

            builder.setPositiveButton("Aceptar") { dialog, which ->
               Toast.makeText(applicationContext,"¡Gracias por la reserva!",Toast.LENGTH_SHORT).show()
               onBackPressed()
            }
         builder.show()
      }
   }
}
