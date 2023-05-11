package com.example.calculatetip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatetip.ui.theme.CalculateTipTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculateTipTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculateTipTheme() {

                        AppCalculateTipTheme()

                        
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AppCalculateTipTheme(){

    var valorEntrada by remember { mutableStateOf("0") }
    var percetagemGorjeta by remember { mutableStateOf("") }
    var gorjeta by remember { mutableStateOf(0.0) }

    gorjeta = CalcularGorjeta(valorEntrada,percetagemGorjeta)

    Surface(
        modifier =  Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {

          Text(
              text = "Calculadora de Gorjeta",
              fontSize = 30.sp,
              fontWeight = FontWeight.Bold,
              modifier = Modifier
                  .padding(top = 40.dp)
          )
            TextField(
                value = valorEntrada,
                label = {
                    Text(text = "valor de Entrada")
                        },
                onValueChange = {valorEntrada = it},
                modifier = Modifier
                    .padding(top = 30.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = porcentagemgorjeta,
                label = {
                    Text(text = "porcentagem da Gorjeta")
                },
                onValueChange = {porcentagemgorjeta = },
                modifier = Modifier
                    .padding(top = 30.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Text(
                text = "valor da Gorjeta: ${NumberFormat.getCurrencyInstance().format(gorjeta)}",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 30.dp)
            )
        }
    }
}
fun CalcularGorjeta(
        ValorEntrada:String,
        percetagemGorjeta:String
):Double{
    return  (ValorEntrada.toDoubleOrNull()?:0.0)*(percetagemGorjeta.toDoubleOrNull()?:0.0)/100

}