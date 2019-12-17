package com.example.listahoteles

import android.app.AlertDialog
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptadorHoteles(var lista: ArrayList<Hoteles>): RecyclerView.Adapter<AdaptadorHoteles.MiViewHolder>(){


    class MiViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun enlazaItems(datos:Hoteles){
            val nombre:TextView=itemView.findViewById(R.id.nombre)
            val estrellas:TextView=itemView.findViewById(R.id.estrellas)
            val precio:TextView=itemView.findViewById(R.id.precio)
            val direccion:TextView=itemView.findViewById(R.id.direccion)
            val imagen:ImageView=itemView.findViewById(R.id.imagen)

            nombre.text=datos.nombre
            estrellas.text="${datos.estrellas.toString()} Estrellas"
            precio.text="${datos.precio.toString()}€ por noche"
            direccion.text=datos.direccion


            Glide.with(itemView.context).load(datos.imagen).into(imagen)

            val valor:Button=itemView.findViewById(R.id.valor)

            valor.setOnClickListener{
                val builder = AlertDialog.Builder(itemView.context)
                builder.setTitle(Html.fromHtml("<font color='#00574b'>Valoraciones de ${datos.nombre}</font>"))
                builder.setMessage("Los usuarios han puntuado el hotel ${datos.nombre} con una valoración de ${datos.valor}")
                builder.show()
            }


            itemView.setOnClickListener {
                Toast.makeText(itemView.context,"${datos.nombre}",Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.contenido_item,parent,false)
        return MiViewHolder(v)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    ////////////MiViewHolder.ViewHolder
    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.enlazaItems(lista[position])
    }
}