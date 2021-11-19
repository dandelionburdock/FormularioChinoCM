package com.example.formulachina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.regex.Pattern

class formulaDatos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula_datos)
        val etDate = findViewById<EditText>(R.id.etDate)
        etDate.setOnClickListener{showDatePickerDialog()}
    }


    private fun showDatePickerDialog(){
        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day,month,year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        val etDate = findViewById<EditText>(R.id.etDate)
        if(day<10){
            if(month<9){
                etDate.setText("0$day/0${month+1}/$year")
            }
            else{
                etDate.setText("0$day/${month+1}/$year")
            }
        }
        else if(month<9){
            etDate.setText("$day/0${month+1}/$year")
        }
        else{
            etDate.setText("$day/${month+1}/$year")
        }
    }
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    fun isValidString(str: String): Boolean{
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }
    fun botonCalcular(view: android.view.View) {
        var intent = Intent(this,Horoscope::class.java)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etFecha = findViewById<EditText>(R.id.etDate)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etCuenta = findViewById<EditText>(R.id.etCuenta)

        if(etCuenta.text.toString() != "" && etEmail.text.toString() != "" && etNombre.text.toString() != "" && etFecha.text.toString() != ""){
            if(etCuenta.text.toString().length == 9){
                if (isValidString(etEmail.text.toString())){
                    if(etNombre.text.toString().contains("0") ||
                        etNombre.text.toString().contains("1") ||
                        etNombre.text.toString().contains("2") ||
                        etNombre.text.toString().contains("3") ||
                        etNombre.text.toString().contains("4") ||
                        etNombre.text.toString().contains("5") ||
                        etNombre.text.toString().contains("6") ||
                        etNombre.text.toString().contains("7") ||
                        etNombre.text.toString().contains("8") ||
                        etNombre.text.toString().contains("9") ){

                        Toast.makeText(this, R.string.mensajeError2, Toast.LENGTH_SHORT).show()
                    }
                    else{
                        val dia = etFecha.text.toString().substring(0,2)
                        val mes = etFecha.text.toString().substring(3,5)
                        val anio = etFecha.text.toString().substring(6)

                        val c = Calendar.getInstance()

                        val anioActual = c.get(Calendar.YEAR)
                        val mesActual = c.get(Calendar.MONTH)
                        val diaActual = c.get(Calendar.DAY_OF_MONTH)


                        //Enviando datos
                        var parametros = Bundle()

                        val edad = anioActual.toInt()-anio.toInt()
                        if(mes.toInt()<mesActual.toInt()+1){
                            parametros.putString("edad",edad.toString())
                        }
                        else if(mes.toInt()==mesActual.toInt()+1){
                            if(dia.toInt()<=diaActual.toInt()){
                                parametros.putString("edad",edad.toString())
                            }
                            else{
                                val edadReal = edad-1
                                parametros.putString("edad",edadReal.toString())
                            }
                        }
                        else{
                            val edadReal = edad-1
                            parametros.putString("edad",edadReal.toString())
                        }

                        val anioSigno = anio.toInt()%12

                        parametros.putString("signo",anioSigno.toString())

                        parametros.putString("correo",etEmail.text.toString())
                        parametros.putString("nombre",etNombre.text.toString())
                        parametros.putString("fecha",etFecha.text.toString())
                        parametros.putString("cuenta",etCuenta.text.toString())

                        intent.putExtras(parametros)

                        startActivity(intent)
                    }
                }
                else{
                    Toast.makeText(this, R.string.mensajeError3, Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, R.string.mensajeError4, Toast.LENGTH_SHORT).show()
            }
        }
        else{
            //Error con Toast
            Toast.makeText(this, R.string.mensajeError, Toast.LENGTH_SHORT).show()
        }
    }
}