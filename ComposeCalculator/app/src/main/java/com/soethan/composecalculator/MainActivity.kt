package com.soethan.composecalculator

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soethan.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorLayout()
                }
            }
        }
    }
}


@Composable
fun CalculatorLayout(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom){
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                    .background(Color.Red),
                contentAlignment = Alignment.BottomEnd) {
                Text(text = "1+2",
                    maxLines = 2,
                    fontSize = 80.sp,
                    textAlign = TextAlign.End,

                )
            }
            Spacer(modifier = Modifier.paddingFromBaseline(bottom = 8.dp))
            ButtonLayout()
        }
    }
}


@Composable
fun ButtonLayout(modifier: Modifier=Modifier){
    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalculatorButton(text = "AC", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)) {
            }
            CalculatorButton(text = "DEL", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {

            }
            CalculatorButton(text = "/",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {

            }
        }
        Row(modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalculatorButton(text = "7", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "8", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                // TODO
            }
            CalculatorButton(text = "9",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "x",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
        }
        Row(modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalculatorButton(text = "4", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "5", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                // TODO
            }
            CalculatorButton(text = "6",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "-",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
        }
        Row(modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalculatorButton(text = "1", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "2", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                // TODO
            }
            CalculatorButton(text = "3",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
            CalculatorButton(text = "+",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }
        }
        Row(modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CalculatorButton(text = "0", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f)) {
            }
            CalculatorButton(text = ".", color = Color.Black,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
                // TODO
            }
            CalculatorButton(text = "=",
                color = Color.Magenta,
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f)) {
            }

        }
    }
}

@Composable
fun ButtonRow(modifier: Modifier=Modifier){
    Row(modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        CalculatorButton(text = "AC", color = Color.Black,
            modifier = Modifier
                .aspectRatio(2f)
                .weight(2f)) {
        }
        CalculatorButton(text = "DEL", color = Color.Black,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)) {

        }
        CalculatorButton(text = "/",
            color = Color.Magenta,
            modifier = Modifier
                .aspectRatio(1f)
                .weight(1f)) {

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CalculatorButton(modifier: Modifier = Modifier,
                     text: String,
                     color:Color = Color.White,
                     onClick : () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
        modifier
            .clip(
                RoundedCornerShape(50)
            )
            .background(color = color)
            .clickable {
                onClick()
            }
    ) {
        Text(text = text, style = MaterialTheme.typography.headlineSmall,
        color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeCalculatorTheme {
        Greeting("Android")
    }
}

@Preview()
@Composable
fun CalculatorButtonPreview() {
    ComposeCalculatorTheme {
        CalculatorButton(text = "+", onClick = {}, color = Color.Cyan)
    }
}

@Preview(widthDp = 360)
@Composable
fun ButtonRowPreview() {
    ComposeCalculatorTheme {
        ButtonRow()
    }
}