package zamorano.miguel.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var textoRespuesta: Double = 0.0
    var operadorActual: String? = null
    var escribiendo: Boolean = false
    var terminado: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val campoResultado: TextView = findViewById(R.id.resultado)
        val campoCuenta: TextView = findViewById(R.id.cuenta)
        val campoOperador: TextView = findViewById(R.id.txtOperador)

        // números
        val boton0: Button = findViewById(R.id.b0)
        val boton1: Button = findViewById(R.id.b1)
        val boton2: Button = findViewById(R.id.b2)
        val boton3: Button = findViewById(R.id.b3)
        val boton4: Button = findViewById(R.id.b4)
        val boton5: Button = findViewById(R.id.b5)
        val boton6: Button = findViewById(R.id.b6)
        val boton7: Button = findViewById(R.id.b7)
        val boton8: Button = findViewById(R.id.b8)
        val boton9: Button = findViewById(R.id.b9)

        // botones de operaciones
        val botonSuma: Button = findViewById(R.id.bSuma)
        val botonMultiplicacion: Button = findViewById(R.id.bMultiplicacion)
        val botonResta: Button = findViewById(R.id.bResta)
        val botonDivision: Button = findViewById(R.id.bDivision)

        // botón de borrar
        val botonBorrar: Button = findViewById(R.id.bBorrar)

        botonBorrar.setOnClickListener {
            if (escribiendo) {
                if (campoCuenta.text.toString().length == 1) {
                    campoCuenta.text = "0"
                    escribiendo = false
                } else {
                    var texto: String = campoCuenta.text.toString()
                    campoCuenta.text = texto.substring(0, texto.length - 1)
                }

            }
        }

        val clear: Button = findViewById(R.id.bClear)
        clear.setOnClickListener({
            escribiendo = false
            terminado = true
            textoRespuesta = 0.0
            operadorActual = null
            campoResultado.text = ""
            campoCuenta.text = "0"
            campoOperador.text = ""
        })

        boton0.setOnClickListener {
            if (escribiendo) {
                campoCuenta.text = campoCuenta.text.toString() + "0"
            }
        }
        boton1.setOnClickListener {
            escribir("1")
        }
        boton2.setOnClickListener {
            escribir("2")
        }
        boton3.setOnClickListener {
            escribir("3")
        }
        boton4.setOnClickListener {
            escribir("4")
        }
        boton5.setOnClickListener {
            escribir("5")
        }
        boton6.setOnClickListener {
            escribir("6")
        }
        boton7.setOnClickListener {
            escribir("7")
        }
        boton8.setOnClickListener {
            escribir("8")
        }
        boton9.setOnClickListener {
            escribir("9")
        }


        // corregir
        botonSuma.setOnClickListener {
            // si no se seleccionó un operador anteriormente (primera vez que se selecciona uno)
            if (operadorActual == null) {
                textoRespuesta = campoCuenta.text.toString().toDouble()
                // solo se establece el de la cuenta al resultado
                campoResultado.text = campoCuenta.text.toString()
            } else {
                // si no se escribió nada al tratar de cambiar operador
                if(!campoCuenta.text.toString().equals("0")){
                    // por si ya hay otra cosa en el campo de resultado, se calcula con el operador anteriormente seleccionado
                    if(calcula(campoCuenta.text.toString().toDouble())){
                        campoResultado.text = textoRespuesta.toString()
                    }

                }

            }
            // cambiamos operador para el siguiente cálculo
            operadorActual = "+"
            campoOperador.text = "+"

            // cero por defecto
            campoCuenta.text = "0"


            // se deja de escribir
            escribiendo = false
        }

        botonMultiplicacion.setOnClickListener {
            // si no se seleccionó un operador anteriormente (primera vez que se selecciona uno)
            if (operadorActual == null) {
                textoRespuesta = campoCuenta.text.toString().toDouble()
                // solo se establece el de la cuenta al resultado
                campoResultado.text = campoCuenta.text.toString()
            } else {
                // si no se escribió nada al tratar de cambiar operador
                if(!campoCuenta.text.toString().equals("0")){
                    // por si ya hay otra cosa en el campo de resultado, se calcula con el operador anteriormente seleccionado
                    if(calcula(campoCuenta.text.toString().toDouble())){
                        campoResultado.text = textoRespuesta.toString()
                    }

                }
            }
            // cambiamos operador para el siguiente cálculo
            operadorActual = "*"
            campoOperador.text = "*"

            // cero por defecto
            campoCuenta.text = "0"

            // se deja de escribir
            escribiendo = false

        }
        botonResta.setOnClickListener {
            // si no se seleccionó un operador anteriormente (primera vez que se selecciona uno)
            if (operadorActual == null) {
                textoRespuesta = campoCuenta.text.toString().toDouble()
                // solo se establece el de la cuenta al resultado
                campoResultado.text = campoCuenta.text.toString()
            } else {
                // si no se escribió nada al tratar de cambiar operador
                if(!campoCuenta.text.toString().equals("0")){
                    // por si ya hay otra cosa en el campo de resultado, se calcula con el operador anteriormente seleccionado
                    if(calcula(campoCuenta.text.toString().toDouble())){
                        campoResultado.text = textoRespuesta.toString()
                    }

                }
            }
            // cambiamos operador para el siguiente cálculo
            operadorActual = "-"
            campoOperador.text = "-"


            // cero por defecto
            campoCuenta.text = "0"

            // se deja de escribir
            escribiendo = false
        }
        botonDivision.setOnClickListener {
            // si no se seleccionó un operador anteriormente (primera vez que se selecciona uno)
            if (operadorActual == null) {
                textoRespuesta = campoCuenta.text.toString().toDouble()
                // solo se establece el de la cuenta al resultado
                campoResultado.text = campoCuenta.text.toString()
            } else {
                // si no se escribió nada al tratar de cambiar operador
                if(!campoCuenta.text.toString().equals("0")){
                    // por si ya hay otra cosa en el campo de resultado, se calcula con el operador anteriormente seleccionado
                    if(calcula(campoCuenta.text.toString().toDouble())){
                        campoResultado.text = textoRespuesta.toString()
                    }

                }
            }
            // cambiamos operador para el siguiente cálculo
            operadorActual = "/"
            campoOperador.text = "/"


            // cero por defecto
            campoCuenta.text = "0"

            // se deja de escribir
            escribiendo = false
        }


        // botón de calcular
        val botonCalcular: Button = findViewById(R.id.bResultado)

        botonCalcular.setOnClickListener {
            // si se pudo realizar el cálculo
            if(calcula(campoCuenta.text.toString().toDouble())){
                campoResultado.text = textoRespuesta.toString()
                escribiendo = false
                operadorActual = null
                terminado = true
                campoCuenta.text = "0"
                campoOperador.text = ""

            }
        }

    }

    fun escribir(numero: String) {
        val campoCuenta: TextView = findViewById(R.id.cuenta)
        val campoResultado: TextView = findViewById(R.id.resultado)
        if(terminado){
            campoResultado.text = ""
            terminado = false
        }
        if (escribiendo) {
            campoCuenta.text = campoCuenta.text.toString() + numero
        } else {

            campoCuenta.text = numero
            escribiendo = true
        }
    }


    // CORREGIR
    fun calcula(valor: Double): Boolean {
        // si no se pidió dividir entre 0
        if (operadorActual != null && (operadorActual != "/" || valor != 0.0)) {

            when (operadorActual) {
                "+" -> textoRespuesta += valor
                "*" -> textoRespuesta *= valor
                "-" -> textoRespuesta -= valor
                "/" -> textoRespuesta /= valor
            }
            return true

        }
        else {
            return false
        }

    }
}
