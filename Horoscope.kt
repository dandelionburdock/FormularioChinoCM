package com.example.formulachina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Horoscope : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_horoscopo)

        //Obteniendo parametros
        val bundle = intent.extras
        val correoRecibido = bundle?.getString("correo")
        val fechaRecibida = bundle?.getString("fecha")
        val cuentaRecibida = bundle?.getString("cuenta")
        val nombreRecibido = bundle?.getString("nombre")
        val edadRecibida = bundle?.getString("edad")
        val signoRecibido = bundle?.getString("signo")

        val tvCorreo = findViewById<TextView>(R.id.tvCorreou)
        val tvNombre = findViewById<TextView>(R.id.tvNombreu)
        val tvCuenta = findViewById<TextView>(R.id.tvCuentau)
        val tvFecha = findViewById<TextView>(R.id.tvFechau)
        val tvEdad = findViewById<TextView>(R.id.tvEdadu)
        val ivSigno = findViewById<ImageView>(R.id.ivSigno)
        val tvNombreSigno = findViewById<TextView>(R.id.tvNombreSigno)

        tvCorreo.text = correoRecibido
        tvNombre.text = nombreRecibido
        tvCuenta.text = cuentaRecibida
        tvFecha.text = fechaRecibida
        tvEdad.text = edadRecibida
        when(signoRecibido){
            "4"->{
                ivSigno.setImageResource(R.drawable.rata)
                tvNombreSigno.setText(R.string.rata)
            }
            "5"->{
                ivSigno.setImageResource(R.drawable.buey)
                tvNombreSigno.setText(R.string.buey)
            }
            "6"->{
                ivSigno.setImageResource(R.drawable.tigre)
                tvNombreSigno.setText(R.string.tigre)
            }
            "7"->{
                ivSigno.setImageResource(R.drawable.conejo)
                tvNombreSigno.setText(R.string.conejo)
            }
            "8"->{
                ivSigno.setImageResource(R.drawable.dragon)
                tvNombreSigno.setText(R.string.dragon)
            }
            "9"->{
                ivSigno.setImageResource(R.drawable.serpiente)
                tvNombreSigno.setText(R.string.serpiente)
            }
            "10"->{
                ivSigno.setImageResource(R.drawable.caballo)
                tvNombreSigno.setText(R.string.caballo)
            }
            "11"->{
                ivSigno.setImageResource(R.drawable.cabra)
                tvNombreSigno.setText(R.string.cabra)
            }
            "12"->{
                ivSigno.setImageResource(R.drawable.mono)
                tvNombreSigno.setText(R.string.mono)
            }
            "13"->{
                ivSigno.setImageResource(R.drawable.gallo)
                tvNombreSigno.setText(R.string.gallo)
            }
            "14"->{
                ivSigno.setImageResource(R.drawable.perro)
                tvNombreSigno.setText(R.string.perro)
            }
            "15"->{
                ivSigno.setImageResource(R.drawable.cerdo)
                tvNombreSigno.setText(R.string.cerdo)
            }
        }

        //Mostrando con un toast
        //Toast.makeText(this, "Usuario Recibido: $correoRecibido, sesión: $sesion", Toast.LENGTH_LONG).show()

    }
}