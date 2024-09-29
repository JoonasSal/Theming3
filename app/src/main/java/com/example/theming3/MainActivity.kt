package com.example.theming3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theming3.ui.theme.Theming3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Theming3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    // Define a Modifier to be reused across multiple components
    val appModifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    // The Column holds the composables vertically
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Text composable, styled with MaterialTheme's typography
        Text(
            text = "My Title",
            style = MaterialTheme.typography.headlineSmall, // Material 3 equivalent to h5
            modifier = appModifier
        )

        // OutlinedTextField for input, with basic functionality
        OutlinedTextField(
            value = "",
            onValueChange = { /* Handle input */ },
            modifier = appModifier
        )

        // Button with an action
        Button(
            onClick = { /* Handle click */ },
            modifier = appModifier
        ) {
            Text(text = "Submit")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    Theming3Theme {
        MyApp()
    }
}