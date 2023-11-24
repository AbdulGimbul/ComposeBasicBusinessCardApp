package com.abdl.mybusinesscardapp

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Identity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdl.mybusinesscardapp.ui.theme.MyBusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.tertiaryContainer),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Identity(modifier = Modifier.weight(1f))
            ContactInfo(modifier = Modifier.weight(0.2f))
        }
    }
}

@Composable
fun Identity(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.tertiary)
                .clip(MaterialTheme.shapes.medium)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android's logo",
                modifier = Modifier.size(100.dp)
            )
        }
        Text(text = "Muhamad Abdul Aziz", modifier = Modifier.padding(top = 16.dp, bottom = 4.dp), style = MaterialTheme.typography.headlineMedium)
        Text(text = "Android Developer Intermediate", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.tertiary)
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row {
            Icon(imageVector = Icons.Filled.Call, contentDescription = "Call", tint = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "+62 895 3482 4379 4")
        }
        Row {
            Icon(imageVector = Icons.Filled.Share, contentDescription = "Share", tint = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "@AbdulGimbul")
        }
        Row {
            Icon(imageVector = Icons.Filled.Email, contentDescription = "Email", tint = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "azizgimboell@gmail.com")
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview() {
    MyBusinessCardAppTheme {
        BusinessCardScreen()
    }
}