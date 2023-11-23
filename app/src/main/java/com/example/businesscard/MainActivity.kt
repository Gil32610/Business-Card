package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
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
fun BusinessCard(){
    val image = painterResource(R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha =0.7f
        )
    }
    Column (Modifier.fillMaxWidth()
        ){
        HeadSection(
            fullName = stringResource(R.string.my_full_name),
            title = stringResource(R.string.title)
        )
        ContactComposable(
            phoneNumber = stringResource(R.string.phone_number),
            instagramAccount = stringResource(R.string.instagram_profile),
            emailAddress = stringResource(R.string.personal_email))

    }
}

@Composable
fun HeadSection(fullName:String, title:String,modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    val padding = 16.dp
    Column(
        modifier
            .padding(top = 250.dp,start = padding, end = padding)
            .fillMaxWidth()
            ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image ,
            contentDescription =null,
            modifier = Modifier.width(250.dp)

        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Text(
            text = title
        )

    }
}

@Composable
fun ContactComposable(
    phoneNumber: String,
    instagramAccount: String,
    emailAddress: String,
    modifier: Modifier = Modifier
){
Column(
    modifier
        .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
        .fillMaxSize()
        ,
    horizontalAlignment = Alignment.Start,
    verticalArrangement = Arrangement.Center
){
    val businessCardIcons = Icons.Sharp
    val offset = 28.dp
    ContactInfo(
        icon = businessCardIcons.Call,
        contact = stringResource(R.string.phone_number),
        description = "Phone Number",
    horizontalOffset = offset)
    ContactInfo(
        icon = businessCardIcons.AccountCircle,
        contact = stringResource(R.string.instagram_profile) ,
        description ="Instagram Account",
        horizontalOffset = offset)

    ContactInfo(
        icon = businessCardIcons.Email,
        contact = stringResource(R.string.personal_email),
        description = "Email address",
        horizontalOffset = offset)

}
}

@Composable
fun ContactInfo(
    icon: ImageVector,
    contact: String,
    description: String,
    horizontalOffset: Dp,
    modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        Icon(
            icon,
            contentDescription = description,
            modifier = Modifier
                .offset(x = horizontalOffset)
                .size(35.dp)
        )
        Text(
            text= contact,
            modifier = Modifier
                .padding(start = 10.dp)
                .offset(horizontalOffset),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}