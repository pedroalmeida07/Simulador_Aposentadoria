package com.example.aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aposentadoria.databinding.ActivityMainBinding

const val indMasculino = 65
const val indFeminino = 62
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dados para o Spinner
        val Itens = listOf("Masculino", "Feminino")

        // Acessando o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Itens)
        binding.SpinnerSx.adapter = adapter

        // Acionando evento de clique no botão
        binding.btnCalcular.setOnClickListener {
            val sxSelecionado = binding.SpinnerSx.selectedItem as String
            val idade = binding.EditTextIdade.text.toString().toLongOrNull()

            var resultado: Long = 0L

            if(idade != null){
                if(sxSelecionado.trim() == "Masculino"){
                    resultado = indMasculino - idade
                } else{
                    resultado = indFeminino - idade
                }
                if(resultado>=0){
                    binding.txtResultado.text = "Faltam $resultado anos para você se aposentar"
                } else{
                    binding.txtResultado.text = "Você já deveria ter se aposentado"
                }

            } else{
                binding.txtResultado.text = "Informe uma idade"
            }
        }
    }
}